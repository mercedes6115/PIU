package com.example.pickitup.service.user;

import com.example.pickitup.domain.dao.user.UserDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSerivce {

    private final UserDAO userDAO;

    // 유저 목록(관리자용)
    public List<UserVO> getList(Criteria criteria){
        return userDAO.getList(criteria);
    }

    // 일반 유저 가입
    public void register(UserVO userVO){
        userDAO.register(userVO);
    }

    // 유저 상세보기
    public UserVO read(Long num){
        return userDAO.read(num);
    }

    // 유저 정보 수정
    public boolean update(UserVO userVO){
        return userDAO.update(userVO);
    }

    // 유저 탈퇴
    public boolean remove(Long num){
        return userDAO.remove(num);
    }

    // 로그인 -> select count-> read() 사용?
}
