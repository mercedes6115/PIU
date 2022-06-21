package com.example.pickitup.domain.vo.product.productReview;

import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ProductReviewVO {
    private Long num;
    private String content;
    private String registDate;
    private String updateDate;
    private Long userNum;
    private Long productNum;

    private List<ProductReviewFileVO> fileList;

}
