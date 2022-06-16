package com.example.pickitup.mapper.product.productFile;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    //    프로젝트 전부 띄우기
    public List<ProductVO> getList();

    //
    public List<ProductVO> getProductList(Criteria criteria);

    //    프로젝트 한개만 띄우기
    public ProductVO getDetail(Long num);

    //    프로젝트 등록하기
    public void insert(ProductVO productVO);

    //    프로젝트 수정하기
    public boolean update(ProductVO productVO);

    //    프로젝트 삭제하기
    public boolean delete(Long num);
}
