package com.linkedin.linkedinProject.controller;

import com.linkedin.linkedinProject.model.Education;
import com.linkedin.linkedinProject.repository.EducationRepository;
import com.linkedin.linkedinProject.repository.LoginRepository;
import com.linkedin.linkedinProject.service.EducationService;
//
//import src.main.java.com.in28minutes.springboot.web.springbootfirstwebapplication.controller.CustomDateEditor;
//import src.main.java.com.in28minutes.springboot.web.springbootfirstwebapplication.controller.InitBinder;
//import src.main.java.com.in28minutes.springboot.web.springbootfirstwebapplication.controller.SimpleDateFormat;
//import src.main.java.com.in28minutes.springboot.web.springbootfirstwebapplication.controller.WebDataBinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

@RestController
public class EducationController {

    @Autowired
    private EducationService service;

    @Autowired
    private LoginRepository loginRepository;
    
    @Autowired
    private EducationRepository repo;

	

    @PostMapping("/edu-add/{id}")
    @Transactional
    public Education addEducationDetails(@PathVariable int id, @RequestBody Education edu) throws Exception{

        String name = edu.getEduName();
        String degree = edu.getDegree();
        String field = edu.getField();
        Date eduStart = edu.getEduStart();
        Date eduStop = edu.getEduStop();
        String grade = edu.getGrade();
       if(loginRepository.existsById(id)) {
        	return service.saveMyEdu(id, name, degree, field, eduStart, eduStop, grade);
        }
        else
        	throw new Exception("Education details already exists.");
      
    }

    @PutMapping("/edu-edit/{id}/{eid}")
    @Transactional
    public Education updateEdu(@PathVariable int id, @PathVariable int eid, @RequestBody Education edu){
    	
        return service.updateEdu(id, eid, edu );

    }
    
    @GetMapping("/edu-delete/{id}/{eid}")
    @Transactional
    public Education[] deleteEdu(@PathVariable int id, @PathVariable int eid) {
    	return service.deleteEducation(id, eid);
    }
    
    @GetMapping("/edu-display/{id}")
    @Transactional
    public Education[] displayEdu(@PathVariable int id) {
    	return service.displayEdu(id);
    }
//
//    @PostMapping("/delete-edu")
//    @Transactional
//    public void deleteEdu(@PathVariable int id)
//    {
//        service.deleteEdu(id);
//
//    }
}
