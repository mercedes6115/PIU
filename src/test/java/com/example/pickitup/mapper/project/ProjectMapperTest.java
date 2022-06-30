package com.example.pickitup.mapper.project;

import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.mapper.project.projectFile.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectMapperTest {
    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void getListJJimTest(){
        log.info(projectMapper.getListJJim().toString());
    }

    @Test
    public void getListPointTest(){ log.info(projectMapper.getListPoint().toString());    }

    @Test
    public void getListApplyTest(){
        log.info(projectMapper.getListApply().toString());
    }

    
    @Test
    public void getListCourseTest() { log.info(projectMapper.getListCourse("산").toString());}


    @Test
    public void wewewe(){
        log.info(projectMapper.adminStatistics("2022-06-24")+"============");
    }

    @Test
    public void getSearchTest(){ log.info(projectMapper.getSearchList("test").toString());}

    @Test
    public void getListTerrainTest() { projectMapper.getListTerrain("1").stream().map(ProjectVO::toString).forEach(log::info);}
}
