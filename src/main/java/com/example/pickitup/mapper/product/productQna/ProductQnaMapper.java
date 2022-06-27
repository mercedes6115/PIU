package com.example.pickitup.mapper.product.productQna;

import com.example.pickitup.domain.vo.ProductQnaCriteria;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductQnaMapper {
    //    qna 전체 띄우기 페이징
    public List<ProductQnaVO> getList(@Param("productQnaCriteria") ProductQnaCriteria productQnaCriteria, @Param("productNum") Long productNum);

    //    qan 상세보기 class101에 없음 qna+comment 세트로 불러옴
//    관리자에서 필요함 관리자가 댓글 달아준것만 리스트 업
    public ProductQnaVO getDetail(Long num);

    //    qna 삽입 -> 일반 유저, 관리자
    public void insert(ProductQnaVO productQnaVO);

    //    qna 수정하기 ->일반 유저, 관리자
    public boolean update(ProductQnaVO productQnaVO);

    //    qna 삭제하기 qna 글 기본키 받아오기 ->일반유저,관리자
    public boolean delete(Long num);

    // qna 갯수
    public int count(Long productNum);

}
