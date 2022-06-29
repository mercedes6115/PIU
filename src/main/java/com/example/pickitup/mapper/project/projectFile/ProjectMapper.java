package com.example.pickitup.mapper.project.projectFile;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.ProjectCriteria;
import com.example.pickitup.domain.vo.dto.ProjectDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {

//    프로젝트 전부 띄우기
    public List<ProjectVO> getList();

//      관리자용 프로젝트 전체목록

    public boolean insertQr(Long qrNum,String projectLink1,String projectLink2);

//    관리자용 프로젝트 전체 목록
    public List<ProjectDTO> getProjectList(ProjectCriteria projectCriteria);

//    관리자용 프로젝트 전체 개수
    public int getProjectTotal(ProjectCriteria projectCriteria);

//  특정 유저의 프로젝트 목록
    public List<ProjectVO> getUserProjectList(Long companyNum, ProjectCriteria projectCriteria);


//    프로젝트 한개만 띄우기
    public ProjectVO getDetail(Long num);

//    프로젝트 등록하기
    public void insert(ProjectVO projectVO);

//    프로젝트 수정하기
    public boolean update(ProjectVO projectVO);

//    프로젝트 삭제하기
    public boolean delete(Long num);

//    프로젝트 최대 찜순 가져오기
    public List<ProjectVO> getListJJim();

    //    프로젝트 최대 포인트순 가져오기
    public List<ProjectVO> getListPoint();

    //    프로젝트 최대 참가자순 가져오기
    public List<ProjectVO> getListApply();

    // 프로젝트 전부
    public List<ProjectVO> getListAll();


    // 프로젝트 코스별 가져오기
    public List<ProjectVO> getListCourse(String course);


    public int adminStatistics(String date);

    public boolean approveProject(Long num);

    public boolean disapproveProject(Long num);

    public boolean awaitProject(Long num);

    public boolean setApprovaltoContinue(Long projectNum);

    public List<ProjectDTO> getListToday(String startDate,String endDate);

    public List<ProjectVO> getSearchList(String searchStr);

    // 프로젝트 생성한 개수
    public int getUserProjectTotal(Long companyNum);

    //  특정 유저의 프로젝트 목록
    public List<ProjectVO> getUserProjectList(Long companyNum, Criteria criteria);
}
