package com.linkedin.linkedinProject.service;

import com.linkedin.linkedinProject.model.Login;
import com.linkedin.linkedinProject.model.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService {

    @Autowired
    private SkillsRepository repo;

    public SkillsService() {
    }

    public SkillsService(SkillsRepository repo) {
        this.repo = repo;
    }

    public void saveMySkill(Skills skill) {
        repo.save(skill);
    }

    public Iterable<Skills> showAllSkills(){
        return repo.findAll();
    }
    public Iterable<Skills> deleteSkill(String skill){
        repo.deleteBySkill(skill);
        return repo.findAll();
    }
    public Skills fetchBySkill(String skill) {
        return repo.findBySkill(skill);
    }

}
