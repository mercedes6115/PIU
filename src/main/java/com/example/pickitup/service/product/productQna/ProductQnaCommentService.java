package com.example.pickitup.service.product.productQna;

import com.example.pickitup.domain.dao.product.productQna.ProductQnaCommentDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaCommentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductQnaCommentService {

    private final ProductQnaCommentDAO productQnaCommentDAO;

    // 답변한 문의 목록 가져오기(관리자)
    // 쿼리 조건문?
    public List<ProductQnaCommentVO> getList(Long qna_num){
        return productQnaCommentDAO.getList(qna_num);
    }

    // 문의글 답변
    public void register(ProductQnaCommentVO productQnaCommentVO){
        productQnaCommentDAO.register(productQnaCommentVO);
    }

    // 문의글 답변 수정
    public boolean update(ProductQnaCommentVO productQnaCommentVO){
        return productQnaCommentDAO.update(productQnaCommentVO);
    }

    // 문의글 답변 삭제
    public boolean delete(Long num){
        return productQnaCommentDAO.remove(num);
    }
}
