package com.example.pickitup.domain.vo.adminVO;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class AdminBoardDTO {

    private Criteria criteria;
    private Long num;
    private String category;
    private String answerStatus;
    private String title;
    private String content;
    private String registDate;
    private Long userNum;
    private String type2;
    private String keyword;
    private String nickname;
    private Long projectQnaNum;
    private Long productQnaNum;



    private List<ProjectVO> projectList;
    private List<ProductVO> productList;
    private List<ProjectQnaVO> projectQnaList;
    private List<ProductQnaVO> productQnaList;

}



