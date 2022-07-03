package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.dto.AdminQnaDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.TempAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    // 프로젝트 상세보기
    @GetMapping("/projectDetail")
    public String projectDetail(Long num, Model model) throws ParseException {
        ProjectVO projectVO = projectService.read(num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date projectDate = sdf.parse(projectVO.getStartTime());
        SimpleDateFormat addSdf = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 HH:mm");
        projectVO.setStartTime(addSdf.format(projectDate));

        model.addAttribute("project", projectVO);
        model.addAttribute("qna", projectService.getQnAList(num));
        return "/project/projectDetail";
    }

    // 프로젝트 문의 작성
    @GetMapping("/qnaWrite")
    public void qnaWrite(HttpSession session, Long num, Model model){
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());

        // projectNum, title -> model 사용
        // userNum -> 쿠키 및 세션 사용
        model.addAttribute("project", projectService.read(num));
    }


    // 프로젝트 문의 작성폼
    @PostMapping("/qnaWriteForm")
    public String qnaWriteForm(HttpSession session, ProjectQnaVO projectQnaVO, AdminQnaDTO adminQnaDTO, Model model) throws ParseException {
        // 임시
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        projectQnaVO.setUserNum(userNum);
        projectService.registerQnA(projectQnaVO);
        tempAdminService.qnaProjectSave(adminQnaDTO);
        return projectDetail(11L, model);

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
    @PostMapping("/createStepForm")
    public String projectCreate(ProjectVO projectVO){
        String startDate = projectVO.getStartTime().substring(0,10)+" "+projectVO.getStartTime().substring(11,16)+":00";
        String endDate = projectVO.getEndTime().substring(0,10)+" "+projectVO.getEndTime().substring(11,16)+":00";
        projectVO.setStartTime(startDate);
        projectVO.setEndTime(endDate);
        projectService.registerProject(projectVO);
        return "/group/main";
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
