package com.example.pickitup.domain.dao.product.productReview;

import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import com.example.pickitup.mapper.product.productReview.ProductReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class ProductReviewDAO {

    private final ProductReviewMapper productReviewMapper;

    // 리뷰 리스트 -> 수정
    public List<ProductReviewVO> getList(Long productNum){
        return productReviewMapper.getList(productNum);
    }

    // 리뷰 상세보기 -> 수정
    public ProductReviewVO read(Long num){
        return productReviewMapper.getDetail(num);
    }

    // 리뷰작성
    public void insert(ProductReviewVO productReviewVO){
        productReviewMapper.insert(productReviewVO);
    }

    // 리뷰 수정하기
    public boolean update(ProductReviewVO productReviewVO){
        return productReviewMapper.update(productReviewVO);
    }

    // 리뷰 삭제하기
    public boolean remove(Long num){
        return productReviewMapper.delete(num);
    }

    //리뷰 갯수 구하기
    public int count(Long productNum){return productReviewMapper.count(productNum);}

}
