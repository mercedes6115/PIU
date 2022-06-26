package com.example.pickitup.controller;


import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.project.projectFile.ProjectFileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class MainController {
    private final ProjectService projectService;
    private final ProjectFileService projectFileService;

    @GetMapping("/main")
    public void test(Model model) throws ParseException {
//        model.addAttribute("projectListThumb", projectFileService.getList());   // 사진 가져오기
        model.addAttribute("projectListJJim", projectService.getListJJim());  // 내용가져오기
        model.addAttribute("projectListPoint", projectService.getListPoint());  // 내용가져오기
        model.addAttribute("projectListApply", projectService.getListApply());  // 내용가져오기

    }



}
