package com.example.pickitup.service.product.productFile;

import com.example.pickitup.domain.dao.product.productFile.ProductDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;


    // 상품 목록
    public List<ProductVO> getList(String category){
        return productDAO.getList(category);
    }
    // 상품 디테일
    public ProductVO getDetail(Long num){
        return productDAO.getDetail(num);
    }

    // 상품 목록 - 관리자용
//    public List<ProductVO> getProductList(Criteria criteria){
//        return productDAO.getProductList(criteria);
//    }

    // 상품 등록하기 - 관리자용
    public void register(ProductVO productVO){
        productDAO.register(productVO);
    }

    // 상품 수정하기 - 관리자용
    public boolean update(ProductVO productVO){
        return productDAO.update(productVO);
    }

    // 상품 삭제하기 - 관리자용
    public boolean remove(Long num){
        return productDAO.remove(num);
    }


    // 상품 개수 - 관리자용
    public int count(){
        return productDAO.count();
    }

}
