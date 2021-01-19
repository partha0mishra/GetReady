package com.leetcode.binarySearch;
/** TODO Anki
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
		/**
		 * Anyway, we wanted to find the 'rotation' value and when there are no duplicate items, we can easily do it using Binary Search
		 * But when there're duplicate items, even the minimum value can have duplicates, we can still find it at O(n)
		 * 
		 * if the values were 1 1 2 3 3 4 and has become 4 1 1 2 3 3 we need the first 1 which is now at index 1. so, rotation = 1
		 * if those were 3 3 4 1 1 2, rotation = 3 and similarly, for 2 3 3 4 1 1 it's 4 and for 1 2 3 3 4 1 it's 5 for THE LAST ONE
		 * so, we really need to find the last index of the minimum value
		 * O(logN) avg case, but if all are same number it would become O(n) <- worst case
		 */
		int left=0, n=nums.length, right=n-1, rotation=0;
		if(n < 1) return false;
		
		int min=Integer.MAX_VALUE;
		for(int i=0; i< n; i++) {
			if(nums[i] <= min) {
				min=nums[i];
				rotation=i;
			}
		}
		// the only case is when min value is duplicated. 
		// we need to find the last one from rightmost ( single/group) of the mins
		// 12345 112345 1123451 11234511
		while(rotation > 0 && nums[rotation-1]==nums[rotation]) rotation-=1;
		System.out.println("rotation: "+rotation);
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
		assertFalse(instance.search(new int[] {1}, 5));// false
		assertTrue(instance.search(new int[] {3,1,1,1,1}, 3));// true
		assertTrue(instance.search(new int[] {2,2,2,0,2,2}, 0));// true
		assertTrue(instance.search(new int[] {1,3,1,1,1}, 3));// true
	}

}
