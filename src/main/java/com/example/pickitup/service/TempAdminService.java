package com.example.pickitup.service;
import com.example.pickitup.domain.dao.product.productFile.ProductDAO;
import com.example.pickitup.domain.dao.product.productFile.ProductFileDAO;
import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import com.example.pickitup.domain.dao.project.projectFile.ProjectFileDAO;
import com.example.pickitup.domain.dao.user.*;
import com.example.pickitup.domain.vo.AdminCriteria;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.OrderCriteria;
import com.example.pickitup.domain.vo.ProductCriteria;
import com.example.pickitup.domain.vo.adminVO.AdminBoardDTO;
import com.example.pickitup.domain.vo.dto.*;
import com.example.pickitup.domain.vo.dto.OrderDTO;
import com.example.pickitup.domain.vo.dto.*;
import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TempAdminService {
    private final UserDAO userDAO;
    private final ApplyDAO applyDAO;
    private final JjimDAO jjimDAO;
    private final LatestDAO latestDAO;
    private final OrderDAO orderDAO;
    private final CompanyDAO companyDAO;
    private final ProductDAO productDAO;
    private final ProductFileDAO productFileDAO;
    private final ProjectDAO projectDAO;
    private final ProjectFileDAO projectFileDAO;








    // applyDAO
    // 프로젝트 참가 정보 확인
    public ApplyVO read(Long num){
        return applyDAO.read(num);
    }

    @Transactional
    public boolean autoPoint(String point, Long userNum,Long applyNum){
        applyDAO.setApproach(applyNum);
        return userDAO.autoPoint(point,userNum);
    }

    // 프로젝트 참가자 정보 수정(완수여부)
    public boolean update(Long approach, Long userNum){
        return applyDAO.update(approach, userNum);
    }


    public List<ApplyDTO> getApplyUser(Long projectNum){
        return applyDAO.getApplyUser(projectNum);
    }

    // userDAO
    // 유저 목록
    public List<UserDTO> getList(Criteria criteria) {
        return userDAO.getList(criteria);
    }


    public int getTotal(Criteria criteria){
        return userDAO.getTotal(criteria);
    }

    // 유저 상세보기
    public UserVO readUserInfo(Long num) {
        return userDAO.read(num);
    }

    // 유저 정보 수정
    public boolean updateUserInfo(UserVO userVO) {
        return userDAO.update(userVO);
    }

    // 유저 탈퇴
    public boolean removeUser(Long num) {
        return userDAO.remove(num);
    }

    @Transactional
    public boolean addPoint(String nickname,String point,Long applynum1){
        applyDAO.setApproach(applynum1);
        return userDAO.addPoint(nickname,point);
    }
    // 상품목록 가져오기 관리자용
    public List<ProductVO> getProductList(ProductCriteria productCriteria){
        return productDAO.getProductList(productCriteria);
    }

    // 전체개수 가져오기 관리자용
    public int getTotal(){
        return productDAO.getTotal();
    }




    // companyDAO
    // 단체 목록
//    public List<CompanyVO> getList(){
//        return companyDAO.getList();
//    }


    // jjimDAO
    // 유저들 찜 목록

    // latestDAO
    // 유저들 최근에 본 게시물 목록


    // productDAO
    // 상품 목록 - 관리자용
//    public List<ProductVO> getProductList(Criteria criteria){
//        return productDAO.getProductList(criteria);
//    }



    // 상품 등록하기 - 관리자용
    public void registerProduct(ProductVO productVO){
        productDAO.register(productVO);
    }

    // 상품 수정하기 - 관리자용
    public boolean updateProduct(ProductVO productVO){
        return productDAO.update(productVO);
    }

    // 상품 삭제하기 - 관리자용
    public boolean removeProduct(Long num){
        return productDAO.remove(num);
    }

    // 프로젝트 삭제
    public boolean deleteProject(Long num)
    {
        return projectDAO.remove(num);
    }

    //프로젝트 승인

    public boolean approveProject(Long num){return projectDAO.approveProject(num);}

    public boolean disapproveProject(Long num){ return  projectDAO.disapproveProject(num);}

    public boolean awaitProject(Long num){ return  projectDAO.awaitProject(num);}


    // productFileDAO
    // 파일 경로 가져오기 -> mapper 수정
    public List<ProductFileVO> findByProductNum(Long productNum) {
        return productFileDAO.findByProductNum(productNum);
    }

    // 해당 후기글 작성 도중 창을 이동할 경우 저장 경로에서 사진 지우기
    public List<ProductFileVO> getOldFilesProductImg(){
        return productFileDAO.getOldFiles();
    }

    // 사진 등록
    public void registerProductImg(ProductFileVO productFileVO){
        productFileDAO.register(productFileVO);
    };

    // 사진 삭제(mapper 매개변수 수정)
    public void removeProductImg(Long productNum){
        productFileDAO.remove(productNum);
    }


    // orderDAO
    // 주문 목록 (mapper 추가 및 변경)
    public List<OrderDTO> getOrderList(OrderCriteria orderCriteria){
        return orderDAO.getList(orderCriteria);
    }

    //한달치 주문내역을 가져옴
    public List<OrderDTO> getListToday(String startDate,String endDate){
        return orderDAO.getListToday(startDate,endDate);
    }
    //관리자 공지 등록
    public void registerWrite(AdminBoardVO adminBoardVO) {
        userDAO.registerWrite(adminBoardVO);
    }

    //관리자 공지 리스트
    public List<AdminBoardDTO> getNoticeList(AdminCriteria adminCriteria){
        return userDAO.getNoticeList(adminCriteria);
    }

    //관리자 공지 상세보기
    public AdminBoardVO getReadDetail(Long num){
        return userDAO.getReadDetail(num);
    }

    //관리자 공지 총 개수
    public int getNoticeTotal(AdminCriteria adminCriteria) {
        return userDAO.getNoticeTotal(adminCriteria);
    }

    //관리자 adminboard 게시글 총 개수
    public int getAdminBoardCount(AdminCriteria adminCriteria) {
        return userDAO.getAdminBoardCount(adminCriteria);
    }

    //관리자 adminboard 글 리스트 뽑아오기
    public List<AdminBoardVO> getAdminboardList(AdminCriteria adminCriteria){
        return userDAO.getAdminboardList(adminCriteria);
    }

    //관리자 adminboard 글 삭제하기
    public int deleteById(Long num) {
        return userDAO.deleteById(num);
    }

    //관리자 adminboard 글 공지 해제 하기
    public int noticeCancel(Long num){
        return userDAO.noticeCancel(num);
    }

    //관리자 adminboard 글 공지 지정 하기
    public int noticeConfirm(Long num){
        return userDAO.noticeConfirm(num);
    }

    //관리자 게시물 관리에서 상세보기
    public AdminBoardPageDTO getQnaReply(Long num){
        return userDAO.getQnaReply(num);
    }

    //관리자 프로젝트 문의에 댓글 달기
    public void getProjectQnaReply(AdminQnaCommentDTO adminQnaCommentDTO){
        userDAO.projectQnaReply(adminQnaCommentDTO);
    }

    //관리자 상품 문의에 댓글 달기
    public void getProductQnaReply(AdminQnaCommentDTO adminQnaCommentDTO){
        userDAO.productQnaReply(adminQnaCommentDTO);
    }

    //관리자 문의에 댓글 달고 난후 게시물의 answerStatus 2로 변경
    public void changeAnswerStatus(Long num){
        userDAO.answerComplete(num);
    }

    //유저가 상품 문의 남겼을때 adminboard 에도 저장
    public void qnaStoreSave(AdminQnaDTO adminQnaDTO){
        userDAO.qnaStoreSave(adminQnaDTO);
    }

    //유저가 프로젝트 문의 남겼을때 adminboard 에도 저장
    public void qnaProjectSave(AdminQnaDTO adminQnaDTO) {
        userDAO.qnaProjectSave(adminQnaDTO);
    }

    //유저가 상품 문의 수정했을때 adminboard 에도 수정
    public boolean qnaStoreModify(AdminQnaDTO adminQnaDTO) {
        return userDAO.qnaStoreModify(adminQnaDTO);
    }

    //유저가 프로젝트 문의 수정했을때 adminboard 에도 수정
    public boolean qnaProjectModify(AdminQnaDTO adminQnaDTO) {
        return userDAO.qnaProjectModify(adminQnaDTO);
    }

    //관리자가 게시물 목록에서 상품문의 삭제 했을때 productQnA 테이블에서 삭제
    public void productQnaDelete(Long num) {
        userDAO.productQnaDelete(num);
    }

    //관리자가 게시물 목록에서 프로젝트문의 삭제 했을때 projectQnA 테이블에서 삭제
    public void projectQnaDelete(Long num) {
        userDAO.projectQnaDelete(num);
    }


    // 관리자 단체,일반유저 승인/거절 활성화/비활성화

    public boolean UserStatusDisable(Long num) {// 비활성화
        return userDAO.UserStatusDisable(num);
    }
    public boolean UserStatusEnable(Long num) {// 비활성화
        return userDAO.UserStatusEnable(num);
    }
    public boolean UserApprovalDisable(Long num) {// 비활성화
        return userDAO.UserApprovalDisable(num);
    }
    public boolean UserApprovalEnable(Long num) {// 비활성화
        return userDAO.UserApprovalEnable(num);
    }

    public boolean CompanyStatusDisable(Long num) {// 비활성화
        return companyDAO.companyStatusDisable(num);
    }
    public boolean CompanyStatusEnable(Long num) {// 비활성화
        return companyDAO.companyStatusEnable(num);
    }
    public boolean CompanyApprovalDisable(Long num) {// 비활성화
        return companyDAO.companyApprovalDisable(num);
    }
    public boolean CompanyApprovalEnable(Long num) {// 비활성화
        return companyDAO.companyApprovalEnable(num);
    }


    public OrderVO getOrderDetail(Long orderNum){
        return orderDAO.getOrderDetail(orderNum);
    }

    public ProductVO getDetail(Long productNum){
        return productDAO.getDetail(productNum);
    }

    public boolean setDelivery(Long orderNum){
        return orderDAO.setDelivery(orderNum);
    }
}
