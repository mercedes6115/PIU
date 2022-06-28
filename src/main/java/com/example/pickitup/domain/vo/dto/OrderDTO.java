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
    private String nickname;
    private String email;
    private String phone;
    private String address;
    private Long productNum;
    private String productName;
    private String manufacturer;
    private String supplier;
    private String registDate;
    private String status;
    private String price;
    private String category;
}
