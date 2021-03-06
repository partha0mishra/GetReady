package com.leetcode.binarySearch;
/** TODO Anki
 * 1283. Find the Smallest Divisor Given a Threshold - Medium
 * 
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array by it 
 * and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
 * Each result of division is rounded to the nearest integer greater than or equal to that element. 
 * (For example: 7/3 = 3 and 10/2 = 5). It is guaranteed that there will be an answer. 
 * Example 1:
 * Input: nums = [1,2,5,9], threshold = 6
 * Output: 5
 * Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
 * If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
 * Example 2:
 * Input: nums = [2,3,5,7,11], threshold = 11
 * Output: 3
 * Example 3:
 * Input: nums = [19], threshold = 5
 * Output: 4
 * Constraints:
 * 1 <= nums.length <= 5 * 10^4
 * 1 <= nums[i] <= 10^6
 * nums.length <= threshold <= 10^6
 */
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
public class SmallestDivisiorGivenThreshold {
	/**
	 * There's no way to know but to ACTUALLY do the division.
	 * From? 1 => the result would be = sum(elements)
	 * To?   whatever gives the least threshold=0. that would be max(elements)+1
	 * that means, we'll have to keep dividing by the numbers from 1 to max+1 and see what's the divisior.
	 * 
	 * A smarter way would be to search using Binary search. Left=1, Right=Max+1 Are we optimizing?
	 * If we take Mid and get a threshold that's <=6, anything more than Mid will anyway give threshold <=6.
	 * We REALLY need to look left to find any value lesser than Mid that can give us threshold <=6.
	 * So, this is really a Binary Search problem.
	 * 
	 * O(logN)/ O(1)
	 */
	public int smallestDivisor(int[] nums, int threshold) {
        int left=1, right=Arrays.stream(nums).max().getAsInt()+1;
        while(left < right) {
        	int mid=left + (right-left)/2;
        	if(isFeasible(mid,nums,threshold)) right=mid;
        	else left=mid+1;
        }
        return left;
    }
	// Ceiling is better implemented using (n-1)/divisor +1
	private boolean isFeasible(int divisor, int[] nums, int threshold) {
		for(int n: nums) {
			threshold-=(n-1)/divisor+1;
			if(threshold < 0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		SmallestDivisiorGivenThreshold instance= new SmallestDivisiorGivenThreshold();
		assertEquals(5,instance.smallestDivisor(new int[] {1,2,5,9}, 6));
		assertEquals(3,instance.smallestDivisor(new int[] {2,3,5,7,11}, 11));
		assertEquals(4,instance.smallestDivisor(new int[] {19}, 5));
	}

}
