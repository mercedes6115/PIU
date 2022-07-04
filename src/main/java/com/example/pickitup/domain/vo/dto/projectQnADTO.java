package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class projectQnADTO {

    private Long num;
    private String content;
    private String registDate;
    private String updateDate;
    private Long userNum;
    private Long projectNum;
    private Long companyNum;

    private String nickname;
}
