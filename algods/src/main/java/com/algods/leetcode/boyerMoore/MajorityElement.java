package com.algods.leetcode.boyerMoore;
/*
 * Majority Element
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
//import java.util.Map;
//import java.util.TreeMap;
import static org.junit.Assert.assertEquals;
public class MajorityElement {
	/* Approach 02: Boyer-Moore - easy to understand for n/2 - O(n) - O(1)*/
	public int majorityElement(int[] nums) {
		int top=nums[0], count=0;
		for(int n: nums) {
			if(n == top) count++;
			else count--;
			if(count <0 ) {
				top=n;
				count=0;
			}
		}
		return top;
	}
	/* Approach 01: Brute Force - O(n) - O(n)*/
//    public int majorityElement(int[] nums) {
//    	Map<Integer,Integer> map= new TreeMap<Integer,Integer>();
//    	for(int n: nums) {
//    		int count=map.getOrDefault(n, 0)+1;
//    		if(count > nums.length/2) return n;
//    		map.put(n, count);
//    	}
//    	return -1;
//    }
	public static void main(String[] args) {
		MajorityElement instance = new MajorityElement();
		assertEquals(3,instance.majorityElement(new int[] {3,2,3}));
		assertEquals(2,instance.majorityElement(new int[] {2,2,1,1,1,2,2}));
	}
}
