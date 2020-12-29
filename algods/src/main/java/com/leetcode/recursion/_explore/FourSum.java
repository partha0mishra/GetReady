package com.leetcode.recursion._explore;
/* 18. 4Sum
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Notice that the solution set must not contain duplicate quadruplets.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [], target = 0
Output: []
 

Constraints:

0 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */
import java.util.*;
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmd= new HashMap<Integer, Integer>();// number and last index
        for(int i=0; i< nums.length; i++) hmd.put(nums[i], hmd.getOrDefault(nums[i], i));
        Integer[] n=new Integer[hmd.size()];
        hmd.keySet().toArray(n);
        List<List<Integer>> result= new ArrayList<>();
        for(int i=0; i< n.length; i++)
        	for(int j=i+1; j< n.length; j++)
        		for(int k=j+1; k< n.length; k++) {
        			int needNum=target - (n[i]+n[j]+n[k]);
        			if(hmd.containsKey(needNum) 
        					&& hmd.get(needNum) != i
        					&& hmd.get(needNum) != j
        					&& hmd.get(needNum) != k) {
        				System.out.println(i+" "+j+" "+k+" "+hmd.get(needNum));
        				Integer[] entry={nums[i],nums[j],nums[k],nums[hmd.get(needNum)]};
        				result.add(Arrays.asList(entry));
        			}
        		}
        return result;
    }
	public static void main(String[] args) {
		System.out.println(new FourSum().fourSum(new int[] {1,0,-1,0,-2,2}, 0));
	}

}
