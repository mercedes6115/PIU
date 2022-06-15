package com.example.pickitup.mapper.product.productFile;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public List<ProductVO> getList();
}
