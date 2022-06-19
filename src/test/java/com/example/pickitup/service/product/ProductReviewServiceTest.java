package com.example.pickitup.service.product;

import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import com.example.pickitup.service.product.productReview.ProductReviewService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductReviewServiceTest {
    @Autowired
    private ProductReviewService productReviewService;
//
    @Test
    public void getListTest(){
        productReviewService.getList(24L);
    }

//    @Test
//    public void updateTest(){
//        ProductReviewVO vo = new ProductReviewVO();
//        vo.setNum(24L);
//        vo.setContent("리뷰 수정이요");
//        if(productReviewService.update(vo)){
//            log.info("성공");
//        }else{
//            log.info("실패");
//        }
//    }
//
//    @Test
//    public void deleteTest(){
//      if(productReviewService.delete(vo)){
//            log.info("성공");
//        }else{
//            log.info("실패");
//        }
//    }
}
