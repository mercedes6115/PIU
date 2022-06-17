package com.example.pickitup.service.project.projectFile;

import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDAO projectDAO;

    // 프로젝트 목록
    public List<ProjectVO> getList(){
        return projectDAO.getList();
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


    // 프로젝트 목록(찜순)
    public List<ProjectVO> getListJJim(){
        return projectDAO.getListJJim();
    }
    // 프로젝트 목록(포인트순)
    public List<ProjectVO> getListPoint(){
        return projectDAO.getListPoint();
    }


}
