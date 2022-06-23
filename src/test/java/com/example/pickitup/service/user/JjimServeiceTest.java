package com.example.pickitup.service.user;

import com.example.pickitup.domain.vo.user.JjimVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class JjimServeiceTest {
    @Autowired
    private JjimService jjimService;

//    @Test
//    public void registerTest(){
//        JjimVO vo = new JjimVO();
//        vo.setUserNum(22L);
//        vo.setProductNum(23L);
//        vo.setCategory("1");
//        jjimService.register(vo);
//    }
//
//    @Test
//    public void removeTest(){
//        JjimVO vo = new JjimVO();
//        vo.setUserNum(22L);
//        vo.setProductNum(23L);
//        jjimService.remove(vo);
//    }
    @Test
    public void getListTest(){
        jjimService.getList();
    }
}
