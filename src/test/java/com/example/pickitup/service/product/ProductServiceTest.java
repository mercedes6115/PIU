package com.example.pickitup.service.product;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.service.product.productFile.ProductService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

//    @Test
//    public void getListTest(){
//        productService.getList();
//    }
//    @Test
//    public void getDetailTest(){
//        productService.getDetail(61L);
//    }

//    @Test
//    public void registerTest(){
//        ProductVO vo = new ProductVO();
//        vo.setName("김현엽serviceTest");
//        vo.setContent("김현엽serviceTest");
//        vo.setCategory("김현엽serviceTest");
//        vo.setPrice(50000L);
//        vo.setStock(1L);
//        vo.setOrigin("한국");
//        vo.setManufacturer("한국");
//        vo.setSupplier("한국");
//        productService.register(vo);
//    }

//    @Test
//    public void updateTest(){
//        ProductVO vo = new ProductVO();
//        vo.setNum(23L);
//        vo.setName("김현엽serviceUpdateTest");
//        vo.setContent("김현엽serviceUpdateTest");
//        vo.setCategory("김현엽serviceUpdateTest");
//        vo.setPrice(500L);
//        vo.setStock(100L);
//        vo.setOrigin("캐나다");
//        vo.setManufacturer("캐나다");
//        vo.setSupplier("캐나다");
//        productService.update(vo);
//    }

//    @Test
//    public void deleteTest(){
//        productService.remove(23L);
//    }

    @Test
    public void countTest(){
        productService.count();
    }
}
