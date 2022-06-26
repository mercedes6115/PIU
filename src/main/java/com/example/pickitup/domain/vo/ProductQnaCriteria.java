package com.example.pickitup.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class ProductQnaCriteria {
    private int pageNum;
    private int amount;
    private String type;
    private String keyword;

    //페이지 1개당 5개 리뷰 보여주기
    public ProductQnaCriteria() {
        this(1, 5);
    }

    public ProductQnaCriteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
}
