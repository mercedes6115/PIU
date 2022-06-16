package com.example.pickitup.service.project.projectReview;


import com.example.pickitup.domain.dao.project.projectReview.ProjectReviewFileDAO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewFileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectReviewFileSerivce {

    private final ProjectReviewFileDAO projectReviewFileDAO;

    // 파일 경로 가져오기
    public List<ProjectReviewFileVO> findProjectReviewNum(Long num) {
        return projectReviewFileDAO.findProjectReviewNum(num);
    }

    // 해당 후기글 작성 도중 창을 이동할 경우 저장 경로에서 사진 지우기
    public List<ProjectReviewFileVO> getOldFiles(){
        return projectReviewFileDAO.getOldFiles();
    }

    // 사진 등록
    public void register(ProjectReviewFileVO projectReviewFileVO){
        projectReviewFileDAO.register(projectReviewFileVO);
    };

    // 사진 삭제
    public void remove(Long projectReviewNum){
        projectReviewFileDAO.remove(projectReviewNum);
    }
}
