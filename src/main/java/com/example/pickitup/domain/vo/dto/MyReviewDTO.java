package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyReviewDTO {
    private String userName;
    private String registDate;
    private String content;
    private String fileName;
    private String uploadPath;
    private String projectName;
    private String productName;
}
