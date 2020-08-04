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
	/* Approach 04: Power of 2 @ even Pos. for 32 bit int, we'll have to shift 32 times max 
	// 3ms 38.7 MB
    public boolean isPowerOfFour(int num) {
        int pos = 0;
        while(num > 0){
            pos++;
            if((num & 1) == 1)
                break;
            num >>= 1;
        }
        return pos % 2 == 1 && num == 1;
    } 
    //*/
	/* Approach 03: check if the number is divisible by 2 and sqrt is multiple of 4 
	public boolean isPowerOfFour(int num) {
        if(num==1 || num==4) return true;
        if(num<=0)
            return false;
        if((num&(num-1))==0 && ( Math.sqrt(num) % (1<<2))==0)        
            return true;
        return false;
    }
	    //*/
	/* Approach 02: NAIVE using loop - Time limit exceeds for 1162261466. Time complexity O(logY)
	public boolean isPowerOfFour(int num) {
		int base=1;
        while(base < num)
        	base=base*4;
        
        if (base == num) return true;
        return false;
    }
	//*/
	/* Approach 02A: NAIVE but faster. Doesn't exceed time limit. 2 ms
	public boolean isPowerOfFour(int num) {
        while(num > 1) {
            if(num % 4 != 0) 
                return false;
            num /= 4;
        }
        return num == 1;
    }
    //*/
/* Approach 01: using Math.log [4ms 38.9 MB]. Added Math.floor : [1 ms 37 MB]
	public boolean isPowerOfFour(int num) {
		if(num ==0) return false;
        Double logDiv=Math.log(num)/Math.log(4);
        return logDiv == Math.floor(logDiv);
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
