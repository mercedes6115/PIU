package com.example.pickitup.domain.vo.project.projectReview;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ProjectReviewVO {
    private Long num;
    private String content;
    private String registDate;
    private String updateDate;
    private Long userNum;
    private Long projectNum;
    private List<ProjectReviewFileVO> fileList;
}
