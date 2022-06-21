package com.example.pickitup.service;


import com.example.pickitup.domain.dao.product.productFile.ProductDAO;
import com.example.pickitup.domain.dao.product.productFile.ProductFileDAO;
import com.example.pickitup.domain.dao.user.*;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.ProductCriteria;
import com.example.pickitup.domain.vo.dto.UserDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.domain.vo.user.CompanyVO;
import com.example.pickitup.domain.vo.user.OrderVO;
import com.example.pickitup.domain.vo.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class TempAdminService {
    private final UserDAO userDAO;
    private final ApplyDAO applyDAO;
    private final JjimDAO jjimDAO;
    private final LatestDAO latestDAO;
    private final OrderDAO orderDAO;
    private final CompanyDAO companyDAO;
    private final ProductDAO productDAO;
    private final ProductFileDAO productFileDAO;



    // applyDAO
    // 프로젝트 참가 정보 확인
    public ApplyVO read(Long num){
        return applyDAO.read(num);
    }

    // 프로젝트 참가자 정보 수정(완수여부)
    public boolean update(Long approach, Long userNum){
        return applyDAO.update(approach, userNum);
    }


    // userDAO
    // 유저 목록
    public List<UserDTO> getList(Criteria criteria) {
        return userDAO.getList(criteria);
    }

    public int getTotal(Criteria criteria){
        return userDAO.getTotal(criteria);
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



    // 상품목록 가져오기 관리자용
    public List<ProductVO> getProductList(ProductCriteria productCriteria){
        return productDAO.getProductList(productCriteria);
    }

    // 전체개수 가져오기 관리자용
    public int getTotal(){
        return productDAO.getTotal();
    }


    // companyDAO
    // 단체 목록
//    public List<CompanyVO> getList(){
//        return companyDAO.getList();
//    }


    // jjimDAO
    // 유저들 찜 목록

    // latestDAO
    // 유저들 최근에 본 게시물 목록


    // productDAO
    // 상품 목록 - 관리자용
//    public List<ProductVO> getProductList(Criteria criteria){
//        return productDAO.getProductList(criteria);
//    }

    // 상품 등록하기 - 관리자용
    public void registerProduct(ProductVO productVO){
        productDAO.register(productVO);
    }

    // 상품 수정하기 - 관리자용
    public boolean updateProduct(ProductVO productVO){
        return productDAO.update(productVO);
    }

    // 상품 삭제하기 - 관리자용
    public boolean removeProduct(Long num){
        return productDAO.remove(num);
    }



    // productFileDAO
    // 파일 경로 가져오기 -> mapper 수정
    public List<ProductFileVO> findProjectReviewNum(Long num) {
        return productFileDAO.findProjectReviewNum(num);
    }

    // 해당 후기글 작성 도중 창을 이동할 경우 저장 경로에서 사진 지우기
    public List<ProductFileVO> getOldFilesProductImg(){
        return productFileDAO.getOldFiles();
    }

    // 사진 등록
    public void registerProductImg(ProductFileVO productFileVO){
        productFileDAO.register(productFileVO);
    };

    // 사진 삭제(mapper 매개변수 수정)
    public void removeProductImg(Long productNum){
        productFileDAO.remove(productNum);
    }


    // orderDAO
    // 주문 목록 (mapper 추가 및 변경)
    public List<OrderVO> getOrderList(Criteria criteria){
        return orderDAO.getList(criteria);
    }



}
