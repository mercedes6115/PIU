package com.example.pickitup.domain.dao.user;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.mapper.user.JjimMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JjimDAO {

    private final JjimMapper jjimMapper;

    // 나의 프로젝트 찜 목록
    public List<ProjectVO> getProjectList(Long userNum){
        return jjimMapper.getProjectList(userNum);
    }

    // 나의 상품 찜 목록
    public List<ProductVO> getProductList(Long userNum){
        return jjimMapper.getProductList(userNum);
    }

    // 찜 등록
    public void register(JjimVO jjimVO){
        jjimMapper.insert(jjimVO);
    }

    // 찜 해제
    public void remove(JjimVO jjimVO){
        jjimMapper.delete(jjimVO);
    }

    // 찜 갯수
    public int count(Long productNum){
       return jjimMapper.count(productNum);
    }

    // 찜 전체 목록
    public List<JjimVO> getList(){
        return jjimMapper.getList();
    }

    // 프로젝트 찜 등록(마이페이지)
    public void myProjectJjimInsert(JjimVO jjimVO) { jjimMapper.myProjectJjimInsert(jjimVO);}

    // 프로젝트 찜 삭제(마이페이지)
    public void myProjectJjimDelete(JjimVO jjimVO) { jjimMapper.myProjectJjimDelete(jjimVO);}

    // 프로젝트 찜 개수(마이페이지)
    public int myProjectJjimCount(Long projectNum) { return jjimMapper.myProjectJjimCount(projectNum);}
}
