package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.user.CompanyVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/groupFile/*")
@RequiredArgsConstructor
public class GroupFileRestController {

    @PostMapping("/upload")
    @ResponseBody
    public CompanyVO upload(MultipartFile[] uploadFiles) throws IOException {
        String uploadFolder = "C:/upload/";
        CompanyVO companyVO = new CompanyVO();

//        yyyy/MM/dd 경로 만들기
        File uploadPath = new File(uploadFolder, getFolder());
        if(!uploadPath.exists()){uploadPath.mkdirs();}

        for(MultipartFile file : uploadFiles){
            String uploadFileName = file.getOriginalFilename();

            UUID uuid = UUID.randomUUID();
            companyVO.setProfileUploadPath(getFolder());

            uploadFileName = uuid.toString() + "_" + uploadFileName;
            companyVO.setProfileFileName(uploadFileName);

            File saveFile = new File(uploadPath, uploadFileName);
            file.transferTo(saveFile);
        }

        return companyVO;
    }

    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException{
        File file = new File("C:/upload/", fileName);
        return FileCopyUtils.copyToByteArray(file);
    }

    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return sdf.format(date);
    }

    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(String fileName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/" + fileName);
        HttpHeaders header = new HttpHeaders();
        String name = resource.getFilename();
        name = name.substring(name.indexOf("_") + 1);
        header.add("Content-Disposition", "attachment;filename="+ new String(name.getBytes("UTF-8"), "ISO-8859-1"));
        return new ResponseEntity<>(resource, header, HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(String fileName){
        File file = new File("C:/upload/", fileName);
        if(file.exists()){ file.delete(); }

        file = new File("C:/upload/", fileName.replace("s_", ""));
        if(file.exists()){ file.delete(); }
    }

}
