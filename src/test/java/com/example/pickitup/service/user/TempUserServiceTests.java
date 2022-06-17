package com.example.pickitup.service.user;

import com.example.pickitup.service.TempUserSerivce;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TempUserServiceTests {
    @Autowired
    private TempUserSerivce tempUserSerivce;

    @Test
    public void getProjectListTest() {
        tempUserSerivce.getJjimProjectList(2L);
    }

    @Test
    public void getProductListTest() {
        tempUserSerivce.getJjimProductList(2L);
    }

    @Test
    public void getInProductListTest() { tempUserSerivce.getInProjectList(2L);}
}
