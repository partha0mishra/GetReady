package com.leetcode._explore;
/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) 
 * which has the largest product.
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
import static org.junit.Assert.assertEquals;
public class MaxProductSubarrays {
	public int maxProduct(int[] nums) {
        int globalMax=nums[0], localMax=nums[0], localMin=nums[0];
//        System.out.println("lmin: "+localMin+" lmax: "+localMax+" gmax: "+globalMax);
        for(int i=1; i<nums.length; i++) {
        	int tempLocalMax=Math.max(nums[i], Math.max(nums[i]*localMax, nums[i]*localMin));
        	int tempLocalMin=Math.min(nums[i], Math.min(nums[i]*localMax, nums[i]*localMin));
        	localMax=tempLocalMax;
        	localMin=tempLocalMin;
        	if(localMax > globalMax) globalMax=localMax;
//        	System.out.println("lmin: "+localMin+" lmax: "+localMax+" gmax: "+globalMax);
        }
        return globalMax;
    }
	public static void main(String[] args) {
		MaxProductSubarrays instance= new MaxProductSubarrays();
		assertEquals(6,instance.maxProduct(new int[] {2,3,-2,4}));
		assertEquals(0,instance.maxProduct(new int[] {-2,0,-1}));
		assertEquals(48,instance.maxProduct(new int[] {2,3,-2,-1,4}));
	}

}
