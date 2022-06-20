package com.example.pickitup.mapper.product;

import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import com.example.pickitup.mapper.product.productReview.ProductReviewMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductReviewMapperTest {
    @Autowired
    private ProductReviewMapper productReviewMapper;

//    @Test
//    public void getListTest(){
//        productReviewMapper.getList().stream().map(ProductReviewVO::toString).forEach(log::info);
//    }

    @Test
    public void getListTest(){
        productReviewMapper.getList(24L);
    }
//
//    @Test
//    public void insertTest(){
//        ProductReviewVO vo = new ProductReviewVO();
//        vo.setContent("이상품 정말 베스트에요!");
//        vo.setUserNum(1L);
//        vo.setProductNum(22L);
//        productReviewMapper.insert(vo);
//    }

//    @Test
//    public void updateTest(){
//        ProductReviewVO vo = new ProductReviewVO();
//        vo.setContent("알고보니 최악이에요");
//        vo.setNum(22L);
//        productReviewMapper.update(vo);
//    }
//
//    @Test
//    public void deleteTest(){
//        productReviewMapper.delete(22L);
//    }

}
