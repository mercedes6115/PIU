package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/projectQnA/*")
@RequiredArgsConstructor
public class ProjectQnARestController {
    private final ProjectService projectService;

    // 댓글 등록
    @PostMapping("/add")
    public void register(@RequestBody ProjectQnaCommentVO projectQnaCommentVO){
        log.info("content" + projectQnaCommentVO.getContent());
        log.info("vo:      " + projectQnaCommentVO.getQnaNum());
//        projectService.registerComment(projectQnaCommentVO);
    }

    // 댓글 목록
    @GetMapping("/commentList/{qnaNum}")
    public List<ProjectQnaCommentVO> getComment(@PathVariable("qnaNum") Long qnaNum){
        return projectService.getCommentList(qnaNum);
    }



}
