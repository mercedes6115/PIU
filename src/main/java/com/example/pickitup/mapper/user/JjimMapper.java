package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JjimMapper {

    //    내가 찜 프로젝트 리스트 보이기
    public List<ProjectVO> getProjectList(Long userNum);

    //    내가 찜 상품 리스트 보이기
    public List<ProductVO> getProductList(Long userNum);

    //   찜한 게시물 테이블 등록
    public void insert(JjimVO jjimVO);
    //   찜한 게시물 테이블 등록
    public void delete(JjimVO jjimVO);

    // registDate update 해주기 
    // projectNum하고 userNum을 주세요
//    해당 외래키로 registDate sysdate할 예정
    public boolean updateProject(JjimVO jjimVO);

    // registDate update 해주기
    // projectNum하고 userNum을 주세요
    public boolean updateProduct(JjimVO jjimVO);

    // 프로젝트 찜 추가
    public void insertProject(JjimVO jjimVO);

    // 프로젝트 찜 해제
    public void deleteProject(JjimVO jjimVO);





}
