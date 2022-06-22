package com.example.pickitup.mapper.project.projectQna;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectQnaCommentMapper {

    //    qna 에 관리자가 답변 달은 것들 전체 띄우기 페이징, qnanum으로 qna도 가져와야함
    public List<ProjectQnaCommentVO> getList(Criteria criteria);

    //    qna 답글 삽입하기기
    public void insert(ProjectQnaCommentVO projectQnaCommentVO);

    //    qna 답글 수정하기
    public boolean update(ProjectQnaCommentVO projectQnaCommentVO);

    //    qna 답글 삭제하기 qna 글 기본키 받아오기
    public boolean delete(Long num);

    //    qna 글에 달린 답변
    public List<ProjectQnaCommentVO> getComment(Long qnaNum);
}
