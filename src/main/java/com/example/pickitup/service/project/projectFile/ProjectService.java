package com.example.pickitup.service.project.projectFile;

import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import com.example.pickitup.domain.vo.dto.ProjectMainDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
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
    public List<ProjectMainDTO> getListJJim() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListJJim();

        for(ProjectVO pp : projectVOS){
            String strDate = pp.getProjectDate();  // 기준 날짜 데이터 (("yyyy-MM-dd")의 형태)
            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // 오늘날짜

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = new Date(dateFormat.parse(strDate).getTime());
            Date today = new Date(dateFormat.parse(todayFm).getTime());

            long calculate = date.getTime() - today.getTime();

            int Ddays = (int) (calculate / ( 24*60*60*1000));

            String Ddate ="";
            if(Ddays==0){
                Ddate = "오늘이에요!";
            }else {
                Ddate = "D" + Integer.toString(Ddays * (-1));
            }
            projectMainDTOS.add(new ProjectMainDTO(pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));


        }
        return projectMainDTOS;
    }
    // 프로젝트 목록(포인트순)
    public List<ProjectMainDTO> getListPoint() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListPoint();

        for(ProjectVO pp : projectVOS){
            String strDate = pp.getProjectDate();  // 기준 날짜 데이터 (("yyyy-MM-dd")의 형태)
            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // 오늘날짜

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = new Date(dateFormat.parse(strDate).getTime());
            Date today = new Date(dateFormat.parse(todayFm).getTime());

            long calculate = date.getTime() - today.getTime();

            int Ddays = (int) (calculate / ( 24*60*60*1000));

            String Ddate ="";
            if(Ddays==0){
                Ddate = "오늘이에요!";
            }else {
                Ddate = "D" + Integer.toString(Ddays * (-1));
            }
            projectMainDTOS.add(new ProjectMainDTO(pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));


        }
        return projectMainDTOS;
    }
    // 프로젝트 목록(포인트순)
    public List<ProjectMainDTO> getListApply() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListApply();

        log.info(projectVOS.toString());

        for(ProjectVO pp : projectVOS){
            String strDate = pp.getProjectDate();  // 기준 날짜 데이터 (("yyyy-MM-dd")의 형태)
            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // 오늘날짜

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = new Date(dateFormat.parse(strDate).getTime());
            Date today = new Date(dateFormat.parse(todayFm).getTime());

            long calculate = date.getTime() - today.getTime();

            int Ddays = (int) (calculate / ( 24*60*60*1000));

            String Ddate ="";
            if(Ddays==0){
                Ddate = "오늘이에요!";
            }else {
                Ddate = "D" + Integer.toString(Ddays * (-1));
            }
            projectMainDTOS.add(new ProjectMainDTO(pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));


        }
        return projectMainDTOS;
    }


}
