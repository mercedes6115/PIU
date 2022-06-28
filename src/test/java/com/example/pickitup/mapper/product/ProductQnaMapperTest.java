package com.example.pickitup.mapper.product;


import com.example.pickitup.domain.vo.ProductQnaCriteria;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import com.example.pickitup.mapper.product.productFile.ProductMapper;
import com.example.pickitup.mapper.product.productQna.ProductQnaMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductQnaMapperTest {
    @Autowired
    private ProductQnaMapper productQnaMapper;

//    @Test
//    public void getListTest(){
//        productQnaMapper.getList(new ProductQnaCriteria(1,5),23L)
//                .stream().map(ProductQnaVO::toString).forEach(log::info);
//    }
//
    @Test
    public void getDetailTest(){
        productQnaMapper.getDetail(120L);
    }
//
//    @Test
//    public void insertTest(){
//        ProductQnaVO vo = new ProductQnaVO();
//       vo.setContent("와우 이상품 정말 좋아요!");
//       vo.setUserNum(1L);
//       vo.setProductNum(22L); //22번 상폼
//        productQnaMapper.insert(vo);
//    }

//    @Test
//    public void updateTest(){
//        ProductQnaVO vo = new ProductQnaVO();
//        vo.setNum(25L);
//        vo.setContent("문의인데 잘못달았어요!");
//        productQnaMapper.update(vo);
//    }
//
//    @Test
//    public void deleteTest(){
//        productQnaMapper.delete(25L);
//    }

//    @Test
//    public void countTest(){
//        productQnaMapper.count(61L);
//    }
}
