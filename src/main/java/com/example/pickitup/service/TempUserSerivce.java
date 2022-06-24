package com.example.pickitup.service;

import com.example.pickitup.domain.dao.product.productFile.ProductDAO;
import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import com.example.pickitup.domain.dao.project.projectFile.ProjectFileDAO;
import com.example.pickitup.domain.dao.user.*;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.dto.OrderDTO;
import com.example.pickitup.domain.vo.dto.PointDTO;
import com.example.pickitup.domain.vo.dto.UserDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor


public class TempUserSerivce {
    private final UserDAO userDAO;
    private final ApplyDAO applyDAO;
    private final JjimDAO jjimDAO;
    private final LatestDAO latestDAO;
    private final OrderDAO orderDAO;
    private final ProjectFileDAO projectFileDAO;
    private final ProjectDAO projectDAO;
    private final ProductDAO productDAO;


    // userDAO

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


    public UserDTO loginUser(String email, String password){
        return userDAO.login(email,password);
    }

    //  이메일 중복검사
    public int emailcheck(String email){
        return userDAO.emailcheck(email);
    };

    //  닉네임 중복검사
    public int nicknameCheck(String nickname) {return userDAO.nicknameCheck(nickname);}

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
            pointDTOList.add(new PointDTO(productVO.getName(), orderVO.getRegistDate(), productVO.getPrice(), "1"));
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


}