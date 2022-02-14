package com.linkedin.linkedinProject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.linkedinProject.model.Experience;
import com.linkedin.linkedinProject.repository.LoginRepository;
import com.linkedin.linkedinProject.service.ExperienceService;

@RestController
public class ExperienceController {

	@Autowired
	private ExperienceService service;

	@Autowired
	private LoginRepository loginRepository;
 
	@PostMapping("/add-exp/{id}")
	@Transactional
	public Experience addExp(@PathVariable int id, @RequestBody Experience exp) throws Exception {
		if(loginRepository.existsById(id)) {
			return service.saveMyExp(id, exp);
		}
		else
			throw new Exception("Experience already exists");
	}


	@PutMapping("/edit-exp/{id}/{eid}")
    @Transactional
	public Experience updateExp(@PathVariable int id, @PathVariable int eid, @RequestBody Experience exp) {
		return service.updateExp(id, eid, exp);
	}
	
	@GetMapping("/delete-exp/{id}/{eid}")
	@Transactional
	public Experience[] deleteExp(@PathVariable int id, @PathVariable int eid) {
		return service.deleteExp(id, eid);
	}
	
	@GetMapping("/display-exp/{id}")
	@Transactional
	public Experience[] displayExp(@PathVariable int id){
		return service.displayExp(id);
	}
}