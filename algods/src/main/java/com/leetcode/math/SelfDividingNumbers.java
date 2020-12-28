package com.leetcode.math;
/* 728. Self Dividing Numbers
 * A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.
 * */
import java.util.*;
public class SelfDividingNumbers {
	public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result= new ArrayList<Integer>();
        for(int num=left; num<=right; num++) {
        	int n=num;
        	boolean toSkip=false;
        	while(n>0) {
        		int digit=n%10;
        		if(digit ==0 || num%digit !=0) {
        			toSkip=true;
        			break;
        		}
        		n/=10;
        	}
        	if(!toSkip) result.add(num);
        }
        return result;
    }
}
