package com.example.pickitup.Util;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

@Component
public class EmailSend {
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
            System.out.println("5 시작");
            msg.setSentDate(new Date());
            InternetAddress from = new InternetAddress();

            from = new InternetAddress("kyg839912@naver.com");
            msg.setFrom(from);

            InternetAddress to = new InternetAddress(user_email);
            msg.setRecipient(Message.RecipientType.TO, to);
            System.out.println("6 시작");

            msg.setSubject("[Pick It Up] 비밀번호 재설정 안내", "UTF-8");
            String msgg="";
            msgg+= "<div style='margin:100px;'>";
            msgg+= "<div align='center' style='border:1px solid black; font-family:verdana; width:50%; margin:auto;'>";
            msgg+= "<h1> 비밀번호 재설정 안내 </h1>";
            msgg+= "<br>";
            msgg+= "<p>안녕하세요 고객님!<br>" +
                    "<br>" +
                    "고객님의 비밀번호 재설정을 위해 메일을 보내드렸습니다<br>." +
                    "새로운 비밀번호를 사용하시려면 아래 버튼을 클릭해주세요.<p>";
            msgg+= "<br>";
            msgg+= "<p>감사합니다.<p>";
            msgg+= "<br>";
            msgg+= "<h3 style='color:blue;'>비밀번호 변경 링크입니다.</h3>";
            msgg+= "<div style='font-size:130%'>";
            msgg+= "링크 : <strong>";
            msgg+= "<a href='http://localhost:10010/user/updatePw?email="+user_email+"' target='_self' >비밀번호 변경</a></strong><div><br/> ";
            msgg+= "</div>";
            msg.setText(msgg, "UTF-8");
            msg.setHeader("content-Type", "text/html");
            System.out.println("7 시작");
            javax.mail.Transport.send(msg);
            System.out.println("8 시작");
        } catch (AddressException addr_e){
            addr_e.printStackTrace();
        } catch (MessagingException msg_e){
            msg_e.printStackTrace();
        }
    }
}

class MyAuthentication extends Authenticator {

    PasswordAuthentication account;

    public MyAuthentication(){
        String id = "kyg839912@naver.com";
        String pw = "rladbsrb8377";
        account = new PasswordAuthentication(id, pw);
    }

    public PasswordAuthentication getPasswordAuthentication(){
        return account;
    }
}