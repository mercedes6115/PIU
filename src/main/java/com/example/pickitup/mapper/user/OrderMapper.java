package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.user.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
//    주문 전체 리스트
    public List<OrderVO> getList(Criteria criteria);
//    주문 등록
    public void insert(OrderVO orderVO);

//    주문 취소
    public boolean delete(Long num);

//    상품별 개수 세어주기 상품명, 주문상품개수 DTO 선언
//







}


