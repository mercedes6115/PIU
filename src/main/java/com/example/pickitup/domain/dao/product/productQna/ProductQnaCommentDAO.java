package com.example.pickitup.domain.dao.product.productQna;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaCommentVO;
import com.example.pickitup.mapper.product.productQna.ProductQnaCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductQnaCommentDAO {

    private final ProductQnaCommentMapper productQnaCommentMapper;

    // 답변한 문의 목록 가져오기(관리자)
    // 쿼리 조건문?
    public List<ProductQnaCommentVO> getList(Long qnaNum){
        return productQnaCommentMapper.getList(qnaNum);
    }

    // 문의글 답변
    public void register(ProductQnaCommentVO productQnaCommentVO){
        productQnaCommentMapper.insert(productQnaCommentVO);
    }

    // 문의글 답변 수정
    public boolean update(ProductQnaCommentVO productQnaCommentVO){
        return productQnaCommentMapper.update(productQnaCommentVO);
    }

    // 문의글 답변 삭제
    public boolean remove(Long num){
        return productQnaCommentMapper.delete(num);
    }
}
