package com.example.pickitup.service.user;


import com.example.pickitup.domain.vo.AdminCriteria;
import com.example.pickitup.domain.vo.dto.AdminQnaCommentDTO;
import com.example.pickitup.domain.vo.dto.AdminQnaDTO;
import com.example.pickitup.domain.vo.dto.OrderUserDTO;
import com.example.pickitup.domain.vo.dto.PointDTO;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.adminVO.AdminBoardDTO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.user.AdminBoardVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.TempAdminService;
import com.example.pickitup.service.TempUserSerivce;
import edu.emory.mathcs.backport.java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
public class TempUserServiceTests {
    @Autowired
    private TempUserSerivce tempUserSerivce;

    @Autowired
    private TempAdminService tempAdminService;

    @Test
    public void getProjectListTest() {
        tempUserSerivce.getJjimProjectList(2L);
    }

    @Test
    public void getProductListTest() {
        tempUserSerivce.getJjimProductList(2L);
    }

    @Test
    public void getDetail(){
        log.info("한명의 유저" + tempUserSerivce.readUserInfo(22L));
    }

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setEmail("bbbb@aaaa");
        userVO.setPassword("aaaa");
        userVO.setNickname("aaaaa");
        userVO.setPhone("5454544545");
        userVO.setAddress("aaaaaa 용산구 갈월");
        tempUserSerivce.registerUser(userVO);
    }

    @Test
    public void updateTest(){
        UserVO userVO = new UserVO();
        userVO.setNum(2L);
        userVO.setEmail("fgdg@naber.com");
        userVO.setPassword("fgdfg");
        userVO.setNickname("dfgdf");
        userVO.setPhone("01000000000");
        userVO.setAddress("서울특별시 zdfgdfg 역삼동");
        userVO.setProfileFileName("adfffaaa");
        userVO.setProfileUploadPath("fffffff");
        log.info("수정"+ tempUserSerivce.updateUserInfo(userVO));
    }

    @Test
    public void deleteTest(){
        log.info("삭제"+tempUserSerivce.removeUser(22L));
    }

    @Test
    public void loginTest(){
        if(tempUserSerivce.loginUser("ddd","dddd")!=null){
            log.info("로그인 성공");
        }
    }

    @Test
    public void changePointTest() throws ParseException {
        List<PointDTO> pointDTOList = tempUserSerivce.changePoint(2L);
        pointDTOList.sort(Comparator.comparing(PointDTO::getPointDate).reversed());
        log.info("결과 : " + pointDTOList);
    }


    public void getInProductListTest() { tempUserSerivce.getInProjectList(2L);}


    @Test
    public void registerWriteTest(){
        AdminBoardVO adminBoardVO = new AdminBoardVO();
        adminBoardVO.setTitle("service 새로운 공지글 제목");
        adminBoardVO.setContent("service 새로운 공지글 내용");
        adminBoardVO.setUserNum(0L);

        tempAdminService.registerWrite(adminBoardVO);

        log.info("게시글 번호 : " + adminBoardVO.getNum());
    }


    @Test
    public void getNoticeListTest(){
        tempAdminService.getNoticeList(new AdminCriteria()).stream().map(AdminBoardDTO::toString).forEach(log::info);
    }

    @Test
    public void getReadDetailTest(){
        Long num = 30L;
        tempAdminService.getReadDetail(num);
    }

    @Test
    public void getNoticeTotalTest(){
        log.info("총 개수 : " + tempAdminService.getNoticeTotal(new AdminCriteria(1,10)));
    }

    @Test
    public void getAdminBoardCountTest() {
        log.info("adminboard 글 총개수 : " + tempAdminService.getAdminBoardCount(new AdminCriteria(1,10)));
    }

    @Test
    public void getAdminboardListTest(){
        tempAdminService.getAdminboardList(new AdminCriteria());
    }

    @Test
    public void deleteByIdTest(){
        tempAdminService.deleteById(47L);
    }

    @Test
    public void noticeCancelTest() {
        tempAdminService.noticeCancel(61L);
    }

    @Test
    public void noticeConfirmTest(){
        tempAdminService.noticeConfirm(61L);
    }

    @Test
    public void getQnaReplyTest(){
        tempAdminService.getQnaReply(125L);
    }

    @Test
    public void getprojectQnaReply(){
        AdminQnaCommentDTO adminQnaCommentDTO = new AdminQnaCommentDTO();
        adminQnaCommentDTO.setContent("디티오서비스테스트");
        adminQnaCommentDTO.setCompanyNum(1L);
        adminQnaCommentDTO.setQnaNum(3L);
        tempAdminService.getProjectQnaReply(adminQnaCommentDTO);
//        ProjectQnaCommentVO projectQnaCommentVO = new ProjectQnaCommentVO();
//        projectQnaCommentVO.setCompanyNum(1L);
//        projectQnaCommentVO.setQnaNum(3L);
//        projectQnaCommentVO.setContent("서비스테스트");
//        tempAdminService.getProjectQnaReply(projectQnaCommentVO);
    }

    @Test
    public void getproductQnaReply() {
        AdminQnaCommentDTO adminQnaCommentDTO = new AdminQnaCommentDTO();
        adminQnaCommentDTO.setContent("디티오서비스테스트");
        adminQnaCommentDTO.setUserNum(1L);
        adminQnaCommentDTO.setQnaNum(1L);
        tempAdminService.getProductQnaReply(adminQnaCommentDTO);
    }

    @Test
    public void changeAnswerStatus(){
        tempAdminService.changeAnswerStatus(5L);
    }

    @Test
    public void qnaStoreSave() {
        AdminQnaDTO adminQnaDTO = new AdminQnaDTO();
        adminQnaDTO.setContent("서비스 테스트");
        adminQnaDTO.setUserNum(5L);
        adminQnaDTO.setProductNum(3L);
        tempAdminService.qnaStoreSave(adminQnaDTO);
    }

    @Test
    public void productQnaDelete() {
        tempAdminService.productQnaDelete(68L);
    }

    @Test
    public void getMyProductQna() { tempUserSerivce.getMyProductQna(2L);}

    @Test
    public void getMyAllReview(){
        tempUserSerivce.myAllReview(22L);
    }

    @Test
    public void orderStoreTest() {
        OrderUserDTO orderUserDTO = new OrderUserDTO();
        orderUserDTO.setUserNum(22L);
        orderUserDTO.setCounting(4L);
        orderUserDTO.setTotal(800L);
        orderUserDTO.setProductName("상품1");
        orderUserDTO.setAddressComment("잘부탁드립니다");
        orderUserDTO.setAddress("경기도");
        orderUserDTO.setAddressDetail("광명시");
        tempUserSerivce.orderStore(orderUserDTO);
    }

    @Test
    public void userPointMinusTest() {
        tempUserSerivce.userPointMinus(22L, "4000");
    }

    @Test
    public void productMinusTest(){
        tempUserSerivce.productMinus("상품2",200L);
    }

    @Test
    public void getDetailByName(){
        tempUserSerivce.getDetailByName("상품3");
    }
}
