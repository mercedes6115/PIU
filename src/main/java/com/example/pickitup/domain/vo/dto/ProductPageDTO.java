package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.ProductCriteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ProductPageDTO {
    private ProductCriteria productCriteria;

    private int startPage;
    private int endPage;
    private int realEnd;
    private int pageCount;
    private boolean prev, next;
    private Long num;
    private String nickname;
    private String email;
    private String registDate;
    private String phone;
    private String address;

    private int total;

    public ProductPageDTO(ProductCriteria productCriteria, int total) {
        this(productCriteria, 10, total);
    }

    public ProductPageDTO(ProductCriteria productCriteria, int pageCount, int total) {
        this.productCriteria = productCriteria;
        this.total = total;
//        현재 페이지를 기준으로 소수점까지 모두 계산하여 보여질 마지막 페이지 번호를 구한다.
        this.endPage = (int)Math.ceil(productCriteria.getPageNum() / (double)pageCount) * pageCount;
        this.startPage = this.endPage - pageCount + 1;
        this.realEnd = (int)Math.ceil((double)total / productCriteria.getAmount());

        if(realEnd < this.endPage){
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}
