package com.leetcode.recursion.strings;
/* 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-231 <= x <= 231 - 1
 */
public class ReverseInteger {
	 private static final int INT_MIN=Integer.MIN_VALUE;
	    private static final int INT_MAX=Integer.MAX_VALUE;
	    public int reverse(int x) {
	        long result=0;
	        boolean negative=false;
	        if(x< 0) {negative=true; x*=-1;}
	        while(x > 0){
	            result=result*10+x%10;
	            x/=10;
	            if(negative && result*-1 < INT_MIN) return 0;
	            else if(result > INT_MAX) return 0;
	        }
	        if(negative) result*=-1;
	        return(int)result;
	    }
}
