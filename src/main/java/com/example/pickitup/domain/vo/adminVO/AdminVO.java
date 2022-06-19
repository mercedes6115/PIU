package com.example.pickitup.domain.vo.adminVO;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class AdminVO {

    private Long num;
    private String nickname;
    private String email;
    private String registDate;
    private String phone;
    private String address;
}
