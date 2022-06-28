package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.dto.MyOrderDTO;
import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.service.TempUserSerivce;
import com.example.pickitup.service.user.JjimService;
import com.example.pickitup.service.user.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/userR/*")
@RequiredArgsConstructor
public class UserRestController {
    private final TempUserSerivce tempUserSerivce;
    private final OrderService orderService;
    private final JjimService jjimService;

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
    public void addJjim(JjimVO jjimVO){
        jjimService.myProjectJjimInsert(jjimVO);
    }

    // 찜해제
    @DeleteMapping("/jjim")
    public void removeJjim(JjimVO jjimVO){
        jjimService.myProjectJjimDelete(jjimVO);
    }

    // 찜목록
    @GetMapping("/jjim")
    public List<JjimVO> listJjim() {return jjimService.getList();}

    // 찜 개수
    @GetMapping("/jjimCount")
    public int jjimList(Long projectNum) {return jjimService.myProjectJjimCount(projectNum);}

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

    // 주문내역 기간 조회하기
    @PostMapping("/betweenOrder")
    public List<MyOrderDTO> betweenOrderList(String startDate, String endDate, Long num) {
        return orderService.getBetweenOrder(num,startDate, endDate);
    }
}
