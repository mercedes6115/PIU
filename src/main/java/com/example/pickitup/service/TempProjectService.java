package com.example.pickitup.service;


import com.example.pickitup.domain.dao.project.projectFile.ProjectFileDAO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor



public class TempProjectService {
    private final ProjectFileDAO projectFileDAO;

    public ProjectFileVO getThumbnail(Long projectNum) { return projectFileDAO.findByProjectNum(projectNum);}
}
