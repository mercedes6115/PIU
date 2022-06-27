package com.example.pickitup.controller;


import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import com.example.pickitup.service.product.productFile.ProductFileService;

import com.example.pickitup.domain.vo.product.productReview.ProductReviewFileVO;
import com.example.pickitup.service.product.productReview.ProductReviewFileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
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
@RequestMapping("/productReviewFile/*")
@RequiredArgsConstructor
public class ProductReviewFileRestController {
    private final ProductReviewFileService productReviewFileService;

    @PostMapping("/upload")
    @ResponseBody
    public List<ProductReviewFileVO> upload(MultipartFile[] uploadFiles) throws IOException {
        log.info(uploadFiles[0].toString());
        String uploadFolder = "C:/upload";
        ArrayList<ProductReviewFileVO> files = new ArrayList<>();

//        yyyy/MM/dd 경로 만들기
        File uploadPath = new File(uploadFolder, getFolder());
        if(!uploadPath.exists()){uploadPath.mkdirs();}

        for(MultipartFile file : uploadFiles){
            ProductReviewFileVO productReviewFileVO = new ProductReviewFileVO();
            String uploadFileName = file.getOriginalFilename();

            UUID uuid = UUID.randomUUID();
            productReviewFileVO.setFileName(uploadFileName);
            productReviewFileVO.setUuid(uuid.toString());
            productReviewFileVO.setUploadPath(getFolder());
//          productReviewFileVO.setReviewNum(70L);

            uploadFileName = uuid.toString() + "_" + uploadFileName;

            log.info("--------------------------------");
            log.info("Upload File Name : " + uploadFileName);
            log.info("Upload File Size : " + file.getSize());

//            ProductReviewFileVO.setFileSize(file.getSize());

            File saveFile = new File(uploadPath, uploadFileName);
            file.transferTo(saveFile);

//            if(checkImageType(saveFile)){
//                FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
//                Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 100, 100);
//                thumbnail.close();
////                ProductReviewFileVO.setImage(true);
//            }
            files.add(productReviewFileVO);
//            productReviewFileService.register(productReviewFileVO);
        }
        return files;
    }

    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException{
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

        file = new File("C:/upload/", fileName.replace("_", ""));
        if(file.exists()){ file.delete(); }
    }

    @GetMapping("/list/{productReviewNum}")
    @ResponseBody
    public List<ProductReviewFileVO> findByProductReviewNum(@PathVariable("productReviewNum") Long productReviewNum){
        log.info("get file list....... : " + productReviewNum);
        return productReviewFileService.findByProductReviewNum(productReviewNum);
    }

}
