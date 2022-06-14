package com.example.pickitup.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CompanyVO {
    private Long num;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String businessPhone;
    private String address;
    private String businessNumber;
    private String approval;
    private String registDate;
    private String status;


}
