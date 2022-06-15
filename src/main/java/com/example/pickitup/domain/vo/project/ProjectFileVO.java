package com.example.pickitup.domain.vo.project;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class ProjectFileVO {
    private String uuid;
    private String uploadPath;
    private String fileName;
    private Long projectNum;


}
