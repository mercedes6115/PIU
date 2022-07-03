package com.example.pickitup.controller;


import com.example.pickitup.Util.EmailSend;
import com.example.pickitup.domain.vo.dto.MyOrderDTO;
import com.example.pickitup.domain.vo.dto.PageDTO;
import com.example.pickitup.domain.vo.dto.PointDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.dto.PageDTO;
import com.example.pickitup.domain.vo.dto.ReviewDTO;


import com.example.pickitup.domain.vo.dto.UserDTO;
import com.example.pickitup.domain.vo.user.CompanyVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.TempCompanyService;
import com.example.pickitup.service.TempUserSerivce;
import com.example.pickitup.service.user.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


@Controller
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
    private final TempUserSerivce tempUserSerivce;
    private final TempCompanyService tempCompanyService;
    private final OrderService orderService;

    @Resource
    private EmailSend emailSend;

    // 마이페이지 메인
    @GetMapping("/myPage")
    public String mypage(HttpSession session, Model model){
        int checkLogin= 3;

        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        model.addAttribute("jjimProjectList", tempUserSerivce.getJjimProjectList(userNum));
        model.addAttribute("jjimProductList", tempUserSerivce.getJjimProductList(userNum));
        model.addAttribute("inProductList",tempUserSerivce.getInProductList(userNum));
        model.addAttribute("inProjectList",tempUserSerivce.getInProjectList(userNum));
        model.addAttribute("seenProductList",tempUserSerivce.getLatestProductList(userNum));
        model.addAttribute("seenProjectList",tempUserSerivce.getLatestProjectList(userNum));
        model.addAttribute("getDetail",tempUserSerivce.readUserInfo(userNum));
        return "/user/myPage";
    }

    // 마이페이지 포인트
    @GetMapping("/myPoint")
    public String mypoint(HttpSession session, Model model) throws ParseException {
        int checkLogin= 3;

        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("checkLogin",checkLogin);
        model.addAttribute("changePoint",tempUserSerivce.changePoint(userNum));
        model.addAttribute("user",tempUserSerivce.readUserInfo(userNum));
        return "/user/myPoint";
    }

    // 마이페이지 QnA
    @GetMapping("/myQnA")
    public String myQnA(HttpSession session, Model model){
        int checkLogin= 3;
        model.addAttribute("checkLogin",checkLogin);
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("qnaList",tempUserSerivce.getMyProductQna(userNum));
        model.addAttribute("user",tempUserSerivce.readUserInfo(userNum));
        return "/user/myQnA";
    }

    // 마이페이지 내후기
    @GetMapping("/myReview")
    public String myReview(HttpSession session, Model model){
        int checkLogin= 3;
        model.addAttribute("checkLogin",checkLogin);
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("reviewList",tempUserSerivce.myAllReview(userNum));
        model.addAttribute("user",tempUserSerivce.readUserInfo(userNum));

        return "/user/myReview";
    }

    // 마이페이지 주문내역
    @GetMapping("/myOrderList")
    public String myOrderList(HttpSession session, Model model,String num){
        int checkLogin= 3;
        model.addAttribute("checkLogin",checkLogin);
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        Calendar mon = Calendar.getInstance();
        mon.add(Calendar.MONTH,-3);
        String nowTime = sdf1.format(now.getTime());
        String beforeMonth = sdf1.format(mon.getTime());
        List<MyOrderDTO> myOrderDTOList = orderService.getBetweenOrder(userNum,beforeMonth,nowTime);
        int totalCount = myOrderDTOList.size();
        model.addAttribute("myOrderList", myOrderDTOList);
        String startDate = sdf2.format(mon.getTime());
        String endDate = sdf2.format(now.getTime());
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("totalCount", totalCount);

        return "/user/myOrderList";
    }

    // 비밀번호 찾기
    @GetMapping("/findPw")
    public void findPW(HttpSession session, Model model) {
        int checkLogin= 3;
            Long userNum = Long.parseLong(session.getAttribute("num").toString());
            model.addAttribute("fileName", session.getAttribute("fileName"));
            model.addAttribute("uploadPath", session.getAttribute("uploadPath"));
            model.addAttribute("checkLogin", checkLogin);
    }

    @PostMapping("/findPw")
    public String findPWForm(HttpSession session,String email, Model model) throws Exception {

        log.info("전달받은 이메일 : " + email);
        if(tempUserSerivce.emailcheck(email)==1){ //이메일 확인
            model.addAttribute("msg","인증메일을 보냈습니다. 메일을 확인해 주세요");
            emailSend.sendEmail(email);
        }else{
            model.addAttribute("msg","회원가입이 안된 이메일 입니다");
        }
        return "/user/findPw";
    }

    // 비밀번호 재설정
    @GetMapping("/updatePw")
    public void updatePw(@RequestParam(value="email")String email, HttpSession session, Model model){
        int checkLogin= 3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName", session.getAttribute("fileName"));
        model.addAttribute("uploadPath", session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin", checkLogin);
        log.info("비밀번호 재설정 들어옴");
        log.info(email);

    }


    // 비밀번호 재설정 폼
    @PostMapping("/updatePw")
    public RedirectView updatePwForm(String email, String password, String password2 ,RedirectAttributes rttr){
        tempUserSerivce.updatePW(email,password);
        return new RedirectView("/user/login");
    }

    // 마이페이지 비밀번호 수정
    @GetMapping("/myPassword")
    public String myPassword(HttpSession session, Model model){
        int checkLogin= 3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName", session.getAttribute("fileName"));
        model.addAttribute("uploadPath", session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin", checkLogin);
        model.addAttribute("getDetail",tempUserSerivce.readUserInfo(userNum));
        return "/user/myPassword";
    }

    @PostMapping("/myPassword")
    public RedirectView myPasswordForm(String password, Long num) {
        tempUserSerivce.changePw(password,num);
        return new RedirectView("/user/myPage");
    }

    // 회원 정보 수정
    @GetMapping("/infoUpdate")
    public void infoUpdate(HttpSession session, Model model){
        int checkLogin=3;
        model.addAttribute("checkLogin",checkLogin);
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("user", tempUserSerivce.readUserInfo(userNum));
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
    public String joinGroupForm(CompanyVO companyVO){
        companyVO.setPhone(String.join("",companyVO.getPhone().split("-")));
        companyVO.setBusinessPhone(String.join("",companyVO.getBusinessPhone().split("-")));

        log.info(companyVO.getPhone());
        log.info(companyVO.getBusinessPhone());
        tempCompanyService.registerCompany(companyVO);
        return "/user/login";

    }



    // 로그인
    @GetMapping("/login")
    public String login(){
//        boolean checkEmail=true;
//        model.addAttribute("")
        return "/user/login";
    }

    // 로그인 폼
    @PostMapping("/login")
    public RedirectView loginForm(String email, String password,
                                  RedirectAttributes rttr,
                                  HttpServletRequest request){

//        Base64.getEncoder().encode(password.getBytes());

        UserDTO userDTO=tempUserSerivce.loginUser(email, password);

        if(userDTO!=null){
            rttr.addFlashAttribute("num", userDTO.getNum());
            rttr.addFlashAttribute("nickname", userDTO.getNickname());
            rttr.addFlashAttribute("category",userDTO.getCategory());
            UserVO userVO = tempUserSerivce.readUserInfo(userDTO.getNum());
            HttpSession session=request.getSession();

            session.setAttribute("num", userDTO.getNum().toString());
            session.setAttribute("nickname", userDTO.getNickname());
            session.setAttribute("category", userDTO.getCategory());
            session.setAttribute("fileName", userVO.getProfileFileName());
            session.setAttribute("uploadPath",userVO.getProfileUploadPath());
            log.info("사진 : " + userVO.getProfileFileName());
            log.info("파일 경로 : " + userVO.getProfileUploadPath());
            log.info(session.getAttribute("category").toString());

            log.info("사진 : " + userVO.getProfileFileName());
            log.info("파일 경로 : " + userVO.getProfileUploadPath());

            if(userDTO.getNickname().equals("admin")){
                return new RedirectView("/admin/login");
            }
            return new RedirectView("/main/main");
        }
        rttr.addFlashAttribute("msg","입력된 정보가 틀립니다. 회원가입해주세요.");
        return new RedirectView("/user/login");
    }


    // 회원탈퇴
    @GetMapping("/delete")
    public String delete(HttpSession session){
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        tempUserSerivce.removeUser(userNum);
        return login();
    }

    @GetMapping("/guide")
    public void guide(){

    }

    @GetMapping("/center")
    public void center(){

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        log.info("control");

        return "/user/login";
    }

}
