package com.linkedin.linkedinProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "edu")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eduId;
    
    @Column(name="edu_name")
    private String eduName;
    private String degree;
    private String field;
    
    @Column(name="edu_start")
    private Date eduStart;
    
   @Column(name="edu_stop")
    private Date eduStop;
    
    private String grade;
    
    @ManyToOne
    @JoinColumn(name = "eid",referencedColumnName = "id")
    @JsonIgnore
    private Login user;

    protected Education() {
    	
    }
    
	public Education( String eduName, String degree, String field, Date eduStart, Date eduStop, String grade,
			Login user) {
		super();
	//	this.eduId = eduId;
		this.eduName = eduName;
		this.degree = degree;
		this.field = field;
		this.eduStart = eduStart;
		this.eduStop = eduStop;
		this.grade = grade;
		this.user = user;
	}


	public Education(int eduId, String eduName, String degree, String field, Date eduStart,
			Date eduStop, String grade,Login user) {
		super();
		this.eduId = eduId;
		this.eduName = eduName;
		this.degree = degree;
		this.field = field;
		this.eduStart = eduStart;
		this.eduStop = eduStop;
		this.grade = grade;
		this.user = user;
	}




	public int getEduId() {
		return eduId;
	}

	public void setEduId(int eduId) {
		this.eduId = eduId;
	}

	public String getEduName() {
		return eduName;
	}

	public void setEduName(String eduName) {
		this.eduName = eduName;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Date getEduStart() {
		return eduStart;
	}

	public void setEduStart(Date eduStart) {
		this.eduStart = eduStart;
	}

	public Date getEduStop() {
		return eduStop;
	}

	public void setEduStop(Date eduStop) {
		this.eduStop = eduStop;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Login getUser() {
		return user;
	}

	public void setUser(Login user) {
		this.user = user;
	}

    
}



