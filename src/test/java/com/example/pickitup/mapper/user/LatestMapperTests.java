package com.example.pickitup.mapper.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LatestMapperTests {
    @Autowired
    private LatestMapper latestMapper;

    @Test
    public void getProjectListTest() {
        latestMapper.getProjectList(2L);
    }

    @Test
    public void getProductListTest() {
        latestMapper.getProductList(2L);
    }
}
