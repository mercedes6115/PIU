package com.example.pickitup.dao.project;

import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectDaoTest {
    @Autowired
    private ProjectDAO projectDAO;

    @Test
    public void getListJJimTest(){
        log.info(projectDAO.getListJJim().toString());
    }

    @Test
    public void getListPointTest(){
        log.info(projectDAO.getListPoint().toString());
    }
}
