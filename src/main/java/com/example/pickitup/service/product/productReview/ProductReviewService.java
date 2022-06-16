package com.example.pickitup.service.product.productReview;

import com.example.pickitup.domain.dao.product.productReview.ProductReviewDAO;
import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductReviewService {

    private final ProductReviewDAO productReviewDAO;

    // 리뷰 리스트 -> 수정
    public List<ProductReviewVO> getList(Long productNum){
        return productReviewDAO.getList(productNum);
    }

    // 리뷰 상세보기 -> 수정
//    public ProductReviewVO read(Long num){
//        return productReviewDAO.read(num);
//    }

    // 리뷰 수정하기
    public boolean update(ProductReviewVO productReviewVO){
        return productReviewDAO.update(productReviewVO);
    }

    // 리뷰 삭제하기
    public boolean delete(Long num){
        return productReviewDAO.remove(num);
    }

}
