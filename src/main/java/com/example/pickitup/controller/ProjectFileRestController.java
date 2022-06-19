package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import com.example.pickitup.service.TempProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@Slf4j
@RequestMapping("/projectFile/*")
@RequiredArgsConstructor
public class ProjectFileRestController {
    private final TempProjectService tempProjectService;


    @GetMapping("/thumbnail")
    @ResponseBody
    public ProjectFileVO getThumbnail(Long projectNum) {
        return tempProjectService.getThumbnail(projectNum);
    }

    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException {
        File file = new File("C:/upload/", fileName);
        return FileCopyUtils.copyToByteArray(file);
    }

    private boolean checkImageType(File file) throws IOException{
        String contentType = Files.probeContentType(file.toPath());
        return contentType.startsWith("image");
    }

    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return sdf.format(date);
    }
}


