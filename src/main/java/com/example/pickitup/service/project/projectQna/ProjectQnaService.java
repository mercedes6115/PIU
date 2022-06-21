package com.example.pickitup.service.project.projectQna;

import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaDAO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectQnaService {

    private final ProjectQnaDAO projectQnaDAO;

    // qna 전체 목록 -> 수정
    public List<ProjectQnaVO> getList(Long projectNum){
        return projectQnaDAO.getList(projectNum);
    }

//    // qna 상세보기 -> 수정
//    public ProjectQnaVO read(Long projectNum){
//        return projectQnaDAO.read(projectNum);
//    }

    // qna 등록
    public void register(ProjectQnaVO projectQnaVO){
        projectQnaDAO.register(projectQnaVO);
    }

    // qna 수정
    public boolean update(ProjectQnaVO projectQnaVO){
        return projectQnaDAO.update(projectQnaVO);
    }

    // qna 삭제
    public boolean remove(Long num){
        return projectQnaDAO.remove(num);
    }



}
