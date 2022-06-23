package com.example.pickitup.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class ProjectCriteria {
    private int pageNum;
    private int amount;
    private String type;
    private String type1;
    private String type2;
    private String keyword;
    private String startDate;
    private String endDate;
    private int total;


    public ProjectCriteria() {
        this(1, 10);
    }

    public ProjectCriteria(int pageNum, int amount) {
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
                .queryParam("startDate", this.startDate)
                .queryParam("endDate", this.endDate)
                .queryParam("keyword", this.keyword)
                .queryParam("total", this.total);
        return builder.toUriString();
    }

    public Map<String,String> getTypes() {
        Map<String,String> getTypes= new HashMap<String,String>();
        getTypes.put("type",type);
        getTypes.put("type1",type1);
        getTypes.put("type2",type2);
        getTypes.put("startDate",startDate);
        getTypes.put("endDate",endDate);
        getTypes.put("keyword",keyword);
        return getTypes;
    }
}
