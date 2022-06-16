package com.example.pickitup.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/adminR/*")
@RequiredArgsConstructor
public class AdminRestController {


    // qr생성
    @PostMapping("/qr")
    public void addQr(){

    }

    // 관리자 프로젝트 승인
    @GetMapping("/approveProject")
    public void approveProject(){

    }

    // 관리자 단체유저 승인
    @GetMapping("/approveProduct")
    public void approveProduct(){

    }

    // 문의글 답변
    @PostMapping("/comment")
    public void addComment(){

    }


}
