package com.example.pickitup.mapper.project;

import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.mapper.project.projectFile.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class ProjectMapperTests {
    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void createTest(){
        ProjectVO projectVO = new ProjectVO();
        projectVO.setTitle("플로깅 팟 구함");
        projectVO.setContent("산갈사람");
        projectVO.setCourse("C");
        projectVO.setTerrain("산");
        projectVO.setPoint(1111l);
        projectVO.setStartAddress("역삼역1번출구");
        projectVO.setEndAddress("역삼역7번출구");
        projectVO.setDistance("111km");
        projectVO.setUserNum(7l);
        projectVO.setCompanyNum(2l);

        projectMapper.insert(projectVO);
    }

}
