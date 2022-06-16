package com.example.pickitup.domain.dao.user;

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

    // 프로젝트 참가자 정보 수정(완수여부)
    public boolean update(Long approach, Long userNum){
        return applyMapper.update(approach, userNum);
    }
}
