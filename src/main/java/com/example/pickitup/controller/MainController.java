package com.example.pickitup.controller;

import com.example.pickitup.service.project.projectFile.ProjectFileService;
import com.example.pickitup.service.project.projectFile.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class MainController {
    private final ProjectService projectService;
    private final ProjectFileService projectFileService;

    // 메인페이지
    @GetMapping("/main")
    public String main(Model model){
        log.info(projectService.getListJJim().toString());
//        model.addAttribute("projectListThumb", projectFileService.getList());   // 사진 가져오기
        model.addAttribute("projectListJJim", projectService.getListJJim());  // 내용가져오기

        return "/main/main";
    }


}
