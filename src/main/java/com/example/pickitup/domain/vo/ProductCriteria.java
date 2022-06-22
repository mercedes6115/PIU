package com.example.pickitup.domain.vo;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class ProductCriteria {
    private int pageNum;
    private int amount;
    private String type;
    private String type1;
    private String keyword;
    private String keyword1;
    private String startDate;
    private String endDate;
    private int total;

    public ProductCriteria() {
        this(1, 10);
    }
    public ProductCriteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String getListLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", this.pageNum)
                .queryParam("amount", this.amount)
                .queryParam("type", this.type)
                .queryParam("type1", this.type1)
                .queryParam("keyword", this.keyword)
                .queryParam("total", this.total);
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
