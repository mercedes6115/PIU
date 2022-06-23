package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.AdminCriteria;
import com.example.pickitup.domain.vo.Criteria;

import com.example.pickitup.domain.vo.ProductCriteria;

import com.example.pickitup.domain.vo.adminVO.AdminBoardDTO;
import com.example.pickitup.domain.vo.dto.AdminBoardPageDTO;

import com.example.pickitup.domain.vo.dto.PageDTO;
import com.example.pickitup.domain.vo.dto.ProductPageDTO;
import com.example.pickitup.domain.vo.dto.UserDTO;
import com.example.pickitup.domain.vo.user.AdminBoardVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.TempAdminService;
import com.example.pickitup.service.TempCompanyService;
import com.example.pickitup.service.TempProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {
    private final TempAdminService tempAdminService;
    private final TempProductService tempProductService;
    private final TempCompanyService tempCompanyService;

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
    public void boardList(AdminCriteria adminCriteria, Model model){
        log.info("==========");
        log.info("===List===");
        log.info("==========");
        log.info("=====pagenum : "+adminCriteria.getPageNum());
        log.info("=====amount : "+adminCriteria.getAmount());
        log.info("====adminboardcount : " + adminCriteria.getAdminBoardCount());

        if(adminCriteria.getEndDate()==""){
            adminCriteria.setStartDate(null);
        }
        if(adminCriteria.getEndDate()==""){
            adminCriteria.setEndDate(null);
        }

        model.addAttribute("adminboardList", tempAdminService.getAdminboardList(adminCriteria));
        model.addAttribute("adminBoardPageDTO",new AdminBoardPageDTO(adminCriteria, (tempAdminService.getAdminBoardCount(adminCriteria))));
    }

    // 관리자 게시물 등록
    @GetMapping("/boardWrite")
    public void boardWrite(){

    }

    // 관리자 게시물 등록 폼
    @PostMapping("/boardWrite")
    public RedirectView boardWriteForm(AdminBoardVO adminBoardVO, RedirectAttributes rttr){
        log.info("====================");
        log.info("/boardWriteForm");
        log.info("====================");
        tempAdminService.registerWrite(adminBoardVO);
        rttr.addFlashAttribute("num", adminBoardVO.getNum());
        return new RedirectView("/admin/main");
    }

    // 관리자 adminboard 체크 삭제
    @ResponseBody
    @PostMapping("/deleteById")
    public String deleteById(Long num, HttpServletRequest request){
        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i = 0; i<size; i++){
            num = Long.parseLong(ajaxMsg[i]);
                tempAdminService.deleteById(num);
            }
        return "/admin/boardList";
        }

    // 관리자 adminboard 체크 공지 해제
    @ResponseBody
    @PostMapping("/noticeCancel")
    public String noticeCancel(Long num, HttpServletRequest request){
        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i = 0; i<size; i++){
            num = Long.parseLong(ajaxMsg[i]);
            tempAdminService.noticeCancel(num);
        }
        return "/admin/boardList";
    }

    // 관리자 adminboard 체크 공지 지정
    @ResponseBody
    @PostMapping("/noticeConfirm")
    public String noticeConfirm(Long num, HttpServletRequest request){
        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i = 0; i<size; i++){
            num = Long.parseLong(ajaxMsg[i]);
            tempAdminService.noticeConfirm(num);
        }
        return "/admin/boardList";
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
    public void productList(ProductCriteria productCriteria, Model model){
        log.info("=============");
        log.info("===Product===");
        log.info("=============");

        // 아무조건없이 검색했을경우 그에 해당하는 전체적인 목록을 출력해야하기에 =""로 넘어온값은 동적 쿼리에서 null로 인식하지 않아서 null로바꿔줘야함
        if(productCriteria.getType()=="total"){
            productCriteria.setType(null);
        }
        if(productCriteria.getEndDate()==""){
            productCriteria.setStartDate(null);
        }
        if(productCriteria.getEndDate()==""){
            productCriteria.setEndDate(null);
        }
        if(productCriteria.getType()==""){
            productCriteria.setType(null);
        }
        if(productCriteria.getType1()=="") {
            productCriteria.setType1(null);
        }

        model.addAttribute( "productList",tempAdminService.getProductList(productCriteria));
        model.addAttribute("productPageDTO",new ProductPageDTO(productCriteria,(tempAdminService.getTotal())));

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
    public void userDetail(Long num,String category, ProductCriteria productCriteria, Model model){
        log.info("성공"+num);
        log.info("성공"+category);
        if(category.equals("user")){
            model.addAttribute("detailVO",tempAdminService.readUserInfo(num));
        }
        if(category.equals("company")) {
            model.addAttribute("detailVO", tempCompanyService.readCompanyInfo(num));
        }
        log.info("sssss"+tempAdminService.readUserInfo(num).toString());
        log.info("sssss"+tempCompanyService.readCompanyInfo(num).toString());
    }



    // 관리자 유저 문의 글 보기
    @GetMapping("/userQnA")
    public void userQnA(){

    }





}
