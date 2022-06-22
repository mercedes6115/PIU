package com.example.pickitup.mapper.product;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaCommentVO;
import com.example.pickitup.mapper.product.productQna.ProductQnaCommentMapper;
import com.jayway.jsonpath.InvalidCriteriaException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductQnaCommentMapperTest {
    @Autowired
    private ProductQnaCommentMapper productQnaCommentMapper;

    @Test
    public void getListTest(){
        productQnaCommentMapper.getList(26L).stream().map(ProductQnaCommentVO::toString).forEach(log::info);
    }
//
//    @Test
//    public void insertTest(){
//        ProductQnaCommentVO vo = new ProductQnaCommentVO();
//        vo.setContent("이 문의는 해결되었습니다");
//        vo.setUserNum(1L);
//        vo.setQnaNum(23L); //23번 문의에 대해 작성
//        productQnaCommentMapper.insert(vo);
//    }

//    @Test
//    public void updateTest(){
//        ProductQnaCommentVO vo = new ProductQnaCommentVO();
//        vo.setNum(4L);
//        vo.setContent("아직 해결이 안되었네요");
//        productQnaCommentMapper.update(vo);
//    }
//
//    @Test
//    public void deleteTest(){
//        productQnaCommentMapper.delete(4L);
//    }

}
