package com.example.pickitup.domain.vo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyOrderDTO {
    private String productName;
    private String registDate;
    private Long total;
    private Long counting;
    private String address;
    private String addressDetail;
    private String startDate;
    private String endDate;
    private String status;
    private String addressComment;
    private Long productNum;
    private Long num;
    private Long orderNum;

}
