package com.example.pickitup.Util;

import com.example.pickitup.domain.vo.dto.UserDTO;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class SessionManager {
    /**
     * 세션 생성
     */
    public static void setSesstion(UserDTO userDTO, HttpSession sesstion){
        // 세션 id를 생성하고, 값을 세션에 저장
        sesstion.setAttribute("num", userDTO.getNum().toString());
        sesstion.setAttribute("nickname", userDTO.getNickname());
        sesstion.setAttribute("category", userDTO.getCategory());
    }

    /**
     * 세션 조회
     */
    public static boolean checkSession(HttpSession session){

        if(session.getAttribute("num")==null||session.getAttribute("nickname")==null){

            return false;
        }
        return true;
    }

    /**
     * 세션 만료
     */
    public void expire(HttpSession session){
        session.invalidate();
    }


}
