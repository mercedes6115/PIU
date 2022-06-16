package com.example.pickitup.mapper.project.projectFile;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {

//  프로젝트 전부 띄우기
    public List<ProjectVO> getList();

//  프로젝트 목록(관리자용)
    public List<ProjectVO> getProjectList(Criteria criteria);

//  특정 유저의 프로젝트 목록
    public List<ProjectVO> getUserProjectList(Long userNum);

//  프로젝트 한개만 띄우기
    public ProjectVO getDetail(Long num);

//  프로젝트 등록하기
    public void insert(ProjectVO projectVO);

//  프로젝트 수정하기
    public boolean update(ProjectVO projectVO);

//  프로젝트 삭제하기
    public boolean delete(Long num);


}
