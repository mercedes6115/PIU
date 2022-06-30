package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.OrderCriteria;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderDTO {
    private OrderCriteria orderCriteria;
    private Long orderNum;
    private String orderName;
    private String email;
    private String phone;
    private String address;
    private String addressDetail;
    private Long productNum;
    private String productName;
    private String manufacturer;
    private String supplier;
    private String registDate;
    private String status;
    private Long userNum;
    private Long counting;
    private String addressComment;
    private Long num;
    private Long total;
    private String nickName;
    private String category;
    private int price;
}