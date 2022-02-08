package com.linkedin.linkedinProject.controller;

import com.linkedin.linkedinProject.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillsController {

    @Autowired
    private SkillsService service;



}
