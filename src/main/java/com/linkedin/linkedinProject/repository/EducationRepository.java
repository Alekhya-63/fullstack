package com.linkedin.linkedinProject.repository;


import com.linkedin.linkedinProject.model.Education;
import com.linkedin.linkedinProject.model.Login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Integer> {
   
//	public boolean findByEduName(String name);
public Education findByUserAndEduName(Login login, String name);
//public boolean existsByUserAndEduName(Optional<Login> findById, String name);
//public Education existsByUserAndEduId(Optional<Login> findById, int eid);
//public Education existsByUser(Optional<Login> findById);
//public Education findByUserAndEduName(Optional<Login> findById, String name);

public Education[] findByUser(Login login);



public Education findByUserAndEduId(Login login, int eid);
}
