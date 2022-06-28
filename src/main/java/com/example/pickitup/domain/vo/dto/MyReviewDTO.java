package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyReviewDTO {
    private String title;
    private String updateDate;
    private String content;
    private Long num;
}
