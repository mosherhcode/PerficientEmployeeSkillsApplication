package com.mosherhcode.EmployeeSkillsApplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mosherhcode.EmployeeSkillsApplication.DAOs.SkillDAO;
import com.mosherhcode.EmployeeSkillsApplication.models.Skill;

@RestController
public class SkillController {
	
	
	@Autowired
	private SkillDAO skillDAO;
	
	@RequestMapping(path = "/employees/{employeeId}/skills", method = RequestMethod.GET)
	public List<Skill> getEmployeeSkills(@PathVariable String employeeId){
		
		//TODO: Add X-Total-Count to header
		return null;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(path = "/employees/{employeeId}/skills", method = RequestMethod.POST)
	public Skill addSkillToEmployee(@PathVariable String employeeId, @RequestBody Skill newSkill) {
		
		//TODO: successfully created, 201
		//TODO: Invalid ID format, 400
		//TODO: Employee Not Found, 404
		//TODO: Invalid skill data sent to server, 422
		return null;
	}
	
	@RequestMapping(path = "/employees/{employeeId}/skills/{skillId}", method = RequestMethod.GET)
	public Skill getSingleEmployeeSkill(@PathVariable String employeeId, @PathVariable String skillId) {
		
		//TODO: Invalid ID, 400
		//TODO: skill or employee not found, 404
		return null;
	}
	
	@RequestMapping(path = "/employees/{employeeId}/skills/{skillId}", method = RequestMethod.PUT )
	public Skill updateEmployeeSkill(@PathVariable String employeeId, @PathVariable String skillId, @RequestBody Skill updatedSkill) {
		
		//TODO: Invalid ID, 400
		//TODO: skill or employee not found, 404
		//TODO: invalid skill data sent to server, 422
		return null;
	}
	
	@RequestMapping(path = "/employees/{employeeId}/skills/{skillId}", method = RequestMethod.DELETE)
	public void deleteEmployeeSkill(@PathVariable String employeeId, @PathVariable String skillId) {
		//TODO: successfully deleted, 204
		//TODO: Invalid ID, 400
		//TODO: Skill or employee not found, 404
	}
	
	
	
}
