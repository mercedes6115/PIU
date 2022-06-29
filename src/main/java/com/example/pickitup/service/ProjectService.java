package com.example.pickitup.service;

import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import com.example.pickitup.domain.dao.project.projectFile.ProjectFileDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaCommentDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaDAO;
import com.example.pickitup.domain.dao.project.projectReview.ProjectReviewDAO;
import com.example.pickitup.domain.dao.project.projectReview.ProjectReviewFileDAO;
import com.example.pickitup.domain.dao.user.ApplyDAO;
import com.example.pickitup.domain.dao.user.JjimDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.ProjectCriteria;
import com.example.pickitup.domain.vo.dto.ProjectDTO;
import com.example.pickitup.domain.vo.dto.ProjectMainDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewFileVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final ProjectQnaDAO projectQnaDAO;
    private final ProjectQnaCommentDAO projectQnaCommentDAO;
    private final JjimDAO jjimDAO;
    private final ApplyDAO applyDAO;
    private final ProjectReviewDAO projectReviewDAO;
    private final ProjectReviewFileDAO projectReviewFileDAO;
    private final ProjectFileDAO projectFileDAO;

    // 프로젝트 목록(관리자용)
    public List<ProjectVO> getList(){
        return projectDAO.getList();
    }



    public boolean insertQr(Long qrNum, String projectLink1,String projectLink2 ){
        return projectDAO.insertQr(qrNum,projectLink1,projectLink2);
    }

    // 프로젝트 목록(특정 단체 유저)
//    public List<ProjectVO> getProjectList(Long companyNum, ProjectCriteria projectCriteria){
//        return projectDAO.getUserProjectList(companyNum, projectCriteria);
//    }


    // 관리자용 프로젝트 전체 목록
    public List<ProjectDTO> getProjectList(ProjectCriteria projectCriteria){
        return projectDAO.getProjectList(projectCriteria);
    }

    public List<ProjectDTO> getListToday(String startDate,String endDate){
        return projectDAO.getListToday(startDate,endDate);
    }

    // 프로젝트 상세보기
    public ProjectVO read(Long num){
        return projectDAO.read(num);
    }

    public int getProjectTotal(ProjectCriteria projectCriteria){
        return projectDAO.getProjectTotal(projectCriteria);
    }


    // 프로젝트 등록

    public List<ProjectFileVO> getList1(Long num) {
        return projectFileDAO.findByProjectNum(num);
    }
//    하나의 트랜잭션에 여러 개의 DML이 있을 경우 한 개라도 오류 시 전체 ROLLBACK

    @Transactional(rollbackFor = Exception.class)
    public void register(ProjectVO projectVO) {
        //게시글 추가
        projectDAO.register(projectVO);
        log.info("============"+projectVO.getNum());
        //게시글에 업로드된 첨부파일 정보 중 게시글 번호를 따로 추가
        if(projectVO.getFileList() != null) {
            projectVO.getFileList().forEach(projectfileVO -> {
                projectfileVO.setProjectNum(projectVO.getNum()+1l);
                projectFileDAO.register(projectfileVO);
            });
        }
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


//
//    // 리뷰 등록
//    @Transactional(rollbackFor = Exception.class)
//    public void registerReview(ProjectReivewVO projectReivewVO) {
//        //게시글 추가
//        boardDAO.register(boardVO);
//        //게시글에 업로드된 첨부파일 정보 중 게시글 번호를 따로 추가
//        if(boardVO.getFileList() != null) {
//            boardVO.getFileList().forEach(fileVO -> {
//                fileVO.setBoardBno(boardVO.getBoardBno());
//                fileDAO.register(fileVO);
//            });
//        }
//    }


    public int getUserProjectTotal(Long companyNum){
        return projectDAO.getUserProjectTotal(companyNum);
    }

    @Transactional
    public boolean setApproval(Long projectNum, Long applyNum){
        applyDAO.setApproachToContinue(applyNum);
        return projectDAO.setApprovaltoContinue(projectNum);
    }
    // 파일
    @Transactional(rollbackFor = Exception.class)
    public void registerReview(ProjectReviewVO projectReviewVO) {
        //게시글 추가
        projectReviewDAO.register(projectReviewVO);
        //게시글에 업로드된 첨부파일 정보 중 게시글 번호를 따로 추가
        if (projectReviewVO.getFileList() != null) {
            projectReviewVO.getFileList().forEach(projectReviewFileVO -> {
//                projectReviewFileVO.setProjectNum(boardVO.getBoardBno());
                projectReviewFileVO.setProjectReviewNum(34L);
                projectReviewFileDAO.register(projectReviewFileVO);
            });
        }
    }

    public List<ProjectVO> getUserProjectList(Long companyNum, Criteria criteria){
        return projectDAO.getUserProjectList(companyNum, criteria);
    }

    // 하나의 트랜잭션에 여러 개의 DML이 있을 경우 한 개라도 오류 시 전체 ROLLBACK
    @Transactional(rollbackFor = Exception.class)
    public void registerProject (ProjectVO projectVO) {
        //게시글 추가
        projectDAO.register(projectVO);
        //게시글에 업로드된 첨부파일 정보 중 게시글 번호를 따로 추가
        if(projectVO.getFileList() != null) {
            projectVO.getFileList().forEach(projectFileVO -> {
                projectFileVO.setProjectNum(projectVO.getNum());
                projectFileDAO.register(projectFileVO);
            });
        }
    }


    // 파일 테스트
    public void testFile(ProjectReviewFileVO projectReviewFileVO){
        projectReviewFileDAO.register(projectReviewFileVO);
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
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));
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
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));


        }
        return projectMainDTOS;
    }
    // 프로젝트 목록(참가자순)
    public List<ProjectMainDTO> getListApply() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListApply();


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
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));


        }
        return projectMainDTOS;
    }

    public List<ProjectMainDTO> getListCourse(String course) throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListCourse(course);

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
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));
        }

        return projectMainDTOS;
    }

    public List<ProjectMainDTO> getListAll() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListAll();

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
            projectMainDTOS.add(new ProjectMainDTO(pp.getNum(),pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));
        }

        return projectMainDTOS;
    }


    public List<ProjectVO> getSearchList(String searchStr){
        return projectDAO.getSearchList(searchStr);
    }
}
