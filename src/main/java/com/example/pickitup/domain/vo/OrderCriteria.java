package com.example.pickitup.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class OrderCriteria {
    private int pageNum;
    private int amount;
    private String type;
    private String type1;
    private String keyword;
    private String keyword1;
    private String startDate;
    private String endDate;
    private int total;



    public OrderCriteria() {
        this(1, 10);
    }

    public OrderCriteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String getListLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", this.pageNum)
                .queryParam("amount", this.amount)
                .queryParam("type", this.type)
                .queryParam("type1", this.type1)
                .queryParam("startDate", this.startDate)
                .queryParam("endDate", this.endDate)
                .queryParam("keyword", this.keyword)
                .queryParam("keyword1", this.keyword1)
                .queryParam("total", this.total);
        return builder.toUriString();
    }

    public Map<String,String> getTypes() {
        Map<String,String> getTypes= new HashMap<String,String>();
        getTypes.put("type",type);
        getTypes.put("type1",type1);
        getTypes.put("startDate",startDate);
        getTypes.put("endDate",endDate);
        getTypes.put("keyword",keyword);
        getTypes.put("keyword1",keyword1);
        return getTypes;
    }
}
