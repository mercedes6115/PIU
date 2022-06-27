package com.example.pickitup.mapper.product.productReview;

import com.example.pickitup.domain.vo.product.productReview.ProductReviewVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
public interface ProductReviewMapper {
    //    하나의 상품 리뷰 리스트 , 무한 스크롤
    public List<ProductReviewVO> getList(Long num);

    //  하나의 리뷰 상세보기
    public ProductReviewVO getDetail(Long num);

    //    리뷰 하나 작성하기 ->일반 유저 ,관리자
    public void insert(ProductReviewVO productReviewVO);

    //    리뷰 수정하기 ->일반 유저, 관리자
    public boolean update(ProductReviewVO productReviewVO);

    //    리뷰 삭제하기 ->일반유저, 관리자
    public boolean delete(Long num);

    public int count(Long productNum);

}
