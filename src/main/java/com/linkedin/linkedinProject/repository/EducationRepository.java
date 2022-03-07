package com.linkedin.linkedinProject.repository;
import com.linkedin.linkedinProject.model.Education;
import com.linkedin.linkedinProject.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Integer> {

public Education findByUserAndEduName(Login login, String name);

public Education[] findByUser(Login login);

public Education findByUserAndEduId(Login login, int eid);
}
