package com.algods.leetcode;
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
public class MajorityElementsII {
	public List<Integer> majorityElement(int[] nums) {
		Map<Integer,Integer> hm= new TreeMap<Integer, Integer>();
        for(int n: nums) {
        	hm.put(n, hm.getOrDefault(n, 0)+1);
        }
        List<Integer> result= new ArrayList<Integer>();
        Set<Integer> keys=hm.keySet();
        for(Integer k: keys) {
        	if(hm.get(k) > nums.length/3) result.add(k);
//        	else break;
        }
        return result;
    }
	public static void main(String[] args) {
		MajorityElementsII instance = new MajorityElementsII();
		System.out.println(instance.majorityElement(new int[] {3,2,3}));
		System.out.println(instance.majorityElement(new int[] {1,1,1,3,3,2,2,2}));
	}

}
