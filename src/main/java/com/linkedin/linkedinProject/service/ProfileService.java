package com.linkedin.linkedinProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkedin.linkedinProject.model.Login;
import com.linkedin.linkedinProject.model.Profile;
import com.linkedin.linkedinProject.repository.LoginRepository;
import com.linkedin.linkedinProject.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository repo;
	
	@Autowired
    private LoginRepository loginRepository;

	public ProfileService(ProfileRepository repo) {
		super();
		this.repo = repo;
	}

	public Profile saveMyProfile(int id, String name, String title, String about, String location, Long phoneNo, String emailId) {
		
		if(loginRepository.existsById(id)) {
			
			Login login = loginRepository.findById(id).orElse(null);
			
			Profile p = new Profile(name, title, about, location, login,  phoneNo, emailId);
			
			repo.save(p);
			return repo.findByUserAndName(login, name);
		}
		else
			return null;
	}
	
	public Profile updateMyProfile(int id, String name, String title, String about, String location, Long phoneNo, String emailId) {
		Optional<Login> user = loginRepository.findById(id);
		Profile p = repo.findByUser(user);
		p.setName(name);
		p.setTitle(title);
		p.setAbout(about);
		p.setLocation(location);
		p.setPhoneNo(phoneNo);
		p.setEmailId(emailId);
		repo.save(p);
		return repo.findByUser(user);
	}
	
	public Profile displayProfile(int id) {
		Login user = loginRepository.findById(id).orElse(null);
		return repo.findByUser(user);
	}
	
}
