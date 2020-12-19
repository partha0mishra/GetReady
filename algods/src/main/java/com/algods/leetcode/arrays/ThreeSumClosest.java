package com.algods.leetcode.arrays;
/* 16. 3Sum Closest
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Constraints:
3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
 */
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        int sum=Integer.MIN_VALUE, delta=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i< nums.length; i++)
            for(int j=i+1; j< nums.length; j++)
                for(int k=j+1; k< nums.length; k++){
                    int s=nums[i]+nums[j]+nums[k];
                    int d=Math.abs(target-s);
                    if(d < delta) {
                        sum=s;
                        delta=d;
                    }
                }
        return sum;
    }
	public static void main(String[] args) {
		ThreeSumClosest tsc= new ThreeSumClosest();
		assertEquals(2,(tsc.threeSumClosest(new int[] {1,1,1,0}, 0)));
		assertEquals(2,(tsc.threeSumClosest(new int[] {-1,2,1,-4}, 1)));
		assertEquals(1,(tsc.threeSumClosest(new int[] {1,1,-1}, 0)));
	}

}
