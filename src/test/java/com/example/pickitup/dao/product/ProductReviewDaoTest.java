package com.example.pickitup.dao.product;

import com.example.pickitup.domain.dao.product.productReview.ProductReviewDAO;
import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@Slf4j
public class ProductReviewDaoTest {
    @Autowired
    private ProductReviewDAO productReviewDAO;

//    @Test
//    public void getListTest(){
//        productReviewDAO.getList(23L);
//    }
//
//    @Test
//    public void updateTest(){
//        ProductReviewVO vo = new ProductReviewVO();
//        vo.setNum(23L);
//        vo.setContent("이 리뷰 수정할래요1");
//        if(productReviewDAO.update(vo)){
//            log.info("수정성공");
//        }else{
//            log.info("수정실패");
//        }
//    }
//
//    @Test
//    public void removeTest(){
//        if(productReviewDAO.remove(23L)){
//            log.info("삭제성공");
//        }else{
//            log.info("삭제실패");
//        }
//    }
}
