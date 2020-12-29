package com.leetcode.recursion;
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
    	//attempt 02: good enough
    	//return getMinBinarySearch(nums,0,nums.length-1);
    	
    	// attempt01: brute-force
//    	int pivot=0;
//        for(int i=0; i< nums.length-1;i++) {
//        	if(nums[i] > nums[i+1]) {
//        		pivot=i+1;// Stopped at the biggest element, next element is last (starting)
//        		break;
//        	}
//        }
//        return nums[pivot];
    }
    
//    private int getMinBinarySearch(int[] nums, int start, int end) {
//    	if(start==end) return nums[start];
//    	int pivot=(start+end)/2;
//    	if(nums[pivot] > nums[pivot+1]) {// this is THE pivot
//			return nums[pivot+1];
//		}else if(nums[end] > nums[start]) {
//			return getMinBinarySearch(nums,start,pivot);
//		}else {
//			return Math.min(getMinBinarySearch(nums,start,pivot),getMinBinarySearch(nums,pivot+1,end));
//		}
//    }
	public static void main(String[] args) {
		RotatedArrayDuplFindMinimum instance= new RotatedArrayDuplFindMinimum();
		int[] nums1= {1,3,5};
		System.out.println(instance.findMin(nums1));//1
		int[] nums2= {2,2,2,0,1};
		System.out.println(instance.findMin(nums2));//0
		int[] nums3= {1,3};
		System.out.println(instance.findMin(nums3));//1
		int[] nums4= {3,1,3};
		System.out.println(instance.findMin(nums4));//1
		int[] nums5= {5,1,3};
		System.out.println(instance.findMin(nums5));//1
		int[] nums6= {1,1};
		System.out.println(instance.findMin(nums6));//1
		int[] nums7= {3,1};
		System.out.println(instance.findMin(nums7));//1
		int[] nums8= {1,1,1};
		System.out.println(instance.findMin(nums8));//1
		int[] nums9= {10,1,10,10,10};
		System.out.println(instance.findMin(nums9));//1
	}

}
