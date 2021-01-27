package com.leetcode.arrays;
/**
 * Check If All 1's Are at Least Length K Places Away
 * Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other, otherwise return False.
Example 1:
Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.
Example 2:
Input: nums = [1,0,0,1,0,1], k = 2
Output: false
Explanation: The second 1 and third 1 are only one apart from each other.
Example 3:

Input: nums = [1,1,1,1,1], k = 0
Output: true
Example 4:

Input: nums = [0,1,0,1], k = 1
Output: true
Constraints:

1 <= nums.length <= 10^5
0 <= k <= nums.length
nums[i] is 0 or 1
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class CheckAllOnesKDistanceAway {
	public boolean kLengthApart(int[] nums, int k) {
        if(k==0) return true;
        int count=1-nums[0];// starting 1 is not counted but starting 0 is
        for(int i=1; i< nums.length; i++) {
        	int n=nums[i];
        	if(n ==0) count+=1;
        	else {
        		if(count<k) return false;
        		count=0;
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		assertTrue(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {1,0,0,0,1,0,0,1}, 2));
		assertFalse(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {1,0,0,1,0,1}, 2));
		assertTrue(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {1,1,1,1,1}, 0));
		assertTrue(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {0,1,0,1}, 1));
		assertTrue(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {1,1}, 0));
		assertTrue(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {0,1,0,1}, 1));
		assertTrue(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {0,1,1,1}, 0));
		assertTrue(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {1,1,0,1}, 0));
		assertTrue(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {1}, 0));
		assertTrue(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {0}, 0));
		assertTrue(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {0,0}, 0));
		assertTrue(new CheckAllOnesKDistanceAway().kLengthApart(new int[] {1}, 1));
	}
}
