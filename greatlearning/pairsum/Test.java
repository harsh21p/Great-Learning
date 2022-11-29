package com.greatlearning.pairsum;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		FindPairSum findPairSum = new FindPairSum();
		Scanner sc = new Scanner(System.in);
		
		Node root = null;
		int givenSum = 100; 
		
		root = Node.insertNewNode(root,30);
		root = Node.insertNewNode(root,80);
		root = Node.insertNewNode(root,40);
		root = Node.insertNewNode(root,20);
		root = Node.insertNewNode(root,10);
		root = Node.insertNewNode(root,5);
		root = Node.insertNewNode(root,90);
		
//		System.out.print("Enter the number of nodes : ");
//	    int nodes = sc.nextInt();
//	    for (int i=0;i < nodes;i++) {
//	    	 System.out.println("Value of node : ");
//	    	 int input = sc.nextInt(); 
//	    	 root = Node.insertNewNode(root,input);
//	    }
//	    
//	    System.out.print("Enter sum : ");
//	    givenSum = sc.nextInt();
	   
		if(!findPairSum.findPairSum(root,givenSum)) {
			System.out.println("Not found!");
		}
		
		sc.close();
		
	}
}
