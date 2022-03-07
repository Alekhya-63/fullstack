package com.linkedin.linkedinProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="exp")
public class Experience {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expId;
	private String companyName;
	private String role;
	private String empType;
	private Date startDate;
	private Date stopDate;
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "eid", referencedColumnName = "id")
	@JsonIgnore
	private Login user;

	
	public Experience() {
		
	}
	
	

	public Experience(int expId, String companyName, String role, String empType, Date startDate, Date stopDate,
			String description, Login user) {
		super();
		this.expId = expId;
		this.companyName = companyName;
		this.role = role;
		this.empType = empType;
		this.startDate = startDate;
		this.stopDate = stopDate;
		this.description = description;
		this.user = user;
	}



	public Experience(String companyName, String role, String empType, Date startDate, Date stopDate,
			String description, Login user) {
		super();
		this.companyName = companyName;
		this.role = role;
		this.empType = empType;
		this.startDate = startDate;
		this.stopDate = stopDate;
		this.description = description;
		this.user = user;
	}



	public int getExpId() {
		return expId;
	}

	public void setExpId(int expId) {
		this.expId = expId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Login getUser() {
		return user;
	}

	public void setUser(Login user) {
		this.user = user;
	}
	

}
