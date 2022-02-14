package com.linkedin.linkedinProject.controller;

import com.linkedin.linkedinProject.model.Skills;
import com.linkedin.linkedinProject.repository.LoginRepository;
import com.linkedin.linkedinProject.repository.SkillsRepository;
import com.linkedin.linkedinProject.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
public class SkillsController {

    @Autowired
    private SkillsRepository skillsRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private SkillsService service;

    @PostMapping("/add-skill/{id}")
    @Transactional
    public Skills addSkill(@PathVariable int id, @RequestBody Skills skills) throws Exception{
       String skill= skills.getSkill();
    	if(loginRepository.existsById(id) && 
        		!skillsRepository.existsByUserAndSkill(loginRepository.findById(id),skill)) {
    		return service.saveMySkill(id, skill);
    		
    	}
    	else
    		throw new Exception("Skill already exists");

    }
    
    @GetMapping("/display-skill/{id}")
    @Transactional
    public Skills[] displaySkills(@PathVariable int id) {
    	
    	return service.fetchByUserAndSkill(id);
    }
    
    @GetMapping("/delete-skill/{id}/{sid}")
    @Transactional
    public Skills[] deleteSkill(@PathVariable int id, @PathVariable int sid) throws Exception{
    	
    	        return service.deleteSkill(id, sid);
    	        
    	    }
    
    
//    @DeleteMapping("/delete-skill/{id}/{sid}")
//    @Transactional
//    public void deleteSkill(@PathVariable int id, @PathVariable int sid) throws Exception{
//
//        service.deleteSkill(id, sid);
//    }

//    @PutMapping("/update-skill")
//    public void updateSkill(@PathVariable int id,@RequestBody Skills skill){
//
//        service.updateSkill(id, skill);
//    }
}
