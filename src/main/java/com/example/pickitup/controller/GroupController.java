package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.AdminCriteria;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.dto.PageDTO;
import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.TempAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/group/*")
public class GroupController {
    private final TempAdminService tempAdminService;
    private final ProjectService projectService;


    // 그룹 메인
//    @GetMapping("/main")
//    public void main(Model model, Criteria criteria){
//        model.addAttribute("projectList", projectService.getProjectList(10L,criteria ));
//    }

    // 그룹 공지사항
//    @GetMapping("/notice")
//    public String notice(AdminCriteria adminCriteria, Model model){
//        model.addAttribute("adminBoardList", tempAdminService.getNoticeList(criteria));
//        model.addAttribute("pageDTO", new PageDTO(adminCriteria, tempAdminService.getNoticeTotal()));
//        return "group/notice";
//    }

    // 그룹 공지사항 상세보기
    @GetMapping("/noticeDetail")
    public void noticeDetail(Long num, Criteria criteria, HttpServletRequest request, Model model){
        String requestURL = request.getRequestURI();
        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        log.info("*************");
        log.info("================================");
        log.info(criteria.toString());
        log.info("================================");
        model.addAttribute("adminBoard", tempAdminService.getReadDetail(51L));
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


    // 그룹 QnA
    @GetMapping("/qna")
    public void qna(){

    }



}
