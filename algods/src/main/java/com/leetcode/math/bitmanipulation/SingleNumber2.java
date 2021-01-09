package com.leetcode.math.bitmanipulation;
/** TODO Anki
 * Single Number 2
 * 
 * Given an integer array nums where every element appears three times except for one, 
 * which appears exactly once. Find the single element and return it.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
 

Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
import java.util.*;
public class SingleNumber2 {
	/**
	 * Approach 03: Bitwise NOT, AND and XOR
	 * seenOnce = ~seenTwice & (seenOnce ^ num);
	 * seenTwice = ~seenOnce & (seenTwice ^ num);
	 * O(N)/ O(1) - 1 ms
	 * 
	 * Explanation: FIRST pass
	 * seenOnce ^ num => num
	 * In the first iteration, seenTwice is 0 and remains 0 throughout. why?
	 * seenTwice = !seenOnce (bitwise, comparatively false for all the numbers as all the numbers are already inside) 
	 * & (seenTwice ^ num => num) => this has to yield 0 
	 * 
	 * it's different in the SECOND pass
	 * seenOnce now has every number. For each number, seenTwice doesn't have it, so, ~seenTwice is okay. 
	 * but seenOnce ^ num now means seenOnce ^ num ^ num as it's there twice now. this nullifies num
	 * so, seenOnce doesn't have the number anymore. seenTwice doesn't have the number anyway. so,
	 * ~seenOnce & (seenTwice ^ num) => [doesn't have the num] & num => num
	 * so, this time, in the second pass, seenTwice has all the numbers
	 * 
	 * THIRD pass:
	 * in the first line, ~seenTwice is false since it has all the numbers. 
	 * so, the first line doesn't add the number to seenOnce
	 * in the second line, it's [! doesn't have it] & (seenTwice ^ num ^ num) => [true] & [0] => num is removed from seenTwice
	 * 
	 * Therefore, the only number that remains in any of these bitmasks is the single number in the very first bitmask
	 */
	public int singleNumber(int[] nums) {
        int seenOnce=0, seenTwice=0;// two bitmasks
        for(int n: nums){
            seenOnce=~seenTwice & (seenOnce ^ n);
            seenTwice=~seenOnce & (seenTwice ^ n);
        }
        return seenOnce;
    }
	/**
	 * Approach 02: 6x faster
	 * Keep in hashset and calculate sum of numbers.
	 * compare that sum from the triple of hashset elements sum
	 * O(N)/ O(N)
	 */
//	public int singleNumber(int[] nums) {
//        HashSet<Integer> uniqueNums= new HashSet<>();
//        long sum=0, hashSetSum=0;
//        for(int n: nums){
//            if(uniqueNums.add((Integer)n)) {hashSetSum+=3*(long)n;}// NOTE the (long)
//            sum+=n;
//        }
//        return (int)((hashSetSum-sum)/2);// the single number is missing TWICE
//    }
	/**
	 * Approach 01: Brute
	 * Keep in hashmap for the 1st and 3rd time and see which one's duplicate
	 * O(N)/ O(N)
	 */
//	public int singleNumber(int[] nums) {
//        HashMap<Integer,Integer> numCount= new HashMap<>();
//        int result=0;
//        for(int n: nums){
//            int c=numCount.getOrDefault(n,0);
//            if(c != 1) result^=n;
//            numCount.put(n,c+1);
//        }
//        return result;
//    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
