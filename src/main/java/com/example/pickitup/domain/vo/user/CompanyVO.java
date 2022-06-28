package com.example.pickitup.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CompanyVO {
    private Long num;
    private String email;
    private String password;
    private String nickname;
    private String phone;
    private String businessPhone;
    private String address;
    private String addressDetail;
    private String businessNumber;
    private String approval;
    private String registDate;
    private String profileFileName;
    private String profileUploadPath;

    private String category;
    private String status;


}
