package com.example.pickitup.domain.dao.project.projectQna;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.mapper.project.projectQna.ProjectQnaCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class ProjectQnaCommentDAO {

    private final ProjectQnaCommentMapper projectQnaCommentMapper;

    // 관리자가 답변한 qna 전체 목록
    public List<ProjectQnaCommentVO> getList(Criteria criteria){
        return projectQnaCommentMapper.getList(criteria);
    }


    // 답글 조회
    public List<ProjectQnaCommentVO> getComment(Long qnaNum){
        return projectQnaCommentMapper.getComment(qnaNum);
    }

    // qna 답글 달기(모집자, 관리자)
    public void register(ProjectQnaCommentVO projectQnaCommentVO){
        projectQnaCommentMapper.insert(projectQnaCommentVO);
    }

    // qna 답글 수정(모집자, 관리자)
    public boolean update(ProjectQnaCommentVO projectQnaCommentVO){
        return projectQnaCommentMapper.update(projectQnaCommentVO);
    }

    // qna 답글 삭제
    public boolean remove(Long num){
        return projectQnaCommentMapper.delete(num);
    }
}
