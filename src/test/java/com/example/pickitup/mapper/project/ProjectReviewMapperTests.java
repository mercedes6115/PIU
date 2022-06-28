package com.example.pickitup.mapper.project;

import com.example.pickitup.mapper.project.projectReview.ProjectReviewMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ProjectReviewMapperTests {
    @Autowired
    private ProjectReviewMapper projectReviewMapper;

    @Test
    public void getMyProjectReviewTest(){
        projectReviewMapper.getMyProjectReview(2L);
    }
}
