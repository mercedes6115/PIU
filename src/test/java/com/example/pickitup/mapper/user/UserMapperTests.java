package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void getListTest(){
        userMapper.getList(new Criteria()).stream().map(UserVO::toString).forEach(log::info);
    }

    @Test
    public void getDetailTest(){
        userMapper.getDetail(1L);
    }

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setEmail("alswltn@naber.com");
        userVO.setPassword("1111");
        userVO.setNickname("nickname");
        userVO.setPhone("01055555555");
        userMapper.insert(userVO);
    }

}





