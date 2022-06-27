package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ApplyDTO {
    private Long num;
    private String approach;
    private String registDate;
    private Long projectNum;
    private Long userNum;
    private String startTime;
    private String endTime;
    private String nickname;
    private String phone;
    private String point;
    private String terrain;
    private String course;
}