package com.example.pickitup.domain.dao.user;

import com.example.pickitup.domain.vo.user.CompanyVO;
import com.example.pickitup.mapper.user.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompanyDAO {

    private final CompanyMapper companyMapper;

    // 단체 목록
    public List<CompanyVO> getList(){
        return companyMapper.getList();
    }

    // 단체 회원가입
    public void register(CompanyVO companyVO){
        companyMapper.insert(companyVO);
    }

    // 단체 정보 상세보기
    public CompanyVO read(Long num){
        return companyMapper.getDetail(num);
    }

    // 단체 유저 탈퇴
    public boolean remove(Long num){
        return companyMapper.delete(num);
    }

    // 로그인 select count -> read 사용?
    public CompanyVO login(String email, String password){
        return companyMapper.login(email,password);
    }


    public boolean adminCompanyPwUpdate(String password, Long num){
        return companyMapper.adminCompanyPwUpdate(password,num);
    }


    public boolean companyStatusDisable(Long num) {// 비활성화
        return companyMapper.companyStatusDisable(num);
    }
    public boolean companyStatusEnable(Long num) {// 비활성화
        return companyMapper.companyStatusEnable(num);
    }
    public boolean companyApprovalDisable(Long num) {// 비활성화
        return companyMapper.companyApprovalDisable(num);
    }
    public boolean companyApprovalEnable(Long num) {// 비활성화
        return companyMapper.companyApprovalEnable(num);
    }

    // 회원 정보 수정
    public void update(CompanyVO companyVO){
        companyMapper.update(companyVO);
    }

}
