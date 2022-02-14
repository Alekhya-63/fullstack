package com.linkedin.linkedinProject.service;

import com.linkedin.linkedinProject.model.Login;
import com.linkedin.linkedinProject.model.Skills;
import com.linkedin.linkedinProject.repository.LoginRepository;
import com.linkedin.linkedinProject.repository.SkillsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillsService {

    @Autowired
    private SkillsRepository repo;

    @Autowired
    private LoginRepository loginRepository;

    public SkillsService() {
    }

    public SkillsService(SkillsRepository repo) {
        this.repo = repo;
    }

    public Skills saveMySkill(int id, String skill) {
    // Optional<Login> obj = loginRepository.findById(id);
    	//String name = skill.getSkill();
        if(loginRepository.existsById(id) && 
        		!repo.existsByUserAndSkill(loginRepository.findById(id),skill)){
        Login login = loginRepository.findById(id).orElse(null);
        
        Skills s = new Skills(login, skill);
        
        repo.save(s);
        
       return repo.findByUserAndSkill(login, skill);
        }
        else
        	return null;
    }

    public Skills[] deleteSkill(int id, int sid){

        Skills skill = repo.findById(sid);
        Login login = loginRepository.findById(id).orElse(null);
        if(loginRepository.existsById(id) && repo.existsById(sid)) {
            repo.deleteById(sid);
        }
       return repo.findByUser(login);
        //return repo.findAll();
    }
    public Skills[] fetchByUserAndSkill(int id) {
    	
Login login = loginRepository.findById(id).orElse(null);
        
        
        return repo.findByUser(login);
    }
    

}
