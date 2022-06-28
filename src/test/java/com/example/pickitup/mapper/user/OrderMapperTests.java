package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.dto.OrderUserDTO;
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


    @Test
    public void getOrderListTest(){
        log.info("주문 전체 목록 페이징"+ orderMapper.getList(new OrderCriteria(1,10)));
    }

//    @Test
//    public void getOrderListTest(){
//        log.info("주문 전체 목록 페이징"+ orderMapper.getList(new Criteria(1,10)));
//    }
    @Test
    public void getToday(){
        log.info("오늘기준 한달치 "+orderMapper.getListToday("2022-06-25","2022-06-26").toString());
    }

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


    @Test
    public void getBetweenOrderTest() {orderMapper.getBetweenOrder(2L, "2022-06-16","2022-06-25");}

    @Test
    public void BoughtOrderTest() {orderMapper.orderProductDetail(21L);}

//    @Test
//    public void getBetweenOrderTest() {orderMapper.getBetweenOrder(2L);}

    @Test
    public void orderStoreTest() {
        OrderUserDTO orderUserDTO = new OrderUserDTO();
        orderUserDTO.setUserNum(22L);
        orderUserDTO.setCounting(3L);
        orderUserDTO.setTotal(300L);
        orderUserDTO.setProductName("상품3");
        orderUserDTO.setAddressComment("부재시 경비실에 맡겨주세요");
        orderUserDTO.setAddress("서울시 강남구");
        orderUserDTO.setAddressDetail("역삼동 2번지");
        orderMapper.orderStore(orderUserDTO);
    }

    @Test
    public void userPointMinusTest() {
        orderMapper.userPointMinus(22L,"5000");
    }

    @Test
    public void productMinusTest(){
        orderMapper.productMinus("상품3", 50L);
    }

    @Test
    public void getDetailByNameTest(){
        orderMapper.getDetailByName("상품1");
    }

}

