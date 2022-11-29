package com.greatlearning.pairsum;

import java.util.HashSet;

public class FindPairSum{

	public boolean findPairSum(Node root, int sum) {
		HashSet<Integer> value = new HashSet<Integer>();
		return isPairPresent(root,value,sum);
	}

	private boolean isPairPresent(Node root, HashSet<Integer> value, int sum) {
		if(root == null)
			return false;
		
		int deference = sum - root.value;
		
		if(value.contains(deference)) {
			System.out.println("("+ root.value+ ","+deference+")="+sum);
			return true;
		}else {
			value.add(root.value);
		}
		
		return isPairPresent(root.left, value, sum) 
				|| isPairPresent(root.right, value, sum);
	}
}
