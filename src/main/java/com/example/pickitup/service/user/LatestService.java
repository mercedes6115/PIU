package com.example.pickitup.service.user;

import com.example.pickitup.domain.dao.user.LatestDAO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.LatestVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LatestService {

    private final LatestDAO latestDAO;

    // 최근에 본 프로젝트 목록
    public List<ProjectVO> getProjectList(Long userNum){
        return latestDAO.getProjectList(userNum);
    }

    // 최근에 본 상품 목록
    public List<ProductVO> getProductList(Long userNum){
        return latestDAO.getProductList(userNum);
    }

    // 최근에 본 게시물 등록
    public void register(LatestVO latestVO){
        latestDAO.register(latestVO);
    }

    // 최근에 본 프로젝트 게시물 수정(날짜 최신화)
    public boolean updateProject(LatestVO latestVO){
        return latestDAO.updateProject(latestVO);
    }

    // 최근에 본 스토어 게시물 수정(날짜 최신화)
    public boolean updateProduct(LatestVO latestVO){
        return latestDAO.updateProduct(latestVO);
    }

    // 수정 하기전에 목록에 있는지 확인여부?
}
