package com.algods.leetcode.explore.october;
/* 132 Pattern
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the O(n) solution?

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 104
-109 <= nums[i] <= 109
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class Find132Pattern {
	/* Approach 01: keep track of minimum so far and check if there's a lesser element greater than the min */
	public boolean find132pattern(int[] nums) {
        int minVal=Integer.MAX_VALUE;
        int n=nums.length;
        
        minVal=Integer.MAX_VALUE;
        for(int i=0; i< n; i++) {
        	if(nums[i] > minVal && nextGreaterIsValid(nums,i,minVal)) return true;
        	minVal=Math.min(minVal, nums[i]);
        }
        return false;
    }
	private boolean nextGreaterIsValid(int[] nums, int pivot, int minVal) {
		for(int i=pivot+1; i< nums.length; i++) {
			if(nums[i] < nums[pivot] && nums[i] > minVal) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Find132Pattern instance = new Find132Pattern();
		assertFalse(instance.find132pattern(new int[]{1,2,3}));
		assertTrue(instance.find132pattern(new int[]{1,3,2}));
		assertFalse(instance.find132pattern(new int[]{2,1,3}));
		assertFalse(instance.find132pattern(new int[]{2,3,1}));
		assertFalse(instance.find132pattern(new int[]{3,1,2}));
		assertFalse(instance.find132pattern(new int[]{3,2,1}));
	}
}
