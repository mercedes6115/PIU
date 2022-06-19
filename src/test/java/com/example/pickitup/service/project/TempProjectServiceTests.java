package com.example.pickitup.service.project;

import com.example.pickitup.service.TempProjectService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TempProjectServiceTests {
    @Autowired
    private TempProjectService tempProjectService;

    @Test
    public void getThumbnailTest() {
        tempProjectService.getThumbnail(22L);
    }
}
