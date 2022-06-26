package com.example.pickitup.domain.vo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ProductQnaDTO {
    private String qnaContent;
    private String qnaRegistDate;
    private String qnaUpdateDate;
    private String productName;
    private String projectName;
    private String commentContent;
    private String commentRegistDate;
    private String commentUpdateDate;
    private String qnaUserName;
    private String commentUserName;
    private String commentCompanyName;
    private String fileName;
    private String uploadPath;

}
