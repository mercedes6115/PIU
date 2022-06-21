package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.product.productFile.ProductFileVO;
import com.example.pickitup.service.product.productFile.ProductFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/productReviewFile/*")
@RequiredArgsConstructor
public class ProductReviewFileRestController {
    private final ProductFileService productFileService;

}
