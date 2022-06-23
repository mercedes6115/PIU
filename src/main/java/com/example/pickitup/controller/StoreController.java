package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.dto.ProductDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaCommentVO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import com.example.pickitup.domain.vo.user.OrderVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.product.productFile.ProductFileService;
import com.example.pickitup.service.product.productFile.ProductService;
import com.example.pickitup.service.product.productQna.ProductQnaCommentService;
import com.example.pickitup.service.product.productQna.ProductQnaService;
import com.example.pickitup.service.product.productReview.ProductReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private final ProductFileService productFileService;
    private final ProductReviewService productReviewService;
    private final ProductQnaService productQnaService;
    private final ProductQnaCommentService productQnaCommentService;

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
        model.addAttribute("count",productReviewService.count(num));
        model.addAttribute("product",productService.getDetail(num));
        return "/store/detail";
    }

    // 스토어 리뷰 목록
    @ResponseBody
    @GetMapping("/reviewLists/{productNum}")
    public List<ProductReviewVO> reviewLists(@PathVariable("productNum") Long productNum){
       return productReviewService.getList(productNum);
    }

    @GetMapping("/reviewList")
    public String reviewList(Long productNum, Model model){
        model.addAttribute("reviews",productReviewService.getList(productNum));
        return "/store/reviewList";
    }

    @GetMapping("/goReviewList/{productNum}")
    public String goReviewList(@PathVariable("productNum") Long productNum,Model model){
        model.addAttribute("products",productService.getDetail(productNum));
        model.addAttribute("productNum",productNum);
        model.addAttribute("reviews",productReviewService.getList(productNum));
        return reviewList(productNum,model);
    }

    // 스토어 리뷰 작성
    @GetMapping("/reviewWrite")
    public void reviewWrite(Long num, Model model){
        model.addAttribute("product",productService.getDetail(num));
    }

    // 스토어 리뷰 작성 폼
    @PostMapping("/reviewWrite")
    public String reviewWriteForm(ProductReviewVO productReviewVO, Model model){
//        model.addAttribute("user", productNum); 유저의 정보 가져와야함.?? 어떻게??
        productReviewVO.setUserNum(22L);
        productReviewService.insert(productReviewVO);
        return storeDetail(productReviewVO.getProductNum(), model);
    }

    // 스토어 리뷰 작성
    @ResponseBody
    @GetMapping("/reviewDelete")
    public void reviewDelete(Long num){
        productReviewService.delete(num);
    }

    // 스토어 문의 목록
    @ResponseBody
    @GetMapping("/qnaList/{productNum}")
    public List<ProductQnaVO> qnaList(@PathVariable("productNum") Long productNum){
       return productQnaService.getList(productNum);
    }

    // 스토어 문의 작성
    @GetMapping("/qnaWrite")
    public void qnaWrite(Long productNum, Model model){
        //유저 정보도 같이 보내야함
        model.addAttribute("productNum",productNum);
    }

    // 스토어 문의 작성 폼
    @PostMapping("/qnaWrite")
    public String qnaWriteForm(ProductQnaVO productQnaVO, Model model){
        productQnaService.register(productQnaVO);
        return storeDetail(productQnaVO.getProductNum(), model);
    }

    // 스토어 문의 댓글
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

    // 스토어 결제 정보 입력
    @GetMapping("/payment")
    public void payment(){

    }

    // 스토어 결제 정보 입력
    @PostMapping("/payment")
    public void paymentForm(ProductDTO productDTO, ProductVO productVO,Model model){
        model.addAttribute("product", productVO);
        model.addAttribute("productinfo",productDTO);
    }

    // 스토어 결제 전 상품 선택
    @PostMapping("/itemChoose")
    public void itemChoose(ProductVO productVO,Model model){
        model.addAttribute("product",productVO);
    }

    // 결제 완료 후 주문내역
    @PostMapping("/buyProductDetail")//나중에 rest 방식으로 바꿀것
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
}
