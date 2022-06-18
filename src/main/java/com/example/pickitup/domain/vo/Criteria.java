package com.example.pickitup.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

//Criteria : 검색의 기준
@Component
@Data
public class Criteria {
    private int pageNum;
    private int amount;
    private String type;
    private String type1;
    private String type2;
    private String type3;
    private String keyword;

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int pageNum, int amount) {
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
                .queryParam("keyword", this.keyword);
        return builder.toUriString();
    }


    public Map<String,String> getTypesAdd() {
        Map<String,String> userTypes= new HashMap<String,String>();
        userTypes.put("type",type);
        userTypes.put("type1",type1);
        userTypes.put("type2",type2);
        userTypes.put("type3",type3);
        return userTypes;
    }



}

















