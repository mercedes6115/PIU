package com.example.pickitup.dao.product;

import com.example.pickitup.domain.dao.product.productQna.ProductQnaCommentDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaCommentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductQnaCommentDaoTest {
    @Autowired ProductQnaCommentDAO productQnaCommentDAO;

//    @Test
//    public void getListTest(){
//        productQnaCommentDAO.getList(new Criteria()).stream().map(ProductQnaCommentVO::toString).forEach(log::info);
//    }

//    @Test
//    public void insertTest(){
//        ProductQnaCommentVO vo = new ProductQnaCommentVO();
//        vo.setContent("이 문의는 해결되었습니다");
//        vo.setUserNum(1L);
//        vo.setQnaNum(26L); //23번 문의에 대해 작성
//        productQnaCommentDAO.register(vo);
//    }

//    @Test
//    public void updateTest(){
//        ProductQnaCommentVO vo = new ProductQnaCommentVO();
//        vo.setNum(8L);
//        vo.setContent("아직 해결이 안되었네요");
//        productQnaCommentDAO.update(vo);
//    }
//
//    @Test
//    public void deleteTest(){
//        productQnaCommentDAO.remove(5L);
//    }


}
