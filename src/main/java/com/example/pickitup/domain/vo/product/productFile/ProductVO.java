package com.example.pickitup.domain.vo.product.productFile;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ProductVO {
    private Long num;
    private String name;
    private String content;
    private String category;
    private Long price;
    private Long stock;
    private String origin;
    private String manufacturer;
    private String supplier;
    private String registDate;
    private String status;
    private Long jjimCount;

    private List<ProductFileVO> fileList;
}
