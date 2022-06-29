package com.example.pickitup.service.product.productFile;

import com.example.pickitup.domain.dao.product.productFile.ProductFileDAO;
import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductFileService {
    private final ProductFileDAO productFileDAO;

    // 파일 경로 가져오기
    public List<ProductFileVO> findByProductNum(Long productNum) {
        return productFileDAO.findByProductNum(productNum);
    }

    // 해당 후기글 작성 도중 창을 이동할 경우 저장 경로에서 사진 지우기
    public List<ProductFileVO> getOldFiles(){
        return productFileDAO.getOldFiles();
    }

    // 사진 등록
    public void register(ProductFileVO productFileVO){
        productFileDAO.register(productFileVO);
    };

    // 사진 삭제(mapper 매개변수 수정)
    public void remove(Long productNum){
        productFileDAO.remove(productNum);
    }
}
