package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.user.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//@SpringBootTest
//@Slf4j
//public class OrderMapperTests {
//    @Autowired
//    private OrderMapper orderMapper;
//
//    @Test
//    public void getDetailTest(){
//        log.info("주문 상세 내용 "+ orderMapper.);
//    }
//}

@SpringBootTest
@Slf4j
public class OrderMapperTests {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void getDetailTest(){
        log.info("주문 상세 내용 " + orderMapper.getDetail(22L,21L));
    }

//    @Test
//    public void getOrderListTest(){
//        log.info("주문 전체 목록 페이징"+ orderMapper.getList(new Criteria(1,10)));
//    }

    @Test
    public void insertTest(){
        OrderVO orderVO=new OrderVO();
        orderVO.setTotal(10L);
        orderVO.setCounting(100L);
        orderVO.setProductNum(22L);
        orderVO.setUserNum(1L);

        orderMapper.insert(orderVO);
    }
    @Test
    public void deleteTest(){
        orderMapper.delete(25L);
    }
    @Test
    public void countOrderTest(){
        log.info("주문 개수: "+orderMapper.countOrder());
    }
    @Test
    public void countProductOrderTest(){
        log.info("상품별 개수: "  +orderMapper.countProductOrder(22L));
    }

    @Test
    public void boughtItemTest() {orderMapper.boughtItem(2L);}


}

