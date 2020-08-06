package com.mosherhcode.EmployeeSkillsApplication.DAOs;

import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.mosherhcode.EmployeeSkillsApplication.models.Field;

public class FieldJdbcDAO implements FieldDAO {

	JdbcTemplate jdbcTemplate;
	
	public FieldJdbcDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public Field getField(String fieldId) {
		String sqlGetField = "SELECT * FROM field WHERE id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetField, UUID.fromString(fieldId));
		
		if(results.next())		
			return mapRowToField(results);
		else
			return null;
	}

	@Override
	public Field addField(Field theField) {
		String sqlAddField = "INSERT INTO (name, type) "
							+ "VALUES (?,?) RETURNING id";
		return getField(jdbcTemplate.queryForObject(sqlAddField, String.class));
	}

	
	private Field mapRowToField(SqlRowSet results) {
		Field theField = new Field();
		theField.setId(results.getString("id"));
		theField.setName(results.getString("name"));
		theField.setType(results.getString("type"));
		return theField;
	}

	
}
