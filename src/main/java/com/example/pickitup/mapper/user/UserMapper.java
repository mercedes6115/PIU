package com.example.pickitup.mapper.user;

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
import org.apache.catalina.User;
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
    public List<AdminBoardDTO> getNoticeList(AdminCriteria adminCriteria);

    //    관리자 공지사항 총갯수
    public int getNoticeTotal(AdminCriteria adminCriteria);

    //     관리자 유저 비밀번호 수정
    public boolean adminPwUpdate(String password, Long num);

    //    ADMINBOARD에 총 게시글 수 가져오기
    public int getAdminBoardCount(AdminCriteria adminCriteria);

    //    ADMINBOARD에 게시글 리스트 가져오기
    public List<AdminBoardVO> getAdminboardList(AdminCriteria adminCriteria);

    //    Adminboard에서 선택한것들 삭제
    public int deleteById(Long num);

    //    AdminBoard에서 선택한것들 공지 지정해제
    public int noticeCancel(Long num);

    //    AdminBoard에서 선택한것들 공지 지정
    public int noticeConfirm(Long num);

    //    관리자 게시물 관리에서 상세보기
    public AdminBoardPageDTO getQnaReply(Long num);

    //    관리자 project qna 답글쓴것 insert
    public void projectQnaReply(AdminQnaCommentDTO adminQnaCommentDTO);

    //    관리자 product qna 답글쓴것 insert
    public void productQnaReply(AdminQnaCommentDTO adminQnaCommentDTO);

    //    관리자가 답글 남겼을때 answer_status 2로 변경
    public void answerComplete(Long num);

    //    관리자 게시물 목록에서 문의글 삭제 했을때 QnA테이블에서 같이 삭제
    public void productQnaDelete(Long num);

    //    관리자 게시물 목록에서 문의글 삭제 했을때 QnA테이블에서 같이 삭제
    public void projectQnaDelete(Long num);

    //    유저가 상품 문의 남겼을때 adminboard 에도 저장
    public void qnaStoreSave(AdminQnaDTO adminQnaDTO);

    //    유저가 상품 문의 남겼을때 adminboard 에도 저장
    public void qnaProjectSave(AdminQnaDTO adminQnaDTO);

    //    유저가 상품 문의 수정했을때 adminboard 에도 수정
    public boolean qnaStoreModify(AdminQnaDTO adminQnaDTO);

    //    유저가 상품 문의 수정했을때 adminboard 에도 수정
    public boolean qnaProjectModify(AdminQnaDTO adminQnaDTO);

    //    유저 내 리뷰 모두 보기
    public List<MyReviewDTO> myAllReview(Long userNum);

    //    유저 목록 관리자용
    public  List<UserDTO> getList(Criteria criteria);
    //    유저,회사 전체 목록 총 합
    public int getTotal(Criteria criteria);

    //    일반 유저 가입
    public void insert(UserVO userVO);

    //    유저 상세보기(마이페이지 내정보)
    public UserVO getDetail(Long num);

    //    유저 정보 수정, 비밀번호 수정-> 재활용 할건데 리턴 이멜 보내기, 비밀번호 찾기
    public int update(UserVO userVO);

    //    유저 탈퇴
    public int delete(Long num);

    //    로그인
    public UserDTO login(@Param("email") String email, @Param("password") String password);

// 포인트 적립?

    //  유저가 참여한 플로깅 목록
    public List<ProductVO> getInProductList(Long userNum);

//  유저가 구매한 상품 목록

    public List<ProjectVO> getInProjectList(Long userNum);



    //  이메일 중복검사
    public int emailMatching(@Param("email") String email);

    //  닉네임 중복검사
    public int nicknameMatching(@Param("nickname") String nickname);



//    //    비밀번호 변경
//    public boolean updatePW(String email);

//    비밀번호 변경
    public boolean updatePW(String email,String password);



// 관리자용 유저 활성화/비활성화

    public boolean userStatusDisable(Long num); // 비활성화
    public boolean userStatusEnable(Long num); // 활성화
    public boolean userApprovalDisable(Long num); // 비활성화
    public boolean userApprovalEnable(Long num); // 활성화


    public boolean addPoint(String nickname, String point);

//  마이페이지 비밀번호 변경
    public boolean changePw(String password, Long num);


//    카카오톡 유저 로그인하자마자 이메일 중복확인 후 회원가입
    public void kakaoinsert(UserVO userVO);

//    카카오톡 유저 로그인하자마자 이메일 중복 시 회원정보가져오기
    public UserVO kakaoDetail(@Param("email") String email);

//    내가 작성한 projectQna
    public List<ProjectQnaVO> getMyProjectQna(Long userNum);

//    내가 작성한 productQna
    public  List<ProductQnaVO> getMyProductQna(Long userNum);

//    해당 project 문의글에 작성된 답변
    public ProjectQnaCommentVO myProjectQnaComment(Long qnaNum);

//    해당 product 문의글에 작성된 답변
    public ProductQnaCommentVO myProductQnaComment(Long qnaNum);


    public QrDTO getQrInfo(Long userNum);

    public boolean autoPoint(String point,Long userNum);
}
