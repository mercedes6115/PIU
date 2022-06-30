package com.example.pickitup.domain.vo.dto;


import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewFileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ReviewDTO {

    private Long num;
    private String updateDate;
    private String content;

    private String title;

    private String nickname;

    private String profileFileName;
    private String profileUploadPath;

    private List<ProjectReviewFileVO> fileList;


}



