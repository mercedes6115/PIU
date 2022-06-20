package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.dto.PageDTO;
import com.example.pickitup.domain.vo.dto.UserDTO;
import com.example.pickitup.service.TempAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Service;

@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {
    private final TempAdminService tempAdminService;

    // 관리자 로그인
    @GetMapping("/login")
    public void login(){

    }

    // 관리자 메인
    @GetMapping("/main")
    public void main(){

    }

    // 관리자 게시물 목록
    @GetMapping("/boardList")
    public void boardList(){

    }

    // 관리자 게시물 등록
    @GetMapping("/boardWrite")
    public void boardWrite(){

    }

    // 관리자 게시물 등록 폼
    @PostMapping("/boardWrite")
    public void boardWriteForm(){

    }


    // 관리자 주문 목록
    @GetMapping("/orderList")
    public void orderList(){

    }

    // 관리자 프로젝트 목록
    @GetMapping("/projectList")
    public void projectList(){

    }

    // 관리자 프로젝트 생성 폼
    @GetMapping("/projectCreate")
    public void projectCreate(){

    }

    // 관리자 프로젝트 생성
    @PostMapping("/projectCreate")
    public void projectCreateForm(){

    }

    // 관리자 상품 목록
    @GetMapping("/productList")
    public void productList(){

    }

    // 관리자 상품 등록
    @GetMapping("/productRegister")
    public void productRegister(){

    }

    // 관리자 상품 등록
    @PostMapping("/productRegister")
    public void productRegisterForm(){

    }

    // 관리자 유저 목록
    @GetMapping("/userList")
    public void userList(Criteria criteria, Model model){
        log.info("==========");
        log.info("===List===");
        log.info("==========");
        log.info("====="+criteria.getEndDate());
        log.info("====="+criteria.getKeyword());
        log.info("====="+criteria.getStartDate());
        log.info("====="+criteria.getType());
        log.info("====="+criteria.getType1());
        // 아무조건없이 검색했을경우 그에 해당하는 전체적인 목록을 출력해야하기에 =""로 넘어온값은 동적 쿼리에서 null로 인식하지 않아서 null로바꿔줘야함
        if(criteria.getType()=="total"){
            criteria.setType(null);
        }
        if(criteria.getEndDate()==""){
                criteria.setStartDate(null);
            }
        if(criteria.getEndDate()==""){
            criteria.setEndDate(null);
        }

        if(criteria.getType()==""){
            criteria.setType(null);
        }
        if(criteria.getType1()=="") {
            criteria.setType1(null);
        }


//        model.addAttribute("boardList")
        model.addAttribute( "userList",tempAdminService.getList(criteria));
        model.addAttribute("pageDTO",new PageDTO(criteria,(tempAdminService.getTotal(criteria))));
        //tempAdminService.getList(criteria)).size())
        // 검색결과에 따라 페이징할 리스트의 길이가 달라지기 때문에 바로
        // 리스트의 사이즈를 구해줘서 total로 넘겨준다
    }



    // 관리자 유저 상세보기
    @GetMapping("/userDetail")
    public void userDetail(){

    }



}
