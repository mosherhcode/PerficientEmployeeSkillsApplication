package com.mosherhcode.EmployeeSkillsApplication.DAOs;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SkillJdbcDAO implements SkillDAO {
	private JdbcTemplateAutoConfiguration jdbcTemplate;
	
	
	
}
