package com.example.pickitup.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class UserVO {
    private Long num;
    private String email;
    private String password;
    private String nickname;
    private String phone;
    private String address;
    private String profileFileName;
    private String profileUploadPath;
    private String point;
    private String registDate;

}
