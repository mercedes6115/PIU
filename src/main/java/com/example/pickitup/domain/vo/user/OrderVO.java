package com.example.pickitup.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderVO {
    private Long num;
    private Long total;
    private Long counting;
    private String registDate;
    private String status;
    private Long userNum;
    private Long productNum;
    private String addressComment;
    private String orderName;
    private String address;
    private String addressDetail;
}
