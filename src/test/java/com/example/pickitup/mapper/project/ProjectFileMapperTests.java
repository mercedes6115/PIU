package com.example.pickitup.mapper.project;

import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import com.example.pickitup.mapper.project.projectFile.ProjectFileMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class ProjectFileMapperTests {
    @Autowired
    private ProjectFileMapper projectFileMapper;
//
//    @Test
//    public void findByProjectNum(){
//        projectFileMapper.findProjectNum(22L);
//    }
}
