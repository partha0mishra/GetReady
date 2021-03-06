package com.leetcode._explore;
/*
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
 */

public class AddDigits {
    public int addDigits(int num) {
    	return (num ==0) ? 0: (num-1) %9 +1;
    }
    
	public static void main(String[] args) {
		AddDigits instance= new AddDigits();
		System.out.println(instance.addDigits(38));//2
		System.out.println(instance.addDigits(0));//0
		System.out.println(instance.addDigits(9));//9
	}

}
