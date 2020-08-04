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
	//* Approach 03: check if the number is divisible by 2 and sqrt is multiple of 4 
	public boolean isPowerOfFour(int num) {
        if(num==1 || num==4) return true;
        if(num<=0)
            return false;
        if((num&(num-1))==0 && ( Math.sqrt(num) % (1<<2))==0)        
            return true;
        return false;
    }
	    //*/
	/* Approach 02: using loop - Time limit exceeds for 1162261466. Time complexity O(logY)
	public boolean isPowerOfFour(int num) {
		int base=1;
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
    //*/
	public static void main(String[] args) {
		PowerOfFour instance = new PowerOfFour();
		System.out.println(instance.isPowerOfFour(16));// true
		System.out.println(instance.isPowerOfFour(5));// false
		System.out.println(instance.isPowerOfFour(0));// false
		System.out.println(instance.isPowerOfFour(1));// true
		System.out.println(instance.isPowerOfFour(1162261466));// false
	}

}
