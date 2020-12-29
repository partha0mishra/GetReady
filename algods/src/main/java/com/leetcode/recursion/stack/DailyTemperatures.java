package com.leetcode.recursion.stack;
/* 739. Daily Temperatures
 * Monotonic Stack
 * Given a list of daily temperatures T, return a list such that, for each day in the input, 
 * tells you how many days you would have to wait until a warmer temperature. 
 * If there is no future day for which this is possible, put 0 instead.
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], 
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * Note: The length of temperatures will be in the range [1, 30000]. 
 * Each temperature will be an integer in the range [30, 100].
 */
import java.util.*;
public class DailyTemperatures {
	public int[] dailyTemperatures(int[] T) {
        Stack<int[]> stack=new Stack<int[]>();
        int[] result=new int[T.length];
        for(int i=T.length-1; i>=0; i--) {
        	int days=0;
        	while(!stack.isEmpty() && stack.peek()[0] <= T[i]) {// no use of lower temperature
        		int[] p=stack.pop();
        		days+=p[1];// when you pick me up, you're skipping the lower ones I've picked up earlier
        	}
        	if(stack.isEmpty()) {// haven't found
        		days=0;
        	}else {
        		days+=1;
        	}
        	stack.push(new int[] {T[i],days});
        	result[i]=days;
        }
        return result;
    }
}
