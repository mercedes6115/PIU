package com.example.pickitup.mapper.product;

import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import com.example.pickitup.mapper.product.productFile.ProductFileMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductFileMapperTest {
    @Autowired
    private ProductFileMapper productFileMapper;

//    @Test
//    public void insertTest(){
//        ProductFileVO vo = new ProductFileVO();
//        vo.setFileName("11");
//        vo.setProductNum(23L);
//        vo.setUploadPath("22");
//        vo.setUuid("33");
//        productFileMapper.insert(vo);
//    }

//    @Test
//    public void deleteTest(){
//
//        productFileMapper.delete("모른다구");
//    }

//    @Test
//    public void findByProductNumTest(){
//        productFileMapper.findByProductNum(23L).stream().map(ProductFileVO::toString).forEach(log::info);
//    }

}
