package com.leetcode.binarySearch;
/** TODO Anki
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 */
public class FindMinimumRotatedSortedArray {
	public int findMin(int[] nums) {
		int left=0, right=nums.length-1;
		while(left < right) {
			int mid=left+(right-left)/2;
			if(nums[mid] < nums[right]) right=mid;
			else left=mid+1;
		}
		return nums[left];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
