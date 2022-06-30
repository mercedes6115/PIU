package com.example.pickitup.service.user;

import com.example.pickitup.domain.dao.user.ApplyDAO;
import com.example.pickitup.domain.vo.dto.ApplyDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyService {

    private final ApplyDAO applyDAO;
    // 내가 신청한 프로젝트 목록
    public List<ProjectVO> getList(Long userNum){
        return applyDAO.getList(userNum);
    }

    // 프로젝트 신청
    public void apply(ApplyVO applyVO){
        applyDAO.register(applyVO);
    }

    // 프로젝트 참가 정보 확인
    public ApplyVO read(Long num){
        return applyDAO.read(num);
    }

    // 유저 프로젝트 완료
    public void userFinish(Long num){
        applyDAO.userFinish(num);
    }

    // 유저 프로젝트 시작
    public void userStart(ApplyDTO applyDTO){
        applyDAO.userStart(applyDTO);
    }

    // 유저 프로젝트 종료
    public void userEnd(ApplyDTO applyDTO){
        applyDAO.userEnd(applyDTO);
    }

    // 신청한 유저 목록
    public List<ApplyDTO> getApplyUser(Long projectNum){
        return applyDAO.getApplyUser(projectNum);
    }
}
