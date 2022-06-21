package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.user.AdminBoardVO;
import com.example.pickitup.domain.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

//    @Test
//    public void getListTest(){
//        userMapper.getList(new Criteria()).stream().map(UserVO::toString).forEach(log::info);
//    }
//
//    @Test
//    public void getDetailTest(){
//        userMapper.getDetail(1L);
//    }
//
    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setEmail("a1848n@naver.com");
        userVO.setPassword("134312");
        userVO.setNickname("nickname77");
        userVO.setPhone("010-5325-6785");
        userVO.setAddress("서울특별시 용산구 청파동58");
        userVO.setProfileFileName("dd");
        userVO.setProfileUploadPath("rr");
        userMapper.insert(userVO);
    }


    @Test
    public void deleteTest(){
        log.info("삭제"+userMapper.delete(3L));
    }

    @Test
    public void getDetailTest(){
        userMapper.getDetail(2L);
    }

    @Test
    public void updateTest(){
        UserVO userVO = new UserVO();
        userVO.setNum(2L);
        userVO.setEmail("test@naber.com");
        userVO.setPassword("test");
        userVO.setNickname("test");
        userVO.setPhone("01000000000");
        userVO.setAddress("서울특별시 강남구 역삼동");
        userVO.setProfileFileName("aaaa");
        userVO.setProfileUploadPath("bbbb");
        log.info("수정"+ userMapper.update(userVO));
    }

    @Test
    public void getList(){
        Criteria criteria = new Criteria();
        criteria.setType1("nickname");
        criteria.setKeyword("admin");
        criteria.setAmount(10);
        criteria.setPageNum(1);
        criteria.setStartDate("2022-06-16");
        criteria.setEndDate("2022-06-18");
        userMapper.getList(criteria);

    }

    @Test
    public void getInProductListTest() {
        userMapper.getInProductList(2L);
    }

//    @Test
//    public boolean login(String email, String password){
//        return userMapper.login("ddd","dddd");
//    }
    @Test
    public void loginTest(){
        userMapper.login("ddd","dddd");

    }

    //관리자 공지 등록
    @Test
    public void writeTest(){
        AdminBoardVO adminBoardVO = new AdminBoardVO();
        adminBoardVO.setTitle("새로운 공지글 제목2");
        adminBoardVO.setContent("새로운 공지글 내용2");
        adminBoardVO.setUserNum(0L);

        userMapper.write(adminBoardVO);

        log.info("게시글 번호 : " + adminBoardVO.getNum());
    }

    //공지리스트
    @Test
    public void getNoticeListTest(){
        userMapper.getNoticeList(new Criteria(1, 10));

    }

    //공지상세보기
    @Test
    public void getNoticeDetailTest(){
        Long num = 10L;
        log.info(userMapper.getNoticeDetail(num).toString());
        log.info("***************************************************");
        log.info(userMapper.getNoticeDetail(10L).getContent());
        log.info("***************************************************");
    }

    @Test
    public void getNoticeTotalTest(){
        userMapper.getNoticeTotal();
    }




}





