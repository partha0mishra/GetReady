package com.algods.leetcode;
/**
 * 
 * @author Partha.X.Mishra
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Input: 16
 * Output: true
 * 
 * Input: 5
 * Output: false
 * 
 */
public class PowerOfFour {
//* Approach 02: using loop - Time limit exceeds for 1162261466
	public boolean isPowerOfFour(int num) {
        if(num ==1) return true;
		int base=4;
        while(base < num)
        	base=base*4;
        
        if (base == num) return true;
        return false;
    }
	//*/
/* Approach 01: using Math.log [4ms 38.9 MB]
	public boolean isPowerOfFour(int num) {
        Double logDiv=Math.log(num)/Math.log(4);
        if(logDiv.intValue() == logDiv) return true;
        
        return false;
    }
    */
	public static void main(String[] args) {
		PowerOfFour instance = new PowerOfFour();
		System.out.println(instance.isPowerOfFour(16));// true
		System.out.println(instance.isPowerOfFour(5));// false
		System.out.println(instance.isPowerOfFour(0));// false
		System.out.println(instance.isPowerOfFour(1));// true
		System.out.println(instance.isPowerOfFour(1162261466));// true
	}

}
