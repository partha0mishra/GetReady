package com.algods.leetcode.math;

public class PowerOfThree {
/*Approach 01: can't do it during Interview*/
	 public boolean isPowerOfThree(int n) {
	       // 1162261467 is 3^19,  3^20 is bigger than int  
	    return ( n>0 &&  1162261467%n==0);
	    }
}
