package com.example.pickitup.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/project/*")
public class ProjectController {


    // 프로젝트 상세보기
    @GetMapping("/projectDetail")
    public void projectDetail(){
    }

    // 프로젝트 등록 스텝 1
    @GetMapping("/createStep1")
    public void createStep1(){
    }
    // 프로젝트 등록 스텝 2
    @GetMapping("/createStep2")
    public void createStep2(){
    }
    // 프로젝트 등록 스텝 3
    @GetMapping("/createStep3")
    public void createStep3(){
    }
    // 프로젝트 등록 스텝 4
    @GetMapping("/createStep4")
    public void createStep4(){
    }
    // 프로젝트 등록 스텝 5
    @GetMapping("/createStep5")
    public void createStep5(){
    }

    // 프로젝트 등록 스텝 1
    @PostMapping("/createStep1")
    public void projectCreateStep1(){
    }

    // 프로젝트 등록 스텝 2
    @PostMapping("/createStep2")
    public void projectCreateStep2(){
    }

    // 프로젝트 등록 스텝 3
    @PostMapping("/createStep3")
    public void projectCreateStep3(){

    }

    // 프로젝트 등록 스텝 4
    @PostMapping("/createStep4")
    public void projectCreateStep4(){

    }

    // 프로젝트 등록 스텝 5
    @PostMapping("/createStep5")
    public void projectCreateStep5(){

    }





}
