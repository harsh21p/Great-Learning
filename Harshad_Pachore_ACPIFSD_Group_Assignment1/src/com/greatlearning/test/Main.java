package com.greatlearning.test;

import com.greatlearning.departments.AdminDepartment;
import com.greatlearning.departments.HrDepartment;
import com.greatlearning.departments.TechDepartment;

public class Main {

	public static void main(String[] args) {

		AdminDepartment subAdmin = new AdminDepartment();
		HrDepartment subHr = new HrDepartment();
		TechDepartment subTech = new TechDepartment();

		System.out.println("Welcome to " + subAdmin.departmentName() + "\n" + subAdmin.getTodaysWork() + "\n"
				+ subAdmin.getWorkDeadline() + "\n" + subAdmin.isTodayAHoliday() + "\n");
		System.out.println("Welcome to " + subHr.departmentName() + "\n" + subHr.doActivity() +"\n" + subHr.getTodaysWork() + "\n"
				+ subHr.getWorkDeadline() + "\n" + subHr.isTodayAHoliday() + "\n");
		System.out.println("Welcome to " + subTech.departmentName() + "\n" + subTech.getTodaysWork() + "\n"
				+ subTech.getWorkDeadline() + "\n" + subTech.getTechStackInformation() + "\n"
				+ subTech.isTodayAHoliday() + "\n");

	}

}
