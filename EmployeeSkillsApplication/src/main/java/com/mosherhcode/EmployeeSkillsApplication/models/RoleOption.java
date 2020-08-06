package com.mosherhcode.EmployeeSkillsApplication.models;

public enum RoleOption {
	TECHNICAL_CONSULTANT("Technical Consultant"),
	PROJECT_MANAGER("Project Manager"),
	DIRECTOR("Director"),
	CHIEF("Chief");
	
	private String roleOption;
	
	private RoleOption(String roleOption) {
		this.roleOption = roleOption;
	}
	
	public String getRoleOption() {
		return this.roleOption;
	}
	
}
