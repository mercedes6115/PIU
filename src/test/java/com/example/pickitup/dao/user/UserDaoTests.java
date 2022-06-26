package com.example.pickitup.dao.user;

import com.example.pickitup.domain.dao.user.UserDAO;
import com.example.pickitup.domain.vo.AdminCriteria;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.adminVO.AdminBoardDTO;
import com.example.pickitup.domain.vo.user.AdminBoardVO;
import com.example.pickitup.domain.vo.user.UserVO;
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
    public void getDetail() {
        log.info("한명의 유저" + userDAO.read(22L));
    }

    @Test
    public void insertTest() {
        UserVO userVO = new UserVO();
        userVO.setEmail("a45665n@naber.com");
        userVO.setPassword("dfdf");
        userVO.setNickname("nickname");
        userVO.setPhone("5454544545");
        userVO.setAddress("서울특별시 용산구 갈월");
        userDAO.register(userVO);
    }

    @Test
    public void updateTest() {
        UserVO userVO = new UserVO();
        userVO.setNum(2L);
        userVO.setEmail("fgdg@naber.com");
        userVO.setPassword("fgdfg");
        userVO.setNickname("dfgdf");
        userVO.setPhone("01000000000");
        userVO.setAddress("서울특별시 zdfgdfg 역삼동");
        userVO.setProfileFileName("adfffaaa");
        userVO.setProfileUploadPath("fffffff");
        log.info("수정" + userDAO.update(userVO));
    }

    @Test
    public void deleteTest() {
        log.info("삭제" + userDAO.remove(22L));
    }

    @Test
    public void loginTest(){
        if(userDAO.login("ddd","dddd")!=null){
            log.info("로그인 성공");
        }
    }

    public void getInProductTest() {
        userDAO.getInProductList(2L);
    }

    @Test
    public void registerWriteTest () {

        AdminBoardVO adminBoardVO = new AdminBoardVO();
        adminBoardVO.setTitle("DAO새로운 공지글 제목2");
        adminBoardVO.setContent("DAO새로운 공지글 내용2");
        adminBoardVO.setUserNum(0L);

        userDAO.registerWrite(adminBoardVO);

        log.info("게시글 번호 : " + adminBoardVO.getNum());
    }

    @Test
    public void getReadDetailTest () {
        Long num = 12L;
        userDAO.getReadDetail(num);
    }

    @Test
    public void getNoticeListTest () {
        userDAO.getNoticeList(new AdminCriteria()).stream().map(AdminBoardDTO::toString).forEach(log::info);
    }

    @Test
    public void getNoticeTotalTest () {
        log.info("공지글 총 개수 : " + userDAO.getNoticeTotal(new AdminCriteria(1,10)));
    }

    @Test
    public void getAdminBoardCountTest () {
        log.info("adminboard 글 총 개수 : " + userDAO.getAdminBoardCount(new AdminCriteria(1, 10)));
    }

    @Test
    public void getAdminboardListTest () {
        userDAO.getAdminboardList(new AdminCriteria(1, 10));
    }

    @Test
    public void deleteByIdTest(){
        userDAO.deleteById(49L);
    }

    @Test
    public void noticeCancelTest(){
        userDAO.noticeCancel(59L);
    }

    @Test
    public void noticeConfirmTest(){
        userDAO.noticeConfirm(59L);
    }

    @Test
    public void getQnaReplyTest(){
        userDAO.getQnaReply(125L);
    }

    @Test
    public void nicknameCheckTest() { log.info("결과 : " + userDAO.nicknameCheck("짜리킴"));}

}

