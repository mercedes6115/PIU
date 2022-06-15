package com.example.pickitup.domain.vo.project;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class ProjectQnaCommentVO {
    private Long num;
    private String content;
    private String registDate;
    private String updateDate;
    private Long userNum;
    private Long qnaNum;
    private Long companyNum;

}
