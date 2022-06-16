package com.example.pickitup.service.project.projectQna;

import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaCommentDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectQnaCommentService {

    private final ProjectQnaCommentDAO projectQnaCommentDAO;

    // 관리자가 답변한 qna 전체 목록
    public List<ProjectQnaCommentVO> getList(Criteria criteria){
        return projectQnaCommentDAO.getList(criteria);
    }

    // qna 답글 달기(모집자, 관리자)
    public void register(ProjectQnaCommentVO projectQnaCommentVO){
        projectQnaCommentDAO.register(projectQnaCommentVO);
    }

    // qna 답글 수정(모집자, 관리자)
    public boolean update(ProjectQnaCommentVO projectQnaCommentVO){
        return projectQnaCommentDAO.update(projectQnaCommentVO);
    }

    // qna 답글 삭제
    public boolean remove(Long num){
        return projectQnaCommentDAO.remove(num);
    }
}
