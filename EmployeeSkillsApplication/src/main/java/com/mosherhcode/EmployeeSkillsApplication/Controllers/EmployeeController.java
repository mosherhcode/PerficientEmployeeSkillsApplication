package com.mosherhcode.EmployeeSkillsApplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mosherhcode.EmployeeSkillsApplication.DAOs.EmployeeDAO;
import com.mosherhcode.EmployeeSkillsApplication.models.Employee;

@RestController
public class EmployeeController {

	
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public List<Employee> getEmployees(){
		
		//TODO: Need to figure out how to add in Headers to the response object.
				//		Include X-Total-Count (int) in headers.
		
		return employeeDAO.getEmployeesList();
		
	}
	
	@RequestMapping(path = "/employees", method = RequestMethod.POST)
	public Employee createEmployee(@Validated @RequestBody Employee newEmployee){
		
		//TODO: Created new employee, 201
		//TODO: Invalid employee data sent to server, 422
		return employeeDAO.createNewEmployee(newEmployee);
	}
	
	@RequestMapping(path = "/employees/{employeeId}", method = RequestMethod.GET)
	public Employee findEmployee(@PathVariable String employeeId) {
		
		//TODO: On Invalid ID Format, response code 400
		//TODO: On employee not found, response code 404
		return employeeDAO.getSingleEmployee(employeeId);
	}
	
	@RequestMapping(path = "/employees/{employeeId}", method = RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable String employeeId, @Validated @RequestBody Employee updatedEmployee) {
		
		//TODO: On Invalid ID Format, response code 400
		//TODO: On employee not found, response code 404
		//TODO: Invalid Perficient Employee Data sent to server, response code 422
		return null;
	}
	
	@RequestMapping(path = "/employees/{employeeId}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable String employeeId) {
		//TODO: Deleted a Perficient employee, 204
		//TODO: Invalid ID Format, 400
		//TODO: Employee Not Found, 404
	}
}
