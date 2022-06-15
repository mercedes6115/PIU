package com.example.pickitup.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/user/*")
public class UserController {

    // 마이페이지 메인
    @GetMapping("/myPage")
    public void mypage(){

    }

    // 마이페이지 포인트
    @GetMapping("/myPoint")
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
    @GetMapping("/myOrderList")
    public void myOrderList(){

    }

    // 비밀번호 찾기
    @GetMapping("/findPw")
    public void findPW(){

    }

    // 비밀번호 재설정
    @GetMapping("/updatePw")
    public void updatePw(){

    }

    // 회원정보 수정 전 비밀번호 확인
    @GetMapping("/pwCheck")
    public void pwCheck(){

    }

    // 회원 정보 수정
    @GetMapping("/infoUpdate")
    public void infoUpdate(){

    }

    // 일반 유저 회원가입
    @GetMapping("/join")
    public void join(){

    }

    // 단체 유저 회원가입
    @GetMapping("/joinGroup")
    public void joinGroup(){

    }

    // 로그인
    @GetMapping("/login")
    public void login(){

    }

}
