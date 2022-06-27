package com.example.pickitup.domain.dao.project.projectFile;



import com.example.pickitup.domain.vo.Criteria;

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


    public boolean setApprovaltoContinue(Long projectNum){
        return projectMapper.setApprovaltoContinue(projectNum);
    }
    // 프로젝트 목록
    public List<ProjectVO> getList(){
        return projectMapper.getList();
    }

    public boolean insertQr(Long qrNum,String projectLink1,String projectlink2){
        return projectMapper.insertQr(qrNum,projectLink1,projectlink2);
    }

    // 특정 유저의 프로젝트 목록
    public List<ProjectVO> getUserProjectList(Long companyNum, ProjectCriteria projectCriteria){
        return projectMapper.getUserProjectList(companyNum, projectCriteria);
    }

    // 전체 프로젝트 목록

    public List<ProjectDTO> getProjectList(ProjectCriteria projectCriteria){
        return projectMapper.getProjectList(projectCriteria);
    }

    public List<ProjectDTO> getListToday(String startDate, String endDate){
        return projectMapper.getListToday(startDate,endDate);
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

    public boolean approveProject(Long num){ return  projectMapper.approveProject(num);}

    public boolean disapproveProject(Long num){ return projectMapper.disapproveProject(num);}

    public boolean awaitProject(Long num){ return projectMapper.awaitProject(num);}

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
