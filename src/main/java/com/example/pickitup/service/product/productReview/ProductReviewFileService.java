package com.example.pickitup.service.product.productReview;

import com.example.pickitup.domain.dao.product.productReview.ProductReviewFileDAO;
import com.example.pickitup.domain.vo.product.productReview.ProductReviewFileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductReviewFileService {

    private final ProductReviewFileDAO productReviewFileDAO;

    // 파일 경로 가져오기(mapper 매서드명 수정)
    public List<ProductReviewFileVO> findByProductReviewNum(Long reviewNum) {
        return productReviewFileDAO.findByProductReviewNum(reviewNum);
    }

    // 해당 후기글 작성 도중 창을 이동할 경우 저장 경로에서 사진 지우기
    public List<ProductReviewFileVO> getOldFiles(){
        return productReviewFileDAO.getOldFiles();
    }

    // 사진 등록
    public void register(ProductReviewFileVO productReviewFileVO){
        productReviewFileDAO.register(productReviewFileVO);
    };

    // 사진 삭제
    public void remove(Long reviewNum){
        productReviewFileDAO.remove(reviewNum);
    }

}
