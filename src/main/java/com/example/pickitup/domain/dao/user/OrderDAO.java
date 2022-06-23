package com.example.pickitup.domain.dao.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.dto.OrderDTO;
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
}
