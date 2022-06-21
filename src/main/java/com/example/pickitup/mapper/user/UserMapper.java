package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.Criteria;

import com.example.pickitup.domain.vo.adminVO.AdminBoardDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;

import com.example.pickitup.domain.vo.dto.UserDTO;

import com.example.pickitup.domain.vo.user.AdminBoardVO;
import com.example.pickitup.domain.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    //    관리자 공지등록
    public void write(AdminBoardVO adminBoardVO);

    //    관리자 공지상세보기
    public AdminBoardVO getNoticeDetail(Long num);

    //    관리자 공지리스트보기
    public List<AdminBoardDTO> getNoticeList(Criteria criteria);

    //    관리자 공지사항 총갯수
    public int getNoticeTotal();

    //    ADMINBOARD에 총 게시글 수 가져오기
    public int getAdminBoardCount(Criteria criteria);

    //    ADMINBOARD에 게시글 리스트 가져오기
    public List<AdminBoardVO> getAdminboardList(Criteria criteria);

//    유저 목록 관리자용
    public  List<UserDTO> getList(Criteria criteria);
//    유저,회사 전체 목록 총 합
    public int getTotal(Criteria criteria);

//    일반 유저 가입
    public void insert(UserVO userVO);

//    유저 상세보기(마이페이지 내정보)
    public UserVO getDetail(Long num);

//    유저 정보 수정, 비밀번호 수정-> 재활용 할건데 리턴 이멜 보내기, 비밀번호 찾기
    public boolean update(UserVO userVO);

//    유저 탈퇴
    public boolean delete(Long num);

//    로그인
    public int login(@Param("email") String email,@Param("password") String password);

// 포인트 적립?

//  유저가 참여한 플로깅 목록
    public List<ProductVO> getInProductList(Long userNum);

//  유저가 구매한 상품 목록

    public List<ProjectVO> getInProjectList(Long userNum);



//  이메일 중복검사
    public int emailMatching(@Param("email") String email);

//    비밀번호 변경
    public boolean updatePW(@Param("email") String email);

}
