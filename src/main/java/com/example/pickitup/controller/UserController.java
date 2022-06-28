package com.example.pickitup.controller;


import com.example.pickitup.Util.EmailSend;
import com.example.pickitup.domain.vo.dto.UserDTO;
import com.example.pickitup.domain.vo.user.CompanyVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.TempCompanyService;
import com.example.pickitup.service.TempUserSerivce;
import com.example.pickitup.Util.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import javax.annotation.Resource;


@Controller
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
    private final TempUserSerivce tempUserSerivce;
    private final TempCompanyService tempCompanyService;
    private final SessionManager sessionManager;
    @Resource
    private EmailSend emailSend;

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
    public String myQnA(Model model){
        model.addAttribute("qnaList",tempUserSerivce.getMyProductQna(2L));
        model.addAttribute("user",tempUserSerivce.readUserInfo(2L));
        return "/user/myQnA";
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

    @PostMapping("/findPw")
    public String findPWForm(String email, Model model) throws Exception {
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
    public void updatePw(@RequestParam(value="email")String email){
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
    public String myPassword(Model model){
        model.addAttribute("getDetail",tempUserSerivce.readUserInfo(2L));
        return "/user/myPassword";
    }

    @PostMapping("/myPassword")
    public RedirectView myPasswordForm(String password, Long num) {
        tempUserSerivce.changePw(password,num);
        return new RedirectView("/user/myPage");
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
    public void login(){

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

            HttpSession session=request.getSession();

            session.setAttribute("num", userDTO.getNum().toString());
            session.setAttribute("nickname", userDTO.getNickname());
            session.setAttribute("category", userDTO.getCategory());

            log.info(session.getAttribute("category").toString());

            if(userDTO.getNickname().equals("admin")){
                return new RedirectView("/admin/login");
            }
            return new RedirectView("/main/main");
        }
        rttr.addFlashAttribute("msg","입력된 정보가 틀립니다. 회원가입해주세요.");
        return new RedirectView("/user/login");
    }


    // 회원탈퇴
    @DeleteMapping("/delete")
    public void delete(){

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

//    @GetMapping("/myOrderList")
//    public String myOrderList(Long num, Model model){
//        model.addAttribute("myOrderList", tempUserSerivce.myOrderList(2L));
//        return  "/user/myOrderList";
//    }
}
