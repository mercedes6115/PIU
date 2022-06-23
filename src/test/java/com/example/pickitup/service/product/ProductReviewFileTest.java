package com.example.pickitup.service.product;

import com.example.pickitup.domain.vo.product.productReview.ProductReviewFileVO;
import com.example.pickitup.service.product.productFile.ProductFileService;
import com.example.pickitup.service.product.productReview.ProductReviewFileService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductReviewFileTest {
    @Autowired
    private ProductReviewFileService productReviewFileService;

    @Test
    public void findByProductReviewNumTest(){
        productReviewFileService.findByProductReviewNum(24L);
    }
//
//    @Test
//    public void registerTest(){
//        ProductReviewFileVO vo = new ProductReviewFileVO();
//        vo.setFileName("service test");
//        vo.setUploadPath("service test");
//        vo.setUuid("service test");
//        vo.setProductReviewNum(24L);
//        productReviewFileService.register(vo);
//    }
//
//    @Test
//    public void removeTest(){
//        productReviewFileService.remove(24L);
//    }
}
