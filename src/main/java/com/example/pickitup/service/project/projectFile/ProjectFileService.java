package com.example.pickitup.service.project.projectFile;

import com.example.pickitup.domain.dao.project.projectFile.ProjectFileDAO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectFileService {

    private final ProjectFileDAO projectFileDAO;
    // 파일 경로 가져오기
    public List<ProjectFileVO> findProjectReviewNum(Long num) {
        return projectFileDAO.findProjectNum(num);
    }

    // 해당 후기글 작성 도중 창을 이동할 경우 저장 경로에서 사진 지우기
    public List<ProjectFileVO> getOldFiles(){
        return projectFileDAO.getOldFiles();
    }

    // 사진 등록
    public void register(ProjectFileVO ProjectFileVO){
        projectFileDAO.register(ProjectFileVO);
    };

    // 사진 삭제 (mapper 매개변수 수정)
    public void remove(Long projectNum){
        projectFileDAO.remove(projectNum);
    }
}
