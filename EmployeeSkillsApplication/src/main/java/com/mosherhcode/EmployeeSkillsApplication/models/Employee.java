package com.mosherhcode.EmployeeSkillsApplication.models;


public class Employee {
	private String id;
	private String firstName;
	private String lastName;
	private Address address;
	private String contactEmail;
	private String companyEmail;
	private String birthDate;
	private String hiredDate;
	private String role;
	private String businessUnit;
	private Skill[] skills;
	private Employee assignedTo;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}
	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	/**
	 * @return the companyEmail
	 */
	public String getCompanyEmail() {
		return companyEmail;
	}
	/**
	 * @param companyEmail the companyEmail to set
	 */
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the hiredDate
	 */
	public String getHiredDate() {
		return hiredDate;
	}
	/**
	 * @param hiredDate the hiredDate to set
	 */
	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the businessUnit
	 */
	public String getBusinessUnit() {
		return businessUnit;
	}
	/**
	 * @param businessUnit the businessUnit to set
	 */
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	/**
	 * @return the skills
	 */
	public Skill[] getSkills() {
		return skills;
	}
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(Skill[] skills) {
		this.skills = skills;
	}
	/**
	 * @return the assignedTo
	 */
	public Employee getAssignedTo() {
		return assignedTo;
	}
	/**
	 * @param assignedTo the assignedTo to set
	 */
	public void setAssignedTo(Employee assignedTo) {
		this.assignedTo = assignedTo;
	}
}
