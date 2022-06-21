package com.example.pickitup.domain.dao.user;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.LatestVO;
import com.example.pickitup.mapper.user.LatestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LatestDAO {

    private final LatestMapper latestMapper;

    // 최근에 본 프로젝트 목록
    public List<ProjectVO> getProjectList(Long userNum){
        return latestMapper.getProjectList(userNum);
    }

    // 최근에 본 상품 목록
    public List<ProductVO> getProductList(Long userNum){
        return latestMapper.getProductList(userNum);
    }

    // 최근에 본 게시물 등록
    public void register(LatestVO latestVO){
        latestMapper.insert(latestVO);
    }

    // 최근에 본 프로젝트 게시물 수정(날짜 최신화)
    public boolean updateProject(LatestVO latestVO){
        return latestMapper.updateProject(latestVO);
    }

    // 최근에 본 스토어 게시물 수정(날짜 최신화)
    public boolean updateProduct(LatestVO latestVO){
        return latestMapper.updateProduct(latestVO);
    }

    // 수정 하기전에 목록에 있는지 확인여부?
}
