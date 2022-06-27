package com.example.pickitup.domain.vo.product.productFile;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@EqualsAndHashCode(callSuper=false)
public class ProductVO extends ProductFileVO {
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

    //    input태그의 name에
//    fileList[i].fileName
//    fileList[i].uploadPath
//    fileList[i].uuid
//    fileList[i].image

    private List<ProductFileVO> fileList;
}
