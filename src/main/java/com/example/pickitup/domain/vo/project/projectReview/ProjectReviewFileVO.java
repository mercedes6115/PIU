package com.example.pickitup.domain.vo.project.projectReview;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class ProjectReviewFileVO {
    private String uuid;
    private String uploadPath;
    private String fileName;
    private Long projectReviewNum;

}
