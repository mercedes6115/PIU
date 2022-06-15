package com.example.pickitup.domain.vo.product.productReview;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductReviewVO {
    private Long num;
    private String content;
    private String registDate;
    private String updateDate;
    private Long userNum;
    private Long productNum;

}
