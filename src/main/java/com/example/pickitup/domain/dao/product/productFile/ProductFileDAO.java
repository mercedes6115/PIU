package com.example.pickitup.domain.dao.product.productFile;

import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import com.example.pickitup.mapper.product.productFile.ProductFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductFileDAO {

    private final ProductFileMapper productFileMapper;

    // 파일 경로 가져오기
    public List<ProductFileVO> findByProductNum(Long productNum) {

        return productFileMapper.findByProductNum(productNum);
    }

    // 해당 후기글 작성 도중 창을 이동할 경우 저장 경로에서 사진 지우기
    public List<ProductFileVO> getOldFiles(){
        return productFileMapper.getOldFiles();
    }

    // 사진 등록
    public void register(ProductFileVO productFileVO){
        productFileMapper.insert(productFileVO);
    };

    // 사진 삭제(mapper 매개변수 수정)
    public void remove(Long productNum){
        productFileMapper.delete(productNum);
    }
}
