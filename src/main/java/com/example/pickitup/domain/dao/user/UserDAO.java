package com.example.pickitup.domain.dao.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.adminVO.AdminBoardDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;

import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;

import com.example.pickitup.domain.vo.dto.UserDTO;
import com.example.pickitup.domain.vo.user.AdminBoardVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {

    private final UserMapper userMapper;

    //    관리자 공지등록
    public void registerWrite(AdminBoardVO adminBoardVO) {
        userMapper.write(adminBoardVO);
    }

    // 관리자 공지 리스트 보기
    public List<AdminBoardDTO> getNoticeList(Criteria criteria){
        return userMapper.getNoticeList(criteria);
    }

    //    관리자 공지 상세보기
    public AdminBoardVO getReadDetail(Long num){
        return userMapper.getNoticeDetail(num);
    }

    // 관리자 공지글 총개수
    public int getNoticeTotal(){
        return userMapper.getNoticeTotal();
    }

    // 관리자 adminboard 글 총개수
    public int getAdminBoardCount(Criteria criteria){
        return userMapper.getAdminBoardCount(criteria);
    }

    // 관리자 adminboard 글 목록 가져오기
    public List<AdminBoardVO> getAdminboardList(Criteria criteria){
        return userMapper.getAdminboardList(criteria);
    }


    // 유저 목록(관리자용)
    public List<UserDTO> getList(Criteria criteria){
        return userMapper.getList(criteria);
    }

    public int getTotal(Criteria criteria){
        return userMapper.getTotal(criteria);
    }
    // 일반 유저 가입
    public void register(UserVO userVO){
        userMapper.insert(userVO);
    }

    // 유저 상세보기
    public UserVO read(Long num){
        return userMapper.getDetail(num);
    }

    // 유저 정보 수정
    public boolean update(UserVO userVO){
        return userMapper.update(userVO);
    }

    // 유저 탈퇴
    public boolean remove(Long num){
        return userMapper.delete(num);
    }

    // 유저가 구매한 상품 목록
    public List<ProductVO> getInProductList(Long userNum) {
        return userMapper.getInProductList(userNum);
    }

    // 유저가 참여한 프로젝트 목록록
   public List<ProjectVO> getInProjectList(Long userNum) {
        return userMapper.getInProjectList(userNum);
    }

    // 로그인 -> select count-> read() 사용?
    public UserDTO login(String email, String password){
        return userMapper.login(email,password);
    }

    //  이메일 중복검사
    public int emailCheck(String email){
        return userMapper.emailMatching(email);
    };
    //  닉네임 중복검사
    public int nicknameCheck(String nickname){
        return userMapper.nicknameMatching(nickname);
    };

    //  비밀번호 수정
    public boolean updatePW(String email){
        return userMapper.updatePW(email);
    };

    // 카카오 로그인 즉시 회원가입
    public UserVO kakaoinsert(UserVO userVO){
        return userMapper.kakaoinsert(userVO);
    }

    //    카카오톡 유저 로그인하자마자 이메일 중복 시 회원정보가져오기
    public UserVO kakaoDetail(@Param("email") String email){
        return userMapper.kakaoDetail(email);
    }

}
