package com.example.pickitup.controller;

import com.example.pickitup.service.TempUserSerivce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/userR/*")
@RequiredArgsConstructor
public class UserRestController {
    private final TempUserSerivce tempUserSerivce;

    // 문의글
    @PostMapping("/qna")
    public void addQnA() {

    }

    // 후기
    @PostMapping("/review")
    public void addReview() {

    }

    // 찜추가
    @PostMapping("/jjim")
    public void addJjim(){

    }

    // 찜해제
    @DeleteMapping("/jjim")
    public void removeJjim(){

    }

    //이메일 중복확인
    @PostMapping("/emailMatching")
    public int emailMatch(@RequestParam String email){
        log.info("email test 띄워짐? : "+email);
        return tempUserSerivce.emailcheck(email);
    }
    //닉네임 중복확인
    @PostMapping("/nicknameMatching")
    public int nicknameMatch(@RequestParam String nickname){
        log.info("nickname test 띄워짐? : "+nickname);
        log.info("ooooooooo"+tempUserSerivce.nicknameCheck(nickname));
        return tempUserSerivce.nicknameCheck(nickname);
    }
}
