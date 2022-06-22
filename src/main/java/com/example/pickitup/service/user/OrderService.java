package com.example.pickitup.service.user;

import com.example.pickitup.domain.dao.user.OrderDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.dto.OrderDTO;
import com.example.pickitup.domain.vo.user.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService {

    private final OrderDAO orderDAO;

    // 주문 목록(관리자용)
    public List<OrderDTO> getList(OrderCriteria orderCriteria){
        return orderDAO.getList(orderCriteria);
    }

    // 주문 목록(구매자용)


    // 주문 등록
    public void register(OrderVO orderVO){
        orderDAO.register(orderVO);
    }

    // 주문 취소
    public boolean remove(Long num){
        return orderDAO.remove(num);
    }

    // 주문 개수 - 관리자용


}
