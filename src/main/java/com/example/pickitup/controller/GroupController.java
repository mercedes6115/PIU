package com.example.pickitup.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/group/*")
public class GroupController {


    // 그룹 메인
    @GetMapping("/main")
    public void main(){

    }

    // 그룹 공지사항
    @GetMapping("/notice")
    public void notice(){

    }

    // 그룹 공지사항 상세보기
    @GetMapping("/noticeDetail")
    public void noticeDetail(){

    }

    // 그룹 마이페이지
    @GetMapping("/introduce")
    public void introduce(){
    }


    // 그룹 프로필 수정 메인
    @GetMapping("/modifyMain")
    public void modifyMain(){
    }


    // 그룹 프로필 수정
    @GetMapping("/modify")
    public void modify(){

    }

    // 그룹 프로필 수정 폼
    @PostMapping("/modify")
    public void modifyForm(){

    }

    // 그룹 QnA
    @GetMapping("/qna")
    public void qna(){

    }



}
