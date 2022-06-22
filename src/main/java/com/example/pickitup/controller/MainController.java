package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.service.project.projectFile.ProjectFileService;
import com.example.pickitup.service.project.projectFile.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
