package com.example.pickitup.domain.dao.product.productReview;

import com.example.pickitup.domain.vo.product.productReview.ProductReviewFileVO;
import com.example.pickitup.mapper.product.productReview.ProductReviewFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class ProductReviewFileDAO {

    private final ProductReviewFileMapper productReviewFileMapper;

    // 파일 경로 가져오기(mapper 매서드명 수정)
    public List<ProductReviewFileVO> findByProductReviewNum(Long reviewNum) {
        return productReviewFileMapper.findByProductReviewNum(reviewNum);
    }

    // 해당 후기글 작성 도중 창을 이동할 경우 저장 경로에서 사진 지우기
    public List<ProductReviewFileVO> getOldFiles(){
        return productReviewFileMapper.getOldFiles();
    }

    // 사진 등록
    public void register(ProductReviewFileVO productReviewFileVO){
        productReviewFileMapper.insert(productReviewFileVO);
    };

    // 사진 삭제
    public void remove(Long reviewNum){
        productReviewFileMapper.delete(reviewNum);
    }

}
