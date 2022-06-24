package com.example.pickitup.dao.user;

import com.example.pickitup.domain.dao.user.JjimDAO;
import com.example.pickitup.domain.vo.user.JjimVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class JjimDaoTests {
    @Autowired
    private JjimDAO jjimDAO;

    @Test
    public void getProjectListTest() {
        jjimDAO.getProjectList(2L);
    }

    @Test
    public void getProductListTest() { jjimDAO.getProductList(2L); }

//    @Test
//    public void registerTest(){
//        JjimVO vo = new JjimVO();
//        vo.setCategory("1");
//        vo.setProductNum(23L);
//        vo.setUserNum(22L);
//        jjimDAO.register(vo);
//    }
//    @Test
//    public void removeTest(){
//        JjimVO vo = new JjimVO();
//        vo.setProductNum(23L);
//        vo.setUserNum(22L);
//        jjimDAO.remove(vo);
//    }
//    @Test
//    public void getListTest(){
//        jjimDAO.getList();
//    }
}
