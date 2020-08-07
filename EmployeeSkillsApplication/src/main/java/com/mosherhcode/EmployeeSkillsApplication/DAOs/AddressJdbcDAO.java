package com.mosherhcode.EmployeeSkillsApplication.DAOs;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.mosherhcode.EmployeeSkillsApplication.models.Address;

public class AddressJdbcDAO implements AddressDAO {

	JdbcTemplate jdbcTemplate;
	
	public AddressJdbcDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Address getAddress(String addressId) {
		String sqlGetAddress = "SELECT * FROM address WHERE id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAddress, UUID.fromString(addressId));
		
		if(results.next())
			return mapRowToAddress(results);
		else
			return null;
	}


	@Override
	public Address addNewAddress(Address theAddress) {
		String sqlAddNewAddress = "INSERT INTO address (street, suite, city, region, postal, country) "
								+ "VALUES (?,?,?,?,?,?) RETURNING id";
		
		String addressId = jdbcTemplate.queryForObject(sqlAddNewAddress, String.class, theAddress.getStreet(), theAddress.getSuite(), theAddress.getCity(), 
				theAddress.getRegion(), theAddress.getPostal(), theAddress.getCountry());
		
		theAddress.setId(addressId);
		
		return theAddress;
		
	}
	
	private Address mapRowToAddress(SqlRowSet results) {
		Address theAddress = new Address();
		
		theAddress.setId(results.getString("id"));
		theAddress.setStreet(results.getString("street"));
		theAddress.setSuite(results.getString("suite"));
		theAddress.setCity(results.getString("city"));
		theAddress.setRegion(results.getString("region"));
		theAddress.setPostal(results.getString("postal"));
		theAddress.setCountry(results.getString("country"));
		
		return theAddress;
	}

	@Override
	public Address updateAddress(Address address) {
		// TODO Auto-generated method stub
		String sqlUpdateAddress = "UPDATE address "
									+ "SET street = ?, "
									+ "suite = ?, "
									+ "city = ?,"
									+ "region = ?,"
									+ "postal = ?,"
									+ "country = ?"
									+ "WHERE id = ?";
		
		jdbcTemplate.update(sqlUpdateAddress, address.getStreet(), address.getSuite(), 
				address.getCity(), address.getRegion(), address.getPostal(), address.getCountry(), UUID.fromString(address.getId()));
		
		return getAddress(address.getId());
	}
}
