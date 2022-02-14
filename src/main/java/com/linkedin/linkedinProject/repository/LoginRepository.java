package com.linkedin.linkedinProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linkedin.linkedinProject.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	public Login findByEmailId(String email);
	public Iterable<Login> deleteByEmailId(String user);
	public Login findByEmailIdAndPassword(String tid, String tpass);
}
