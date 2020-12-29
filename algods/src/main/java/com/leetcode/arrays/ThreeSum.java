package com.leetcode.arrays;
/* 15. 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []

Constraints:
0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
import java.util.*;
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i< nums.length; i++){
        	if(nums[i] >0) continue;// since the array is sorted, this is a dead end
        	if(i>0 && nums[i] == nums[i-1]) continue;// skip duplicates
            int toFind=0-nums[i];
            HashSet<Integer> hSet=new HashSet<>();
            for(int j=i+1; j< nums.length; j++){
                int needNum=toFind-nums[j];
                if(hSet.contains(needNum)){
                    result.add(Arrays.asList(new Integer[] {nums[i],nums[j],needNum}));
                    while(j+1< nums.length && nums[j]==nums[j+1]) j+=1;// skipping duplicates
                }
                hSet.add(nums[j]);
            }
        }
        return result;
    }
	public static void main(String[] args) {
		ThreeSum ts=new ThreeSum();
		System.out.println(ts.threeSum(new int[] {-1,0,1,2,-1,-4}));
		System.out.println(ts.threeSum(new int[] {}));
		System.out.println(ts.threeSum(new int[] {0}));
		System.out.println(ts.threeSum(new int[] {0,0,0,0}));
	}

}
