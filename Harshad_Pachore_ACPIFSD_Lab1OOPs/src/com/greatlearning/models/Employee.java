package com.greatlearning.models;


public class Employee {
	
	private String firstName;
	private String lastName;
	
	public Employee(String firstName,String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	Employee() {
		this.setFirstName("Firstname");
		this.setLastName("Lastname");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
