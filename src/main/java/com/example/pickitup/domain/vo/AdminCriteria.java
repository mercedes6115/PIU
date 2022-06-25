package com.example.pickitup.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class AdminCriteria {
    private int pageNum;
    private int amount;
    private Long num;
    private String type;
    private String type1;
    private String type2;
    private String type3;
    private String keyword;
    private String keyword1;
    private String startDate;
    private String endDate;
    private int total;
    private int adminBoardCount;

    public AdminCriteria() {
        this(1, 10);
    }
    public AdminCriteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String getListLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", this.pageNum)
                .queryParam("amount", this.amount)
                .queryParam("type", this.type)
                .queryParam("type1", this.type1)
                .queryParam("type2", this.type2)
                .queryParam("type3", this.type3)
                .queryParam("startDate", this.startDate)
                .queryParam("endDate", this.endDate)
                .queryParam("keyword", this.keyword);
//                .queryParam("keyword1", this.keyword1)
//                .queryParam("total", this.total)
//                .queryParam("adminBoardCount", this.adminBoardCount);
        return builder.toUriString();
    }

    public Map<String,String> getTypes() {
        Map<String,String> getTypes= new HashMap<String,String>();
        getTypes.put("type",type);
        getTypes.put("type1",type1);
        getTypes.put("keyword",keyword);
        return getTypes;
    }

}


