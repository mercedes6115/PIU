package com.example.pickitup.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProjectVO {
    private Long num;
    private String title;
    private String content;
    private String course;
    private String terrain;
    private String address;
    private String point;
    private String approval;
    private String startTime;
    private String endTime;
    private String registDate;
    private String updateDate;
    private String status;
    private Long companyNum;
    private Long userNum;

}
