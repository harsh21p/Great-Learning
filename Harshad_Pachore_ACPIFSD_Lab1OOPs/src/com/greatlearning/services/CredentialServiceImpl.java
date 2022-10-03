package com.greatlearning.services;

import com.greatlearning.models.Employee;

public class CredentialServiceImpl implements CredentialService {
	
	private String generatePassword() {

		String generatePasswordHelper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz*#$%^!";
		 
		  String sb = "";
		 
		  for (int i = 0; i < 8; i++) {

		   int j= (int)(generatePasswordHelper.length()* Math.random());
		
		   sb = sb+generatePasswordHelper.charAt(j);
		  
		  }
		  
		 return sb.toString();
	}
	

	@Override
	public String generateEmailAddress(Employee e,String department,String company) {
		String emailAddress;
		emailAddress = e.getFirstName()+e.getLastName()+"@"+department+"."+company+".com";
		return emailAddress;
	}

	@Override
	public void showCredentials(String email) {
		
		System.out.println("\nEmail --> "+email+"\nPassword --> "+generatePassword());
		
	}

}
