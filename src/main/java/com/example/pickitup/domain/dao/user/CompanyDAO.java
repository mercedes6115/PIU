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

}
