package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.dto.AdminQnaDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.service.CompanyService;
import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.TempAdminService;
import com.example.pickitup.service.TempUserSerivce;
import com.example.pickitup.service.user.ApplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Slf4j
@RequestMapping("/project/*")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final TempAdminService tempAdminService;
    private final ApplyService applyService;
    private final CompanyService companyService;
    private final TempUserSerivce tempUserSerivce;

    // 프로젝트 상세보기
    @GetMapping("/projectDetail")
    public String projectDetail(Long num, Model model) throws ParseException {

        ProjectVO projectVO = projectService.read(num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date projectDate = sdf.parse(projectVO.getProjectDate());
        SimpleDateFormat addSdf = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 HH:mm");

        projectVO.setProjectDate(addSdf.format(projectDate));

        model.addAttribute("company", companyService.read(projectVO.getCompanyNum()));
        model.addAttribute("project", projectVO);
        model.addAttribute("qna", projectService.getQnAList(num));
        model.addAttribute("img", projectService.getProjectFileList(num));
        return "/project/projectDetail";
    }


    // 프로젝트 문의 작성
    @GetMapping("/qnaWrite")
    public void qnaWrite(Long num, Model model){

        // projectNum, title -> model 사용
        // userNum -> 쿠키 및 세션 사용
        model.addAttribute("project", projectService.read(num));
    }


    // 프로젝트 문의 작성폼
    @PostMapping("/qnaWriteForm")
    public String qnaWriteForm(ProjectQnaVO projectQnaVO, AdminQnaDTO adminQnaDTO, Model model) throws ParseException {
        // 임시
        projectQnaVO.setUserNum(42L);
        projectService.registerQnA(projectQnaVO);
        tempAdminService.qnaProjectSave(adminQnaDTO);
        return projectDetail(41L, model);

    }

    // 프로젝트 등록 스텝 1
    @GetMapping("/createStep")
    public void createStep1(){
    }


//
//    // 프로젝트 등록 스텝 2
//    @GetMapping("/createStep2")
//    public void createStep2(){
//    }
//
    // 프로젝트 등록 스텝 3
    @GetMapping("/createStep3")
    public void createStep3(){
    }
//
//    // 프로젝트 등록 스텝 4
//    @GetMapping("/createStep4")
//    public void createStep4(){
//    }
//    // 프로젝트 등록 스텝 5
//    @GetMapping("/createStep5")
//    public void createStep5(){
//    }

    // 프로젝트 등록 스텝 1
    @PostMapping("/createStep")
    public void projectCreate(ProjectVO projectVO){
        projectService.registerProject(projectVO);
    }


    // 프로젝트 찜 추가
    @PostMapping("/jjim")
    @ResponseBody
    public void addJjim(@RequestBody JjimVO jjimVO){
        projectService.addJjim(jjimVO);
    }

    // 프로젝트 찜 해제
    @DeleteMapping("/jjim")
    @ResponseBody
    public void removeJjim(@RequestBody JjimVO jjimVO){
        projectService.removeJjim(jjimVO);
    }


    // 프로젝트 지원
    @PostMapping("/apply")
    @ResponseBody
    public void applyProject(@RequestBody ApplyVO applyVO){

    }


    // 리뷰작성
    @GetMapping("/review/add")
    public String addReview(){
        return "/project/projectReviewWrite";

    }

    // 리뷰작성폼
    @PostMapping("/review/add")
    public void addReviewForm(ProjectReviewVO projectReviewVO){
        projectService.registerReview(projectReviewVO);
    }


    // 전체 목록
    @GetMapping("/projectAllList")
    public void projectAllList(){

    }


}
