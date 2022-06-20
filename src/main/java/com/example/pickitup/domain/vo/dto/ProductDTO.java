package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductDTO {
    private String itemname;
    private String itemimg;
    private String totalitems;
    private String totalpayment;
    private Long ogprice;
}
