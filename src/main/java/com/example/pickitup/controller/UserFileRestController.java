package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.TempUserSerivce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/userFile/*")
@RequiredArgsConstructor
public class UserFileRestController {
    private final TempUserSerivce tempUserSerivce;

    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException {
        File file = new File("C:/upload/", fileName);
        log.info(file.getPath());
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

    @GetMapping("/profile/{num}")
    @ResponseBody
    public UserVO readUserInfo(@PathVariable("num") Long num){
        return tempUserSerivce.readUserInfo(num);
    }
}
