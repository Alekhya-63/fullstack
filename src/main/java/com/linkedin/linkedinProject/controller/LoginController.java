package com.linkedin.linkedinProject.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.linkedin.linkedinProject.model.Login;
import com.linkedin.linkedinProject.repository.LoginRepository;
import com.linkedin.linkedinProject.service.LoginService;

//import com.linkedin.linkedinProject.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginRepository repo;
	
	@Autowired
	private LoginService service;
	
	
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
	@Transactional
	public void registerUser(@RequestBody Login user) throws Exception {
		String t=user.getEmailId();
		if(t != null && !"".equals(t)) {
			Login userObj = service.fetchByEmailId(t);
			if(userObj != null) {
				throw new Exception("user with  is already exists");
			}
		}
		service.saveMyUser(user);
	   // return "Hello "+user.getEmailId()+"password is "+user.getPassword();
	    
	}


	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	@Transactional
	public Login loginUser(@RequestBody Login user) throws Exception {
		String tid = user.getEmailId();
		String tpass = user.getPassword();
		Login obj=null;
		if(tid != null && tpass != null) {
			obj = service.fetchByEmailIdAndPassword(tid, tpass);
		}
		if(obj == null) {
			throw new Exception("Should Not be empty");
		}
		return obj;
	}
	@GetMapping("/all-users")
	public Iterable<Login> showAllUsers(){
		return service.showAllUsers();
	}
	
	@GetMapping("/delete-user/{user}")
	@Transactional
	public Iterable<Login> deleteUser(@PathVariable String user){
		return service.deleteUser(user);
		
	}
}

