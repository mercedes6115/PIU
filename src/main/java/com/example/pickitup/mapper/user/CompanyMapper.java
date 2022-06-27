package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.user.CompanyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyMapper {

//    회사 목록
    public  List<CompanyVO> getList();

//    회사 유저 가입
    public void insert(CompanyVO companyVO);

//    회사 유저 상세보기(마이페이지 회사 정보)
    public CompanyVO getDetail(Long num);

//    회사 유저 정보 수정 , 비밀번호 수정-> 재활용 할건데 리턴 이멜 보내기, 비밀번호 찾기
    public boolean update(CompanyVO companyVO);

//    회사 유저 탈퇴
    public boolean delete(Long num);

//    회사 유저 로그인

//    public


//    public CompanyVO login(String email, String password);

    public CompanyVO login(@Param("email") String email, @Param("password") String password);


    public boolean adminCompanyPwUpdate(String password,Long num);

    public boolean companyStatusDisable(Long num); // 비활성화
    public boolean companyStatusEnable(Long num); // 활성화
    public boolean companyApprovalDisable(Long num); // 비활성화
    public boolean companyApprovalEnable(Long num); // 활성화
}
















