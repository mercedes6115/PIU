package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.ProductQnaCriteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class QnaPageDTO {
    private ProductQnaCriteria productQnaCriteria;


    private int startPage;
    private int endPage;
    private int realEnd;
    private int pageCount;
    private boolean prev, next;

    private int total;

    public QnaPageDTO(ProductQnaCriteria productQnaCriteria, int total) {
        this(productQnaCriteria, 10, total);
    }

    public QnaPageDTO(ProductQnaCriteria productQnaCriteria, int pageCount, int total) {
        this.productQnaCriteria = productQnaCriteria;
        this.total = total;
//        현재 페이지를 기준으로 소수점까지 모두 계산하여 보여질 마지막 페이지 번호를 구한다.
        this.endPage = (int)Math.ceil(productQnaCriteria.getPageNum() / (double)pageCount) * pageCount;
        this.startPage = this.endPage - pageCount + 1;
        this.realEnd = (int)Math.ceil((double)total / productQnaCriteria.getAmount());

        if(realEnd < this.endPage){
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }

}
