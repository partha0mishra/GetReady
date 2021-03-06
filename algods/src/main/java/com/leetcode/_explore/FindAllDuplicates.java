package com.leetcode._explore;
/*
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [2,3]
 */
import java.util.*;
public class FindAllDuplicates {
	// Approach 02: since 1 ≤ a[i] ≤ n (n = size of array)
	// Use [Array Index] to indicate which number is already seen
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result= new ArrayList<Integer>();
		for(int num: nums) {
			int n=Math.abs(num);
			if(nums[n-1] < 0)
				result.add(n);
			else
				nums[n-1] *=-1;
		}
		
		return result;
    }
	// Approach 01: 16 ms 49+ mb
//	public List<Integer> findDuplicates(int[] nums) {
//		HashSet<Integer> tempSet= new HashSet<Integer>();
//		ArrayList<Integer> resList=new ArrayList<Integer>();
//		
//		for(int i=0; i< nums.length; i++) {
//			if(tempSet.contains(nums[i])) {
//				resList.add(nums[i]);
//			}else {
//				tempSet.add(nums[i]);
//			}
//		}
//		return resList;
//    }
	public static void main(String[] args) {
		FindAllDuplicates instance= new FindAllDuplicates();
		int[] input= {1,2,1,3,2,5};
		System.out.println(instance.findDuplicates(input));// [1,2]
		int[] input2= {4,3,2,7,8,2,3,1};
		System.out.println(instance.findDuplicates(input2));// [2,3]
	}
	

}
