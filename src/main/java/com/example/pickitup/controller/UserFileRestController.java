package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import com.example.pickitup.domain.vo.user.UserVO;
import com.example.pickitup.service.TempUserSerivce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @PostMapping("/upload")
    @ResponseBody
    public Object upload(MultipartFile uploadFile) throws IOException {
        String uploadFolder = "C:/upload/";
//        yyyy/MM/dd 경로 만들기
        File uploadPath = new File(uploadFolder, getFolder());
        if(!uploadPath.exists()){uploadPath.mkdirs();}
        Map<String,Object> map=new HashMap<String, Object>();

        UserVO userVO=new UserVO();
        String uploadFileName = uploadFile.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        uploadFileName = uuid.toString() + "_" + uploadFileName;
        map.put("profileUploadPath",getFolder());
        map.put("profileFileName",uploadFileName);

//        userVO.setProfileFileName(uploadFileName);
//        userVO.setProfileUploadPath(getFolder());

        log.info("--------------------------------");
        log.info("Upload File Name : " + uploadFileName);

        File saveFile = new File(uploadPath, uploadFileName);
        uploadFile.transferTo(saveFile);

        return map;

    }

    //기업 회원가입 파일처리 메서드
    @PostMapping("/businessFileUpload")
    @ResponseBody
    public Object businessFileUpload(MultipartFile uploadFile) throws IOException{
        String uploadFolder="C:/upload/";
        //        yyyy/MM/dd 경로 만들기
        File uploadPath = new File(uploadFolder, getFolder());
        if(!uploadPath.exists()){uploadPath.mkdirs();}

//        uploadFile.transferTo(new File(uploadFolder+"/"+uploadPath+ uploadFile.getOriginalFilename()));

        Map<String,Object> map=new HashMap<String, Object>();

        UserVO userVO=new UserVO();
        String uploadFileName = uploadFile.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        uploadFileName = uuid.toString() + "_" + uploadFileName;
        map.put("profileUploadPath",getFolder());
        map.put("profileFileName",uploadFileName);

//        userVO.setProfileFileName(uploadFileName);
//        userVO.setProfileUploadPath(getFolder());

        log.info("--------------------------------");
        log.info("Upload File Name : " + uploadFileName);

        File saveFile = new File(uploadPath, uploadFileName);
        uploadFile.transferTo(saveFile);

        return map;

    }

}
