package com.example.pickitup.dao.user;

import com.example.pickitup.domain.dao.user.JjimDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class JjimDaoTests {
    @Autowired
    private JjimDAO jjimDAO;

    @Test
    public void getProjectListTest() {
        jjimDAO.getProjectList(2L);
    }

    @Test
    public void getProductListTest() { jjimDAO.getProductList(2L); }
}
