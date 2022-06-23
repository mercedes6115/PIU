package com.example.pickitup.mapper.product;

import com.example.pickitup.domain.vo.product.productReview.ProductReviewFileVO;
import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import com.example.pickitup.mapper.product.productReview.ProductReviewFileMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductReviewFileMapperTest {
    @Autowired
    private ProductReviewFileMapper productReviewFileMapper;

    @Test
    public void findByProductReviewNumTest(){
        productReviewFileMapper.findByProductReviewNum(24L);
    }
//
//    @Test
//    public void insertTest(){
//        ProductReviewFileVO vo = new ProductReviewFileVO();
//        vo.setFileName("모름1");
//        vo.setProductReviewNum(24L);
//        vo.setUploadPath("2022/06/18");
//        vo.setUuid("몰라1");
//        productReviewFileMapper.insert(vo);
//    }
//
//    @Test
//    public void deleteTest(){
//        productReviewFileMapper.delete(24L);
//    }
}
