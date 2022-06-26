package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.dto.MyOrderDTO;
import com.example.pickitup.domain.vo.dto.OrderDTO;
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
    public int updateUser(UserVO userVO);
    public List<ProductVO> getProduct(Long num);

    public List<MyOrderDTO> getBetweenOrder(Long userNum);


}


