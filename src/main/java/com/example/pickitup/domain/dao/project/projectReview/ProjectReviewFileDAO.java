package com.example.pickitup.domain.dao.project.projectReview;


import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewFileVO;
import com.example.pickitup.mapper.project.projectReview.ProjectReviewFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProjectReviewFileDAO {

    private final ProjectReviewFileMapper projectReviewFileMapper;

    // 파일 경로 가져오기
    public List<ProjectReviewFileVO> findProjectReviewNum(Long num) {
        return projectReviewFileMapper.findProjectReviewNum(num);
    }

    // 해당 후기글 작성 도중 창을 이동할 경우 저장 경로에서 사진 지우기
    public List<ProjectReviewFileVO> getOldFiles(){
        return projectReviewFileMapper.getOldFiles();
    }

    // 사진 등록
    public void register(ProjectReviewFileVO projectReviewFileVO){
        projectReviewFileMapper.insert(projectReviewFileVO);
    };

    // 사진 삭제
    public void remove(Long projectReviewNum){
        projectReviewFileMapper.delete(projectReviewNum);
    }
}
