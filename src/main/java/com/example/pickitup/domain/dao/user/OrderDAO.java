package com.example.pickitup.domain.dao.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.user.OrderVO;
import com.example.pickitup.mapper.user.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class OrderDAO {

    private final OrderMapper orderMapper;

    // 주문 목록(관리자용)
    public List<OrderVO> getList(Criteria criteria){
        return orderMapper.getList(criteria);
    }

    // 주문 목록(구매자용)


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

}
