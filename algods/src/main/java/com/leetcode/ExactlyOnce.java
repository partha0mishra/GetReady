package com.leetcode;
/*
 * Given an array of numbers nums, in which exactly two elements appear only once 
 * and all the other elements appear exactly twice. Find the two elements that appear only once.
 * 
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * 
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
import java.util.*;
public class ExactlyOnce {
	public int[] singleNumber(int[] nums) {
		HashSet<Integer> tempSet= new HashSet<Integer>();
		int[] result=new int[2];
		
		for(int i=0; i< nums.length; i++) {
			if(tempSet.contains(nums[i])) {
				tempSet.remove(nums[i]);
			}else {
				tempSet.add(nums[i]);
			}
		}
		Iterator<Integer> itSet=tempSet.iterator();
		int i=0;
		while(itSet.hasNext()) {
			result[i++]=itSet.next();
		}
        return result;
    }
	public static void main(String[] args) {
		ExactlyOnce instance= new ExactlyOnce();
		int[] input= {1,2,1,3,2,5};
		System.out.println(Arrays.toString(instance.singleNumber(input)));

	}

}
