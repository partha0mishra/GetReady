package com.leetcode.recursion.arrays;
/* 1304. Find N Unique Integers Sum up to Zero
 * 
 * Given an integer n, return any array containing n unique integers such that they add up to 0.

 

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]
 

Constraints:

1 <= n <= 1000
 * */
public class UniqueIntegersSumZero {
	 public int[] sumZero(int n) {
	        int[] result=new int[n];
	        boolean even=(n%2==0);int i;
	        for(i=0; i< n/2; i++){// calculate 2*i +1, pos and neg
	            result[2*i]=2*i+1;
	            result[2*i+1]=-result[2*i];
	        }
	        if(!even)
	            result[2*i]=0;
	        return result;
	    }
}
