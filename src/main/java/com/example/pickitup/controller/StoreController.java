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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    // 스토어 메인페이지
//    @GetMapping("/main")
//    public void storeMain(){


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

//        model.addAttribute("productlist",productService.getList());


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
//
//    public void storeDetail(){
//

    public String storeDetail(Long num ,Model model){
        model.addAttribute("count",productReviewService.count(num));
        model.addAttribute("product",productService.getDetail(num));
        return "/store/detail";

    }

    // 스토어 리뷰 목록
    @GetMapping("/reviewList")
    public void reviewList(){

    }

    // 스토어 리뷰 작성
    @GetMapping("/reviewWrite")
    public void reviewWrite(){

    }

    // 스토어 리뷰 작성 폼
    @PostMapping("/reviewWrite")
//
//    public void reviewWriteForm(){
//
//    public void reviewWriteForm(ProductReviewVO productReviewVO, Model model){

    public String reviewWriteForm(ProductReviewVO productReviewVO, Model model){

//        model.addAttribute("user", productNum); 유저의 정보 가져와야함.?? 어떻게??
        productReviewVO.setUserNum(22L);
        productReviewService.insert(productReviewVO);
        return storeDetail(productReviewVO.getProductNum(), model);
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
        //유저 정보도 같이 보내야함(관리자)
        productQnaCommentService.register(productQnaCommentVO);
        return "success";
    }
//
//    // 스토어 문의 댓글 작성 폼
//    @PostMapping("/qnaWrite")
//    public String qnaCommentWriteForm(ProductQnaVO productQnaVO, Model model){
//        productQnaService.register(productQnaVO);
//        return storeDetail(productQnaVO.getProductNum(), model);
//    }

    // 스토어 결제 정보 입력
    @GetMapping("/payment")
    public void payment(){

    }

    // 스토어 결제 정보 입력
    @PostMapping("/payment")
    public void paymentForm(){

    }

    // 스토어 결제 전 상품 선택
    @GetMapping("/itemChoose")
    public void itemChoose(){

    }

    // 결제 완료 후 주문내역
    @GetMapping("/buyProductDetail")
    public void buyProductDetail(){

    }

}
