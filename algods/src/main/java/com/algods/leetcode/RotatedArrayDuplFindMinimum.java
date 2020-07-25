package com.algods.leetcode;
/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * The array may contain duplicates.
 * 
 * Input: [1,3,5]
 * Output: 1
 * 
 * Input: [2,2,2,0,1]
 * Output: 0
 * 
 * Note:
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */
public class RotatedArrayDuplFindMinimum {
    public int findMin(int[] nums) {
    	
    	// attempt01: brute-force
    	int pivot=0;
        for(int i=0; i< nums.length-1;i++) {
        	if(nums[i] > nums[i+1]) {
        		pivot=i+1;// Stopped at the biggest element, next element is last (starting)
        		break;
        	}
        }
        return nums[pivot];
    }
	public static void main(String[] args) {
		RotatedArrayDuplFindMinimum instance= new RotatedArrayDuplFindMinimum();
		int[] nums1= {1,3,5};
		System.out.println(instance.findMin(nums1));
		int[] nums2= {2,2,2,0,1};
		System.out.println(instance.findMin(nums2));
	}

}
