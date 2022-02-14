package com.linkedin.linkedinProject.service;

import com.linkedin.linkedinProject.model.Education;
import com.linkedin.linkedinProject.model.Login;
import com.linkedin.linkedinProject.repository.EducationRepository;
import com.linkedin.linkedinProject.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EducationService {

    @Autowired
    private EducationRepository repo;
    
    @Autowired
    private LoginRepository loginRepository;

    public EducationService(EducationRepository repo) {
        this.repo = repo;
    }

    public Education saveMyEdu(int id, String name, String degree, String field, Date eduStart,
    		Date eduStop, String grade) {
    	if(loginRepository.existsById(id)){
    				
    		 Login login = loginRepository.findById(id).orElse(null);
    		 
    		 Education e = new Education(name, degree, field, eduStart, eduStop,
    				 grade, login);
    		 repo.save(e);
    		 
    		return repo.findByUserAndEduName(login, name);
    	}
    	else
    		return null;
    }
    
    public Education updateEdu(int id, int eid, Education edu) {
    	
    		String name = edu.getEduName();
    		String degree = edu.getDegree();
    		String field = edu.getField();
    		Date eduStart = edu.getEduStart();
    		Date eduStop = edu.getEduStop();
    		String grade = edu.getDegree();
    		 Login login = loginRepository.findById(id).orElse(null);
    	Education e = repo.findByUserAndEduId(login,eid);
    	e.setEduName(name);
    	e.setDegree(degree);
    	e.setField(field);
    	e.setEduStart(eduStart);
    	e.setEduStop(eduStop);
    	e.setGrade(grade);
    	 repo.save(e);
    		return e;
    }
    
    public Education[] deleteEducation(int id, int eid) {
    	
    	Education edu = repo.findById(eid).orElse(null);
    	Login login = loginRepository.findById(id).orElse(null);
    	repo.deleteById(eid);
    	
    	return repo.findByUser(login);
    	
    }
    
    public Education[] displayEdu(int id) {
    	Login login = loginRepository.findById(id).orElse(null);
    	return repo.findByUser(login);
    }
   
}
