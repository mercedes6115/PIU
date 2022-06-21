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



    // 메인페이지
    @GetMapping("/main")
    public String main(Model model) throws ParseException {

//        List<ProjectVO> aaaa = projectService.getListJJim();
//
//        for(ProjectVO aa : aaaa) {
//            String strDate = aa.getProjectDate();  // 기준 날짜 데이터 (("yyyy-MM-dd")의 형태)
//            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // 오늘날짜
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//            Date date = new Date(dateFormat.parse(strDate).getTime());
//            Date today = new Date(dateFormat.parse(todayFm).getTime());
//
//            long calculate = date.getTime() - today.getTime();
//
//            int Ddays = (int) (calculate / ( 24*60*60*1000));
////            aa.setDday(Ddays);
//            System.out.println("두 날짜 차이일 : " + Ddays);
//
////            dDayMap.put(v,  Ddays);
//
//        }
//
////        model.addAttribute("dDayMap" , dDayMap);

        return test(model);
    }



    @GetMapping("/test")
    public String test(Model model) throws ParseException {
//        model.addAttribute("projectListThumb", projectFileService.getList());   // 사진 가져오기
        model.addAttribute("projectListJJim", projectService.getListJJim());  // 내용가져오기
        model.addAttribute("projectListPoint", projectService.getListPoint());  // 내용가져오기
        model.addAttribute("projectListApply", projectService.getListApply());  // 내용가져오기

        return "/main/main";
    }



}
