//package com.example.pickitup.util;
package com.example.pickitup.Util;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class CoolSmsUtil {
    @Value("NCSQOOEMXARDESBI")  // api 키
    private String coolSmsApiKey;

    @Value("OLQEIGG1GLWORLRHPTQ9KEO5GKQXEWMH")  // api 비밀번호
    private String coolSmSapiSecret;

    @Value("010-7761-6652")  // 보내는 번호
    private String from;


    //단일 문자 발송 method
    public void singleSms(String number, String text) {
        Message coolsms = new Message(coolSmsApiKey, coolSmSapiSecret);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", number);
        params.put("from", from);
        params.put("type", "SMS");
        params.put("text", "Pick It Up 휴대폰인증 메시지 : 인증번호는" + " ["+text+"] " + "입니다.");
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());

        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }
}