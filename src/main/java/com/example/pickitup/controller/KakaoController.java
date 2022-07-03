package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.KakaoService;
import com.example.pickitup.service.TempUserSerivce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@Slf4j
public class KakaoController {

    private final KakaoService kakaoService;
    private final TempUserSerivce tempUserSerivce;

    @GetMapping("/login")
    public RedirectView kakaoCallback(@RequestParam String code, HttpSession session, RedirectAttributes rttr) throws Exception {
        log.info(code);
        String token = kakaoService.getKaKaoAccessToken(code);


        HashMap<String, Object> kakaoInfo = kakaoService.getKakaoInfo(token);
        log.info("###access_Token#### : " + token);
        log.info("###userInfo#### : " + kakaoInfo.get("email"));
        log.info("###nickname#### : " + kakaoInfo.get("nickname"));

        UserVO userVO=new UserVO();
        userVO.setEmail(kakaoInfo.get("email").toString());
        userVO.setNickname(kakaoInfo.get("nickname").toString());

        UserVO tempVO=tempUserSerivce.kakaoLogin(userVO);
        if(tempVO==null){
            boolean checkEmail=true;
            log.info("널인가 "+tempUserSerivce.kakaoLogin(userVO));
            rttr.addFlashAttribute("checkEmail",checkEmail);

            return new RedirectView("user/login");
        }else {
            log.info("null 아닌가"+tempVO);
            session.setAttribute("token", token);
            log.info("///////////////////////////////////////////////////////");
            log.info("///////////////////////////////////////////////////////");
            log.info("///////////////////////////////////////////////////////");
            session.setAttribute("num", tempVO.getNum());
            log.info("sessionnum"+ tempVO.getNum());
            session.setAttribute("nickname", tempVO.getNickname());
            log.info("sessionNickname"+ tempVO.getNickname());
            session.setAttribute("category", tempVO.getCategory());
            log.info("sessioncategory"+tempVO.getCategory());
            log.info("sessioncategory"+tempVO.getProfileFileName());

            return new RedirectView("main/main");
        }

    }

    @GetMapping("/logout")
    public RedirectView kakaoLogout(HttpSession session){
        log.info("logout");
        log.info("logout"+session.getAttribute("token"));
        kakaoService.logoutKakao((String)session.getAttribute("token"));
        session.invalidate();
        return new RedirectView("main/main");
    }
}