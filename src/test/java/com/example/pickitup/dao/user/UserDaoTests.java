package com.example.pickitup.dao.user;

import com.example.pickitup.domain.dao.user.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserDaoTests {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void getInProductTest() {
        userDAO.getInProjectList(2L);
    }
}
