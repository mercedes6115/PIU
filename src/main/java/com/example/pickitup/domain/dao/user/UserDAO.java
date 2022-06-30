package com.example.pickitup.domain.dao.user;

import com.example.pickitup.domain.vo.AdminCriteria;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.adminVO.AdminBoardDTO;
import com.example.pickitup.domain.vo.dto.*;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;

import com.example.pickitup.domain.vo.product.productQna.ProductQnaCommentVO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;

import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
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



    public QrDTO getQrInfo(Long userNum){
        return userMapper.getQrInfo(userNum);
    }

    public boolean autoPoint(String point,Long userNum){
        return userMapper.autoPoint(point,userNum);
    }

    //    관리자 공지등록
    public void registerWrite(AdminBoardVO adminBoardVO) {
        userMapper.write(adminBoardVO);
    }

    // 관리자 공지 리스트 보기
    public List<AdminBoardDTO> getNoticeList(AdminCriteria adminCriteria){
        return userMapper.getNoticeList(adminCriteria);
    }


    public boolean addPoint(String nickname,String point){
        return userMapper.addPoint(nickname,point);
    }
    //    관리자 공지 상세보기
    public AdminBoardVO getReadDetail(Long num){
        return userMapper.getNoticeDetail(num);
    }

    // 관리자 공지글 총개수
    public int getNoticeTotal(AdminCriteria adminCriteria){
        return userMapper.getNoticeTotal(adminCriteria);
    }

    // 관리자 adminboard 글 총개수
    public int getAdminBoardCount(AdminCriteria adminCriteria){
        return userMapper.getAdminBoardCount(adminCriteria);
    }

    // 관리자 adminboard 글 목록 가져오기
    public List<AdminBoardVO> getAdminboardList(AdminCriteria adminCriteria){
        return userMapper.getAdminboardList(adminCriteria);
    }

    // 관리자 adminbaord 글 삭제하기
    public int deleteById(Long num){
        return userMapper.deleteById(num);
    }

    // 관리자 adminboard 글 공지 해제하기
    public int noticeCancel(Long num){
        return userMapper.noticeCancel(num);
    }

    // 관리자 adminboard 글 공지 지정하기
    public int noticeConfirm(Long num){
        return userMapper.noticeConfirm(num);
    }

    //    관리자 게시물 관리에서 상세보기
    public AdminBoardPageDTO getQnaReply(Long num){
        return userMapper.getQnaReply(num);
    }

    //  관리자 project qna 답글쓴것 insert
    public void projectQnaReply(AdminQnaCommentDTO adminQnaCommentDTO) {
        userMapper.projectQnaReply(adminQnaCommentDTO);
    }

    //  관리자 product qna 답글쓴것 insert
    public void productQnaReply(AdminQnaCommentDTO adminQnaCommentDTO) {
        userMapper.productQnaReply(adminQnaCommentDTO);
    }

    //  관리자가 문의에 답글 남기면 answerStatus 2로 변경
    public void answerComplete(Long num){
        userMapper.answerComplete(num);
    }

    // 유저가 상품 문의 남겼을때 adminboard 에도 저장
    public void qnaStoreSave(AdminQnaDTO adminQnaDTO) {
        userMapper.qnaStoreSave(adminQnaDTO);
    }

    // 유저가 프로젝트 문의 남겼을때 adminboard 에도 저장
    public void qnaProjectSave(AdminQnaDTO adminQnaDTO) {
        userMapper.qnaProjectSave(adminQnaDTO);
    }

    // 유저가 상품 문의 수정했을때 adminboard 에도 수정
    public boolean qnaStoreModify(AdminQnaDTO adminQnaDTO) {
        return userMapper.qnaStoreModify(adminQnaDTO);
    }

    // 유저가 프로젝트 문의 수정했을때 adminboard 에도 수정
    public boolean qnaProjectModify(AdminQnaDTO adminQnaDTO) {
        return userMapper.qnaProjectModify(adminQnaDTO);
    }

    // 관리자가 게시물 목록에서 상품문의 글 지웠을때 productQnA 테이블에서도 삭제
    public void productQnaDelete(Long num) {
        userMapper.productQnaDelete(num);
    }

    // 관리자가 게시물 목록에서 프로젝트 문의 글 지웠을때 projectQnA 테이블에서도 삭제
    public void projectQnaDelete(Long num) {
        userMapper.projectQnaDelete(num);
    }

    // 유저 내 리뷰 모두 보기
    public List<MyReviewDTO> myAllReview(Long num) {
        return userMapper.myAllReview(num);
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
        return userMapper.update(userVO) != 0;
    }

    // 유저 탈퇴
    public boolean remove(Long num){
        return userMapper.delete(num) !=0 ;
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
    public boolean updatePW(String email,String password){
        return userMapper.updatePW(email,password);
    };



    public boolean updateUserAdminPW(String password, Long num){
        return userMapper.adminPwUpdate(password,num);

    }

    public boolean UserStatusDisable(Long num) {// 비활성화
        return userMapper.userStatusDisable(num);
    }
    public boolean UserStatusEnable(Long num) {// 비활성화
        return userMapper.userStatusEnable(num);
    }
    public boolean UserApprovalDisable(Long num) {// 비활성화
        return userMapper.userApprovalDisable(num);
    }
    public boolean UserApprovalEnable(Long num) {// 비활성화
        return userMapper.userApprovalEnable(num);
    }



    // 마이페이지 비밀번호 변경
    public boolean changePw(String password, Long num) {return userMapper.changePw(password, num);}

    // 카카오 로그인 즉시 회원가입
    public void kakaoinsert(UserVO userVO){
        userMapper.kakaoinsert(userVO);
    }

    //    카카오톡 유저 로그인하자마자 이메일 중복 시 회원정보가져오기
    public UserVO kakaoDetail(@Param("email") String email){
        return userMapper.kakaoDetail(email);
    }

    //  내가 작성한 project 문의글 가져오기
    public List<ProjectQnaVO> getMyProjectQna(Long userNum) {return userMapper.getMyProjectQna(userNum);}

    //  내가 작성한 product 문의글 가져오기
    public List<ProductQnaVO> getMyProductQna(Long userNum) {return userMapper.getMyProductQna(userNum);}

    //  내가 작성한 project 문의글에 달린 답변 가져오기
    public ProjectQnaCommentVO getMyProjectQnaComment(Long qnaNum) {return userMapper.myProjectQnaComment(qnaNum);}

    // 내가 작성한 product 문의글에 달린 답변 가져오기
    public ProductQnaCommentVO getMyProductQnaComment(Long qnaNum) {return userMapper.myProductQnaComment(qnaNum);}

    public List<MyReviewDTO> getAllMyReview(Long userNum) {return userMapper.myAllReview(userNum);}

}
