package com.example.pickitup.dao.product;

import com.example.pickitup.domain.dao.product.productQna.ProductQnaDAO;
import com.example.pickitup.domain.vo.ProductQnaCriteria;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductQnaDaoTest {
    @Autowired
    private ProductQnaDAO productQnaDAO;
    
    
    @Test
    public void getListTest(){
        productQnaDAO.getList(new ProductQnaCriteria(1,5),23L)
                .stream().map(ProductQnaVO::toString).forEach(log::info);
    }
//
//    @Test
//    public void readTest(){
//        productQnaDAO.getList(26L);
//    }

//    @Test
//    public void registerTest(){
//        ProductQnaVO vo = new ProductQnaVO();
//        vo.setContent("질문있어요!");
//        vo.setUserNum(1L);
//        vo.setProductNum(23L);
//        productQnaDAO.register(vo);
//    }
//
//    @Test
//    public void modifyTest(){
//        ProductQnaVO vo = new ProductQnaVO();
//        vo.setNum(26L);
//        vo.setContent("새문의가 아니라 나문희에요!");
//        if(productQnaDAO.update(vo)){
//            log.info("UPDATE SUCCESS");
//        }else{
//            log.info("UPDATE FAIL");
//        }
//    }
//
//    @Test
//    public void removeTest(){
//        if(productQnaDAO.remove(27L)){
//            log.info("DELETE SUCCESS");
//            return;
//        }
//        log.info("DELETE FAIL");
//    }

//    @Test
//    public void countTest(){
//        productQnaDAO.count(61L);
//    }
}
