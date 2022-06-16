package com.example.pickitup.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/store/*")
public class StoreController {

    // 스토어 메인페이지
    @GetMapping("/main")
    public void storeMain(){

    }

    // 스토어 상세페이지
    @GetMapping("/detail")
    public void storeDetail(){

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
    public void reviewWriteForm(){

    }

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
