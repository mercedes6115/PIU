package com.example.pickitup.dao.project;

import com.example.pickitup.domain.dao.project.projectFile.ProjectFileDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectFileDaoTests {
    @Autowired
    private ProjectFileDAO projectFileDAO;

//    @Test
//    public void findByProjectNum() {
//        projectFileDAO.findProjectNum(22L);
//    }
}
