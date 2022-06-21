package com.example.pickitup.dao.product;

import com.example.pickitup.domain.dao.product.productFile.ProductFileDAO;
import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductFileDaoTest {
    @Autowired
    private ProductFileDAO productFileDAO;

//    @Test
//    public void getListTest(){
//        productFileDAO.findByProductNum(23L);
//    }
//
//    @Test
//    public void insertTest(){
//        ProductFileVO vo  = new ProductFileVO();
//        vo.setUuid("dao에서 파일추가");
//        vo.setUploadPath("dao에서 파일추가");
//        vo.setProductNum(23L);
//        vo.setFileName("dao에서 파일추가");
//        productFileDAO.register(vo);
//    }
//
//    @Test
//    public void deleteTest(){
//        productFileDAO.remove("dao에서 파일추가");
//    }
}
