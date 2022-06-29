package com.example.pickitup.mapper.product.productFile;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.ProductCriteria;
import com.example.pickitup.domain.vo.dto.ProductDTO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    //    상품 전부 띄우기
    public List<ProductVO> getList(String category);

    //
    public List<ProductVO> getProductList(ProductCriteria productCriteria);

    public int getTotal();

    public List<ProductVO> getFullList();

    //    상품 한개만 띄우기 (상세보기)
    public ProductVO getDetail(Long num);

    //    상품 등록하기 ->관리자
    public void insert(ProductVO productVO);

    //    상품 수정하기 ->관리자
    public boolean update(ProductVO productVO);

    //    상품 삭제하기 ->관리자

    public boolean deleteProduct(Long num);

    public boolean delete(Long num);

    // 상품 전체 개수
    public int count();

}
