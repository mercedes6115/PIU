package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.AdminCriteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminBoardPageDTO {
    private AdminCriteria adminCriteria;

    private int startPage;
    private int endPage;
    private int realEnd;
    private int pageCount;
    private boolean prev, next;
    private Long num;
    private String title;
    private String category;
    private String answerStatus;
    private String registDate;
    private String updateDate;
    private String status;
    private String content;
    private String userNum;
    private String nickname;
    private Long projectQnaNum;
    private Long productQnaNum;

    private int adminBoardCount;

    public AdminBoardPageDTO(AdminCriteria adminCriteria, int adminBoardCount) {
        this(adminCriteria, 10, adminBoardCount);
    }

    public AdminBoardPageDTO(AdminCriteria adminCriteria, int pageCount, int adminBoardCount) {
        this.adminCriteria = adminCriteria;
        this.adminBoardCount = adminBoardCount;
//        현재 페이지를 기준으로 소수점까지 모두 계산하여 보여질 마지막 페이지 번호를 구한다.
        this.endPage = (int)Math.ceil(adminCriteria.getPageNum() / (double)pageCount) * pageCount;
        this.startPage = this.endPage - pageCount + 1;
        this.realEnd = (int)Math.ceil((double)adminBoardCount / adminCriteria.getAmount());

        if(realEnd < this.endPage){
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }


}