package com.leetcode.arrays._easy;

import java.util.Arrays;

/** TODO Anki
 * 88. Merge Sorted Array
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 

Constraints:

-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n
 */
public class MergeSortedArrays {
	/**
	 * Fill from the back. more efficient implementation
	 * O(n+m)/ O(1)
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
	    // two get pointers for nums1 and nums2
	    int p1 = m - 1;
	    int p2 = n - 1;
	    // set pointer for nums1
	    int p = m + n - 1;

	    // while there are still elements to compare
	    while ((p1 >= 0) && (p2 >= 0))
	      // compare two elements from nums1 and nums2 
	      // and add the largest one in nums1 
	      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

	    // add missing elements from nums2
	    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	  }
	/**
	 * Fill from the back.
	 * O(n+m)/ O(1)
	 */
//	public void merge(int[] nums1, int m, int[] nums2, int n) {
//		if(m ==0) {
//			for(int i=0; i< n; i++) nums1[i]=nums2[i];
////			nums1=nums2;
//			printArray(nums1);
//			return;
//		}
//		if(n ==0) {
//			printArray(nums1);
//			return; 
//		}
////        m=m-1; n=n-1;// read and compare from end of numbers and start filling at the end of nums1
//        for(int ip=nums1.length-1;ip>=0; ip--) {// ip -> insertion point
//        	if		(m == 0 ) 					nums1[ip]=nums2[--n];
//        	else if	(n == 0) 					break;
//        	else if (nums1[m-1] >= nums2[n-1]) 	nums1[ip]=nums1[--m];
//        	else								nums1[ip]=nums2[--n];
////        	printArray(nums1);
//        }
//        printArray(nums1);
//    }
	private void printArray(int[] n) {
		for(int i: n) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		new MergeSortedArrays().merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
		new MergeSortedArrays().merge(new int[] {1,2,3,7,0,0,0}, 4, new int[] {2,5,6}, 3);
		new MergeSortedArrays().merge(new int[] {1,2,3,7}, 4, new int[] {}, 0);
		new MergeSortedArrays().merge(new int[] {0,0,0}, 0, new int[] {2,5,6}, 3);
		new MergeSortedArrays().merge(new int[] {1,2,3,7,0,0,0}, 4, new int[] {0,5,6}, 3);
		new MergeSortedArrays().merge(new int[] {0}, 0, new int[] {1}, 1);
	}

}
