package com.mosherhcode.EmployeeSkillsApplication.DAOs;

import com.mosherhcode.EmployeeSkillsApplication.models.Field;

public interface FieldDAO {
	public abstract Field getField(String fieldId);
	
	public abstract Field addField(Field theField);
}
