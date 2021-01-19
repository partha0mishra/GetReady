package com.leetcode.binarySearch;
/**
 * 81. Search in Rotated Sorted Array II
 * 
 * You are given an integer array nums sorted in ascending order (not necessarily distinct values), and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,4,4,5,6,6,7] might become [4,5,6,6,7,0,1,2,4,4]).

If target is found in the array return its index, otherwise, return -1.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
 

Follow up: This problem is the same as Search in Rotated Sorted Array, where nums may contain duplicates. Would this affect the run-time complexity? How and why?
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class SearchRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		int left=0, n=nums.length, right=n-1;
		if(n < 1) return false;
		int min=Integer.MAX_VALUE;
		for(int i=0; i< n; i++) {
			if(nums[i] < min) {
				min=nums[i];
				left=i;
			}
		}
		boolean foundBigger=false;
		for(int i=left; i< n; i++) {
			if(nums[i] > min) foundBigger=true;
			if(foundBigger && nums[i] == min) {
				left=i; break;
			}
		}
		int rotation=left; left=0; right=n-1;
		while(left < right) {
			int mid=left+(right-left)/2;
			int midPlusRotation=(mid+rotation)%n;
			if(nums[midPlusRotation] >= target) right=mid;
			else left=mid+1;
		}
		left=(left+rotation)%n;
		return (nums[left]==target);
    }
	public static void main(String[] args) {
		SearchRotatedSortedArrayII instance = new SearchRotatedSortedArrayII();
		assertTrue(instance.search(new int[] {2,5,6,0,0,1,2}, 0));// true
		assertFalse(instance.search(new int[] {2,5,6,0,0,1,2}, 3));// false
		assertFalse(instance.search(new int[] {}, 5));// false
		assertTrue(instance.search(new int[] {3,1,1,1,1}, 3));// true
		assertTrue(instance.search(new int[] {2,2,2,0,2,2}, 0));// true
		assertTrue(instance.search(new int[] {1,3,1,1,1}, 3));// true
	}

}
