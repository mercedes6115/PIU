package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.ProjectCriteria;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProjectDTO {

    private ProjectCriteria projectCriteria;
    private String nickname;
    private Long num;
    private String title;
    private String content;
    private String course;
    private String startTime;
    private String endTime;
    private String terrain;
    private String status;
    private int point;
    private String approval;
    private String registDate;
    private String qr;
    private String updateDate;
    private String startAddress;
    private String endAddress;
    private String distance;
}

