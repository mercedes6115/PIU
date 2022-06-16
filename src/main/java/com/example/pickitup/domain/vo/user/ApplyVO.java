package com.example.pickitup.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ApplyVO {
    private Long num;
    private Long approach;
    private String registDate;
    private Long userNum;
    private Long projectNum;
}
