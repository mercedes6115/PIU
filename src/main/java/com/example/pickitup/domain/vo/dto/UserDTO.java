package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.Criteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDTO{

    private Criteria criteria;
    private Long num;
    private String nickname;
    private String email;
    private String registDate;
    private String phone;
    private String address;
    private String category;
    private String point;
    private String status;
    private String approval;

}

