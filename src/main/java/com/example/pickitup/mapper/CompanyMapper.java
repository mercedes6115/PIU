package com.example.pickitup.mapper;

import com.example.pickitup.domain.vo.CompanyVO;
import com.example.pickitup.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {

//    회사 목록
    public  List<CompanyVO> getList();

//    회사 유저 가입
    public void insert(UserVO userVO);

//    유저 상세보기(마이페이지 내정보)
    public UserVO getDetail(Long num);

//    유저 정보 수정
    public boolean update(UserVO userVO);

//    유저 탈퇴
    public boolean delete(Long num);



}
















