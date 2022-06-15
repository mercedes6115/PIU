package com.example.pickitup.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class JjimVO {
    private Long num;
    private String category;
    private String registDate;
    private String status;
    private Long userNum;
    private Long projectNum;
    private Long productNum;

}
