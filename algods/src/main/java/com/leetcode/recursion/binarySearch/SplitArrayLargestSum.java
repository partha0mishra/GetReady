package com.leetcode.recursion.binarySearch;
/*
 * 410. Split Array Largest Sum - HARD
 * Given an array nums which consists of non-negative integers and an integer m, 
 * you can split the array into m non-empty continuous subarrays.
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * Example 1:
 * Input: nums = [7,2,5,10,8], m = 2
 * Output: 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
 * Example 2:
 * Input: nums = [1,2,3,4,5], m = 2
 * Output: 9
 * Example 3:
 * Input: nums = [1,4,4], m = 3
 * Output: 4
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 106
 * 1 <= m <= min(50, nums.length)
 */
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
public class SplitArrayLargestSum {
	/**
	 * If you take a close look, you would probably see how similar this problem is with LC 1011 above. 
	 * Similarly, we can design a feasible function: given an input threshold, then decide if we can split the array into 
	 * several subarrays such that every subarray-sum is less than or equal to threshold. In this way, we discover the monotonicity 
	 * of the problem: if feasible(m) is True, then all inputs larger than m can satisfy feasible function. 
	 * You can see that the solution code is exactly the same as LC 1011. 
	 */
	public int splitArray(int[] nums, int m) {
        int left =Arrays.stream(nums).max().getAsInt();// important to start from Max
        int right=Arrays.stream(nums).sum();
        while(left < right) {
        	int mid=left+(right-left)/2;
        	if(isFeasible(nums,mid,m)) right=mid;
        	else left=mid+1;
        }
        return left;
    }
	private boolean isFeasible(int[] nums, int targetSum, int groups) {
		int total=0, count=0;
		for(int n: nums) {
			total+=n;
			if(total > targetSum) {
				total=n;
				count++;
				if(count == groups) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		SplitArrayLargestSum instance= new SplitArrayLargestSum();
		assertEquals(18,instance.splitArray(new int[] {7,2,5,10,8}, 2));
		assertEquals( 9,instance.splitArray(new int[] {1,2,3,4,5}, 2));
		assertEquals( 4,instance.splitArray(new int[] {1,4,4}, 3));// important.
	}

}
