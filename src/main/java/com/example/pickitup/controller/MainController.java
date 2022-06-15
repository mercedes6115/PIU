package com.example.pickitup.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/pickitup/main/*")
public class MainController {


    // 메인페이지
    @GetMapping("/main")
    public void main(){
        log.info("============== main페이지");
    }

    // 게시물 상세보기
    @GetMapping("/{pno}")
    public void projectDetail(){
    }

    // 로그인
    @GetMapping("/login")
    public void login(){

    }

    // 회원가입
    @GetMapping("/join")
    public void join(){

    }

    // 단체 회원가입
    @GetMapping("/joinCorp")
    public void joinCorp(){

    }




}
