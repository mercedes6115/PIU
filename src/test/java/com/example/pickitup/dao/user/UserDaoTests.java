package com.example.pickitup.dao.user;

import com.example.pickitup.domain.dao.user.OrderDAO;
import com.example.pickitup.domain.dao.user.UserDAO;
import com.example.pickitup.domain.vo.AdminCriteria;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.adminVO.AdminBoardDTO;
import com.example.pickitup.domain.vo.dto.AdminQnaCommentDTO;
import com.example.pickitup.domain.vo.dto.AdminQnaDTO;
import com.example.pickitup.domain.vo.dto.OrderUserDTO;
import com.example.pickitup.domain.vo.dto.ReviewDTO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.user.AdminBoardVO;
import com.example.pickitup.domain.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class UserDaoTests {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OrderDAO orderDAO;

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
    public void loginTest() {
        if (userDAO.login("ddd", "dddd") != null) {
            log.info("로그인 성공");
        }
    }

    public void getInProductTest() {
        userDAO.getInProductList(2L);
    }

    @Test
    public void registerWriteTest() {

        AdminBoardVO adminBoardVO = new AdminBoardVO();
        adminBoardVO.setTitle("DAO새로운 공지글 제목2");
        adminBoardVO.setContent("DAO새로운 공지글 내용2");
        adminBoardVO.setUserNum(0L);

        userDAO.registerWrite(adminBoardVO);

        log.info("게시글 번호 : " + adminBoardVO.getNum());
    }

    @Test
    public void getReadDetailTest() {
        Long num = 12L;
        userDAO.getReadDetail(num);
    }

    @Test
    public void getNoticeListTest() {
        userDAO.getNoticeList(new AdminCriteria()).stream().map(AdminBoardDTO::toString).forEach(log::info);
    }

    @Test
    public void getNoticeTotalTest() {
        log.info("공지글 총 개수 : " + userDAO.getNoticeTotal(new AdminCriteria(1, 10)));
    }

    @Test
    public void getAdminBoardCountTest() {
        log.info("adminboard 글 총 개수 : " + userDAO.getAdminBoardCount(new AdminCriteria(1, 10)));
    }

    @Test
    public void getAdminboardListTest() {
        userDAO.getAdminboardList(new AdminCriteria(1, 10));
    }

    @Test
    public void deleteByIdTest() {
        userDAO.deleteById(49L);
    }

    @Test
    public void noticeCancelTest() {
        userDAO.noticeCancel(59L);
    }

    @Test
    public void noticeConfirmTest() {
        userDAO.noticeConfirm(59L);
    }

    @Test
    public void getQnaReplyTest() {
        userDAO.getQnaReply(125L);
    }

    @Test
    public void projectQnaReplyTest() {
        AdminQnaCommentDTO adminQnaCommentDTO = new AdminQnaCommentDTO();
        adminQnaCommentDTO.setContent("디티오테스트01");
        adminQnaCommentDTO.setCompanyNum(2L);
        adminQnaCommentDTO.setQnaNum(3L);
        userDAO.projectQnaReply(adminQnaCommentDTO);
//        ProjectQnaCommentVO projectQnaCommentVO = new ProjectQnaCommentVO();
//        projectQnaCommentVO.setContent("다오테스트01");
//        projectQnaCommentVO.setCompanyNum(2L);
//        projectQnaCommentVO.setQnaNum(3L);
//        userDAO.projectQnaReply(projectQnaCommentVO);
    }

    @Test
    public void productQnaReplyTest() {
        AdminQnaCommentDTO adminQnaCommentDTO = new AdminQnaCommentDTO();
        adminQnaCommentDTO.setContent("디티오테스트01");
        adminQnaCommentDTO.setUserNum(0L);
        adminQnaCommentDTO.setQnaNum(1L);
        userDAO.productQnaReply(adminQnaCommentDTO);
    }

    @Test
    public void answerCompleteTest() {
        userDAO.answerComplete(3L);
    }

    @Test
    public void nicknameCheckTest() {
        log.info("결과 : " + userDAO.nicknameCheck("짜리킴"));
    }

    @Test
    public void qnaStoreSaveTest() {
        AdminQnaDTO adminQnaDTO = new AdminQnaDTO();
        adminQnaDTO.setContent("0626다오 테스트");
        adminQnaDTO.setUserNum(3L);
        adminQnaDTO.setProductNum(3L);
        userDAO.qnaStoreSave(adminQnaDTO);
    }

    @Test
    public void productQnaDeleteTest() {
        userDAO.productQnaDelete(62L);
    }


    @Test
    public void getMyProductQnaComment() {
        userDAO.getMyProductQnaComment(13L);
    }

    @Test
    public void getMyProjectQnaTest() {
        userDAO.getMyProjectQna(2L);
    }

    @Test
    public void getMyAllReviewTest(){
        userDAO.myAllReview(22L);
    }

    @Test
    public void orderStoreTest() {
        OrderUserDTO orderUserDTO = new OrderUserDTO();
        orderUserDTO.setUserNum(22L);
        orderUserDTO.setCounting(5L);
        orderUserDTO.setTotal(250L);
        orderUserDTO.setProductName("상품2");
        orderUserDTO.setAddressComment("배송중 던지지 마세요");
        orderUserDTO.setAddress("인천광역시");
        orderUserDTO.setAddressDetail("주안");
        orderDAO.orderStore(orderUserDTO);
    }

    @Test
    public void userPointMinus(){
        orderDAO.userPointMinus(22L, "3000");
    };

    @Test
    public void productMinusTest() {
        orderDAO.productMinus("상품1",30L);
    }

    @Test
    public void getDetailByNameTest(){
        orderDAO.getDetailByName("상품2");
    }
}

