package com.leetcode._explore;
/***
 * 713. Subarray Product Less Than K
 * 
 * Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
* Hint:
* For each j, let opt(j) be the smallest i so that nums[i] * nums[i+1] * ... * nums[j] is less than k. opt is an increasing function.
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class SubarrayProductLessThanK {
	/* Approach 03: replacing memo with count*/
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int result=0, toAdd=0,last=nums.length-1;
		for(int i=nums.length-1; i>=0; i--) {
			if(nums[i] >= k) {toAdd=0; last=i; continue;}
			if(nums[i] ==1) {toAdd+=1; result+=toAdd; continue;}
			toAdd=0; int product=1;
			for(int j=i; j<=last; j++) {
				product*=nums[j];
				if(product < k) toAdd++;
				else {
					last=j;
					break;
				}
			}
			result+=toAdd;
		}
		return result;
	}
	/* Approach 02: bettered with memo. getting MLE*/
//	public int numSubarrayProductLessThanK(int[] nums, int k) {
//		if(nums.length == 0) return 0;
//		int result=0;
//		ArrayList<Integer> products=new ArrayList<>();
//		for(int i=nums.length-1; i>= 0; i--) {
////			System.out.println(nums[i]);
//			if(nums[i] > k) {// start afresh
//				products=new ArrayList<Integer>();
//				continue;
//			}else {
//				ArrayList<Integer> tempProducts= new ArrayList<Integer>();
//				tempProducts.add(nums[i]);
//				for(int j=0; j< products.size(); j++) {
//					if(nums[i] ==0) tempProducts.add(0);
//					if(nums[i] ==1) tempProducts.addAll(products);
//					int p=products.get(j)*nums[i];
//					System.out.println(p);
//					if(p < k) {
//						tempProducts.add(p);
//					}else break;// dead combination hereafter
//				}
//				result+=tempProducts.size();
//				products=tempProducts;
//			}
//		}
//		return result;
//	}
	/* Approach 01: Brute force - TLE*/
//	public int numSubarrayProductLessThanK(int[] nums, int k) {
//		if(nums.length ==0) return 0;
//        int result=0;
//        for(int i=0; i< nums.length; i++) {
//        	int prod=1;
//        	for(int j=i; j< nums.length; j++) {
//        		prod*=nums[j];
////        		System.out.println(prod);
//        		if(prod<k) result++;
//        		else break;
//        	}
//        }
//        return result;
//    }
	public static void main(String[] args) {
		assertEquals(8,new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
		assertEquals(0,new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[] {1,1,1}, 1));
	}
}
