package com.example.pickitup.service;


import com.example.pickitup.domain.dao.product.productFile.ProductDAO;
import com.example.pickitup.domain.dao.product.productFile.ProductFileDAO;
import com.example.pickitup.domain.dao.product.productQna.ProductQnaCommentDAO;
import com.example.pickitup.domain.dao.product.productQna.ProductQnaDAO;
import com.example.pickitup.domain.dao.product.productReview.ProductReviewDAO;
import com.example.pickitup.domain.dao.product.productReview.ProductReviewFileDAO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.service.product.productQna.ProductQnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TempProductService {
    private final ProductDAO productDAO;
    private final ProductFileDAO productFileDAO;

    private final ProductQnaDAO productQnaDAO;
    private final ProductQnaCommentDAO productQnaCommentDAO;

    private final ProductReviewDAO productReviewDAO;
    private final ProductReviewFileDAO productReviewFileDAO;


    public List<ProductVO> getFullList(){
        return productDAO.getFullList();
    }


}
