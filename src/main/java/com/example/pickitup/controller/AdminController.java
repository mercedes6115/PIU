package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.Criteria;

import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.ProductCriteria;

import com.example.pickitup.domain.vo.ProjectCriteria;
import com.example.pickitup.domain.vo.dto.*;

import com.example.pickitup.domain.vo.user.AdminBoardVO;
import com.example.pickitup.service.TempAdminService;
import com.example.pickitup.service.TempCompanyService;
import com.example.pickitup.service.TempProductService;
import com.example.pickitup.service.TempUserSerivce;
import com.example.pickitup.service.project.projectFile.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;

@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {
    private final TempAdminService tempAdminService;
    private final TempProductService tempProductService;
    private final TempCompanyService tempCompanyService;
    private final TempUserSerivce tempUserSerivce;
    private final ProjectService projectService;

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
    public void boardList(Criteria criteria, Model model){
        log.info("==========");
        log.info("===List===");
        log.info("==========");
        model.addAttribute("adminboardList", tempAdminService.getAdminboardList(criteria));
        model.addAttribute("adminBoardPageDTO",new AdminBoardPageDTO(criteria, (tempAdminService.getAdminBoardCount(criteria))));
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


    // 관리자 주문 목록
    @GetMapping("/orderList")
    public void orderList(OrderCriteria orderCriteria, Model model){
        log.info("====================");
        log.info("/orderList");
        log.info("====================");
        if(orderCriteria.getType()==""){
            orderCriteria.setType(null);
        }
        if(orderCriteria.getType1()==""){
            orderCriteria.setType1(null);
        }
        if(orderCriteria.getEndDate()==""){
            orderCriteria.setStartDate(null);
        }
        if(orderCriteria.getEndDate()==""){
            orderCriteria.setEndDate(null);
        }

        model.addAttribute("orderList",tempAdminService.getOrderList(orderCriteria));
        model.addAttribute("orderPageDTO",new OrderPageDTO(orderCriteria,(tempUserSerivce.getOrderTotal(orderCriteria))));


    }

    // 관리자 프로젝트 목록
    @GetMapping("/projectList")
    public void projectList(ProjectCriteria projectCriteria, Model model, HttpServletRequest request){
        log.info("====================");
        log.info("/projectList");
        log.info("====================");

        if(projectCriteria.getType()==""){
            projectCriteria.setType(null);
        }
        if(projectCriteria.getType1()=="total"){
            projectCriteria.setType1(null);
        }
        if(projectCriteria.getType2()==""){
            projectCriteria.setType2(null);
        }
        if(projectCriteria.getEndDate()==""){
            projectCriteria.setStartDate(null);
        }
        if(projectCriteria.getStartDate()==""){
            projectCriteria.setEndDate(null);
        }
        request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(request.getRemoteAddr()+"==========");
        model.addAttribute( "projectList",projectService.getProjectList(projectCriteria));
        model.addAttribute("projectPageDTO",new ProjectPageDTO(projectCriteria,(projectService.getProjectTotal(projectCriteria))));
        model.addAttribute("ipV4",request.getRemoteAddr());
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
            if(productCriteria.getStartDate()==""){
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

    @PostMapping("/deleteProduct")
    @ResponseBody
    public void deleteProduct(Long num, HttpServletRequest request){
        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i = 0; i<size; i++) {
            num = Long.parseLong(ajaxMsg[i]);
            tempAdminService.removeProduct(num);
        }
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




    @PostMapping("/statusDisable")
    @ResponseBody
    public void statusDisable(HttpServletRequest request){
        String[] ajaxMsg = request.getParameterValues("list");
        String[] ajaxMsg1 = request.getParameterValues("list1");
        for(int i=0; i< ajaxMsg.length;i++) {
            if(ajaxMsg[i].equals("user")){
                tempAdminService.UserStatusDisable(Long.parseLong(ajaxMsg1[i]));
            }else{
                tempAdminService.CompanyStatusDisable(Long.parseLong(ajaxMsg1[i]));
            }
        }
    }

    @PostMapping("/statusEnable")
    @ResponseBody
    public void statusEnable(HttpServletRequest request){

        String[] ajaxMsg = request.getParameterValues("listEn");
        String[] ajaxMsg1 = request.getParameterValues("listEn1");
        for(int i=0; i< ajaxMsg.length;i++) {
            if(ajaxMsg[i].equals("user")){
                tempAdminService.UserStatusEnable(Long.parseLong(ajaxMsg1[i]));
            }else{
                tempAdminService.CompanyStatusEnable(Long.parseLong(ajaxMsg1[i]));
            }
        }
    }


    @PostMapping("/detailEnable")
    @ResponseBody
    public void detailEnable(HttpServletRequest request){
        String category = request.getParameter("category");
        String statNum = request.getParameter("stateNum");
        log.info("==================="+category);
        log.info("==================="+statNum);
        if(category.equals("user")){
            tempAdminService.UserStatusEnable(Long.parseLong(statNum));
        }
        if(category.equals("company")){
            tempAdminService.CompanyStatusEnable(Long.parseLong(statNum));
        }
    }

    @PostMapping("/detailDisable")
    @ResponseBody
    public void detaiDisable(HttpServletRequest request){
        String category = request.getParameter("category");
        String statNum = request.getParameter("stateNum");
        log.info("==================="+category);
        log.info("==================="+statNum);
        if(category.equals("user")){
            tempAdminService.UserStatusDisable(Long.parseLong(statNum));
        }
        if(category.equals("company")){
            tempAdminService.CompanyStatusDisable(Long.parseLong(statNum));
        }
    }

    @PostMapping("/detailApprovalEnable")
    @ResponseBody
    public void detailApprovalEnable(HttpServletRequest request){
        String category = request.getParameter("category");
        String statNum = request.getParameter("stateNum");

        log.info("==================="+category);
        log.info("==================="+statNum);
        if(category.equals("user")){
            tempAdminService.UserApprovalEnable(Long.parseLong(statNum));
        }
        if(category.equals("company")){
            tempAdminService.CompanyApprovalEnable(Long.parseLong(statNum));
        }
    }

    @PostMapping("/detailApprovalDisable")
    @ResponseBody
    public void detailApprovalDisable(HttpServletRequest request){
        String category = request.getParameter("category");
        String statNum = request.getParameter("stateNum");
        log.info("==================="+category);
        log.info("==================="+statNum);
        if(category.equals("user")){
            tempAdminService.UserApprovalDisable(Long.parseLong(statNum));
        }
        if(category.equals("company")){
            tempAdminService.CompanyApprovalDisable(Long.parseLong(statNum));
        }
    }
    // 관리자 유저 상세보기
    @GetMapping("/userDetail")
    public void userDetail(Long num,String category, ProductCriteria productCriteria, Model model){
        log.info("성공"+num);
        log.info("성공"+category);

        //받아온 카테고리를 통하여 일반유저인지 단체유저인지 확인
        if(category.equals("user")){
            model.addAttribute("detailVO",tempAdminService.readUserInfo(num));
        }
        if(category.equals("company")) {
            model.addAttribute("detailVO", tempCompanyService.readCompanyInfo(num));
        }

    }


    @PostMapping("/modifyInfo")
    @ResponseBody
    public String modifyInfo(String password,String category,Long num){

        log.info(password+"=================");
        log.info(category+"=================");
        log.info(num+"=================");
        if(category.equals("user")){
            tempUserSerivce.adminPwUpdate(password,num);
        }
        if(category.equals("company")){
             tempUserSerivce.adminPwUpdate(password,num);
        }
        return"성공";

    }


    // 관리자 유저 문의 글 보기
    @GetMapping("/userQnA")
    public void userQnA(){

    }





}
