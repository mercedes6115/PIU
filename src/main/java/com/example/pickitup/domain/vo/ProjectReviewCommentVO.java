package com.example.pickitup.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProjectReviewCommentVO {
    private Long num;
    private String content;
    private String registDate;
    private String updateDate;
    private Long userNum;
    private Long CompanyNum;
    private Long reviewNum;

}
