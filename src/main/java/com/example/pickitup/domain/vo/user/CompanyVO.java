package com.example.pickitup.domain.vo.user;

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
    private String profileFileName;
    private String profileUploadPath;
<<<<<<< HEAD
=======
    private String category;
>>>>>>> 3c95ef56a8c609bd027606cac82202479ffe8fac

}
