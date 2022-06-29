package com.example.pickitup.service;


import com.example.pickitup.domain.dao.product.productFile.ProductDAO;
import com.example.pickitup.domain.dao.product.productFile.ProductFileDAO;
import com.example.pickitup.domain.dao.product.productQna.ProductQnaCommentDAO;
import com.example.pickitup.domain.dao.product.productQna.ProductQnaDAO;
import com.example.pickitup.domain.dao.product.productReview.ProductReviewDAO;
import com.example.pickitup.domain.dao.product.productReview.ProductReviewFileDAO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import com.example.pickitup.service.product.productQna.ProductQnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminProductService {
    private final ProductDAO productDAO;
    private final ProductFileDAO productFileDAO;

    private final ProductQnaDAO productQnaDAO;
    private final ProductQnaCommentDAO productQnaCommentDAO;

    private final ProductReviewDAO productReviewDAO;
    private final ProductReviewFileDAO productReviewFileDAO;


    // 상품 상세보기 -> 수정
    public ProductVO read(Long num){
        return productDAO.getDetail(num);
    }

    // 상품 등록하기 - 관리자용
    @Transactional(rollbackFor = Exception.class)
    public void register(ProductVO productVO){
        productDAO.register(productVO);
        if(productVO.getFileList() != null) {
            productVO.getFileList().forEach(productFileVO -> {
                log.info("AdminProductService");
                log.info("들어옴");
                productFileVO.setProductNum(productVO.getNum());
                productFileDAO.register(productFileVO);
            });
        }

    }

    // 상품 수정하기 - 관리자용
    @Transactional(rollbackFor = Exception.class)
    public boolean modify(ProductVO productVO){
        productFileDAO.remove(productVO.getNum());
        if(productVO.getFileList() != null) {
            productVO.getFileList().forEach(productFileVO -> {
                log.info(productVO.getNum().toString());
                productFileVO.setProductNum(productVO.getNum());
                productFileDAO.register(productFileVO);
            });
        }
        return productDAO.update(productVO);
    }

    // 상품 삭제하기 - 관리자용
    public boolean remove(Long num){
        return productDAO.remove(num);
    }


    // 상품 개수 - 관리자용
    public int count(){
        return productDAO.count();
    }



}
