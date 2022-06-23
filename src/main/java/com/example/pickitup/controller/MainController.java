package com.example.pickitup.controller;


import com.example.pickitup.Util.SessionManager;
import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.project.projectFile.ProjectFileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class MainController {
    private final ProjectService projectService;
    private final ProjectFileService projectFileService;
    private final SessionManager sessionManager;


    // 메인페이지
    @GetMapping("/main")
    public String main(HttpServletRequest request, Model model) throws ParseException {
        boolean checkLogin= sessionManager.checkSession(request.getSession());
        model.addAttribute("checkLogin",checkLogin);
//        model.addAttribute("projectListThumb", projectFileService.getList());   // 사진 가져오기
        model.addAttribute("projectListJJim", projectService.getListJJim());  // 내용가져오기
        model.addAttribute("projectListPoint", projectService.getListPoint());  // 내용가져오기
        model.addAttribute("projectListApply", projectService.getListApply());  // 내용가져오기

        return "/main/main";

    }


}
