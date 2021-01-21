package com.leetcode;
/* Increasing Triplet Subsequence
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
 */
import static org.junit.Assert.*;
public class IncreasingTripletSubsequence {
	/* O(N) O(1)
	 * find the first_num and then second_num
	 * */
	public boolean increasingTriplet(int[] nums) {
        int firstNum=Integer.MAX_VALUE, secondNum=Integer.MAX_VALUE;
        for(int n: nums) {
        	if(n< firstNum) firstNum=n;
        	else if(n< secondNum && n> firstNum) secondNum=n;
        	else if(n > secondNum) return true;
        }
        return false;
    }
	public static void main(String[] args) {
		assertTrue(new IncreasingTripletSubsequence().increasingTriplet(new int[] {1,2,3,4,5}));
		assertFalse(new IncreasingTripletSubsequence().increasingTriplet(new int[] {5,4,3,2,1}));
		assertTrue(new IncreasingTripletSubsequence().increasingTriplet(new int[] {2,1,5,0,4,6}));
	}

}
