package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.AdminCriteria;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.dto.AdminQnaCommentDTO;
import com.example.pickitup.domain.vo.dto.AdminQnaDTO;
import com.example.pickitup.domain.vo.product.productQna.ProductQnaCommentVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
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
    public void checkNicknameTest(){
        userMapper.nicknameMatching("짜리킴");
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
//        UserVO userVO = new UserVO();
//        userVO.setNum(2L);
//        userVO.setEmail("test@naber.com");
//        userVO.setPassword("test");
//        userVO.setNickname("test");
//        userVO.setPhone("01000000000");
//        userVO.setAddress("서울특별시 강남구 역삼동");
//        userVO.setProfileFileName("aaaa");
//        userVO.setProfileUploadPath("bbbb");
//        log.info("수정"+ userMapper.update(userVO));
        UserVO userVO = userMapper.getDetail(41L);
        userVO.setNickname("임진석7");
        userVO.setPhone("010-1234-1234");
        userVO.setAddress("서울특별시");
        userVO.setAddressDetail("어딘가");
        userVO.setPassword("12344321");
        log.info("결과 : " + userVO);
        userMapper.update(userVO);
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
        criteria.setType("user");
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
        userMapper.getNoticeList(new AdminCriteria(1, 10));

    }

    //공지상세보기
    @Test
    public void getNoticeDetailTest(){
        Long num = 34L;
        log.info(userMapper.getNoticeDetail(num).toString());
        log.info("***************************************************");
        log.info(userMapper.getNoticeDetail(34L).getContent());
        log.info("***************************************************");
    }

    //공지사항 개수
    @Test
    public void getNoticeTotalTest(){
        userMapper.getNoticeTotal(new AdminCriteria(1,10));
    }

    //ADMINBOARD에 총 게시글 수 가져오기
    @Test
    public void getAdminBoardCountTest(){
        userMapper.getAdminBoardCount(new AdminCriteria(1,10));
    }

    //ADMINBOARD에 게시글 리스트 가져오기
    @Test
    public void getAdminboardListTest() {
        userMapper.getAdminboardList(new AdminCriteria(1,10));
    }

    //adminboard에서 선택한글 삭제 하기
    @Test
    public void getDeleteByIdTest(){
        userMapper.deleteById(50L);
    }

    @Test
    public void getNoticeCancelTest(){
        userMapper.noticeCancel(58L);
    }

    @Test
    public void getNoticeConfirmTest(){
        userMapper.noticeConfirm(58L);
    }

    @Test
    public void getGetQnaReplyTest(){
        userMapper.getQnaReply(125L);
    }

    @Test
    public void getprojectQnaReplyTest() {
        AdminQnaCommentDTO adminQnaCommentDTO = new AdminQnaCommentDTO();
        adminQnaCommentDTO.setContent("시작시간은 오후12시입니다.");
        adminQnaCommentDTO.setUserNum(0L);
        adminQnaCommentDTO.setQnaNum(1L);
        userMapper.projectQnaReply(adminQnaCommentDTO);
//        ProjectQnaCommentVO projectQnaCommentVO = new ProjectQnaCommentVO();
//        projectQnaCommentVO.setContent("시작시간은 오후12시입니다.");
//        projectQnaCommentVO.setUserNum(0L);
//        projectQnaCommentVO.setQnaNum(1L);
//        userMapper.projectQnaReply(projectQnaCommentVO);
    }

    @Test
    public void getproductQnaReplyTest() {
        AdminQnaCommentDTO adminQnaCommentDTO = new AdminQnaCommentDTO();
        adminQnaCommentDTO.setContent("오늘 배송됩니다.");
        adminQnaCommentDTO.setUserNum(0L);
        adminQnaCommentDTO.setQnaNum(1L);
        userMapper.productQnaReply(adminQnaCommentDTO);
    }

    @Test
    public void answerCompleteTest() {
        userMapper.answerComplete(4L);
    }

    @Test
    public void qnaSaveTest() {
        AdminQnaDTO adminQnaDTO = new AdminQnaDTO();
        adminQnaDTO.setContent("이 상품 언제 배송 도착하나요?");
        adminQnaDTO.setUserNum(1L);
        adminQnaDTO.setProductNum(1L);
        userMapper.qnaStoreSave(adminQnaDTO);
    }

    @Test
    public void productQnaDelete() {
        Long num = 63L;
        userMapper.productQnaDelete(num);
    }

    @Test
    public void getMyProjectQnaTest() {userMapper.getMyProjectQna(2L);}

    @Test
    public void getMyProductQnaTest() {userMapper.getMyProductQna(2L);}

    @Test
    public void getProjectQnaComment() {userMapper.myProjectQnaComment(1L);}

    @Test
    public void getProductQnaComment() {userMapper.myProductQnaComment(13L);}

    @Test
    public void getMyAllReview() {
        userMapper.myAllReview(2L);
    }
}





