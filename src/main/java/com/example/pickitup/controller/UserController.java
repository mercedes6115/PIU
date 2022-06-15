package com.example.pickitup.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/pickitup/user/*")
public class UserController {

    // 마이페이지 메인
    @GetMapping("/mypage")
    public void mypage(){

    }

    // 마이페이지 포인트
    @GetMapping("/mypoint")
    public void mypoint(){

    }

    // 마이페이지 QnA
    @GetMapping("/myQnA")
    public void myQnA(){

    }

    // 마이페이지 문의
    @GetMapping("/myReview")
    public void myReview(){

    }

    // 마이페이지 주문내역
    @GetMapping("/myorderlist")
    public void myOrderList(){

    }

}
