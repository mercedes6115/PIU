package com.example.pickitup.mapper.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ApplyMapperTests {
    @Autowired
    private ApplyMapper applyMapper;

    @Test
    public void successProjectTest() { applyMapper.successProject(2L);}

    @Test
    public void countApplyTest() { applyMapper.countApply(21L);}
}
