package com.example.pickitup.service;


import com.example.pickitup.domain.dao.product.productFile.ProductDAO;
import com.example.pickitup.domain.dao.product.productFile.ProductFileDAO;
import com.example.pickitup.domain.dao.product.productQna.ProductQnaCommentDAO;
import com.example.pickitup.domain.dao.product.productQna.ProductQnaDAO;
import com.example.pickitup.domain.dao.product.productReview.ProductReviewDAO;
import com.example.pickitup.domain.dao.product.productReview.ProductReviewFileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductFileDAO productFileDAO;
    private final ProductDAO productDAO;
    private final ProductQnaCommentDAO productQnaCommentDAO;
    private final ProductQnaDAO productQnaDAO;
    private final ProductReviewFileDAO productReviewFileDAO;
    private final ProductReviewDAO productReviewDAO;
}
