package com.example.pickitup.mapper;

import com.example.pickitup.domain.vo.user.CompanyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {

//    회사 목록
    public  List<CompanyVO> getList();

//    회사 유저 가입
    public void insert(CompanyVO companyVO);

//    회사 유저 상세보기(마이페이지 회사 정보)
    public CompanyVO getDetail(Long num);

//    회사 유저 정보 수정
    public boolean update(CompanyVO companyVO);

//    회사 유저 탈퇴
    public boolean delete(Long num);

//    회사 유저 로그인
    public

}
















