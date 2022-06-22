package com.example.pickitup.domain.dao.project.projectFile;

import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import com.example.pickitup.mapper.project.projectFile.ProjectFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class ProjectFileDAO {

    private final ProjectFileMapper projectFileMapper;
    // 파일 경로 가져오기
    public List<ProjectFileVO> findByProjectNum(Long num) {
        return projectFileMapper.findByProjectNum(num);
    }

    // 해당 후기글 작성 도중 창을 이동할 경우 저장 경로에서 사진 지우기
    public List<ProjectFileVO> getOldFiles(){
        return projectFileMapper.getOldFiles();
    }

    // 사진 등록
    public void register(ProjectFileVO ProjectFileVO){
        projectFileMapper.insert(ProjectFileVO);
    };

    // 사진 삭제 (mapper 매개변수 수정)
    public void remove(Long projectNum){
        projectFileMapper.delete(projectNum);
    }
}
