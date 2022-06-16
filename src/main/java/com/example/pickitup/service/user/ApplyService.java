package com.example.pickitup.service.user;

import com.example.pickitup.domain.dao.user.ApplyDAO;
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
    public void register(ApplyVO applyVO){
        applyDAO.register(applyVO);
    }

    // 프로젝트 참가 정보 확인
    public ApplyVO read(Long num){
        return applyDAO.read(num);
    }

    // 프로젝트 참가자 정보 수정(완수여부)
    public boolean update(Long approach, Long userNum){
        return applyDAO.update(approach, userNum);
    }
}
