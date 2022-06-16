package com.example.pickitup.service;

import com.example.pickitup.domain.dao.user.*;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSerivce {

    private final UserDAO userDAO;
    private final ApplyDAO applyDAO;
    private final JjimDAO jjimDAO;
    private final LatestDAO latestDAO;
    private final OrderDAO orderDAO;


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


    // jjimDAO
    // 나의 프로젝트 찜 목록
    public List<JjimVO> getJjimProjectList(Long userNum) {
        return jjimDAO.getProjectList(userNum);
    }

    // 나의 상품 찜 목록
    public List<JjimVO> getJjimProductList(Long userNum) {
        return jjimDAO.getProductList(userNum);
    }

    // 찜 등록
    public void registerJjim(JjimVO jjimVO) {
        jjimDAO.register(jjimVO);
    }


    // latestDAO
    // 최근에 본 프로젝트 목록
    public List<LatestVO> getLatestProjectList(Long userNum) {
        return latestDAO.getProjectList(userNum);
    }

    // 최근에 본 상품 목록
    public List<LatestVO> getLatestProductList(Long userNum) {
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


    // orderDAO
    // 주문 목록(관리자용)
    public List<OrderVO> getOrderList(Criteria criteria){
        return orderDAO.getList(criteria);
    }

    // 주문 취소
    public boolean remove(Long num){
        return orderDAO.remove(num);
    }

    // 주문 상태 변경 있어야함

    // 주문 개수



    // 내가 문의한 게시믈 목록

    // 내 후기 목록



}