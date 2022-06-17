package com.example.pickitup.domain.dao.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {

    private final UserMapper userMapper;

    // 유저 목록(관리자용)
    public List<UserVO> getList(Criteria criteria){
        return userMapper.getList(criteria);
    }

    // 일반 유저 가입
    public void register(UserVO userVO){
        userMapper.insert(userVO);
    }

    // 유저 상세보기
    public UserVO read(Long num){
        return userMapper.getDetail(num);
    }

    // 유저 정보 수정
    public boolean update(UserVO userVO){
        return userMapper.update(userVO);
    }

    // 유저 탈퇴
    public boolean remove(Long num){
        return userMapper.delete(num);
    }

    // 유저가 구매한 상품 목록
    public List<ProductVO> getInProductList(Long userNum) {
        return userMapper.getInProductList(userNum);
    }

    public List<ProjectVO> getInProjectList(Long userNum) {
        return userMapper.getInProjectList(userNum);
    }

    // 로그인 -> select count-> read() 사용?
    public int login(String email, String password){
        return userMapper.login(email,password);
    }
}
