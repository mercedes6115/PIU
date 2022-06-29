package com.example.pickitup.Util;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;
import java.util.Random;



@Component
public class EmailSend {
    private RedisUtil redisUtil;
    private EmailProperties emailProperties;
    public void sendEmail(String user_email) {
        System.out.println("이메일 시작");
        System.out.println(user_email);
        Properties p = System.getProperties();
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.naver.com");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.ssl.trust", "smtp.naver.com");
        p.put("mail.smtp.ssl.protocols", "TLSv1.2");
        p.put("mail.transport.protocol", "SMTP");

        System.out.println("1 시작");
        Authenticator auth = new MyAuthentication();
        Session session = Session.getDefaultInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);

        System.out.println("2 시작");


        try {
            redisUtil.setDataExpire("123456", "email", emailProperties.getValidTime());
            System.out.println("5 시작");
            msg.setSentDate(new Date());
            InternetAddress from = new InternetAddress();

            from = new InternetAddress("min_6652@naver.com");
            msg.setFrom(from);

            InternetAddress to = new InternetAddress(user_email);
            msg.setRecipient(Message.RecipientType.TO, to);
            System.out.println("6 시작");

            msg.setSubject("[Pick It Up] 비밀번호 재설정 안내", "UTF-8");
            String msgg = "";
            msgg += "<center>" +
                    "<div style='background-color: #f8f8f9; max-width: 640px; margin: auto'>" +
                    "<!--[if mso]>" +
                    "<table align='center' width='640' cellspacing='0' cellpadding='0' border='0'>" +
                    "<tr><td>" +
                    "<![endif]-->" +
                    "<table align='center' width='640' cellspacing='0' cellpadding='0' border='0' style='max-width: 640px; width: 100%' bgcolor='#000000'>" +
                    "<tbody><tr><td align='center' valign='top' style='padding: 18px 24px'>" +
                    "<table align='center' width='600' cellspacing='0' cellpadding='0' border='0' style='max-width: 600px; width: 100%'>" +
                    "<tbody><tr><td valign='top'>" +
                    "<a href='http://localhost:10010/main/main' target='_blank' rel='noreferrer noopener' style='text-decoration: none;'>" +
                    "<p>  <span width='85px' height='24px' style='padding: 1px 3px 2px 3px; background-color:black; color:white;' border='0' alt=''>Pick It Up </span>  </p>" +
                    "</a>" +
                    "</td></tr></tbody></table>" +
                    "</td></tr></tbody></table>" +
                    "<table align='center' width='640' cellspacing='0' cellpadding='0' border='0' style='max-width: 640px; width: 100%' bgcolor='#FFFFFF'>" +
                    "<tbody><tr><td align='center' valign='top' style='padding: 52px 24px 28px'>" +
                    "<table align='center' width='600' cellspacing='0' cellpadding='0' border='0' style='max-width: 600px; width: 100%'>" +
                    "<tbody><tr><td valign='top'>" +
                    "CLASS101<br>" +
                    "비밀번호 재설정 안내" +
                    "</td></tr></tbody></table>" +
                    "</td></tr></tbody></table>" +
                    "<table align='center' width='640' cellspacing='0' cellpadding='0' border='0' style='max-width: 640px; width: 100%' bgcolor='#FFFFFF'>" +
                    "<tbody><tr><td align='center' valign='top' style='padding: 0 24px'>" +
                    "<table align='center' width='600' cellspacing='0' cellpadding='0' border='0' style='max-width: 600px; width: 100%'>" +
                    "<tbody><tr><td valign='top'>" +
                    "안녕하세요 고객님!<br><br>" +
                    "고객님의 비밀번호 재설정을 위해 메일을 보내드렸습니다.<br>" +
                    "새로운 비밀번호를 사용하시려면 아래 버튼을 클릭해주세요.<br><br>" +
                    "아래 링크는 메일 발송시간을 기준으로 30분 이후" +
                    "만료됩니다.<br><br>" +
                    "감사합니다." +
                    "</td></tr></tbody></table>" +
                    "</td></tr></tbody></table>" +
                    "<table align='center' width='640' cellspacing='0' cellpadding='0' border='0' style='max-width: 640px; width: 100%' bgcolor='#FFFFFF'>" +
                    "<tbody><tr><td align='center' valign='top' style='padding: 24px'>" +
                    "<table align='center' width='600' cellspacing='0' cellpadding='0' border='0' style='max-width: 600px; width: 100%'>" +
                    "<tbody><tr><td align='center' valign='top'>" +
                    "<a href='http://localhost:10010/user/updatePw?email="+user_email+"' target='_self' >비밀번호 재설정하기</a>" +
                    "</td></tr></tbody></table>" +
                    "</td></tr></tbody></table>" +
                    "<table align='center' width='640' cellspacing='0' cellpadding='0' border='0' style='max-width: 640px; width: 100%' bgcolor='#FFFFFF'>" +
                    "<tbody><tr><td align='center' valign='top' style='padding: 24px 24px 12px; border-top: 2px solid #1b1c1d'>" +
                    "<table align='center' width='600' cellspacing='0' cellpadding='0' border='0' style='max-width: 600px; width: 100%'>" +
                    "<tbody><tr><td valign='top'>" +
                    "<a href='http://localhost:10010/main/main' target='_blank' rel='noreferrer noopener' style='text-decoration: none;'>" +
                    "<p>  <span  width='65px' height='18px' style='padding: 1px 3px 2px 3px; background-color:black; color:white; ' border='0' alt=''>Pick It Up</span>  </p>" +
                    "</a>" +
                    "</td></tr></tbody></table>" +
                    "</td></tr></tbody></table>" +
                    "<table align='center' width='640' cellspacing='0' cellpadding='0' border='0' style='max-width: 640px; width: 100%' bgcolor='#FFFFFF'>" +
                    "<tbody><tr><td align='center' valign='top' style='padding: 0 24px 8px'>" +
                    "<table align='center' width='600' cellspacing='0' cellpadding='0' border='0' style='max-width: 600px; width: 100%'>" +
                    "<tbody><tr><td valign='top'>" +
                    "본 메일은 발신전용 메일이오니 문의사항이 있으시면 고객센터를" +
                    "이용해주시기 바랍니다. (고객센터 :" +
                    "<a href='http://zymmqyc7.r.ap-northeast-2.awstrack.me/L0/http:%2F%2F101.gg%2Fchat/1/010c0181516de8c7-5b16d0eb-82b5-4644-94ec-77e337f91453-000000/1ExW6KXuPEjMMCQJ-4VmO3UYPPs=58' target='_blank' rel='noreferrer noopener'>http://101.gg/chat</a>)" +
                    "</td></tr></tbody></table>" +
                    "</td></tr></tbody></table>" +
                    "<table align='center' width='640' cellspacing='0' cellpadding='0' border='0' style='max-width: 640px; width: 100%' bgcolor='#FFFFFF'>" +
                    "<tbody><tr><td align='center' valign='top' style='padding: 0 24px 32px'>" +
                    "<table align='center' width='600' cellspacing='0' cellpadding='0' border='0' style='max-width: 600px; width: 100%'>" +
                    "<tbody><tr><td valign='top'>" +
                    "여기는 회사 주소" +
                    "대표 사람이름 · 사업자등록번호 00-0000-0000 " +
                    "</td></tr></tbody></table>" +
                    "</td></tr></tbody></table>" +
                    "<!--[if mso]>" +
                    "</td></tr>" +
                    "</table>" +
                    "<![endif]-->" +
                    "</div>" +
                    "</center>";


//            msgg+= '<div style='margin:100px;'>';
//            msgg+= '<div align='center' style='border:1px solid black; font-family:verdana; width:50%; margin:auto;'>';
//            msgg+= '<h1> 비밀번호 재설정 안내 </h1>';
//            msgg+= '<br>';
//            msgg+= '<p>안녕하세요 고객님!<br>' +
//                    '<br>' +
//                    '고객님의 비밀번호 재설정을 위해 메일을 보내드렸습니다<br>.' +
//                    '새로운 비밀번호를 사용하시려면 아래 버튼을 클릭해주세요.<p>';
//            msgg+= '<br>';
//            msgg+= '<p>감사합니다.<p>';
//            msgg+= '<br>';
//            msgg+= '<h3 style='color:blue;'>비밀번호 변경 링크입니다.</h3>';
//            msgg+= '<div style='font-size:130%'>';
//            msgg+= '링크 : <strong>';
//            msgg+= '<a href='http://localhost:10010/user/updatePw?email='+user_email+'' target='_self' >비밀번호 변경</a></strong><div><br/> ';
//            msgg+= '</div>';
            msg.setText(msgg, "UTF-8");
            msg.setHeader("content-Type", "text/html");
            System.out.println("7 시작");
            javax.mail.Transport.send(msg);
            System.out.println("8 시작");
        } catch (AddressException addr_e) {
            addr_e.printStackTrace();
        } catch (MessagingException msg_e) {
            msg_e.printStackTrace();
        }
    }
}

class MyAuthentication extends Authenticator {

    PasswordAuthentication account;

    public MyAuthentication() {
        String id = "min_6652@naver.com";
        String pw = "gusals32";
        account = new PasswordAuthentication(id, pw);
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return account;
    }
}