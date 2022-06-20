package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.dto.ProductDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.product.productFile.ProductFileService;
import com.example.pickitup.service.product.productFile.ProductService;
import com.example.pickitup.service.product.productQna.ProductQnaService;
import com.example.pickitup.service.product.productReview.ProductReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // 스토어 메인페이지
    @GetMapping("/main")
    public void storeMain(Model model){
        model.addAttribute("productlist",productService.getList());
    }

    // 스토어 상세페이지
    @GetMapping("/detail")
    public void storeDetail(Long num ,Model model){
        model.addAttribute("count",productQnaService.count(num));
        model.addAttribute("product",productService.getDetail(num));
    }

    // 스토어 리뷰 목록
    @ResponseBody
    @GetMapping("/reviewList/{productNum}")
    public List<ProductReviewVO> reviewList(@PathVariable("productNum") Long productNum){
       return productReviewService.getList(productNum);
    }

    @GetMapping("/goReviewList/{productNum}")
    public String goReviewList(@PathVariable("productNum") Long productNum,Model model){
        model.addAttribute("products",productService.getDetail(productNum));
        log.info("------------------------1------------------");
        log.info("-----------------------2--------------");
        log.info(productService.getDetail(productNum).toString());
        log.info("----------------------3-----------");
        log.info("-----------------------4--------");
        model.addAttribute("reviews",productReviewService.getList(productNum));
        return "/store/reviewList";
    }

    // 스토어 리뷰 작성
    @GetMapping("/reviewWrite")
    public void reviewWrite(){

    }

    // 스토어 리뷰 작성 폼
    @PostMapping("/reviewWrite")
    public void reviewWriteForm(){

    }
    // 스토어 문의 목록
    @ResponseBody
    @GetMapping("/qnaList/{productNum}")
    public List<ProductQnaVO> qnaList(@PathVariable("productNum") Long productNum){
       return productQnaService.getList(productNum);
    }

    // 스토어 문의 작성
    @GetMapping("/qnaWrite")
    public void qnaWrite(){

    }

    // 스토어 문의 작성 폼
    @PostMapping("/qnaWrite")
    public void qnaWriteForm(){

    }

    // 스토어 결제 정보 입력
    @GetMapping("/payment")
    public void payment(){

    }

    // 스토어 결제 정보 입력
    @PostMapping("/payment")
    public void paymentForm(ProductDTO productDTO, Model model){
        model.addAttribute("productinfo",productDTO);
    }

    // 스토어 결제 전 상품 선택
    @PostMapping("/itemChoose")
    public void itemChoose(ProductVO productVO,Model model){
        model.addAttribute("product",productVO);
    }

    // 결제 완료 후 주문내역
    @PostMapping("/buyProductDetail")//나중에 rest 방식으로 바꿀것
    public void buyProductDetail(UserVO userVO,ProductDTO productDTO,Model model){
        model.addAttribute("userinfo",userVO);
        model.addAttribute("product",productDTO);
    }

}
