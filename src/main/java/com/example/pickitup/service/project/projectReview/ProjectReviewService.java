package com.example.pickitup.service.project.projectReview;

import com.example.pickitup.domain.dao.project.projectReview.ProjectReviewDAO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectReviewService {

    private final ProjectReviewDAO projectReviewDAO;

    // 프로젝트 리뷰 목록 -> 수정
    public List<ProjectReviewVO> getList(Long projectNum){
        return projectReviewDAO.getList(projectNum);
    }

    // 리뷰 상세보기
    public ProjectReviewVO read(Long num){
        return projectReviewDAO.read(num);
    }

    // 리뷰 작성
    public void register(ProjectReviewVO projectReviewVO){
        projectReviewDAO.register(projectReviewVO);
    }

    // 리뷰 수정
    public boolean update(ProjectReviewVO projectReviewVO){
        return projectReviewDAO.update(projectReviewVO);
    }

    // 리뷰 삭제
    public boolean remove(Long num){
        return projectReviewDAO.remove(num);
    }
}
