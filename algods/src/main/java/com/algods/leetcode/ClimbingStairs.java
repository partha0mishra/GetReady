package com.algods.leetcode;
/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
 *
 *Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 *
 * Constraints:
 * 1 <= n <= 45
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
    	int[] cache =new int[n+1];
    	if(n==1) return 1;
    	cache[1]=1;
    	cache[2]=2;
    	for(int i=3; i<=n; i++) {
    		cache[i]=cache[i-1]+cache[i-2];
    	}
        return cache[n];
    }
    
	public static void main(String[] args) {
		ClimbingStairs instance= new ClimbingStairs();
		System.out.println(instance.climbStairs(1));
		System.out.println(instance.climbStairs(2));
		System.out.println(instance.climbStairs(3));
		System.out.println(instance.climbStairs(45));
	}

}
