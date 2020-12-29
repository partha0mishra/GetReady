package com.leetcode.recursion.backtracking;

import java.util.Arrays;

/* 
 * Given an integer array with all positive numbers and no duplicates, 
 * find the number of possible combinations that add up to a positive integer target.
Example:
nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Therefore the output is 7.

Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
 */
public class CombinationSum4 {
	int result=0;
    public int combinationSum4(int[] nums, int target) {
    	Arrays.sort(nums);
        backtrack(nums, target);
        return result;
    }
    private void backtrack(int[] nums, int target){
        if(target < 0) return;
        else if(target == 0) {result+=1; return;}
        else{
            for(int i=0; i< nums.length; i++){
//            	System.out.println(nums[i]);
            	if(nums[i] ==1) {
            		backtrack(nums, target-1);
            	} else {
            		backtrack(nums, target%nums[i]);
            	}
            }
        }
    }
	public static void main(String[] args) {
		CombinationSum4 cs4= new CombinationSum4();
		System.out.println(cs4.combinationSum4(new int[] {1,2,3},4));
		System.out.println(cs4.combinationSum4(new int[] {2,1,3},35));
	}

}
