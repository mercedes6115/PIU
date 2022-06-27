package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.ProductQnaCriteria;
import com.example.pickitup.domain.vo.dto.AdminQnaDTO;
import com.example.pickitup.domain.vo.dto.ProductDTO;
import com.example.pickitup.domain.vo.dto.ProductQnaPageDTO;
import com.example.pickitup.domain.vo.dto.ProductReviewUserDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaCommentVO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.domain.vo.user.OrderVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.TempAdminService;
import com.example.pickitup.service.TempUserSerivce;
import com.example.pickitup.service.product.productFile.ProductFileService;
import com.example.pickitup.service.product.productFile.ProductService;
import com.example.pickitup.service.product.productQna.ProductQnaCommentService;
import com.example.pickitup.service.product.productQna.ProductQnaService;
import com.example.pickitup.service.product.productReview.ProductReviewService;
import com.example.pickitup.service.user.JjimService;
import com.example.pickitup.service.user.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/store/*")
@RequiredArgsConstructor
public class StoreController {
    private final ProductService productService;
    private final ProductReviewService productReviewService;
    private final ProductQnaService productQnaService;
    private final ProductQnaCommentService productQnaCommentService;
    private final JjimService jjimService;
    private final OrderService orderService;
    private final TempUserSerivce tempUserSerivce;
    private final TempAdminService tempAdminService;
    // 스토어 메인페이지
    @GetMapping("/main")
    public void storeMain(String category,Model model){
        if(category == ""){
            category = null;
        }
        model.addAttribute("productsCount",productService.count());
        model.addAttribute("productlist",productService.getList(category));
    }

    @ResponseBody
    @PostMapping("/main")
    public List<ProductVO> storepostMain(String category,Model model){
        if(category == ""){
            category = null;
        }
        model.addAttribute("productsCount",productService.count());
        model.addAttribute("productlist",productService.getList(category));
        return productService.getList(category);
    }

    // 스토어 상세페이지
    @GetMapping("/detail")
    public String storeDetail(Long num ,Model model){
//        // 유저 세션으로 받아서 num 넣어줘야함
//        model.addAttribute("user", tempUserSerivce.readUserInfo(22L));
        model.addAttribute("jjimCount",jjimService.count(num));
        model.addAttribute("count",productReviewService.count(num));
        model.addAttribute("product",productService.getDetail(num));
        return "/store/detail";
    }

    // 스토어 리뷰 목록
    @ResponseBody
    @GetMapping("/reviewLists/{productNum}")
    public List<ProductReviewVO> reviewLists(@PathVariable("productNum") Long productNum){
        // 유저 세션으로 받아서 num 넣어줘야함
       return productReviewService.getList(productNum);
    }

    //유저 정보 얻어오기
    @ResponseBody
    @GetMapping("/userInfo")
    public UserVO userinfo(Long userNum){
        return tempUserSerivce.readUserInfo(userNum);
    }


    // 전체 리뷰 보기 페이지
    @GetMapping("/goReviewList/{productNum}")
    public String goReviewList(@PathVariable("productNum") Long productNum,Model model){
//        // 유저 세션으로 받아서 num 넣어줘야함
//        model.addAttribute("user",tempUserSerivce.readUserInfo(22L));
        model.addAttribute("products",productService.getDetail(productNum));
        model.addAttribute("productNum",productNum);
        model.addAttribute("reviews",productReviewService.getList(productNum));
        return "/store/reviewList";
    }

    // 스토어 리뷰 작성
    @GetMapping("/reviewWrite")
    public void reviewWrite(Long num, Model model){
        model.addAttribute("product",productService.getDetail(num));
    }

    // 스토어 리뷰 작성 폼
    @PostMapping("/reviewWrite")
    public RedirectView reviewWriteForm(ProductReviewVO productReviewVO, RedirectAttributes rttr){
//        model.addAttribute("user", productNum); 유저의 정보 가져와야함.?? 어떻게??
        productReviewVO.setUserNum(22L);
        productReviewService.insert(productReviewVO);
        return new RedirectView("/store/detail");
//
    }

    //스토어 리뷰 수정
    @GetMapping("/reviewModify")
    public void reviewModify(Long num,Model model){
        model.addAttribute("review",productReviewService.read(num));
        model.addAttribute("product", productService.getDetail(productReviewService.read(num).getProductNum()));
    }
    //스토어 리뷰 수정 폼
    @PostMapping("/reviewModify")
    public String reviewModify(ProductReviewVO productReviewVO, Model model){
//        model.addAttribute("user", productNum); 유저의 정보 가져와야함.?? 어떻게??
        productReviewVO.setUserNum(22L);
        productReviewService.modify(productReviewVO);
        return storeDetail(productReviewVO.getProductNum(), model);
    }

    // 스토어 리뷰 삭제
    @ResponseBody
    @GetMapping("/reviewDelete")
    public void reviewDelete(Long num){
        productReviewService.delete(num);
    }

    // 스토어 문의 목록
    @ResponseBody
    @GetMapping("/qnaList/{productNum}/{pageNum}")
    public ProductQnaPageDTO qnaList(@PathVariable("pageNum") int pageNum, @PathVariable("productNum") Long productNum){
       return new ProductQnaPageDTO(productQnaService.getList(new ProductQnaCriteria(pageNum,5),productNum),productQnaService.count(productNum));
    }

    // 스토어 문의 작성
    @GetMapping("/qnaWrite")
    public void qnaWrite(Long productNum, Model model){
        //유저 정보도 같이 보내야함
        model.addAttribute("productNum",productNum);
    }

    // 스토어 문의 작성 폼
    @PostMapping("/qnaWrite")
    public String qnaWriteForm(ProductQnaVO productQnaVO, AdminQnaDTO adminQnaDTO, Model model){
        productQnaService.register(productQnaVO);
        tempAdminService.qnaStoreSave(adminQnaDTO);
        return storeDetail(productQnaVO.getProductNum(), model);
    }




    // 스토어 문의 댓글 리스트
    @ResponseBody
    @GetMapping("/qnaCommentList/{qnaNum}")
    public List<ProductQnaCommentVO> qnaCommentList(@PathVariable("qnaNum") Long qnaNum){
        return productQnaCommentService.getList(qnaNum);
    }

    // 스토어 문의 댓글 작성 (관리자 권한)
    @ResponseBody
    @PostMapping(value = "/qnaCommentWrite", consumes = "application/json")
    public String qnaCommentWrite(@RequestBody ProductQnaCommentVO productQnaCommentVO)  throws UnsupportedEncodingException {
        //(관리자) 정보도 같이 보내야함
        productQnaCommentService.register(productQnaCommentVO);
        return "success";
    }
//
    // 스토어 문의 댓글 삭제
    // 관리자 번호와 같이 넘어와야함
    @ResponseBody
    @GetMapping("/qnaCommentDelete")
    public String qnaCommentDeleteForm(Long qnaCommentNum){
        productQnaCommentService.delete(qnaCommentNum);
        return "success";
    }


    // 스토어 문의 댓글 삭제
    // 관리자 번호와 같이 넘어와야함
    @ResponseBody
    @PostMapping("/qnaCommentUpdate")
    public String qnaCommentUpdateForm(ProductQnaCommentVO productQnaCommentVO) throws UnsupportedEncodingException {
        log.info("=============================================");
        log.info("=============================================");
        log.info("=============================================");
        log.info("=============================================");
        log.info("=============================================");
        productQnaCommentService.update(productQnaCommentVO);
        return "success";
    }

    @GetMapping("/payment")
    public String payment(Long num){
        orderService.payment(num);
        return "store/payment";
    }






    //업데이트는 아직 안됨




    // 스토어 결제 정보 입력
    @PostMapping("/payment")
    public String paymentForm(ProductDTO productDTO, ProductVO productVO,OrderVO orderVO,UserVO userVO,Model model){
        model.addAttribute("product", productVO);
        model.addAttribute("productinfo",productDTO);
        orderService.register(orderVO,userVO);
        return ("/store/payment");
    }
//    @PostMapping("/payment")
//    public void paymentForm(ProductDTO productDTO, ProductVO productVO,Model model){
//        model.addAttribute("product", productVO);
//        model.addAttribute("productinfo",productDTO);
//    }

    // 스토어 결제 전 상품 선택
    @PostMapping("/itemChoose")
    public void itemChoose(ProductVO productVO,Model model){
        model.addAttribute("product",productVO);
    }

    // 결제 완료 후 주문내역
    @PostMapping("/buyProductDetail")//나중에 request 방식으로 바꿀것
    public void buyProductDetail(UserVO userVO, ProductDTO productDTO,String addressComment,Model model){
        model.addAttribute("addressComment", addressComment);
        model.addAttribute("userinfo",userVO);
        model.addAttribute("product",productDTO);
    }

    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return sdf.format(date);
    }

    //찜 목록
    @ResponseBody
    @GetMapping("/jjim")
    public List<JjimVO> listJjim(){
       return jjimService.getList();
    }


    // 찜추가
    @ResponseBody
    @PostMapping("/jjim")
    public void addJjim(JjimVO jjimVO){
        jjimService.register(jjimVO);
    }

    // 찜해제
    @ResponseBody
    @DeleteMapping("/jjim")
    public void removeJjim(JjimVO jjimVO){
        jjimService.remove(jjimVO);
    }

    //찜 갯수
    @ResponseBody
    @GetMapping("jjimCount")
    public int count(Long productNum){
        return jjimService.count(productNum);
    }

}
