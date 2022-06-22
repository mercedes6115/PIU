package com.example.pickitup.dao.product;

import com.example.pickitup.domain.dao.product.productFile.ProductDAO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.mapper.product.productFile.ProductMapper;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductDaoTest {
    @Autowired
    private ProductDAO productDAO;

//    @Test
//    public void getListTest(){
//        productDAO.getList().stream().map(ProductVO::toString).forEach(log::info);
//    }
//    @Test
//    public void getDetail(){
//        productDAO.getDetail(23L);
//    }
//
//    @Test
//    public void registerTest(){
//        ProductVO vo = new ProductVO();
//        vo.setName("dao 삽입 test");
//        vo.setContent("dao 삽입 test");
//        vo.setCategory("dao 삽입 test");
//        vo.setPrice(10000L);
//        vo.setStock(10L);
//        vo.setOrigin("dao 삽입 test");
//        vo.setManufacturer("dao 삽입 test");
//        vo.setSupplier("dao 삽입 test");
//        productDAO.register(vo);
//    }

//    @Test
//    public void modifyTest(){
//        ProductVO vo = new ProductVO();
//        vo.setNum(23L);
//        vo.setName("김현엽 dao 수정");
//        vo.setContent("상품 dao 내용수정");
//        vo.setCategory("가전 dao 수정");
//        vo.setPrice(5000L);
//        vo.setStock(50L);
//        vo.setOrigin("캐나다 dao 수정");
//        vo.setManufacturer("캐나다 dao 수정");
//        vo.setSupplier("샘성 dao 수정");
//        if(productDAO.update(vo)){
//            log.info("UPDATE SUCCESS");
//        }else{
//            log.info("UPDATE FAIL");
//        }
//    }

//    @Test
//    public void removeTest(){
//        if(productDAO.remove(22L)){
//            log.info("DELETE SUCCESS");
//            return;
//        }
//        log.info("DELETE FAIL");
//    }

    @Test

    public void countTest(){
        productDAO.count();
    }



    public void getDetailTest() {
        productDAO.getDetail(2L);
    }

}
