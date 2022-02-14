package com.linkedin.linkedinProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int skillId;
    private String skill;

    @ManyToOne
    @JoinColumn(name = "sid", referencedColumnName = "id")

    private Login user;

    public Skills() {
    }

    public Skills(int skillId, String skill) {
        this.skillId = skillId;
        this.skill=skill;
    }

    public Skills(Login login, String skill2) {
		// TODO Auto-generated constructor stub
    	user = login;
    	skill = skill2;
	}

	public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
