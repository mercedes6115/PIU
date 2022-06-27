package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReviewDTO {
    private Long num;
    private Long productNum;
    private String productName;
    private String updateDate;
    private String content;
    private String userName;
}
