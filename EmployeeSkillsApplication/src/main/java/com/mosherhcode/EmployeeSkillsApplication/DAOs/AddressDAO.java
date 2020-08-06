package com.mosherhcode.EmployeeSkillsApplication.DAOs;

import com.mosherhcode.EmployeeSkillsApplication.models.Address;

public interface AddressDAO {

	
	public abstract Address getAddress(String addressId);

	public abstract Address addNewAddress(Address address);
}
