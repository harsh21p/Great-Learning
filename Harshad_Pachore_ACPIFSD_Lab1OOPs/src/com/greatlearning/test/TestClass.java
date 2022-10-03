package com.greatlearning.test;

import java.util.Scanner;

import com.greatlearning.models.Employee;
import com.greatlearning.services.CredentialServiceImpl;

public class TestClass {

	public static void main(String args[]) {
		CredentialServiceImpl csi = new CredentialServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your first name : ");
		String firstName = sc.nextLine();
		System.out.print("Please enter your last name : ");
		String lastName = sc.nextLine();
		System.out.print("Please enter your company : ");
		String companyName = sc.nextLine();
		
		
		System.out.println("Please enter department from the following : \n1. Technical \n2. Admin \n3. Human Resource \n4. Legal");
		
		int choice = sc.nextInt();
		String department = null;
		
		switch(choice){
		
		case 1 : department ="tech" ;
				
				 break;
				 
		case 2 : department ="adm" ;
		
		 		 break;
		 		 
		case 3 : department ="hr" ;
		
		 		 break;
		 
		case 4 : department ="lg" ;
		
		 		 break;
		 		 
		default : System.out.print("Enter valid choice : ");
				  break;
		 		 
		}
		
		sc.close();
		
		Employee e = new Employee(firstName,lastName);
		if(null != department) {
			
			csi.showCredentials(csi.generateEmailAddress(e, department, companyName));
			
		}else {
			
			System.out.print("Something went wrong!");
		}
		
		
	}

}

