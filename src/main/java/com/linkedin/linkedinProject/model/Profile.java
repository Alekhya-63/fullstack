package com.linkedin.linkedinProject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String name;
	private String title;
	private String about;
	private String location;
	private Long phoneNo;
	private String emailId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="uid", referencedColumnName = "id")
	@JsonIgnore
	private Login user;
	
	public Login getUser() {
		return user;
	}
	public void setUser(Login user) {
		this.user = user;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Profile(int pid, String name, String title, String about, String location, Long phoneNo, String emailId) {
		super();
		this.pid = pid;
		this.name = name;
		this.title = title;
		this.about = about;
		this.location = location;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}
	public Profile(String name, String title, String about, String location, Login user, Long phoneNo, String emailId) {
		super();
		this.name = name;
		this.title = title;
		this.about = about;
		this.location = location;
		this.user = user;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}


	public Profile() {
		// TODO Auto-generated constructor stub
	}
	
	
}
