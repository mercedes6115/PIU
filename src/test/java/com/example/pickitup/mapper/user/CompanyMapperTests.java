package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.user.CompanyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CompanyMapperTests {
    @Autowired
    private CompanyMapper companyMapper;

//    @Test
//    public void insertTest(){
//        CompanyVO companyVO=new CompanyVO();
//        companyVO.setEmail("1111@1111");
//        companyVO.setPassword("1111");
//        companyVO.setNickname("가화");
//        companyVO.setPhone("01022222222");
//        companyVO.setBusinessPhone("023334444");
//        companyVO.setAddress("서울시 은평구");
//        companyVO.setBusinessNumber("1234567891");
//        companyVO.setProfileFileName("123");
//        companyVO.setProfileUploadPath("2131");
//        companyMapper.insert(companyVO);
//    }
    @Test
    public void loginTest(){
        log.info("로그인 : " );
        companyMapper.login("1111@1111","1111");
    }
}
