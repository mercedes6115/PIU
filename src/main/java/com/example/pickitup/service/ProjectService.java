package com.example.pickitup.service;

import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import com.example.pickitup.domain.dao.project.projectFile.ProjectFileDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaCommentDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaDAO;
import com.example.pickitup.domain.dao.project.projectReview.ProjectReviewDAO;
import com.example.pickitup.domain.dao.project.projectReview.ProjectReviewFileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectFileDAO projectFileDAO;
    private final ProjectDAO projectDAO;
    private final ProjectQnaCommentDAO projectQnaCommentDAO;
    private final ProjectQnaDAO projectQnaDAO;
    private final ProjectReviewFileDAO projectReviewFileDAO;
    private final ProjectReviewDAO projectReviewDAO;
}
