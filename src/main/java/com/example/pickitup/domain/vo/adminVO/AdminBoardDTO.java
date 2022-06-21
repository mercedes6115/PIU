package com.example.pickitup.domain.vo.adminVO;

import com.example.pickitup.domain.vo.Criteria;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AdminBoardDTO {

    private Criteria criteria;
    private Long num;
    private String category;
    private String title;
    private String content;
    private String registDate;
    private String userNum;
    private String type2;
    private String keyword;

    private String writer;
    private String notice;
    private String productQna;
    private String projectQna;
    private String createrQna;
}
