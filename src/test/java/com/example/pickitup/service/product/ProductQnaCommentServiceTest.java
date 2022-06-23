package com.example.pickitup.service.product;

import com.example.pickitup.domain.dao.product.productQna.ProductQnaCommentDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaCommentVO;
import com.example.pickitup.service.product.productQna.ProductQnaCommentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductQnaCommentServiceTest {
    @Autowired
    private ProductQnaCommentService productQnaCommentService;

//    @Test
//    public void getListTest(){
//        productQnaCommentService.getList(26L);
//    }

//    @Test
//    public void registerTest(){
//        ProductQnaCommentVO vo = new ProductQnaCommentVO();
//        vo.setContent("서비스 문의에 대한 답글입니다.");
//        vo.setUserNum(1L);
//        vo.setQnaNum(26L);
//        productQnaCommentService.register(vo);
//    }

//    @Test
//    public void updateTest(){
//        ProductQnaCommentVO vo = new ProductQnaCommentVO();
//        vo.setNum(68L);
//        vo.setContent("68번 답글 수정");
//        productQnaCommentService.update(vo);
//    }

//    @Test
//    public void removeTest(){
//        productQnaCommentService.delete(8L);
//    }

}
