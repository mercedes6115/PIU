package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.dto.MyOrderDTO;
import com.example.pickitup.domain.vo.dto.OrderDTO;

import com.example.pickitup.domain.vo.dto.ProductDTO;


import com.example.pickitup.domain.vo.dto.OrderUserDTO;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;

import com.example.pickitup.domain.vo.user.OrderVO;
import com.example.pickitup.domain.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
//    주문 전체 리스트
    public List<OrderDTO> getList(OrderCriteria orderCriteria);

    public int getTotal(OrderCriteria orderCriteria);

    public List<OrderDTO> getListToday(String startDate, String endDate);


//    주문 등록
    public void insert(OrderVO orderVO);

//    주문한 내용 보여주기, 가격, 상품명 등등
    public OrderVO getDetail(@Param("userNum")Long userNum, @Param("productNum")Long productNum);

//    주문 취소
    public boolean delete(Long num);

//
    public int countOrder();
    public int countProductOrder(@Param("productNum") Long productNum);

    public List<OrderVO> boughtItem(Long userNum);


    //
    public List<UserVO> getUser(Long num);
    public void updateUser(UserVO userVO);
    public List<ProductVO> getProduct(Long num);

    public List<MyOrderDTO> getBetweenOrder(Long userNum, String startDate, String endDate);

    public ProductDTO orderProductDetail(Long orderNum);

    //상품 주문
    public void orderStore(OrderUserDTO orderUserDTO);

    //상품 주문후 유저 포인트 차감
    public void userPointMinus(Long num, String point);

    //상품 주문후 상품 재고 차감
    public void productMinus(String itemname, Long stock);

    //상품 이름으로 정보 검색(1개)
    public Long getDetailByName(String itemname);

    public OrderVO getOrderDetail(Long productNum);

    public boolean setDelivery(Long orderNum);


    public OrderVO findByOrderNum(Long orderNum);

    //상품 주문
    public void orderStore(OrderDTO orderDTO);
}


