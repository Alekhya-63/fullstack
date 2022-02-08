package com.linkedin.linkedinProject.model;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int skillId;
    private String skill;

    public Skills() {
    }

    public Skills(int skillId, String skill) {
        this.skillId = skillId;
        this.skill=skill;
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
