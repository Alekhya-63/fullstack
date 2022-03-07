package com.linkedin.linkedinProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkedin.linkedinProject.model.Experience;
import com.linkedin.linkedinProject.model.Login;
import com.linkedin.linkedinProject.repository.ExperienceRepository;
import com.linkedin.linkedinProject.repository.LoginRepository;

@Service
public class ExperienceService {

	@Autowired
	private ExperienceRepository repo;
	
	@Autowired
	private LoginRepository loginRepository;

    public ExperienceService() {

    }

    public ExperienceService(ExperienceRepository repo) {
    	this.repo = repo;
    }

    public Experience saveMyExp(int id, Experience exp) {
    	if(loginRepository.existsById(id)){
			
   		 Login login = loginRepository.findById(id).orElse(null);
   		 
   		 Experience e = new Experience(exp.getCompanyName(), exp.getRole(), exp.getEmpType(), exp.getStartDate(), exp.getStopDate(), exp.getDescription(), login);
   		 repo.save(e);
   		 
   		return repo.findByUserAndCompanyName(login, exp.getCompanyName());
   	}
   	else
   		return null;
    }
    
    public Experience updateExp(int id, int eid,Experience exp) {
    	 Login login = loginRepository.findById(id).orElse(null);
    	 Experience e = repo.findByUserAndExpId(login,eid);
    	 e.setCompanyName(exp.getCompanyName());
    	 e.setRole(exp.getRole());
    	 e.setEmpType(exp.getEmpType());
    	 e.setStartDate(exp.getStartDate());
    	 e.setStopDate(exp.getStopDate());
    	 e.setDescription(exp.getDescription());
   		 repo.save(e);
   		 return e;
    }
    
    public Experience[] deleteExp(int id, int eid) {
    	Login login = loginRepository.findById(id).orElse(null);
    	repo.deleteById(eid);
    	
    	return repo.findByUser(login);
    }
    
    public Experience[] displayExp(int id) {
    	
    	Login login = loginRepository.findById(id).orElse(null);
    	return repo.findByUser(login);
    }

    public Experience disExpById(int id, int eid) {
		Login login = loginRepository.findById(id).orElse(null);
		return repo.findByUserAndExpId(login, eid);
	}
}
