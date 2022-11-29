package com.greatlearning.balance;
import java.util.Stack;

public class Balance {

	public Boolean isBalanced(String string) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<string.length();i++) {
			char stringChar = string.charAt(i);
			if(stringChar == '(' || stringChar == '[' || stringChar == '{') {
				stack.push(stringChar);
				continue;
			}
			if(stack.isEmpty()) {
				return false;
			}
			char preChar = stack.pop();
			switch(stringChar) {
				case ')':
					if(preChar != '(') {
						return false;
					}
					break;
				case ']':
					if(preChar != '[') {
						return false;
					}
					break;
				case '}':
					if(preChar != '{') {
						return false;
					}
					break;
			}
		}
		return stack.isEmpty();
	}
}
