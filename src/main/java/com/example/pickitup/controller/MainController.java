package com.example.pickitup.controller;

import com.example.pickitup.service.project.projectFile.ProjectFileService;

import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.project.projectFile.ProjectFileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class MainController {
    private final ProjectService projectService;
    private final ProjectFileService projectFileService;

    // 메인페이지
    @GetMapping("/main")
    public String main(HttpSession session, Model model) throws ParseException {
       int checkLogin=0;

        if(session.getAttribute("num")==null||session.getAttribute("nickname")==null){
            log.info("aaaaaaaaaaaaaaaaaaaaaaaaaa");
            log.info("aaaaaaaaaaaaaaaaaaaaaaaaaa");
            log.info(session.getAttribute("num").toString());
            log.info(session.getAttribute("nickname").toString());

            log.info("aaaaaaaaaaaaaaaaaaaaaaaaaa");
            log.info("aaaaaaaaaaaaaaaaaaaaaaaaaa");
            checkLogin= 1;
        }else if(session.getAttribute("token")!=null){
            checkLogin = 2;
        }else{
            checkLogin= 3;
        }

       model.addAttribute("checkLogin",checkLogin);
       return "/main/main";

    }



    @GetMapping("/test")
    public void test(Model model) throws ParseException {
//        model.addAttribute("projectListThumb", projectFileService.getList());   // 사진 가져오기
        model.addAttribute("projectListJJim", projectService.getListJJim());  // 내용가져오기
        model.addAttribute("projectListPoint", projectService.getListPoint());  // 내용가져오기
        model.addAttribute("projectListApply", projectService.getListApply());  // 내용가져오기

    }



}
