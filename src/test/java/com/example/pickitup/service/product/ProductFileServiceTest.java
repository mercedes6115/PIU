package com.example.pickitup.service.product;

import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import com.example.pickitup.service.product.productFile.ProductFileService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductFileServiceTest {
    @Autowired
    private ProductFileService productFileService;

    @Test
    public void findByProductNumTest(){
        productFileService.findByProductNum(23L);
    }

    @Test
    public void registerTest(){
        ProductFileVO vo = new ProductFileVO();
        vo.setFileName("서비스에서 추가");
        vo.setProductNum(23L);
        vo.setUploadPath("서비스에서 추가");
        vo.setUuid("서비스에서 추가");
        productFileService.register(vo);
    }

//    @Test
//    public void removeTest(){
//        productFileService.remove("서비스에서 추가");
//    }
}
