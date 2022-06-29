package com.example.pickitup.domain.dao.project.projectReview;

import com.example.pickitup.domain.vo.dto.MyReviewDTO;
import com.example.pickitup.domain.vo.dto.ReviewDTO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import com.example.pickitup.mapper.project.projectReview.ProjectReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class ProjectReviewDAO {

    private final ProjectReviewMapper projectReviewMapper;

    // 프로젝트 리뷰 목록 -> 수정
    public List<ProjectReviewVO> getList(Long projectNum){
        return projectReviewMapper.getList(projectNum);
    }

    // 리뷰 상세보기
    public ProjectReviewVO read(Long num){
        return projectReviewMapper.getDetail(num);
    }



    // 리뷰 상세보기2
    public ReviewDTO readReview(Long num){
        return projectReviewMapper.getReviewDetail(num);
    }

    // 리뷰 작성
    public void register(ProjectReviewVO projectReviewVO){
        projectReviewMapper.insert(projectReviewVO);
    }

    // 리뷰 수정
    public boolean update(ProjectReviewVO projectReviewVO){
        return projectReviewMapper.update(projectReviewVO);
    }

    // 리뷰 삭제
    public boolean remove(Long num){
        return projectReviewMapper.delete(num);
    }

    // 리뷰 목록
    public List<ReviewDTO> getReviewList(Long projectNum){
        return projectReviewMapper.getReviewList(projectNum);
    }

}
