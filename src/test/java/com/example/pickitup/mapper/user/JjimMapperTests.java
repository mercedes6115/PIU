package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.user.JjimVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class JjimMapperTests {
    @Autowired
    private JjimMapper jjimMapper;

    @Test
    public void getProjectListTest() {
        jjimMapper.getProjectList(2L);
    }

    @Test
    public void getProductListTest() {
        jjimMapper.getProductList(2L);
    }

//    @Test
//    public void getListTest(){
//        jjimMapper.getList().stream().map(JjimVO::toString).forEach(log::info);
//    }

//    @Test
//    public void insertTest(){
//        JjimVO vo = new JjimVO();
//        vo.setCategory("1");
//        vo.setUserNum(22L);
//        vo.setProductNum(56L);
//        jjimMapper.insert(vo);
//    }
//
//    @Test
//    public void deleteTest(){
//        JjimVO vo = new JjimVO();
//        vo.setUserNum(22L);
//        vo.setProductNum(23L);
//        jjimMapper.delete(vo);
//    }

    @Test
    public void myProjectJjimListTest(){
        jjimMapper.getList();
    }

    @Test
    public void myProjectJjimInsertTest() {
        JjimVO jjimVO = new JjimVO();
        jjimVO.setUserNum(2L);
        jjimVO.setProjectNum(30L);
        jjimVO.setCategory("2");
        jjimMapper.myProjectJjimInsert(jjimVO);
    }
}
