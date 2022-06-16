package com.example.pickitup.mapper.product.productQna;

import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
<<<<<<< HEAD

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import org.apache.ibatis.annotations.Mapper;



import java.util.List;


=======
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
>>>>>>> 718039d5105b4170035f906806aabc6fb42d1e7a
@Mapper
public interface ProductQnaMapper {
    //    qna 전체 띄우기 무한 스크롤
//    productQna.num 을 이용하여 comment를 바로 밑에 띄워줘야함
    public List<ProductQnaVO> getList(Long productNum);

    //    qan 상세보기 class101에 없음 qna+comment 세트로 불러옴
//    관리자에서 필요함 관리자가 댓글 달아준것만 리스트 업
    public ProductQnaVO getDetail(Long productNum);

    //    qna 삽입
    public void insert(ProductQnaVO productQnaVO);

    //    qna 수정하기
    public boolean update(ProductQnaVO productQnaVO);

    //    qna 삭제하기 qna 글 기본키 받아오기
    public boolean delete(Long num);

}
