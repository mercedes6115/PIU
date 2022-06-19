package com.example.pickitup.controller;


import com.example.pickitup.domain.vo.dto.PageDTO;
import com.example.pickitup.domain.vo.dto.PointDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;

import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.TempUserSerivce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {
    private final TempUserSerivce tempUserSerivce;

    // 마이페이지 메인
    @GetMapping("/myPage")
    public String mypage(Model model){
        model.addAttribute("jjimProjectList", tempUserSerivce.getJjimProjectList(2L));
        model.addAttribute("jjimProductList", tempUserSerivce.getJjimProductList(2L));
        model.addAttribute("inProductList",tempUserSerivce.getInProductList(2L));
        model.addAttribute("inProjectList",tempUserSerivce.getInProjectList(2L));
        return "/user/myPage";
    }

    // 마이페이지 포인트
    @GetMapping("/myPoint")
    public void mypoint(Model model){
        List<ProductVO> productVOList = tempUserSerivce.getInProductList(2L);
        List<ProjectVO> projectVOList = tempUserSerivce.getInProjectList(2L);

        List<PointDTO> pointDTOList = new ArrayList<PointDTO>();
        for(ProductVO productVO : productVOList) {
            for(PointDTO pointDTO : pointDTOList) {
                pointDTO.setPoint(productVO.getPrice());

            }
        }

        log.info("구매한 상품 개수 : " + productVOList.size());
        log.info("참여한 프로젝트 개수 : " + projectVOList.size());

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
    public void infoUpdate(){

    }

    // 회원 정보 수정 폼
    @PostMapping("/infoUpdate")
    public void infoUpdateForm(){

    }

    // 일반 유저 회원가입
    @GetMapping("/join")
    public void join(){

    }

    // 일반 유저 회원가입 폼
    @PostMapping("/join")
    public void joinForm(UserVO userVO){
        tempUserSerivce.registerUser(userVO);
    }

    // 단체 유저 회원가입
    @GetMapping("/joinGroup")
    public void joinGroup(){

    }

    // 단체 유저 회원가입 폼
    @PostMapping("/joinGroup")
    public void joinGroupForm(){

    }


    // 로그인
    @GetMapping("/login")
    public void login(){

    }

    // 로그인 폼
    @PostMapping("/login")
    public void loginForm(){

    }

    // 회원탈퇴
    @DeleteMapping("/delete")
    public void delete(){

    }
}
