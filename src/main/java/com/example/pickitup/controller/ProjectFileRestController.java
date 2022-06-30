package com.example.pickitup.controller;


import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewFileVO;
import com.example.pickitup.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/projectFile/*")
@RequiredArgsConstructor
public class ProjectFileRestController {

    private final ProjectService projectService;


    @PostMapping("/upload")
    @ResponseBody
    public List<ProjectFileVO> upload(MultipartFile[] uploadFiles) throws IOException {
        String uploadFolder = "/Users/minmin/aigb_0900_sms/upload/";
        ArrayList<ProjectFileVO> files = new ArrayList<>();

//        yyyy/MM/dd 경로 만들기
        File uploadPath = new File(uploadFolder, getFolder());
        if(!uploadPath.exists()){uploadPath.mkdirs();}

        for(MultipartFile file : uploadFiles){
            ProjectFileVO projectFileVO = new ProjectFileVO();
            String uploadFileName = file.getOriginalFilename();

            UUID uuid = UUID.randomUUID();
            projectFileVO.setFileName(uploadFileName);
            projectFileVO.setUuid(uuid.toString());
            projectFileVO.setUploadPath(getFolder());

            uploadFileName = uuid.toString() + "_" + uploadFileName;

            File saveFile = new File(uploadPath, uploadFileName);
            file.transferTo(saveFile);

            files.add(projectFileVO);
        }

        return files;
    }

    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException{
        File file = new File("/Users/minmin/aigb_0900_sms/upload/", fileName);
        return FileCopyUtils.copyToByteArray(file);
    }

    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return sdf.format(date);
    }


    @PostMapping("/delete")
    @ResponseBody
    public void delete(String fileName){
        File file = new File("/Users/minmin/aigb_0900_sms/upload/", fileName);
        if(file.exists()){ file.delete(); }

    }

    @GetMapping("/list/{projectNum}")
    @ResponseBody
    public List<ProjectFileVO> getList(@PathVariable("projectNum") Long projectNum){
        return projectService.getProjectFileList(projectNum);
    }
}


