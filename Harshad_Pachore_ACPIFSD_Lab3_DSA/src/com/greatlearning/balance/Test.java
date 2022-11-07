package com.greatlearning.balance;
import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		Balance balance = new Balance();
		Scanner sc = new Scanner(System.in);
		System.out.print("Input : ");
		if(balance.isBalanced(sc.nextLine())) {
			System.out.print("The entered String has Balanced Brackets");
		}else {
			System.out.print("The entered Strings do not contain Balanced Brackets");
		}
		sc.close();
	}
}
