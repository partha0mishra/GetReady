package com.leetcode.recursion;
/* 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * */
import java.util.*;
public class NextPermutation {
	public void nextPermutation(int[] nums) {
        int i, j;
        // I) Start from the right most digit and 
        // find the first digit that is
        // smaller than the digit next to it.
        for (i = nums.length-1; i > 0; i--)
            if (nums[i-1] < nums[i])
               break;

        // If no such digit is found, its the edge case 1.
        if (i == 0) {
        	Arrays.sort(nums);
        	return;
        }
            
         // II) Find the smallest digit on right side of (i-1)'th 
         // digit that is greater than number[i-1]
        int x = nums[i-1], smallest = i;
        for (j = i+1; j < nums.length; j++)
            if (nums[j] > x && nums[j] <= nums[smallest])
                smallest = j;
        
        // III) Swap the above found smallest digit with 
        // number[i-1]
        int temp = nums[i-1];
        nums[i-1] = nums[smallest];
        nums[smallest] = temp;
        
        // IV) Sort the digits after (i-1) in ascending order
        Arrays.sort(nums, i, nums.length);
        return;
    }
}
