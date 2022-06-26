package com.example.pickitup.service.product;

import com.example.pickitup.domain.vo.ProductQnaCriteria;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import com.example.pickitup.service.product.productQna.ProductQnaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductQnaServiceTest {
    @Autowired
    private ProductQnaService productQnaService;

//    @Test
//    public void getListTest(){
//        productQnaService.getList(new ProductQnaCriteria(1,5),23L)
//                .stream().map(ProductQnaVO::toString).forEach(log::info);
//    }

//    @Test
//    public void readTest(){
//        productQnaService.read(26L);
//    }
//
//    @Test
//    public void registerTest(){
//        ProductQnaVO vo = new ProductQnaVO();
//        vo.setContent("상품 문의 또 남겨요");
//        vo.setUserNum(1L);
//        vo.setProductNum(23L);
//        productQnaService.register(vo);
//    }
//
//    @Test
//    public void updateTest(){
//        ProductQnaVO vo = new ProductQnaVO();
//        vo.setNum(28L);
//        vo.setContent("질문 해결됐어요");
//        if(productQnaService.update(vo)){
//            log.info("성공");
//        }else{
//            log.info("실패");
//        }
//    }
//
//    @Test
//    public void removeTest(){
//        if(productQnaService.remove(29L)){
//            log.info("성공");
//        }else{
//            log.info("실패");
//        }
//    }

//    @Test
//    public void countTest(){
//        productQnaService.count(61L);
//    }

}
