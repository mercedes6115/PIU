package com.example.pickitup.controller;


import com.example.pickitup.domain.vo.dto.PageDTO;
import com.example.pickitup.domain.vo.dto.PointDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.CompanyVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.TempCompanyService;
import com.example.pickitup.service.TempUserSerivce;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.text.ParseException;


@Controller
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
    private final TempUserSerivce tempUserSerivce;
    private final TempCompanyService tempCompanyService;


    // 마이페이지 메인
    @GetMapping("/myPage")
    public String mypage(Model model){
        model.addAttribute("jjimProjectList", tempUserSerivce.getJjimProjectList(2L));
        model.addAttribute("jjimProductList", tempUserSerivce.getJjimProductList(2L));
        model.addAttribute("inProductList",tempUserSerivce.getInProductList(2L));
        model.addAttribute("inProjectList",tempUserSerivce.getInProjectList(2L));
        model.addAttribute("seenProductList",tempUserSerivce.getLatestProductList(2L));
        model.addAttribute("seenProjectList",tempUserSerivce.getLatestProjectList(2L));
        model.addAttribute("getDetail",tempUserSerivce.readUserInfo(2L));
        return "/user/myPage";
    }

    // 마이페이지 포인트
    @GetMapping("/myPoint")
    public String mypoint(Model model) throws ParseException {
        model.addAttribute("changePoint",tempUserSerivce.changePoint(2L));
        model.addAttribute("user",tempUserSerivce.readUserInfo(2L));
        return "/user/myPoint";
    }

    // 마이페이지 QnA
    @GetMapping("/myQnA")
    public void myQnA(){

    }

    // 마이페이지 문의
    @GetMapping("/myReview")
    public void myReview(){

    }

    // 마이페이지 주문내역
    @GetMapping("/myOrderList")
    public void myOrderList(){

    }

    // 비밀번호 찾기
    @GetMapping("/findPw")
    public void findPW(){

    }

    // 비밀번호 재설정
    @GetMapping("/updatePw")
    public void updatePw(){

    }

    // 비밀번호 재설정 폼
    @PostMapping("/updatePw")
    public void updatePwForm(){

    }

    // 회원정보 수정 전 비밀번호 확인
    @GetMapping("/pwCheck")
    public void pwCheck(){

    }

    // 회원 정보 수정
    @GetMapping("/infoUpdate")
    public void infoUpdate(Model model){
        model.addAttribute("user", tempUserSerivce.readUserInfo(2L));
    }

    // 회원 정보 수정 폼
    @PostMapping("/infoUpdate")
    public RedirectView infoUpdateForm(UserVO userVO, RedirectAttributes rttr){
        tempUserSerivce.updateUserInfo(userVO);

        return new RedirectView("/user/myPage");
    }

    // 일반 유저 회원가입
    @GetMapping("/join")
    public void join(){

    }

    // 일반 유저 회원가입 폼
    @PostMapping("/join")
//    public void joinForm(){

    public String joinForm(UserVO userVO){
        userVO.setPhone(String.join("",userVO.getPhone().split("-")));
        log.info(userVO.getPhone());
        tempUserSerivce.registerUser(userVO);
        return "/user/login";

    }

    // 단체 유저 회원가입
    @GetMapping("/joinGroup")
    public void joinGroup(){

    }

    // 단체 유저 회원가입 폼
    @PostMapping("/joinGroup")
    public void joinGroupForm(CompanyVO companyVO){
        companyVO.setPhone(String.join("",companyVO.getPhone().split("-")));
        companyVO.setBusinessPhone(String.join("",companyVO.getBusinessPhone().split("-")));
        companyVO.setProfileUploadPath("null");
        companyVO.setProfileFileName("null");
        log.info(companyVO.getPhone());
        log.info(companyVO.getBusinessPhone());
        tempCompanyService.registerCompany(companyVO);

    }


    // 로그인
    @GetMapping("/login")
    public void login(){

    }

    // 로그인 폼
    @PostMapping("/login")
    public RedirectView loginForm(String email, String password, RedirectAttributes rttr){
        UserVO userVO=tempUserSerivce.loginUser(email, password);
        if(userVO!=null){
            rttr.addFlashAttribute("num", userVO.getNum());
            rttr.addFlashAttribute("nickname", userVO.getNickname());
            return new RedirectView("/main/main");
        }

        return new RedirectView("/user/login");
    }

    // 회원탈퇴
    @DeleteMapping("/delete")
    public void delete(){

    }
}
