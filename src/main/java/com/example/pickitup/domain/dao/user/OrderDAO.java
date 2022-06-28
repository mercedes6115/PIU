package com.example.pickitup.domain.dao.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.dto.MyOrderDTO;
import com.example.pickitup.domain.vo.dto.OrderDTO;

import com.example.pickitup.domain.vo.dto.ProductDTO;


import com.example.pickitup.domain.vo.dto.OrderUserDTO;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;

import com.example.pickitup.domain.vo.user.OrderVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.mapper.user.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDAO {

    private final OrderMapper orderMapper;

    // 주문 목록(관리자용)
    public List<OrderDTO> getList(OrderCriteria orderCriteria){
        return orderMapper.getList(orderCriteria);
    }


    public List<OrderDTO> getListToday(String startDate,String endDate){
        return orderMapper.getListToday(startDate,endDate);
    }
    // 주문 목록(구매자용)
    public int getTotal(OrderCriteria orderCriteria){
        return orderMapper.getTotal(orderCriteria);
    }

    // 주문 등록
    public void register(OrderVO orderVO){
        orderMapper.insert(orderVO);
    }

    // 주문 취소
    public boolean remove(Long num){
        return orderMapper.delete(num);
    }

    // 주문 개수 - 관리자용

    // 주문한 상품 목록
    public List<OrderVO> boughtItem(Long userNum) { return orderMapper.boughtItem(userNum);}

    public List<UserVO> getUser(Long num){
        return orderMapper.getUser(num);
    };
    //    public List<UserVO> updateUser(Long num){
//        return orderMapper.updateUser(num);
//    };

    public List<ProductVO> getProduct(Long num1){
        return orderMapper.getProduct(num1);
    };

    public List<MyOrderDTO> getBetweenOrder(Long userNum, String stardDate, String endDate) {
        return orderMapper.getBetweenOrder(userNum, stardDate, endDate);
    }


//    // 유저 정보 수정
//    public boolean updateUser(UserVO userVO){
//        return orderMapper.updateUser(userVO) != 0;
//    }


    public ProductDTO boughtDetail(Long orderNum) { return orderMapper.orderProductDetail(orderNum);}

    public OrderVO findByOrderNum(Long orderNum) {return orderMapper.findByOrderNum(orderNum);}


    //상품 주문
    public void orderStore(OrderUserDTO orderUserDTO) {
        orderMapper.orderStore(orderUserDTO);
    }

    //상품 주문후 유저 포인트 차감
    public void userPointMinus(Long num, String point) {
        orderMapper.userPointMinus(num, point);
    }

    //상품 주문후 상품 재고 차감
    public void productMinus(String itemname, Long stock) {
        orderMapper.productMinus(itemname, stock);
    }

    //상품명으로 정보 가져오기(1개)
    public Long getDetailByName(String itemname){
        return orderMapper.getDetailByName(itemname);
    }


    public OrderVO getOrderDetail(Long orderNum){
        return orderMapper.getOrderDetail(orderNum);
    }


    public boolean setDelivery(Long orderNum){
        return orderMapper.setDelivery(orderNum);
    }

}
