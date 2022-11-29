package com.greatlearning.pairsum;


public class Node {
	
	int value;
	Node left;
	Node right;
	
	Node(int value) {
		this.value = value;
		this.left = this.right = null;
	}
	
	public static Node insertNewNode(Node root, int value) {
		if(root == null) {
			return new Node(value);
		}
		if(root.value > value) {
			root.left = insertNewNode(root.left, value);
		}else {
			root.right = insertNewNode(root.right, value);
		}
		return root;
	}
	
}
