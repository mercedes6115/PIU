package com.example.pickitup.service;

import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaCommentDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaDAO;
import com.example.pickitup.domain.dao.user.ApplyDAO;
import com.example.pickitup.domain.dao.user.JjimDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDAO projectDAO;
    private final ProjectQnaDAO projectQnaDAO;
    private final ProjectQnaCommentDAO projectQnaCommentDAO;
    private final JjimDAO jjimDAO;
    private final ApplyDAO applyDAO;

    // 프로젝트 목록(관리자용)
    public List<ProjectVO> getList(){
        return projectDAO.getList();
    }


    // 프로젝트 목록(특정 단체 유저)
    public List<ProjectVO> getProjectList(Long companyNum){
        return projectDAO.getUserProjectList(companyNum, new Criteria());
    }

    // 프로젝트 상세보기
    public ProjectVO read(Long num){
        return projectDAO.read(num);
    }

    // 프로젝트 등록
    public void register(ProjectVO projectVO){
        projectDAO.register(projectVO);
    }

    // 프로젝트 수정
    public boolean update(ProjectVO projectVO){
        return projectDAO.update(projectVO);
    }

    // 프로젝트 삭제
    public boolean remove(Long num){
        return projectDAO.remove(num);
    }

    // QnA 등록
    public void registerQnA(ProjectQnaVO projectQnaVO){
        projectQnaDAO.register(projectQnaVO);
    }

    // QnA 목록
    public List<ProjectQnaVO> getQnAList(Long projectNum){
        return projectQnaDAO.getList(projectNum);
    }

//    // QnA 댓글 등록
//    public ProjectQnaCommentVO getComment (Long qnaNum){
//        return projectQnaCommentDAO.getComment(qnaNum);
//    }

    // QnA 댓글 목록
    public List<ProjectQnaCommentVO> getCommentList(Long qnaNum){
        return projectQnaCommentDAO.getComment(qnaNum);
    }

    // 찜 추가
    public void addJjim(JjimVO jjimVO){
        jjimDAO.register(jjimVO);
    }

    // 찜 해제
    public void removeJjim(JjimVO jjimVO){
        jjimDAO.remove(jjimVO);
    }

    // 프로젝트 지원
    public void apply(ApplyVO applyVO){
        applyDAO.register(applyVO);
    }

    // 프로젝트 참가자 상태 변경


}
