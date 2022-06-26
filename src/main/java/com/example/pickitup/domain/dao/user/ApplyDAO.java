package com.example.pickitup.domain.dao.user;

import com.example.pickitup.domain.vo.dto.ApplyDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.mapper.user.ApplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplyDAO {

    private final ApplyMapper applyMapper;

    // 내가 신청한 프로젝트 목록
    public List<ProjectVO> getList(Long userNum){
        return applyMapper.get(userNum);
    }

    // 프로젝트 신청
    public void register(ApplyVO applyVO){
        applyMapper.insert(applyVO);
    }

    // 프로젝트 참가 정보 확인
    public ApplyVO read(Long num){
        return applyMapper.getDetail(num);
    }

    public boolean setApproach(Long applyNum){
        return applyMapper.setApproach(applyNum);
    }
    // 프로젝트 참가자 정보 수정(완수여부)
    public boolean update(Long approach, Long userNum){
        return applyMapper.update(approach, userNum);
    }

    // 완주한 프로젝트 목록
    public List<ApplyVO> successProject(Long userNum) { return applyMapper.successProject(userNum);}

    // 총 신청자 수
    public Long countApply(Long projectNum) { return applyMapper.countApply(projectNum);}

    //프로젝트한 참여한 유저 목록
    public List<ApplyDTO> getApplyUser(Long projectNum){
        return applyMapper.getApplyUser(projectNum);
    }
}
