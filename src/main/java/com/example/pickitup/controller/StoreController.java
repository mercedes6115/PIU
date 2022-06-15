package com.example.pickitup.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/pickitup/store/*")
public class StoreController {

    // 스토어 메인페이지
    @GetMapping("/store")
    public void storeMain(){

    }

    // 스토어 상세페이지
    @GetMapping("/store/{ino}")
    public void storeDetail(){

    }

    //
}
