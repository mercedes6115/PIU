package com.example.pickitup.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/userR/*")
@RequiredArgsConstructor
public class UserRestController {

    // 문의글
    @PostMapping("/qna")
    public void addQnA() {

    }

    // 후기
    @PostMapping("/review")
    public void addReview() {

    }

    // 찜추가
    @PostMapping("/jjim")
    public void addJjim(){

    }

    // 찜해제
    @DeleteMapping("/jjim")
    public void removeJjim(){

    }
}
