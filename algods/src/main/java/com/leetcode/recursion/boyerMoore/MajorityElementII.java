package com.leetcode.recursion.boyerMoore;
/*
 * Majority Elements II
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Note: The algorithm should run in linear time and in O(1) space.
 * Example 1:
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
import java.util.*;
public class MajorityElementII {
	/* Approach 02 - Boyer-Moore Voting Algorithm O(n) time O(1) space 
	 * REF: https://leetcode.com/problems/majority-element-ii/solution/
	 * There can be only 1 more than n/2, 2 more than n/3, 3 more than n/4 and so on
	 * so, we need to keep top 2 elements and their counts
	 * They don't affect each other's count
	 * Other elements reduce their counts.
	 * 
	 * NOTE: Need a 2nd pass to ascertain their actual counts*/
	public List<Integer> majorityElement(int[] nums){
		Integer t1=null, t2=null;
		int c1=0, c2=0;
		for(int n: nums) {
					if(t1 != null && n == t1) c1++;
			else 	if(t2 != null && n == t2) c2++;
			else	if(c1 == 0) {t1 = n; c1++;}
			else 	if(c2 == 0) {t2 = n; c2++;}
			else	{c1--; c2--;}
					if(c1 == 0) t1=null;
					if(c2 == 0) t2=null;
		}
		c1=0; c2=0;// second pass - to find actual counts
		for(int n: nums) {
			if( t1 != null && n== t1) c1++;
			if( t2 != null && n== t2) c2++;
		}
		
		List<Integer> result= new ArrayList<Integer>();
		if(c1 > nums.length/3) result.add(t1);
		if(c2 > nums.length/3) result.add(t2);
		return result;
	}
	/* Approach 01 - Naive O(n) time O(n) space*/
//	public List<Integer> majorityElement(int[] nums) {
//		Map<Integer,Integer> hm= new TreeMap<Integer, Integer>();
//        for(int n: nums) {
//        	hm.put(n, hm.getOrDefault(n, 0)+1);
//        }
//        List<Integer> result= new ArrayList<Integer>();
//        Set<Integer> keys=hm.keySet();
//        for(Integer k: keys) {
//        	if(hm.get(k) > nums.length/3) result.add(k);
////        	else break;
//        }
//        return result;
//    }
	public static void main(String[] args) {
		MajorityElementII instance = new MajorityElementII();
		System.out.println(instance.majorityElement(new int[] {3,2,3}));
		System.out.println(instance.majorityElement(new int[] {1,1,1,3,3,2,2,2}));
	}

}
