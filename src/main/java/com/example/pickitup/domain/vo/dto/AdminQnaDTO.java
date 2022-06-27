package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AdminQnaDTO {
    private Long num;
    private Long name;
    private String content;
    private String registDate;
    private String updateDate;
    private Long userNum;
    private Long productNum;
    private Long projectNum;
    private String answerStatus;
    private String category;
    private Long projectQnaNum;
    private Long productQnaNum;
}
