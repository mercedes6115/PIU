package com.example.pickitup.service.user;

import com.example.pickitup.domain.dao.user.OrderDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.dto.MyOrderDTO;
import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.dto.OrderDTO;
import com.example.pickitup.domain.vo.user.OrderVO;
import com.example.pickitup.domain.vo.user.UserVO;
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

//    public List<OrderVO> getList(Criteria criteria){
//        return orderDAO.getList(criteria);
//    }


    // 주문 목록(구매자용)


//    // 주문 등록
//    public void register(OrderVO orderVO,UserVO userVO){
//        orderDAO.register(orderVO);
//        orderDAO.updateUser(userVO);
//    }
    // 주문 취소
    public boolean remove(Long num){
        return orderDAO.remove(num);
    }

    // 주문 개수 - 관리자용




    //update는 아직 성공못해서 진행 안됨.


    public void payment(Long num) {

        orderDAO.getUser(num);
//        orderDAO.getProduct(num1);

    }



    public List<MyOrderDTO> getBetweenOrder(Long userNum, String startDate, String endDate){
        return orderDAO.getBetweenOrder(userNum, startDate, endDate);
    }

    public OrderVO findByOrderNum(Long orderNum) {
        return orderDAO.findByOrderNum(orderNum);
    }

}
