package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class QrDTO {
    private String startQr;
    private String endQr;
    private long userNum;
    private long projectNum;
    private String userPoint;
    private String addPoint;
    private String projectApproval;
    private Long applyNum;
    private String approach;

}
