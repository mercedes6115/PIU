package com.example.pickitup.domain.dao.product.productFile;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.ProductCriteria;
import com.example.pickitup.domain.vo.dto.ProductDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.mapper.product.productFile.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

    // 상품 목록
    public List<ProductVO> getList(String category){
        return productMapper.getList(category);
    }
    //상품 하나의 디테일
    public ProductVO getDetail(Long num){
        return productMapper.getDetail(num);
    }

    public List<ProductVO> getFullList(){
        return productMapper.getFullList();
    }
    // 상품 목록 - 관리자용
    public List<ProductVO> getProductList(ProductCriteria productCriteria){
        return productMapper.getProductList(productCriteria);
    }

    // 상품 전체 개수 가져오기 - 관리자용
    public int getTotal(){
        return  productMapper.getTotal();
    }
    // 상품 등록하기 - 관리자용
    public void register(ProductVO productVO){
        productMapper.insert(productVO);
    }

    // 상품 수정하기 - 관리자용
    public boolean update(ProductVO productVO){
        return productMapper.update(productVO);
    }

    // 상품 삭제하기 - 관리자용
    public boolean remove(Long num){
        return productMapper.deleteProduct(num);
    }


    // 상품 개수 - 관리자용
    public int count(){
        return productMapper.count();
    }


}
