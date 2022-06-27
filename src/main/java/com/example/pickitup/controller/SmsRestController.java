package com.example.pickitup.controller;
import com.example.pickitup.Util.CoolSmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@RestController
@Slf4j
@RequestMapping("/sms/*")
public class SmsRestController {

    @Resource
    private CoolSmsUtil coolSmsUtil;

    @GetMapping("/single")
    public String singleSms(@RequestParam String phoneNumber) {
        // 랜덤 6자리 수 생성
        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<6; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }
        coolSmsUtil.singleSms(phoneNumber, numStr);
        return numStr;
    }
}
