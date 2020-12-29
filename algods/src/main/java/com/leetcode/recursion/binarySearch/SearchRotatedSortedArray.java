package com.leetcode.recursion.binarySearch;
/***
 * 33. Search in Rotated Sorted Array
 * 
 * You are given an integer array nums sorted in ascending order, and an integer target.
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * If target is found in the array return its index, otherwise, return -1.
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * 
 * Constraints:
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is guranteed to be rotated at some pivot.
 * -10^4 <= target <= 10^4
 */
import static org.junit.Assert.assertEquals;
public class SearchRotatedSortedArray {
	public int search(int[] nums, int target) {
		int n=nums.length;
		int left=0, right=n-1;
		while(left < right) {// minimize values that are less than nums[hi]
			int mid=left+(right-left)/2;
			// if at any point mid, the value is less than nums[hi], we look left: right = mid
			if(nums[mid] < nums[right]) right=mid;
			else left=mid+1;
		}
		// left is the minimum value now. Maximum value is at nums[left-1] OR at the right-most, but that doesn't matter
//		System.out.println(left+" max: "+nums[left-1]);
		// left is supposed to be at 0th position. so, Left %num should be Zero.
		int rotation=left;// now left-rotation=0. So, the counting of indices starts from 0 as it should
		left=0; right=n; 
		while(left < right) {
			int mid=left+(right-left)/2;
			int midPlusRotation=(mid+rotation)%n;
			if(nums[midPlusRotation] >= target) right=mid;
			else left=mid+1;
		}
		left=(left+rotation)%n;// This is the original LEFT index
//		System.out.println(left+" val: "+nums[left]);
		return (nums[left] == target)? left: -1;
    }
	public static void main(String[] args) {
		SearchRotatedSortedArray instance = new SearchRotatedSortedArray();
		assertEquals(4,instance.search(new int[] {4,5,6,7,0,1,2}, 0));
		assertEquals(-1,instance.search(new int[] {4,5,6,7,0,1,2}, 3));
		assertEquals(-1,instance.search(new int[] {1}, 0));
		System.out.println(instance.search(new int[] {2,5,6,0,0,1,2}, 0));
	}

}
