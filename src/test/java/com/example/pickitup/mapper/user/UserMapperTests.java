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

//    @Test
//    public void getListTest(){
//        userMapper.getList(new Criteria()).stream().map(UserVO::toString).forEach(log::info);
//    }
//
//    @Test
//    public void getDetailTest(){
//        userMapper.getDetail(1L);
//    }
//
    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setEmail("a45665n@naber.com");
        userVO.setPassword("1222");
        userVO.setNickname("nickname");
        userVO.setPhone("01055555555");
        userVO.setAddress("서울특별시 용산구 청파동");
        userVO.setProfileFileName("dd");
        userVO.setProfileUploadPath("ff");
        userMapper.insert(userVO);
    }


    @Test
    public void deleteTest(){
        log.info("삭제"+userMapper.delete(3L));
    }

    @Test
    public void getDetailTest(){
        log.info("한 개"+ userMapper.getDetail(2L));
    }

    @Test
    public void updateTest(){
        UserVO userVO = new UserVO();
        userVO.setNum(2L);
        userVO.setEmail("test@naber.com");
        userVO.setPassword("test");
        userVO.setNickname("test");
        userVO.setPhone("01000000000");
        userVO.setAddress("서울특별시 강남구 역삼동");
        userVO.setProfileFileName("aaaa");
        userVO.setProfileUploadPath("bbbb");
        log.info("수정"+ userMapper.update(userVO));
    }

//    @Test
//    public boolean login(String email, String password){
//        return userMapper.login("ddd","dddd");
//    }
    @Test
    public void loginTest(){
        userMapper.login("ddd","dddd");
    }






}





