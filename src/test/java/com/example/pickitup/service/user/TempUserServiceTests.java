package com.example.pickitup.service.user;

import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.TempUserSerivce;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TempUserServiceTests {
    @Autowired
    private TempUserSerivce tempUserSerivce;

    @Test
    public void getProjectListTest() {
        tempUserSerivce.getJjimProjectList(2L);
    }

    @Test
    public void getProductListTest() {
        tempUserSerivce.getJjimProductList(2L);
    }

    @Test
    public void getDetail(){
        log.info("한명의 유저" + tempUserSerivce.readUserInfo(2L));
    }

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setEmail("bbbb@aaaa");
        userVO.setPassword("aaaa");
        userVO.setNickname("aaaaa");
        userVO.setPhone("5454544545");
        userVO.setAddress("aaaaaa 용산구 갈월");
        tempUserSerivce.registerUser(userVO);
    }

    @Test
    public void updateTest(){
        UserVO userVO = new UserVO();
        userVO.setNum(2L);
        userVO.setEmail("fgdg@naber.com");
        userVO.setPassword("fgdfg");
        userVO.setNickname("dfgdf");
        userVO.setPhone("01000000000");
        userVO.setAddress("서울특별시 zdfgdfg 역삼동");
        userVO.setProfileFileName("adfffaaa");
        userVO.setProfileUploadPath("fffffff");
        log.info("수정"+ tempUserSerivce.updateUserInfo(userVO));
    }

    @Test
    public void deleteTest(){
        log.info("삭제"+tempUserSerivce.removeUser(22L));
    }

    @Test
    public void loginTest(){
        if(tempUserSerivce.loginUser("ddd","dddd")!=null){
            log.info("로그인 성공");
        }
    }


    public void getInProductListTest() { tempUserSerivce.getInProjectList(2L);}
}
