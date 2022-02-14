package com.linkedin.linkedinProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkedin.linkedinProject.model.Login;
import com.linkedin.linkedinProject.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;

    public LoginService() {
    	
    }
    
    public LoginService(LoginRepository repo) {
    	this.repo = repo;
    }
    
    public void saveMyUser(Login user) {
    	repo.save(user);
    }
    
    public Iterable<Login> showAllUsers(){
    	return repo.findAll();
    }
    public Iterable<Login> deleteUser(String user){
    	repo.deleteByEmailId(user);
    	return repo.findAll();
    }
    public Login fetchByEmailId(String email) {
    	return repo.findByEmailId(email);
    }

	public Login fetchByEmailIdAndPassword(String tid, String tpass) {
		// TODO Auto-generated method stub
		return repo.findByEmailIdAndPassword(tid,tpass);
	}
}
