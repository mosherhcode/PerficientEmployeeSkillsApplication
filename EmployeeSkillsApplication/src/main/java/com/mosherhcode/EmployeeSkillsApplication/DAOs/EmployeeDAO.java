package com.mosherhcode.EmployeeSkillsApplication.DAOs;

import java.util.List;

import com.mosherhcode.EmployeeSkillsApplication.models.Employee;

public interface EmployeeDAO {
	
	
	public abstract List<Employee> getEmployeesList();
	
	public abstract Employee createNewEmployee(Employee newEmployee);
	
	public abstract Employee getSingleEmployee(String employeeId);
	
	public abstract Employee updateEmployee(Employee updatedEmployee);
	
	public abstract void deleteEmployee(String employeeId);
}
