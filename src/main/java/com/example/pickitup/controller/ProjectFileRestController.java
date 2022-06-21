package com.example.pickitup.controller;


import com.example.pickitup.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/projectFile/*")
@RequiredArgsConstructor
public class ProjectFileRestController {

    private final ProjectService projectService;


}


