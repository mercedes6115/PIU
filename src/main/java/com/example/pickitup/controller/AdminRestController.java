package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/adminR/*")
@RequiredArgsConstructor
public class AdminRestController {


    // qr생성
    @PostMapping("/qr")
    public void addQr(){

    }

    // 관리자 프로젝트 승인
    @GetMapping("/approveProject")
    public void approveProject(){

    }

    // 관리자 단체유저 승인
    @GetMapping("/approveProduct")
    public void approveProduct(){

    }

    // 문의글 답변
    @PostMapping("/comment")
    public void addComment(){

    }

    //관리자 프로젝트 생성
    @PostMapping("/create")
    @ResponseBody
    public String projectUpload(ProjectFileVO projectFileVO, MultipartFile file, HttpServletRequest request) throws ServletException,IOException {
        log.info("============================ 컨트롤러 오는거까진 성공");

        String test1 = request.getParameter("endAddress");
        Collection<Part> parts = request.getParts();
        log.info("====="+test1);
        log.info("====="+parts);
        return "project create complete";
    }

    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return sdf.format(date);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> piu5
