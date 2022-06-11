package com.example.pickitup.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/project/*")
public class ProjectController {

    @GetMapping("/projectDetail")
    public void projectDetail() {;}
}
