package com.example.pickitup.service.user;

import com.example.pickitup.domain.dao.user.CompanyDAO;
import com.example.pickitup.domain.vo.user.CompanyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyDAO companyDAO;

    // 단체 목록
//    public List<CompanyVO> getList(){
//        return companyDAO.getList();
//    }

    // 단체 회원가입
    public void register(CompanyVO companyVO){
        companyDAO.register(companyVO);
    }

    // 단체 정보 상세보기
    public CompanyVO read(Long num){
        return companyDAO.read(num);
    }

    // 단체 유저 탈퇴
    public boolean remove(Long num){
        return companyDAO.remove(num);
    }

    // 로그인 select count -> read 사용?
}
