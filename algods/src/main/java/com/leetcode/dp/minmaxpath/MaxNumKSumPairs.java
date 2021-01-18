package com.leetcode.dp.minmaxpath;
/**
 * Max Number of K-sum pairs
 * You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= 10^9
*
* Hints
* The abstract problem asks to count the number of disjoint pairs with a given sum k.
* For each possible value x, it can be paired up with k - x.
* The number of such pairs equals to min(count(x), count(k-x)), unless that x = k / 2, 
* 	where the number of such pairs will be floor(count(x) / 2).
 */
import java.util.*;
public class MaxNumKSumPairs {
	/**
	 * two numbers a + b = k
	 * so, we're trying to find a and k-a
	 * it will be sum of min(count(a), count(k-a)) unless a=k/2 where it's count(a)/2 as k=2a
	 * O(N)/ O(N) keeping counts in a hashmap
	 */
	public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> numCount=new HashMap<>();
        int result=0;
        for(int n: nums) numCount.put(n, numCount.getOrDefault(n, 0)+1);
        for(int n: numCount.keySet()) {
        	if(k%2 ==0 && n == k/2) result+=numCount.get(n)/2;
        	else result+=Math.min(numCount.get(n), numCount.getOrDefault(k-n,0));
        	numCount.put(n, 0);
        }
        return result;
    }
	public static void main(String[] args) {
		MaxNumKSumPairs msp=new MaxNumKSumPairs();
		System.out.println(msp.maxOperations(new int[] {1,2,3,4},5));
	}
}
