package com.algods.leetcode;
/*
 * Number of Ways Where Square of Number Is Equal to Product of Two Numbers
 * Given two arrays of integers nums1 and nums2, return the number of triplets formed (type 1 and type 2) under the following rules:

Type 1: Triplet (i, j, k) if nums1[i]2 == nums2[j] * nums2[k] where 0 <= i < nums1.length and 0 <= j < k < nums2.length.
Type 2: Triplet (i, j, k) if nums2[i]2 == nums1[j] * nums1[k] where 0 <= i < nums2.length and 0 <= j < k < nums1.length.
 

Example 1:

Input: nums1 = [7,4], nums2 = [5,2,8,9]
Output: 1
Explanation: Type 1: (1,1,2), nums1[1]^2 = nums2[1] * nums2[2]. (4^2 = 2 * 8). 
Example 2:

Input: nums1 = [1,1], nums2 = [1,1,1]
Output: 9
Explanation: All Triplets are valid, because 1^2 = 1 * 1.
Type 1: (0,0,1), (0,0,2), (0,1,2), (1,0,1), (1,0,2), (1,1,2).  nums1[i]^2 = nums2[j] * nums2[k].
Type 2: (0,0,1), (1,0,1), (2,0,1). nums2[i]^2 = nums1[j] * nums1[k].
Example 3:

Input: nums1 = [7,7,8,3], nums2 = [1,2,9,7]
Output: 2
Explanation: There are 2 valid triplets.
Type 1: (3,0,2).  nums1[3]^2 = nums2[0] * nums2[2].
Type 2: (3,0,1).  nums2[3]^2 = nums1[0] * nums1[1].
Example 4:

Input: nums1 = [4,7,9,11,23], nums2 = [3,5,1024,12,18]
Output: 0
Explanation: There are no valid triplets.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
1 <= nums1[i], nums2[i] <= 10^5

 */
import java.util.*;
public class NumWaysSquareProductNums {
    public int numTriplets(int[] nums1, int[] nums2) {
    	int result=0;
    	if(nums1.length ==1 || nums2.length ==1) return 0;
        HashMap<Long,Integer> num1Square= new HashMap<Long, Integer>();
        HashMap<Long, Integer> num2Square= new HashMap<Long, Integer>();
        for(int i=0; i<nums1.length; i++) {
        	long val=(long) (nums1[i]*nums1[i]);
        	num1Square.put(val, num1Square.getOrDefault(val, 0)+1);
        }
        for(int i=0; i<nums2.length; i++) {
        	long val=(long) (nums2[i]*nums2[i]);
        	num2Square.put(val, num2Square.getOrDefault(val, 0)+1);
        }
        for(int i=0; i<nums1.length-1; i++) {
        	for(int j=i+1; j<nums1.length; j++) {
        		long val=(long)(nums1[i]*nums1[j]);
        		if(num2Square.containsKey(val)) result+=num2Square.get(val);
        	}
        }
        for(int i=0; i<nums2.length-1; i++) {
        	for(int j=i+1; j<nums2.length; j++) {
        		long val=(long)(nums2[i]*nums2[j]);
        		if(num1Square.containsKey(val)) result+=num1Square.get(val);
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		NumWaysSquareProductNums instance= new NumWaysSquareProductNums();
		System.out.println(instance.numTriplets(new int []{1}, new int[] {2}));
		System.out.println(instance.numTriplets(new int []{1,2}, new int[] {2}));
		System.out.println(instance.numTriplets(new int []{1}, new int[] {1,2}));
		System.out.println(instance.numTriplets(new int []{7,4}, new int[] {5,2,8,9}));
		System.out.println(instance.numTriplets(new int []{1,1}, new int[] {1,1,1}));
		System.out.println(instance.numTriplets(new int []{7,7,8,3}, new int[] {1,2,9,7}));
		System.out.println(instance.numTriplets(new int []{4,7,9,11,23}, new int[] {3,5,1024,12,18}));
	}

}
