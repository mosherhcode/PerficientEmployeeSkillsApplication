package com.mosherhcode.EmployeeSkillsApplication.DAOs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.mosherhcode.EmployeeSkillsApplication.models.Employee;


@Component
public class EmployeeJdbcDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	
	public EmployeeJdbcDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Employee> getEmployeesList() {
		List<Employee> employees = new ArrayList<Employee>(0);
		String sqlGetEmployees = "SELECT * FROM employee";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployees);
		
		while(results.next()) {
			employees.add(mapRowToEmployee(results));
		}
		
		
		return employees;
	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee theEmployee = new Employee();
		theEmployee.setId(results.getString("id"));
		theEmployee.setFirstName(results.getString("first_name"));
		theEmployee.setLastName(results.getString("last_name"));
		
		AddressDAO addressDAO = new AddressJdbcDAO(jdbcTemplate);
		theEmployee.setAddress(addressDAO.getAddress(results.getString("address_id")));
		
		theEmployee.setContactEmail(results.getString("contact_email"));
		theEmployee.setCompanyEmail(results.getString("company_email"));
		theEmployee.setBirthDate(results.getString("birth_date"));
		theEmployee.setHiredDate(results.getString("hired_date"));
		theEmployee.setRole((results.getString("role")));
		
		SkillDAO skillDAO = new SkillJdbcDAO(jdbcTemplate.getDataSource());
		theEmployee.setSkills(skillDAO.getEmployeeSkills(theEmployee.getId()));
		
		theEmployee.setBusinessUnit(results.getString("business_unit"));
		if(results.getString("assigned_to") != null) {
			theEmployee.setAssignedTo(getSingleEmployee(results.getString("assigned_to")));
		}
		
		return theEmployee;
	}

	@Override
	public Employee createNewEmployee(Employee newEmployee) {
		
		AddressDAO addressDAO = new AddressJdbcDAO(jdbcTemplate);
		addressDAO.addNewAddress(newEmployee.getAddress());
		
		String sqlCreateEmployee = 	"INSERT INTO employee (first_name, last_name, address_id, contact_email, company_email, birth_date, hired_date, role, business_unit, assigned_to) "
									+ "VALUES (?,?,?,?,?,?,?,?,?,?) RETURNING id";
		String employeeId = jdbcTemplate.queryForObject(sqlCreateEmployee, String.class, newEmployee.getFirstName(), newEmployee.getLastName(), UUID.fromString(newEmployee.getAddress().getId()), 
				newEmployee.getContactEmail(), newEmployee.getCompanyEmail(), newEmployee.getBirthDate(), newEmployee.getHiredDate(), newEmployee.getRole(), newEmployee.getBusinessUnit(), UUID.fromString(newEmployee.getAssignedTo().getId()));
		
		//Alternatively, we could just set the id value in the newEmployee object and return that. I think there's some value in returning 
		//what's actually in the database, though.
		return getSingleEmployee(employeeId);
	}

	@Override
	public Employee getSingleEmployee(String employeeId) {
		String sqlGetEmployee = "SELECT * FROM employee WHERE id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployee, UUID.fromString(employeeId));
		
		if(results.next()) {
			return mapRowToEmployee(results);
		} else {
			return null;
		}
		
	}

	@Override
	public Employee updateEmployee(String employeeId, Employee updatedEmployee) {
		
		AddressDAO addressDAO = new AddressJdbcDAO(jdbcTemplate);
		addressDAO.updateAddress(updatedEmployee.getAddress());
		
		String sqlUpdateEmployee = "UPDATE employee "
									+ "SET first_name = ?, "
									+ "last_name = ?, "
									+ "address_id = ?, "
									+ "contact_email = ?, "
									+ "company_email = ?, "
									+ "birth_date = ?, "
									+ "hired_date = ?, "
									+ "role = ?, "
									+ "business_unit = ? "
									+ "WHERE id = ?";
		
		jdbcTemplate.update(sqlUpdateEmployee, updatedEmployee.getFirstName(), updatedEmployee.getLastName(), UUID.fromString(updatedEmployee.getAddress().getId()), 
				updatedEmployee.getContactEmail(), updatedEmployee.getCompanyEmail(), updatedEmployee.getBirthDate(), updatedEmployee.getHiredDate(), 
				updatedEmployee.getRole(), updatedEmployee.getBusinessUnit(), UUID.fromString(employeeId));
		
		
		return getSingleEmployee(employeeId);
	}

	@Override
	public void deleteEmployee(String employeeId) {
		String sqlDeleteEmployee = "DELETE FROM employee "
									+ "WHERE id = ?";
		
		jdbcTemplate.update(sqlDeleteEmployee, employeeId);
		
	}

}
