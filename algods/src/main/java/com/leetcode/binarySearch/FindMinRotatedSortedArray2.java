package com.leetcode.binarySearch;
/** TODO Anki
 * 154. Find minimum in rotated sorted array w/ DUPLICATES
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
 */
public class FindMinRotatedSortedArray2 {
	/**
	 * Binary Search: O(logN)
	 * Worst case O(N)
	 */
	public int findMin(int[] nums) {
    	// attemp03 : non-recursive
    	int first=0;
    	int last=nums.length -1;
    	
    	while(first < last) {
    		int mid=first+(last -first)/2;
    		if(nums[mid] > nums[last]) first=mid+1;
    		else if (nums[mid] < nums[last]) last=mid;
    		else last--;
    	}
    	return nums[first];
    }
	/**
	 * Attempt 01: O(n)
	 * go to the last biggest number.
	 */
//	public int findMin(int[] nums) {
//    	int pivot=0;
//        for(int i=0; i< nums.length-1;i++) {
//        	if(nums[i] > nums[i+1]) {
//        		pivot=i+1;// Stopped at the biggest element, next element is last (starting)
//        	}
//        }
//        return nums[pivot];
//    }
}
