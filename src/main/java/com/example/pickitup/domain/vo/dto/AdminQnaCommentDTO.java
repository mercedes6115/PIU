package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AdminQnaCommentDTO {
    private Long num;
    private String content;
    private String registDate;
    private String updateDate;
    private Long userNum;
    private Long qnaNum;
    private Long companyNum;
    private Long productQnaNum;
    private Long projectQnaNum;
    private String answerStatus;
    private String category;
}
