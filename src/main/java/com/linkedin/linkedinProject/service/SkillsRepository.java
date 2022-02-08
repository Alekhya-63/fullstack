package com.linkedin.linkedinProject.service;

//import com.linkedin.linkedinProject.model.Login;
import com.linkedin.linkedinProject.model.Login;
import com.linkedin.linkedinProject.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills, Long> {
    public void deleteBySkill(String skill);

    public Skills findBySkill(String skill);


}
