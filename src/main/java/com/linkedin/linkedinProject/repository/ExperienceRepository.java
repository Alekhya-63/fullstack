package com.linkedin.linkedinProject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.linkedin.linkedinProject.model.Experience;
import com.linkedin.linkedinProject.model.Login;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

	Experience findByUserAndCompanyName(Login login, String companyName);

	Experience[] findByUser(Login login);

	Experience findByUserAndExpId(Login login, int eid);

	
}
