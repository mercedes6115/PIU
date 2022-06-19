package com.example.pickitup.dao.product;

import com.example.pickitup.domain.dao.product.productReview.ProductReviewFileDAO;
import com.example.pickitup.domain.vo.product.productReview.ProductReviewFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductReviewFileDaoTest {
    @Autowired
    private ProductReviewFileDAO productReviewFileDAO;

//    @Test
//    public void findByProductReviewNumTest(){
//        productReviewFileDAO.findByProductReviewNum(24L);
//    }
//
//    @Test
//    public void registerTest(){
//        ProductReviewFileVO vo = new ProductReviewFileVO();
//        vo.setProductReviewNum(24L);
//        vo.setUuid("DAO uuid Test");
//        vo.setUploadPath("DAO uuid Test");
//        vo.setFileName("DAO uuid Test");
//        productReviewFileDAO.register(vo);
//    }
//
//    @Test
//    public void removeTest(){
//        productReviewFileDAO.remove(24L);
//    }
}
