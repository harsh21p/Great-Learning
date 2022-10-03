package com.greatlearning.services;

import com.greatlearning.models.Employee;

public interface CredentialService {
	
	public String generateEmailAddress(Employee e,String department,String company);
	public void showCredentials(String email);
	
}
