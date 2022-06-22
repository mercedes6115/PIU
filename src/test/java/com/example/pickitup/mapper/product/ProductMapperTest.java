package com.example.pickitup.mapper.product;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.mapper.product.productFile.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

//    @Test
//    public void getListTest(){
//        productMapper.getList(null).stream().map(ProductVO::toString).forEach(log::info);
//    }
//
    @Test
    public void getDetailTest(){
        productMapper.getDetail(2L);
    }
//
//    @Test
//    public void insertTest(){
//        ProductVO vo = new ProductVO();
//        vo.setName("김현엽");
//        vo.setContent("상품내용");
//        vo.setCategory("가전");
//        vo.setPrice(3000L);
//        vo.setStock(30L);
//        vo.setOrigin("캐나다");
//        vo.setManufacturer("캐나다");
//        vo.setSupplier("샘성");
//        productMapper.insert(vo);
//    }

//    @Test
//    public void updateTest(){
//        ProductVO vo = new ProductVO();
//        vo.setNum(22L);
//        vo.setName("김현엽수정");
//        vo.setContent("상품내용수정");
//        vo.setCategory("가전수정");
//        vo.setPrice(5000L);
//        vo.setStock(50L);
//        vo.setOrigin("캐나다수정");
//        vo.setManufacturer("캐나다수정");
//        vo.setSupplier("샘성수정");
//        productMapper.update(vo);
//    }
//
//    @Test
//    public void deleteTest(){
//        productMapper.delete(21L);
//    }

//    @Test
//    public void countTest(){
//        productMapper.count();
//    }



}
