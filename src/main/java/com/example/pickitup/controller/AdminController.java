package com.example.pickitup.controller;
import com.example.pickitup.domain.vo.AdminCriteria;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.ProductCriteria;
import com.example.pickitup.domain.vo.ProjectCriteria;
import com.example.pickitup.domain.vo.dto.*;
import com.example.pickitup.domain.vo.dto.AdminBoardPageDTO;
import com.example.pickitup.domain.vo.dto.PageDTO;
import com.example.pickitup.domain.vo.dto.ProductPageDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.AdminBoardVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.domain.vo.*;
import com.example.pickitup.domain.vo.adminVO.AdminBoardDTO;
import com.example.pickitup.domain.vo.dto.*;
import com.example.pickitup.domain.vo.dto.AdminBoardPageDTO;
import com.example.pickitup.domain.vo.dto.PageDTO;
import com.example.pickitup.domain.vo.dto.ProductPageDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.dto.UserDTO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.user.AdminBoardVO;
import com.example.pickitup.service.TempAdminService;
import com.example.pickitup.service.TempCompanyService;
import com.example.pickitup.service.AdminProductService;
import com.example.pickitup.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.Loader;
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
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {
    private final TempAdminService tempAdminService;
    private final AdminProductService adminProductService;
    private final TempCompanyService tempCompanyService;
    private final TempUserSerivce tempUserSerivce;
    private final ProjectService projectService;
    // 관리자 로그인
    @GetMapping("/login")
    public String login(){
        return "/admin/main";
    }


    @GetMapping("/adminQRList")
    public void adminQRList(HttpServletRequest request,Model model){
        request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(request.getRemoteAddr()+"==========");
        model.addAttribute("ipV4",request.getRemoteAddr());
    }


    @PostMapping("/qrEndLogin")
    public void qrEndCheck(String email, String password,HttpServletRequest request,Model model){

        // 이메일과 비밀번호를 통해 userDTO를 불러옴
        UserDTO userDTO=tempUserSerivce.loginUser(email, password);

        Long userNum = userDTO.getNum();

        log.info("============="+userNum);

        QrDTO qrDTO = tempUserSerivce.getQrInfo(userNum);

        log.info(qrDTO.getUserNum() + "===================");
        log.info(qrDTO.getProjectApproval() + "===================");
        log.info(qrDTO.getProjectNum() + "===================");
        log.info(qrDTO.getAddPoint() + "===================");
        log.info(qrDTO.getUserPoint() + "===================");
        log.info(qrDTO.getEndQr() + "===================");
        log.info(qrDTO.getStartQr() + "===================");
        log.info(qrDTO.getApplyNum() + "===================");
            // DTO에서 필요한 정보들을 빼냄
        Long applyNum = qrDTO.getApplyNum();
        int user_point=Integer.parseInt(qrDTO.getUserPoint());
        int add_point=Integer.parseInt(qrDTO.getAddPoint());
        int final_point = user_point+add_point;
        String totalPoint = Integer.toString(final_point);

        tempAdminService.autoPoint(totalPoint,userNum,applyNum);

        request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(request.getRemoteAddr()+"==========");
        model.addAttribute("ipV4",request.getRemoteAddr());

    }

    @PostMapping("/qrStartLogin")
    public void qrStartCheck(String email, String password,HttpServletRequest request,Model model){

        // 이메일과 비밀번호를 통해 userDTO를 불러옴
        UserDTO userDTO=tempUserSerivce.loginUser(email, password);

        Long userNum = userDTO.getNum();

        log.info("============="+userNum);

        QrDTO qrDTO = tempUserSerivce.getQrInfo(userNum);

        log.info(qrDTO.getUserNum() + "===================");
        log.info(qrDTO.getProjectApproval() + "===================");
        log.info(qrDTO.getProjectNum() + "===================");
        log.info(qrDTO.getAddPoint() + "===================");
        log.info(qrDTO.getUserPoint() + "===================");
        log.info(qrDTO.getEndQr() + "===================");
        log.info(qrDTO.getStartQr() + "===================");
        log.info(qrDTO.getApplyNum() + "===================");
        // DTO에서 필요한 정보들을 빼냄
        Long applyNum = qrDTO.getApplyNum();
        Long projectNum = qrDTO.getProjectNum();


        projectService.setApproval(projectNum,applyNum);

        request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(request.getRemoteAddr()+"==========");
        model.addAttribute("ipV4",request.getRemoteAddr());

    }


    @GetMapping("/qrEndLogin")
    public void qrEndLogin(HttpServletRequest request,Model model,String num,String state){

        // 이메일과 비밀번호를 통해 userDTO를 불러옴

        log.info("============="+num);
        log.info("============="+state);
        // DTO에서 필요한 정보들을 빼냄

        request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(request.getRemoteAddr()+"==========");
        model.addAttribute("ipV4",request.getRemoteAddr());

    }

    @GetMapping("/qrStartLogin")
    public void qrStartLogin(HttpServletRequest request,Model model,String num,String state){

        // 이메일과 비밀번호를 통해 userDTO를 불러옴

        log.info("============="+num);
        log.info("============="+state);
        // DTO에서 필요한 정보들을 빼냄

        request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(request.getRemoteAddr()+"==========");
        model.addAttribute("ipV4",request.getRemoteAddr());

    }

    // 관리자 메인
    @GetMapping("/main")
    public void main(Model model,OrderCriteria orderCriteria){

        Date now = new Date();
        Date now1 = new Date();
        Date now2 = new Date();

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        String endDate=sdf.format(now);


        Calendar cal = Calendar.getInstance();
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(now);
        cal1.setTime(now1);
        cal2.setTime(now2);

        cal1.add(Calendar.DATE,-1);
        cal2.add(Calendar.MONTH,-1);

        String startDate1 = sdf.format(cal1.getTime());
        String startDate2 = sdf.format(cal2.getTime());


        log.info(startDate1+"+===================");
        log.info(startDate2+"+===================");
        log.info(endDate+"+===================");

        model.addAttribute("projectList",projectService.getListToday(startDate1,endDate));
        model.addAttribute("orderList",tempAdminService.getListToday(startDate2,endDate));
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

        log.info("====================");
        tempAdminService.registerWrite(adminBoardVO);
        rttr.addFlashAttribute("num", adminBoardVO.getNum());
        return new RedirectView("/admin/boardList");
    }

    // 관리자 adminboard 체크 삭제
    @ResponseBody
    @PostMapping("/deleteById")
    public String deleteById(Long num, HttpServletRequest request){
        String[] ajaxMsg = request.getParameterValues("valueArr");
        String[] category = request.getParameterValues("category");
        int size = ajaxMsg.length;
        for(int i = 0; i<size; i++){
            num = Long.parseLong(ajaxMsg[i]);
            tempAdminService.productQnaDelete(num);
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

    // 관리자 주문 상세
    @GetMapping("/orderDetail")
    public void orderDetail(Long num,String category, ProductCriteria productCriteria, Model model){
        log.info("성공"+num);
        log.info("성공"+category);
        model.addAttribute("detailVO",tempAdminService.readUserInfo(num));

        log.info("sssss"+tempAdminService.readUserInfo(num).toString());
        log.info("sssss"+tempCompanyService.readCompanyInfo(num).toString());
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
        model.addAttribute("ipV4",request.getRemoteAddr());
        model.addAttribute( "projectList",projectService.getProjectList(projectCriteria));
        model.addAttribute("projectPageDTO",new ProjectPageDTO(projectCriteria,(projectService.getProjectTotal(projectCriteria))));

    }

    // 관리자 프로젝트 생성 폼
    @GetMapping("/projectCreate")
    public void projectCreate(){

    }

    // 관리자 프로젝트 생성
    @PostMapping("/projectCreate")
    public void projectCreateForm(ProjectVO projectVO){
        log.info("==========="+projectVO.getStartTime());
        log.info("==========="+projectVO.getEndTime());

        String startDate = projectVO.getStartTime().substring(0,10)+" "+projectVO.getStartTime().substring(11,16)+":00";
        String endDate = projectVO.getEndTime().substring(0,10)+" "+projectVO.getEndTime().substring(11,16)+":00";
        projectVO.setStartTime(startDate);
        projectVO.setEndTime(endDate);

        log.info("==========="+startDate);
        log.info("==========="+endDate);
        projectVO.setCompanyNum(11l);
        projectService.register(projectVO);
    }

    @GetMapping("/projectDetail")
    public void projectDetail(Long projectNum,Model model){
        model.addAttribute("applyUserList",tempAdminService.getApplyUser(projectNum));
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
    public String productRegisterForm(ProductVO productVO){
        adminProductService.register(productVO);

        return "admin/productList";
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



    // 관리자 상품 수정
    @GetMapping("/productModify")
    public void productModify( Model model){

        log.info("====================");
        log.info("/productModify GET");
        log.info("====================");
//        Long num1 = Long.parseLong(num);
//        model.addAttribute("product",adminProductService.read(num1));
        model.addAttribute("product",adminProductService.read(21L));
        log.info("컨트롤러임"+model.addAttribute("product",adminProductService.read(21L)));
    }

    // 관리자 상품 수정
    @PostMapping("/productModify")
    public String productModifyForm(ProductVO productVO){
        adminProductService.modify(productVO);
        log.info("====================");
        log.info("/productModify");
        log.info("====================");
        return "admin/productList";
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
    public void userDetail(Long num,String category, Model model){
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
    public void userQnA(Long num, AdminBoardDTO adminBoardDTO, HttpServletRequest request, Model model){
        String requestURL = request.getRequestURI();
        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        log.info("*************");
        log.info("================================");
        log.info("================================");
        model.addAttribute("adminBoard", tempAdminService.getQnaReply(num));
        log.info("프로젝트QNA넘버 : " + adminBoardDTO.getProjectQnaNum());
        log.info("프로덕트QNA넘버 : " + adminBoardDTO.getProductQnaNum());
        log.info("adminboard리스트의 num값 : " + adminBoardDTO.getNum());
    }


    // 관리자 공지사항 상세 글 보기
    @GetMapping("/adminNoticeDetail")
    public void adminNoticeDetail(Long num, HttpServletRequest request, Model model){
        String requestURL = request.getRequestURI();
        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        log.info("*************");
        log.info("================================");
        log.info("================================");
        model.addAttribute("adminBoard", tempAdminService.getQnaReply(num));
    }

    //관리자가 답글 쓰면 category로 구분해서 프로젝트/프로덕트 qna comment 테이블에 insert
    @PostMapping("/userQnA")
    public RedirectView replyComplete(AdminQnaCommentDTO adminQnaCommentDTO, RedirectAttributes rttr) {
        log.info("================================");
        log.info("여기프로젝트QNA 넘버 : " + adminQnaCommentDTO.getProjectQnaNum());
        log.info("프로덕트QNA 넘버 : " + adminQnaCommentDTO.getProductQnaNum());
        log.info("if문 이전의 게시글의 num값 : " + adminQnaCommentDTO.getNum());

        tempAdminService.changeAnswerStatus(adminQnaCommentDTO.getNum());

        log.info("================================");
        if ((adminQnaCommentDTO.getCategory()).equals("1")) {
            adminQnaCommentDTO.setQnaNum(adminQnaCommentDTO.getProjectQnaNum());
            tempAdminService.getProjectQnaReply(adminQnaCommentDTO);
        }
        if ((adminQnaCommentDTO.getCategory()).equals("2")) {
            adminQnaCommentDTO.setQnaNum(adminQnaCommentDTO.getProductQnaNum());
            tempAdminService.getProductQnaReply(adminQnaCommentDTO);
        }
        log.info("if문 이후에 게시글의 nun값 : " + adminQnaCommentDTO.getNum());
        return new RedirectView("/admin/boardList");
    }

    @PostMapping("/insertQr")
    @ResponseBody
    public void qrInsert(HttpServletRequest request){
        String qrnum = request.getParameter("QRnum");
        Long qrNum = Long.parseLong(qrnum);
        String projectlink1 = request.getParameter("projectLink1");
        String projectlink2 = request.getParameter("projectLink2");
        projectService.insertQr(qrNum,projectlink1,projectlink2);

    }

    @PostMapping("/deleteProject")
    @ResponseBody
    public void deleteProject(Long num, HttpServletRequest request){
        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i = 0; i<size; i++) {
            num = Long.parseLong(ajaxMsg[i]);
            tempAdminService.deleteProject(num);
        }
    }
//    public RedirectView replyComplete(AdminBoardDTO adminBoardDTO, ProjectQnaCommentVO projectQnaCommentVO, RedirectAttributes rttr) {
//        log.info(projectQnaCommentVO.getContent());
//        if((adminBoardDTO.getCategory()).equals("1")){
//            log.info("if문 들어옴");
//            tempAdminService.getProjectQnaReply(projectQnaCommentVO);
//            log.info("getProjectQnaReply 서비스 실행");
//        }
//        log.info("====================");
//        log.info("====================");
//        return new RedirectView("/admin/boardList");
//    }

    @PostMapping("/approveProject")
    @ResponseBody
    public void approveProject(Long num, HttpServletRequest request){
        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i = 0; i<size; i++) {
            num = Long.parseLong(ajaxMsg[i]);
            tempAdminService.approveProject(num);
        }
    }


    @PostMapping("/AwaitingProject")
    @ResponseBody
    public void awaitingProject(Long num, HttpServletRequest request){
        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i = 0; i<size; i++) {
            num = Long.parseLong(ajaxMsg[i]);
            tempAdminService.awaitProject(num);
        }
    }

    @PostMapping("/DispproveProject")
    @ResponseBody
    public void disapproveProject(Long num, HttpServletRequest request){
        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i = 0; i<size; i++) {
            num = Long.parseLong(ajaxMsg[i]);
            tempAdminService.disapproveProject(num);
        }
    }

    @PostMapping("/addPoint")
    @ResponseBody
    public void addPoint(String nickname, String point,String approach,String userNum,String applynum){
        String approach1="";

        if(approach.equals("출발전")){
             approach1="1";
        }
        if(approach.equals("도착전")){
             approach1="2";
        }
        if(approach.equals("프로젝트완료")){
             approach1="3";
        }
        if(approach.equals("지급완료")){
             approach1="4";
        }
        Long userNum1=Long.parseLong(userNum);
        Long applynum1=Long.parseLong(applynum);
        int point1 = Integer.parseInt(point);
        int point2 = Integer.parseInt(tempAdminService.readUserInfo(userNum1).getPoint());

        int point3 = point1+point2;
        String updatePoint = String.valueOf(point3);

        log.info("=========="+point1);
        log.info("=========="+point2);
        log.info("=========="+updatePoint);
        log.info("=========="+nickname);
        log.info("===========+"+tempAdminService.readUserInfo(userNum1).getNickname());
        tempAdminService.addPoint(nickname,updatePoint,applynum1);
    }
}


