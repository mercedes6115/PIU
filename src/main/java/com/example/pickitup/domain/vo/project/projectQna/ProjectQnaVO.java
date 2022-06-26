package com.example.pickitup.domain.vo.project.projectQna;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class ProjectQnaVO {
    private Long num;
    private String content;
    private String registDate;
    private String updateDate;
    private Long userNum;
    private Long projectNum;
    private Long companyNum;
//    private String nickname;

}