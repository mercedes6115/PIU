<<<<<<< HEAD
package com.example.pickitup.mapper.project.projectFile;

import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
=======
package com.example.pickitup.mapper.project;

import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.mapper.project.projectFile.ProjectMapper;
>>>>>>> piu5
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

<<<<<<< HEAD
@SpringBootTest
@Slf4j
public class ProjectMapperTests {

    @Autowired
    private ProjectMapper projectMapper;

    // 모든 목록 테스트
    @Test
    public void getListTest(){
        projectMapper.getList().stream().map(ProjectVO::toString).forEach(log::info);
    }

    @Test
    public void getDetailTest(){
        log.info("TEST"+projectMapper.getDetail(1L));

    }
    //

}
=======

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
>>>>>>> piu5
