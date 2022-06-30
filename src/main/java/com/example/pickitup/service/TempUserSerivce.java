package com.example.pickitup.service;

import com.example.pickitup.domain.dao.product.productFile.ProductDAO;
import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import com.example.pickitup.domain.dao.project.projectFile.ProjectFileDAO;
import com.example.pickitup.domain.dao.user.*;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.dto.*;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaCommentVO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.domain.vo.user.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TempUserSerivce {
    private final UserDAO userDAO;
    private final ApplyDAO applyDAO;
    private final JjimDAO jjimDAO;
    private final LatestDAO latestDAO;
    private final OrderDAO orderDAO;
    private final ProjectFileDAO projectFileDAO;
    private final ProjectDAO projectDAO;
    private final ProductDAO productDAO;
    private final CompanyDAO companyDAO;


    // userDAO

    //해당 유저의 qr찍는데 필요한 정보 뽑아오기
    public QrDTO getQrInfo(Long userNum){
        return userDAO.getQrInfo(userNum);
    }

    // 일반 유저 가입
    public void registerUser(UserVO userVO) {
        userDAO.register(userVO);
    }

    // 유저 상세보기
    public UserVO readUserInfo(Long num) {
        return userDAO.read(num);
    }

    // 유저 정보 수정
    public boolean updateUserInfo(UserVO userVO) {

        return userDAO.update(userVO);
    }

    // 유저 탈퇴
    public boolean removeUser(Long num) {
        return userDAO.remove(num);
    }

    // 로그인 -> select count-> read() 사용?

    // 내가 구매한 상품 목록
    public List<ProductVO> getInProductList(Long userNum) {
        return userDAO.getInProductList(userNum);
    }

    // 내가 참여한 플로깅 목록
    public List<ProjectVO> getInProjectList(Long userNum) {
        return userDAO.getInProjectList(userNum);
    }

    //로그인
    public UserDTO loginUser(String email, String password){
        return userDAO.login(email,password);
    }

    //  이메일 중복검사
    public int emailcheck(String email){
        return userDAO.emailCheck(email);
    };
    //  닉네임 중복검사
    public int nicknameCheck(String nickname){
        return userDAO.nicknameCheck(nickname);
    };

    //카카오톡 회원가입 유무
    //    하나의 트랜잭션에 여러 개의 DML이 있을 경우 한 개라도 오류 시 전체 ROLLBACK
    @Transactional(rollbackFor = Exception.class)
    public UserVO kakaoLogin(UserVO userVO){
        int countEmail=userDAO.emailCheck(userVO.getEmail());
        int countNickname=userDAO.nicknameCheck(userVO.getNickname());
        if(countEmail==0 && countNickname==0){
            userDAO.kakaoinsert(userVO);
            log.info("이제 저장할거임"+userDAO.emailCheck(userVO.getEmail()));
            return userDAO.read(userVO.getNum());

        }else if(countEmail!=0){
            log.info("Email check "+userDAO.emailCheck(userVO.getEmail()));
            return null;
        }else if(countNickname!=0){

            log.info("nickname check "+userDAO.nicknameCheck(userVO.getNickname()));
            String temp=userVO.getNickname()+(countNickname+1);
            log.info(temp);
//            log.info(countNickname+1);
            userVO.setNickname(temp);
            userDAO.kakaoinsert(userVO);

            return userDAO.read(userVO.getNum());
        }

        else{
            log.info("디비저장된거" + userDAO.emailCheck(userVO.getEmail()));
            return userDAO.kakaoDetail(userVO.getEmail());
        }
    }

    // 카카오 로그인 즉시 회원가입
    public void kakaoinsert(UserVO userVO){
        userDAO.kakaoinsert(userVO);
    }

    // 마이메이지 비밀번호 변경
    public boolean changePw(String password, Long num) {return userDAO.changePw(password,num);}

    // jjimDAO
    // 나의 프로젝트 찜 목록
    public List<ProjectVO> getJjimProjectList(Long userNum) {
        return jjimDAO.getProjectList(userNum);
    }

    // 나의 상품 찜 목록
    public List<ProductVO> getJjimProductList(Long userNum) {
        return jjimDAO.getProductList(userNum);
    }

    // 찜 등록
    public void registerJjim(JjimVO jjimVO) {
        jjimDAO.register(jjimVO);
    }



    // latestDAO
    // 최근에 본 프로젝트 목록
    public List<ProjectVO> getLatestProjectList(Long userNum) {
        return latestDAO.getProjectList(userNum);
    }

    // 최근에 본 상품 목록
    public List<ProductVO> getLatestProductList(Long userNum) {
        return latestDAO.getProductList(userNum);
    }

    // 최근에 본 게시물 등록
    public void registerLatest(LatestVO latestVO) {
        latestDAO.register(latestVO);
    }

    // 최근에 본 프로젝트 게시물 수정(날짜 최신화)
    public boolean updateLatestProject(LatestVO latestVO) {
        return latestDAO.updateProject(latestVO);
    }

    // 최근에 본 스토어 게시물 수정(날짜 최신화)
    public boolean updateLatestProduct(LatestVO latestVO) {
        return latestDAO.updateProduct(latestVO);
    }



    // orderDAO
    // 주문 등록
    public void registerOrder(OrderVO orderVO){
        orderDAO.register(orderVO);
    }

    // 주문 취소
    public boolean removeOrder(Long num){
        return orderDAO.remove(num);
    }



    // applyDAO
    // 내가 신청한 프로젝트 목록
    public List<ProjectVO> getMyProjectList(Long userNum){
        return applyDAO.getList(userNum);
    }

    // 프로젝트 신청
    public void registerProject(ApplyVO applyVO){
        applyDAO.register(applyVO);
    }

    // 프로젝트 참가 정보 확인
    public ApplyVO readMyProjectInfo(Long num){
        return applyDAO.read(num);
    }

    // 포인트 변동 내역
    @Transactional(rollbackFor = Exception.class)
    public List<PointDTO> changePoint(Long userNum) throws ParseException {
        List<ApplyVO> applyVOList = applyDAO.successProject(userNum); // 완주한 프로젝트 목록
        List<OrderVO> orderVOList = orderDAO.boughtItem(userNum); // 구매한 상품 목록
        List<PointDTO> pointDTOList = new ArrayList<>();    // pointDTO 값 받을 빈 pointDTOList 선언
        List<PointDTO> pointDTOList10 = new ArrayList<>();
        for(ApplyVO applyVO : applyVOList) {                            // 반복
            ProjectVO projectVO = projectDAO.read(applyVO.getProjectNum());     // 완주한 프로젝트의 프로젝트 번호를 이용해 프로젝트 상세정보 갖고 옴
            pointDTOList.add(new PointDTO(projectVO.getTitle(), applyVO.getRegistDate(), projectVO.getPoint(), "0"));    // 필요한 column값들만 삽입
            // 프로젝트는 category = 0
        }
        for(OrderVO orderVO : orderVOList) {
            ProductVO productVO = productDAO.getDetail(orderVO.getProductNum());
            pointDTOList.add(new PointDTO(productVO.getName(), orderVO.getRegistDate(), orderVO.getTotal(), "1"));
            // 상품은 category = 1
        }
        pointDTOList.sort(Comparator.comparing(PointDTO::getPointDate).reversed());

        return pointDTOList;  //.subList(0,10);    // 값 반환
    }


    // orderDAO
    // 주문 목록(관리자용)
    public List<OrderDTO> getOrderList(OrderCriteria orderCriteria){
        return orderDAO.getList(orderCriteria);

    }

    public int getOrderTotal(OrderCriteria orderCriteria){
        return orderDAO.getTotal(orderCriteria);

    }

    // 주문 취소
    public boolean remove(Long num){
        return orderDAO.remove(num);
    }

    // 주문 상태 변경 있어야함

    // 주문 개수



    // 내가 문의한 게시믈 목록

    // 내 후기 목록




    // 유저 비밀번호 수정
    public boolean updatePW(String email,String password) {
        return userDAO.updatePW(email,password);
    }

    // 관리자 페이지용 유저 비밀번호 수정
    public boolean adminPwUpdate(String password,Long num) {
        return userDAO.updateUserAdminPW(password,num);
    }


    // 내 주문내역 조회 (상품 이름 추가)
//    public List<MyOrderDTO> myOrderList(Long userNum) {
//        List<OrderVO> orderVOList = orderDAO.boughtItem(userNum);
//        List<MyOrderDTO> myOrderDTOList = new ArrayList<>();
//        for(OrderVO orderVO : orderVOList) {
//            ProductVO productVO = productDAO.getDetail(orderVO.getProductNum());
//            myOrderDTOList.add(new MyOrderDTO(productVO.getName(),orderVO.getRegistDate(),orderVO.getTotal(),orderVO.getCounting(),orderVO.getAddress(),orderVO.getAddressDetail()));
//        }
//
//        return myOrderDTOList;
//    }

    // 내가 작성한 product 문의글 정보 가져오기
    @Transactional(rollbackFor = Exception.class)
    public List<ProductQnaDTO> getMyProductQna(Long userNum){
        UserVO qnaUserVO = userDAO.read(userNum);   // 질문한 사용자 닉네임 가져오기 위해 선언
        List<ProductQnaVO> productQnaVOList = userDAO.getMyProductQna(userNum); // 내가 작성한 상품 문의글 전체
        List<ProjectQnaVO> projectQnaVOList = userDAO.getMyProjectQna(userNum); // 내가 작성한 프로젝트 문의글 전체
        List<ProductQnaDTO> productQnaDTOList = new ArrayList<>();
        for(ProductQnaVO productQnaVO : productQnaVOList) {
            ProductVO productVO = productDAO.getDetail(productQnaVO.getProductNum());
            log.info("Qna 넘버 " + productQnaVO.getNum());
            if(userDAO.getMyProductQnaComment(productQnaVO.getNum()) != null){  // 문의에 답변이 있을 경우
                ProductQnaCommentVO productQnaCommentVO = userDAO.getMyProductQnaComment(productQnaVO.getNum());
                UserVO commentUserVO = userDAO.read(productQnaCommentVO.getUserNum());
                productQnaDTOList.add(new ProductQnaDTO(productQnaVO.getContent(),productQnaVO.getRegistDate(),productQnaVO.getUpdateDate(),productVO.getName(),"" ,productQnaCommentVO.getContent(),productQnaCommentVO.getRegistDate(),productQnaCommentVO.getUpdateDate(),qnaUserVO.getNickname(),commentUserVO.getNickname(),"",qnaUserVO.getProfileFileName(),qnaUserVO.getProfileUploadPath()));
            } else {    // 문의에 답변이 없을 경우
                productQnaDTOList.add(new ProductQnaDTO(productQnaVO.getContent(),productQnaVO.getRegistDate(),productQnaVO.getUpdateDate(),productVO.getName(),"" ,"","","",qnaUserVO.getNickname(),"","",qnaUserVO.getProfileFileName(),qnaUserVO.getProfileUploadPath())) ;
            }
        }

        for(ProjectQnaVO projectQnaVO : projectQnaVOList) {
            ProjectVO projectVO = projectDAO.read(projectQnaVO.getProjectNum());
            log.info("Qna 넘버 " + projectQnaVO.getNum());
            if(userDAO.getMyProjectQnaComment(projectQnaVO.getNum()) != null) {     // 문의에 답변이 있으면
                ProjectQnaCommentVO projectQnaCommentVO = userDAO.getMyProjectQnaComment(projectQnaVO.getNum());
                if(projectQnaCommentVO.getUserNum() != null) {      // 관리자가 작성한 프로젝트일 경우
                    UserVO commentUserVO = userDAO.read(projectQnaCommentVO.getUserNum());
                    productQnaDTOList.add(new ProductQnaDTO(projectQnaVO.getContent(), projectQnaVO.getRegistDate(), projectQnaVO.getUpdateDate(), "", projectVO.getTitle(), projectQnaCommentVO.getContent(), projectQnaCommentVO.getRegistDate(), projectQnaCommentVO.getUpdateDate(), qnaUserVO.getNickname(), commentUserVO.getNickname(), "",commentUserVO.getProfileFileName(), commentUserVO.getProfileUploadPath()));
                } else {    // 단체가 작성한 프로젝트일 경우
                    CompanyVO commentUserVO = companyDAO.read(projectQnaCommentVO.getCompanyNum());
                    productQnaDTOList.add(new ProductQnaDTO(projectQnaVO.getContent(), projectQnaVO.getRegistDate(), projectQnaVO.getUpdateDate(), "", projectVO.getTitle(), projectQnaCommentVO.getContent(), projectQnaCommentVO.getRegistDate(), projectQnaCommentVO.getUpdateDate(), qnaUserVO.getNickname(), "", commentUserVO.getNickname(),commentUserVO.getProfileFileName(), commentUserVO.getProfileUploadPath()));
                }
            } else {    // 문의에 답변이 없으면
                productQnaDTOList.add(new ProductQnaDTO(projectQnaVO.getContent(),projectQnaVO.getRegistDate(),projectQnaVO.getUpdateDate(),"",projectVO.getTitle(), "","", "", qnaUserVO.getNickname(), "","",qnaUserVO.getProfileFileName(),qnaUserVO.getProfileUploadPath()));
            }

        }
        productQnaDTOList.sort(Comparator.comparing(ProductQnaDTO::getQnaUpdateDate).reversed());

        return productQnaDTOList;
    }


    // 유저 내 후기 다 가져오기
    public List<MyReviewDTO> myAllReview(Long num){
        return userDAO.myAllReview(num);
    }

    // 상품 주문
    public void orderStore(OrderUserDTO orderUserDTO) {
        orderDAO.orderStore(orderUserDTO);
    }

    // 상품주문후 유저 포인트 차감
    public void userPointMinus(Long num, String point) {
        orderDAO.userPointMinus(num, point);
    }

    // 상품 주문후 재고 차감
    public void productMinus(String itemname, Long stock){
        orderDAO.productMinus(itemname, stock);
    }

    //상품명으로 정보 가져오기(1개)
    public Long getDetailByName(String itemname){
        return orderDAO.getDetailByName(itemname);
    }

    public ProductDTO boughtOrderDetail(Long orderNum) { return orderDAO.boughtDetail(orderNum);}

}