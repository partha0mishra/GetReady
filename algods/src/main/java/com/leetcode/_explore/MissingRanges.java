package com.leetcode._explore;
/* 
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, 
 * where all elements are in the inclusive range.
 * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
 * Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
 * Each range [a,b] in the list should be output as:
 * "a->b" if a != b
 * "a" if a == b
 * Example 1:
 * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]
Explanation: The ranges are:
[2,2] --> "2"
[4,49] --> "4->49"
[51,74] --> "51->74"
[76,99] --> "76->99"
Example 2:

Input: nums = [], lower = 1, upper = 1
Output: ["1"]
Explanation: The only missing range is [1,1], which becomes "1".
Example 3:

Input: nums = [], lower = -3, upper = -1
Output: ["-3->-1"]
Explanation: The only missing range is [-3,-1], which becomes "-3->-1".
Example 4:

Input: nums = [-1], lower = -1, upper = -1
Output: []
Explanation: There are no missing ranges since there are no missing numbers.
Example 5:

Input: nums = [-1], lower = -2, upper = -1
Output: ["-2"]
 

Constraints:

-109 <= lower <= upper <= 109
0 <= nums.length <= 100
lower <= nums[i] <= upper
All the values of nums are unique.
 */
import java.util.*;
public class MissingRanges {
	/* Approach 01: Brute Force O(N) - TLE 
	 * Approach 02: Brute but only working on ranges O(numRanges) */
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result= new ArrayList<>();
        int n=nums.length,i;
        if(n==0) {
        	if(lower == upper) result.add(""+lower);
        	else result.add(""+lower+"->"+upper); 
        	return result;
        }
        Integer start=null, end=null;
        for(i=0; i< n && lower<=upper;) {
        	if(nums[i] < lower) {i++;}// skip
        	else if(nums[i] == lower) {i++; lower++;} 
        	else if(nums[i] > lower) {
        		start=lower;
        		end=Math.min(nums[i]-1,upper);
        		if(start == end) result.add(""+start);
        		else result.add(""+start+"->"+end);
        		
        		if(i< n) lower=nums[i];// otherwise IndexOutOfBounds Exception
        	}
        }
        if(nums[i-1] < upper) {
        	start=nums[i-1]+1;
        	if(start == upper) result.add(""+start);
        	else result.add(""+start+"->"+upper);
        }
        return result;
    }
	public static void main(String[] args) {
		System.out.println(new MissingRanges().findMissingRanges(new int[] {0,1,3,50,75}, 0, 99));// [2, 4->49, 51->74, 76->99]
		System.out.println(new MissingRanges().findMissingRanges(new int[] {}, 1, 1));// ["1"]
		System.out.println(new MissingRanges().findMissingRanges(new int[] {}, -3, -1));// [-3->-1"]
		System.out.println(new MissingRanges().findMissingRanges(new int[] {-1}, -1, -1));// []
		System.out.println(new MissingRanges().findMissingRanges(new int[] {-1}, -2, -1));// [-2]
		System.out.println(new MissingRanges().findMissingRanges(new int[] {-1}, -1, 0));// [0]
		System.out.println(new MissingRanges().findMissingRanges(new int[] {-1000000000,1000000000}, -1000000000,1000000000));// [-999999999->999999999]
	}
}
