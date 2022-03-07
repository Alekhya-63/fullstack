package com.linkedin.linkedinProject.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String emailId;
	private String password;
	@OneToMany(mappedBy = "user")
	private Set<Education> educations = new HashSet<>();

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	
	private Profile profile = new Profile();

	@OneToMany(mappedBy = "user")
	private Set<Skills> Skills = new HashSet<>();


	public Set<Skills> getSkills() {
		return Skills;
	}

	public void setSkills(Set<Skills> skills) {
		Skills = skills;
	}

	public Login() {
		
	}
	public Login(int id, String emailId, String password) {
		super();
		this.id=id;
		this.emailId = emailId;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
