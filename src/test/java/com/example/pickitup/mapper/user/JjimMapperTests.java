package com.example.pickitup.mapper.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    public void getCountMyJjimProjectTest() {
        jjimMapper.countMyJjimProject(2L);
    }

    @Test
    public void getCountMyJjimProductTest() {
        jjimMapper.countMyJjimProduct(2L);
    }
}
