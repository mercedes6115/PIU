package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.user.UserVO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

//    유저 목록
    public  List<UserVO> getList(Criteria criteria);

//    일반 유저 가입
    public void insert(UserVO userVO);

//    유저 상세보기(마이페이지 내정보)
    public UserVO getDetail(Long num);

//    유저 정보 수정, 비밀번호 수정-> 재활용 할건데 리턴 이멜 보내기, 비밀번호 찾기
    public boolean update(UserVO userVO);

//    유저 탈퇴
    public boolean delete(Long num);

//    로그인
<<<<<<< HEAD
    public UserVO login(@Param("email") String email,@Param("password") String password);
=======
    public UserVO login(@Param("email") String email, @Param("password") String password);
>>>>>>> aaa195bbb080f46b8d59940d88f16a44bcfd8356

// 포인트 적립?

}
















