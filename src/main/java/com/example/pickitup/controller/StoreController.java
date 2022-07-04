package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.ProductQnaCriteria;
import com.example.pickitup.domain.vo.dto.*;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public void storeMain(HttpSession session, String category, Model model, HttpServletRequest request){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("userNum", userNum);
        model.addAttribute("checkLogin",checkLogin);
        if(category == ""){
            category = null;
        }
        log.info(request.getRequestURI().split("/")[1]);
        model.addAttribute("productsCount",productService.count());
        model.addAttribute("productlist",productService.getList(category));
        log.info("유저 넘버 : " + userNum);
        model.addAttribute("url",request.getRequestURI().split("/")[1]);
    }

    @ResponseBody
    @PostMapping("/main")
    public List<ProductVO> storepostMain(HttpSession session, String category,Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        model.addAttribute("userNum", userNum);

        if(category == ""){
            category = null;
        }
        model.addAttribute("productsCount",productService.count());
        model.addAttribute("productlist",productService.getList(category));
        return productService.getList(category);
    }

    // 스토어 상세페이지
    @GetMapping("/detail")
    public String storeDetail(HttpSession session, Long num ,Model model){
//        // 유저 세션으로 받아서 num 넣어줘야함
//        model.addAttribute("user", tempUserSerivce.readUserInfo(22L));
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        model.addAttribute("userNum", userNum);

        model.addAttribute("jjimCount",jjimService.count(num));
        model.addAttribute("count",productReviewService.count(num));
        model.addAttribute("product",productService.getDetail(num));
        return "/store/detail";
    }

    // 스토어 리뷰 목록
    @ResponseBody
    @GetMapping("/reviewLists/{productNum}")
    public List<ProductReviewVO> reviewLists(HttpSession session, @PathVariable("productNum") Long productNum, Model model){
        // 유저 세션으로 받아서 num 넣어줘야함
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        return productReviewService.getList(productNum);
    }

    //유저 정보 얻어오기
    @ResponseBody
    @GetMapping("/userInfo")
    public UserVO userinfo(Long userNum,Model model){
        return tempUserSerivce.readUserInfo(userNum);
    }


    // 전체 리뷰 보기 페이지
    @GetMapping("/goReviewList/{productNum}")
    public String goReviewList(HttpSession session,@PathVariable("productNum") Long productNum,Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("products",productService.getDetail(productNum));
        model.addAttribute("productNum",productNum);
        model.addAttribute("reviews",productReviewService.getList(productNum));
        return "/store/reviewList";
    }

    // 스토어 리뷰 작성
    @GetMapping("/reviewWrite")
    public void reviewWrite(HttpSession session,Long num, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        model.addAttribute("userNum",userNum);
        model.addAttribute("user",tempUserSerivce.readUserInfo(userNum));
        model.addAttribute("product",productService.getDetail(num));
    }

    // 스토어 리뷰 작성 폼
    @PostMapping("/reviewWrite")
    public RedirectView reviewWriteForm(HttpSession session, ProductReviewVO productReviewVO, RedirectAttributes rttr,Long productNum, Model model){
//        model.addAttribute("user", productNum); 유저의 정보 가져와야함.?? 어떻게??
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        log.info("===================================");
        log.info("프로덕트넘버다"+productReviewVO.getProductNum());
        log.info("===================================");
        productReviewVO.setUserNum(userNum);
        log.info("productNum======="+productNum);
        log.info("productNum======="+productReviewVO.getProductNum());
        productReviewService.insert(productReviewVO);
        rttr.addAttribute("num",productNum);
        rttr.addAttribute("num",productReviewVO.getProductNum());
        return new RedirectView("/store/detail");
//
    }

    //스토어 리뷰 수정
    @GetMapping("/reviewModify")
    public void reviewModify(HttpSession session, Long num,Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        model.addAttribute("user",tempUserSerivce.readUserInfo(userNum));
        model.addAttribute("review",productReviewService.read(num));
        model.addAttribute("product", productService.getDetail(productReviewService.read(num).getProductNum()));
    }
    //스토어 리뷰 수정 폼
    @PostMapping("/reviewModify")
    public String reviewModify(HttpSession session,
                               ProductReviewVO productReviewVO, Model model){
//        model.addAttribute("user", productNum); 유저의 정보 가져와야함.?? 어떻게??
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        productReviewVO.setUserNum(userNum);
        productReviewService.modify(productReviewVO);
        return storeDetail(session, productReviewVO.getProductNum(), model);
    }

    // 스토어 리뷰 삭제
    @ResponseBody
    @GetMapping("/reviewDelete")
    public void reviewDelete(HttpSession session, Long num, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        productReviewService.delete(num);
    }

    // 스토어 문의 목록
    @ResponseBody
    @GetMapping("/qnaList/{productNum}/{pageNum}")
    public ProductQnaPageDTO qnaList(HttpSession session, @PathVariable("pageNum") int pageNum, @PathVariable("productNum") Long productNum, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        return new ProductQnaPageDTO(productQnaService.getList(new ProductQnaCriteria(pageNum,5),productNum),productQnaService.count(productNum));
    }

    // 스토어 문의 작성
    @GetMapping("/qnaWrite")
    public void qnaWrite(HttpSession session, Long productNum, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        //유저 정보도 같이 보내야함
        model.addAttribute("productNum",productNum);
    }

    // 스토어 문의 작성 폼
    @PostMapping("/qnaWrite")
    public String qnaWriteForm(HttpSession session, ProductQnaVO productQnaVO, AdminQnaDTO adminQnaDTO, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        productQnaService.register(productQnaVO);
//        tempAdminService.qnaStoreSave(adminQnaDTO);
        return storeDetail(session, productQnaVO.getProductNum(), model);
    }

    // 스토어 문의 수정
    @GetMapping("/qnaModify")
    public void qnaModify(HttpSession session, Long num, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        model.addAttribute("qnaDetail",productQnaService.read(num));
    }
    // 스토어 문의 수정폼
    @PostMapping("/qnaModify")
    public String qnaModifyAction(HttpSession session, ProductQnaVO productQnaVO, AdminQnaDTO adminQnaDTO, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        productQnaService.update(productQnaVO);
//        tempAdminService.qnaStoreModify(adminQnaDTO);
        return storeDetail(session, productQnaVO.getProductNum(), model);
    }

    // 스토어 문의 삭제
    @ResponseBody
    @GetMapping("/qnaDelete")
    public void qnaDelete(HttpSession session, Long num, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        productQnaService.remove(num);
    }



    // 스토어 문의 댓글 리스트
    @ResponseBody
    @GetMapping("/qnaCommentList/{qnaNum}")
    public List<ProductQnaCommentVO> qnaCommentList(HttpSession session, @PathVariable("qnaNum") Long qnaNum, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        return productQnaCommentService.getList(qnaNum);
    }

    // 스토어 문의 댓글 작성 (관리자 권한)
    @ResponseBody
    @PostMapping(value = "/qnaCommentWrite", consumes = "application/json")
    public String qnaCommentWrite(HttpSession session, @RequestBody ProductQnaCommentVO productQnaCommentVO, Model model)  throws UnsupportedEncodingException {
        //(관리자) 정보도 같이 보내야함
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        productQnaCommentService.register(productQnaCommentVO);
        return "success";
    }
    //
    // 스토어 문의 댓글 삭제
    // 관리자 번호와 같이 넘어와야함
    @ResponseBody
    @GetMapping("/qnaCommentDelete")
    public String qnaCommentDeleteForm(HttpSession session, Long qnaCommentNum, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        productQnaCommentService.delete(qnaCommentNum);
        return "success";
    }


    // 스토어 문의 댓글 삭제
    // 관리자 번호와 같이 넘어와야함
    @ResponseBody
    @PostMapping("/qnaCommentUpdate")
    public String qnaCommentUpdateForm(HttpSession session, ProductQnaCommentVO productQnaCommentVO, Model model) throws UnsupportedEncodingException {
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        productQnaCommentService.update(productQnaCommentVO);
        return "success";
    }

    @GetMapping("/payment")
    public String payment(HttpSession session, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        orderService.payment(userNum);
        return "store/payment";
    }






    //업데이트는 아직 안됨





//    // 스토어 결제 정보 입력
//    @PostMapping("/payment")
//    public String paymentForm(ProductDTO productDTO, ProductVO productVO,OrderVO orderVO,UserVO userVO,Model model){
//        model.addAttribute("product", productVO);
//        model.addAttribute("productinfo",productDTO);
//        orderService.register(orderVO,userVO);
//        return ("/store/payment");
//    }

    // 스토어 결제 정보 입력
    @PostMapping("/payment")
    public void paymentForm(HttpSession session, ProductDTO productDTO, ProductVO productVO,Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        model.addAttribute("product", productVO);
        model.addAttribute("productinfo",productDTO);
    }

//    @PostMapping("/payment")
//    public void paymentForm(ProductDTO productDTO, ProductVO productVO,Model model){
//        model.addAttribute("product", productVO);
//        model.addAttribute("productinfo",productDTO);
//    }

    // 스토어 결제 전 상품 선택
    @PostMapping("/itemChoose")
    public void itemChoose(HttpSession session, UserVO userVO, ProductVO productVO,Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        userVO = tempUserSerivce.readUserInfo(userNum);

        model.addAttribute("product",productVO);
        model.addAttribute("user", userVO);
    }

    // 결제 완료 후 주문내역
    @PostMapping("/buyProductDetail")
    public void buyProductDetail(HttpSession session, OrderUserDTO orderUserDTO, ProductVO productVO, UserVO userVO, ProductDTO productDTO, String addressComment, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        orderUserDTO.setUserNum(userNum);
        orderUserDTO.setNickName(productDTO.getNickName());
        orderUserDTO.setPhone(productDTO.getPhone());
        orderUserDTO.setCounting(Long.parseLong(productDTO.getTotalitems()));
        orderUserDTO.setTotal(Long.parseLong(productDTO.getTotalpayment()));
        orderUserDTO.setProductName(productDTO.getItemname());
        orderUserDTO.setAddressComment(productDTO.getAddressComment());
        orderUserDTO.setAddress(productDTO.getAddress());
        orderUserDTO.setAddressDetail(productDTO.getAddressDetail());
        tempUserSerivce.orderStore(orderUserDTO);

        userVO = tempUserSerivce.readUserInfo(userNum);
        String point = Long.toString(Long.parseLong(userVO.getPoint()) - Long.parseLong(productDTO.getTotalpayment())); //수정될 포인트
        tempUserSerivce.userPointMinus(userNum, point);

        String itemname = productDTO.getItemname();
        tempUserSerivce.getDetailByName(itemname); // 현재 재고
        Long stock = tempUserSerivce.getDetailByName(itemname) - Long.parseLong(productDTO.getTotalitems()); //수정될 재고
        tempUserSerivce.productMinus(itemname, stock);


        model.addAttribute("addressComment", addressComment);
        model.addAttribute("userinfo",userVO);
        model.addAttribute("orderinfo",orderUserDTO);
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
    public List<JjimVO> listJjim(HttpSession session, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        return jjimService.getList();
    }


    // 찜추가
    @ResponseBody
    @PostMapping("/jjim")
    public void addJjim(HttpSession session, JjimVO jjimVO, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        jjimService.register(jjimVO);
    }

    // 찜해제
    @ResponseBody
    @DeleteMapping("/jjim")
    public void removeJjim(HttpSession session, JjimVO jjimVO, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        jjimService.remove(jjimVO);
    }

    //찜 갯수
    @ResponseBody
    @GetMapping("jjimCount")
    public int count(HttpSession session, Long productNum, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        return jjimService.count(productNum);
    }

    @GetMapping("/buyProductDetail")
    public void myBoughtProductDetail(HttpSession session, String orderNum, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum", userNum);
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        Long orderNumber = Long.parseLong(orderNum);
        OrderUserDTO orderUserDTO = new OrderUserDTO();
        OrderVO orderVO = orderService.findByOrderNum(orderNumber);
        ProductDTO productDTO = tempUserSerivce.boughtOrderDetail(orderNumber);
        log.info("유저 닉네임 : " + productDTO.getNickName());
        orderUserDTO.setUserNum(orderVO.getUserNum());
        orderUserDTO.setNickName(productDTO.getNickName());
        orderUserDTO.setPhone(productDTO.getPhone());
        orderUserDTO.setCounting(Long.parseLong(productDTO.getTotalitems()));
        orderUserDTO.setTotal(Long.parseLong(productDTO.getTotalpayment()));
        orderUserDTO.setProductName(productDTO.getItemname());
        orderUserDTO.setAddressComment(productDTO.getAddressComment());
        orderUserDTO.setAddress(productDTO.getAddress());
        orderUserDTO.setAddressDetail(productDTO.getAddressDetail());
        log.info("유저 닉네임 : " + orderUserDTO.getNickName());
        log.info("orderInfo : " + orderUserDTO);
        model.addAttribute("product", productDTO);
        model.addAttribute("addressComment",orderVO.getAddressComment());
        model.addAttribute("orderinfo",orderUserDTO);
        model.addAttribute("userinfo", tempUserSerivce.readUserInfo(orderVO.getUserNum()));
    }
}
