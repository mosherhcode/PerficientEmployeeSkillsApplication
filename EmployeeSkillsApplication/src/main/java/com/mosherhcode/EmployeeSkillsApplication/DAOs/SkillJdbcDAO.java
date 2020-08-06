package com.mosherhcode.EmployeeSkillsApplication.DAOs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.mosherhcode.EmployeeSkillsApplication.models.Skill;

@Component
public class SkillJdbcDAO implements SkillDAO {
	
	JdbcTemplate jdbcTemplate;
	
	public SkillJdbcDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Skill> getEmployeeSkills(String employeeId) {
		List<Skill> skills = new ArrayList<Skill>(0);
		
		String sqlGetEmployeeSkills = 	"SELECT skill.*, emp_skill.experience "
										+ "FROM emp_skill INNER JOIN skill ON emp_skill.skill_id = skill.id "
										+ "WHERE emp_skill.employee_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeeSkills, UUID.fromString(employeeId));
		
		while(results.next()) {
			skills.add(mapRowToSkill(results));
		}
		
		return skills;
	}



	@Override
	public Skill addSkillToEmployee(String employeeId, Skill theSkill) {
		FieldDAO fieldDAO = new FieldJdbcDAO(jdbcTemplate.getDataSource());
		
		String sqlAddNewSkill = "INSERT INTO skill (summary, field_id) "
								+ "VALUES (?, ?) RETURNING id";
		String skillId = jdbcTemplate.queryForObject(sqlAddNewSkill, String.class, theSkill.getSummary(), UUID.fromString(fieldDAO.addField(theSkill.getField()).getId()));
		
		String sqlAddSkillToEmpSkill = "INSERT INTO emp_skill (employee_id, skill_id, experience) "
										+ "VALUES (?,?,?)";
		
		jdbcTemplate.update(sqlAddSkillToEmpSkill, UUID.fromString(employeeId), UUID.fromString(skillId), theSkill.getExperience());
		
		return getSingleEmployeeSkill(employeeId, skillId);
	}
	
	@Override
	public Skill getSingleEmployeeSkill(String employeeId, String skillId) {
		String sqlGetEmpSkill = "SELECT skill.id, skill.summary, skill.field_id, emp_skill.experience "
				+ "FROM skill INNER JOIN emp_skill ON skill.id = emp_skill.skill_id "
				+ "WHERE emp_skill.employee_id = ? "
				+ "AND emp_skill.skill_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmpSkill, UUID.fromString(employeeId), UUID.fromString(skillId));
		
		if(results.next()) {
			return mapRowToSkill(results);
		} else {
			return null;
		}
	}
	
	private Skill mapRowToSkill(SqlRowSet results) {
		Skill theSkill = new Skill();
		theSkill.setId(results.getString("id"));
		theSkill.setExperience(results.getInt("experience"));
		theSkill.setSummary(results.getString("summary"));
		FieldDAO fieldDAO = new FieldJdbcDAO(jdbcTemplate.getDataSource());
		theSkill.setField(fieldDAO.getField(results.getString("field_id")));
		return theSkill;
	}
	
	
	
}
