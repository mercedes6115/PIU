package com.example.pickitup.mapper.product.productQna;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaCommentVO;

import org.apache.ibatis.annotations.Mapper;


import java.util.List;


@Mapper
public interface ProductQnaCommentMapper {

    //    qna 에 관리자가 답변 달은 것들 전체 띄우기 페이징, qnanum으로 qna도 가져와야함
    public List<ProductQnaCommentVO> getList(Long qnaNum);

    //    qna 답글 삽입하기기 ->관리자
    public void insert(ProductQnaCommentVO productQnaCommentVO);

    //    qna 답글 수정하기 ->관리자
    public boolean update(ProductQnaCommentVO productQnaCommentVO);

    //    qna 답글 삭제하기 qna 글 기본키 받아오기 ->관리자
    public boolean delete(Long num);

}
