package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.Criteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminBoardPageDTO {
    private Criteria criteria;

    private int startPage;
    private int endPage;
    private int realEnd;
    private int pageCount;
    private boolean prev, next;
    private Long num;
    private String title;
    private String category;
    private String registDate;
    private String updateDate;
    private String status;
    private String content;
    private String userNum;

    private int adminBoardCount;

    public AdminBoardPageDTO(Criteria criteria, int adminBoardCount) {
        this(criteria, 10, adminBoardCount);
    }

    public AdminBoardPageDTO(Criteria criteria, int pageCount, int adminBoardCount) {
        this.criteria = criteria;
        this.adminBoardCount = adminBoardCount;
//        현재 페이지를 기준으로 소수점까지 모두 계산하여 보여질 마지막 페이지 번호를 구한다.
        this.endPage = (int)Math.ceil(criteria.getPageNum() / (double)pageCount) * pageCount;
        this.startPage = this.endPage - pageCount + 1;
        this.realEnd = (int)Math.ceil((double)adminBoardCount / criteria.getAmount());

        if(realEnd < this.endPage){
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }


}
















