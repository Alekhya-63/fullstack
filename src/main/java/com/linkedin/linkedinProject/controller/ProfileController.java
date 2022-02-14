package com.linkedin.linkedinProject.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.linkedinProject.model.Profile;
import com.linkedin.linkedinProject.repository.LoginRepository;
import com.linkedin.linkedinProject.repository.ProfileRepository;
import com.linkedin.linkedinProject.service.ProfileService;

@RestController
public class ProfileController {

	@Autowired
	private ProfileRepository repo;
	
	 @Autowired
	    private LoginRepository loginRepository;
	 
	 @Autowired
	 private ProfileService service;
	 
	 @PostMapping("/add-profile/{id}")
	 @Transactional
	 public Profile addProfile(@PathVariable int id, @RequestBody Profile profile) {
		 String name = profile.getName();
		 String title = profile.getTitle();
		 String about = profile.getAbout();
		 String location = profile.getLocation();
		 return service.saveMyProfile(id, name, title, about, location);
	 }
	 
	 @PutMapping("/update-profile/{id}")
	 @Transactional
	 public Profile updateProfile(@PathVariable int id, @RequestBody Profile profile) {
		 String name = profile.getName();
		 String title = profile.getTitle();
		 String about = profile.getAbout();
		 String location = profile.getLocation();
		 return service.updateMyProfile(id, name, title, about, location);
	 }
	 
	 @GetMapping("/display-profile/{id}")
	 @Transactional
	 public Profile displayProfile(@PathVariable int id) {
		 return service.displayProfile(id);
	 }
}
