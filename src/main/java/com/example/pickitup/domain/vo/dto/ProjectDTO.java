package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProjectDTO {
    private Long num;
    private String title;
    private String terrain;
    private Long point;
    private Long companyNum;
    private Long jjimCount;
    private String projectDate;
    private Long applyCount;

    public ProjectDTO(Long num, String title, String terrain, Long point, Long companyNum, Long jjimCount, String projectDate, Long applyCount){
        this.num = num;
        this.title = title;
        this.terrain = terrain;
        this.point = point;
        this.companyNum = companyNum;
        this.jjimCount = jjimCount;
        this.projectDate = projectDate;
        this.applyCount = applyCount;
    }
}
