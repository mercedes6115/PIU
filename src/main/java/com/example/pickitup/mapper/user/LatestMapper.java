package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.LatestVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LatestMapper {

    // 내가 최근본 프로젝트 리스트 보이기
    public List<ProjectVO> getProjectList(Long userNum);

    // 내가 최근본 상품 리스트 보이기
    public List<ProductVO> getProductList(Long userNum);

    // 최근 본 게시물 테이블 등록
    public void insert(LatestVO latestVO);

    // registDate update 해주기
    // projectNum하고 userNum을 주세요
    // 해당 외래키로 registDate sysdate할 예정
    public boolean updateProject(LatestVO latestVO);

    // registDate update 해주기
    // projectNum하고 userNum을 주세요
    public boolean updateProduct(LatestVO latestVO);
}
