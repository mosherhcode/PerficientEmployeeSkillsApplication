package com.mosherhcode.EmployeeSkillsApplication.DAOs;

import java.util.List;

import com.mosherhcode.EmployeeSkillsApplication.models.Skill;

public interface SkillDAO {

	
	public abstract List<Skill> getEmployeeSkills(String employeeId);
	
	public abstract Skill addSkillToEmployee(String employeeId, Skill theSkill);
	
	public abstract Skill getSingleEmployeeSkill(String employeeId, String skillId);
}
