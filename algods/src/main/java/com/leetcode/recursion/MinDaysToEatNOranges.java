package com.leetcode.recursion;
/*
 * There are n oranges in the kitchen and you decided to eat some of these oranges every day as follows:

Eat one orange.
If the number of remaining oranges (n) is divisible by 2 then you can eat  n/2 oranges.
If the number of remaining oranges (n) is divisible by 3 then you can eat  2*(n/3) oranges.
You can only choose one of the actions per day.

Return the minimum number of days to eat n oranges.

 

Example 1:

Input: n = 10
Output: 4
Explanation: You have 10 oranges.
Day 1: Eat 1 orange,  10 - 1 = 9.  
Day 2: Eat 6 oranges, 9 - 2*(9/3) = 9 - 6 = 3. (Since 9 is divisible by 3)
Day 3: Eat 2 oranges, 3 - 2*(3/3) = 3 - 2 = 1. 
Day 4: Eat the last orange  1 - 1  = 0.
You need at least 4 days to eat the 10 oranges.
Example 2:

Input: n = 6
Output: 3
Explanation: You have 6 oranges.
Day 1: Eat 3 oranges, 6 - 6/2 = 6 - 3 = 3. (Since 6 is divisible by 2).
Day 2: Eat 2 oranges, 3 - 2*(3/3) = 3 - 2 = 1. (Since 3 is divisible by 3)
Day 3: Eat the last orange  1 - 1  = 0.
You need at least 3 days to eat the 6 oranges.
Example 3:

Input: n = 1
Output: 1
Example 4:

Input: n = 56
Output: 6
 

Constraints:

1 <= n <= 2*10^9
 */
import java.util.*;
public class MinDaysToEatNOranges {
	/* Approach 04: DP good one*/
	Map<Integer, Integer> dp = new HashMap<>();
	public int minDays(int n) {
	    if (n <= 1)
	        return n;
	    if (!dp.containsKey(n))
	        dp.put(n, 1 + Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3)));
	    return dp.get(n);
	}
	/* Approach 03: BFS + Memoization */
//	public int minDays(int n) {
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(n);
//        int res = 0;
//        Set<Integer> set = new HashSet<>();
//        while(!q.isEmpty()){
//            res++;
//            int size = q.size();
//            for(int i = 0; i < size; i++){
//                int cur = q.poll();
//                if(cur == 0){
//                    return res - 1;
//                }
//                if(set.contains(cur)){
//                    continue;
//                }
//                else{
//                    set.add(cur);
//                }
//                if(cur % 3 == 0){
//                    q.offer(cur / 3);
//                }
//                if(cur % 2 == 0){
//                    q.offer(cur / 2);
//                }
//                q.offer(cur - 1);
//            }
//        }
//        return res;
//    }
	/* Approach 02: DFS + Memoization*/
//    public int minDays(int n) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 1);
//        map.put(2, 2);
//        map.put(3, 2);
//        return helper(n, map);
//    }
//    
//    private int helper(int n, Map<Integer, Integer> map) {
//        if(map.containsKey(n)) return map.get(n);
//        int a = n;
//        if(n % 2 == 0) {
//            a = Math.min(a, 1 + helper(n / 2, map));
//        } else {
//            a = Math.min(a, 1 + helper(n - 1, map));
//        }
//        if(n % 3 == 0) {
//            a = Math.min(a, 1 + helper(n / 3, map));
//        } else if(n % 3 == 1) {
//            a = Math.min(a, 1 + helper(n - 1, map));
//        } else {
//            a = Math.min(a, 2 + helper(n - 2, map));
//        }
//        map.put(n, a);
//        return a;
//    }
	/* Approach 01: Naive - using memoization - Time limit exceeded*/
//	private HashMap<Integer,Integer> minHM;
//    public int minDays(int n) {
//    	if(n ==1) return 1;
//    	minHM= new HashMap<Integer, Integer>();
//    	minHM.put(0, 0);
//    	minHM.put(1, 1);
//    	minHM.put(2, 2);
//    	int min=0;
//    	
//    	for(int i=3; i<=n; i++) {
//    		boolean div2=false;
//        	boolean div3=false;
//    		if(i%2 ==0) div2=true;
//    		if(i%3 ==0) div3=true;
//    		if(div2 && div3) {
//    			min=Math.min(minHM.get(i/2), minHM.get(i/3));
//    		}else if(div2) {
//    			min=minHM.get(i/2);
//    		}else if(div3) {
//    			min=minHM.get(i/3);
//    		}
//    		min=Math.min(1+ min, 1+minHM.get(i-1));
//    		minHM.put(i, min);
//    	}
//    	return minHM.get(n);
//    }
    
	public static void main(String[] args) {
		MinDaysToEatNOranges instance = new MinDaysToEatNOranges();
		System.out.println(instance.minDays(1));
		System.out.println(instance.minDays(2));
		System.out.println(instance.minDays(3));
		System.out.println(instance.minDays(4));
		System.out.println(instance.minDays(5));
		System.out.println(instance.minDays(667517));
	}

}
