package com.example.pickitup.domain.dao.project.projectFile;


import com.example.pickitup.domain.vo.ProjectCriteria;
import com.example.pickitup.domain.vo.dto.ProjectDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.mapper.project.projectFile.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class ProjectDAO {

    private final ProjectMapper projectMapper;

    // 프로젝트 목록
    public List<ProjectVO> getList(){
        return projectMapper.getList();
    }

    public List<ProjectDTO> getProjectList(ProjectCriteria projectCriteria){
        return projectMapper.getProjectList(projectCriteria);
    }

    public int getProjectTotal(ProjectCriteria projectCriteria){
        return projectMapper.getProjectTotal(projectCriteria);
    }

    // 프로젝트 상세보기
    public ProjectVO read(Long num){
        return projectMapper.getDetail(num);
    }

    // 프로젝트 등록
    public void register(ProjectVO projectVO){
        projectMapper.insert(projectVO);
    }

    // 프로젝트 수정
    public boolean update(ProjectVO projectVO){
        return projectMapper.update(projectVO);
    }

    // 프로젝트 삭제
    public boolean remove(Long num){
        return projectMapper.delete(num);
    }

    // 프로젝트 목록(찜순)
    public List<ProjectVO> getListJJim(){
        return projectMapper.getListJJim();
    }
    // 프로젝트 목록(포인트순)
    public List<ProjectVO> getListPoint(){
        return projectMapper.getListPoint();
    }
    // 프로젝트 목록(참가자순)
    public List<ProjectVO> getListApply(){
        return projectMapper.getListApply();
    }

}
