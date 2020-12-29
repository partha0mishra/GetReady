package com.leetcode.recursion;
/***
 * 697. Degree of an Array
 * 
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 

Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation: 
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 

Constraints:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
 */
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
public class DegreeOfArray {
	public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> start= new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> count= new HashMap<Integer, Integer>();
        int len=0, maxCount=0;
        for(int i=0; i<nums.length; i++) {
        	start.putIfAbsent(nums[i], i);
        	int c=count.getOrDefault(nums[i], 0)+1;
        	count.put(nums[i], c);
        	if(c> maxCount) {
        		maxCount=c;
        		len=i-start.get(nums[i])+1;
        	}else if(c == maxCount) {
        		int tempLen=i-start.get(nums[i])+1;
        		if(tempLen < len) len=tempLen;
        	}
        }
        return len;
    }
	public static void main(String[] args) {
		DegreeOfArray instance= new DegreeOfArray();
		assertEquals(2,instance.findShortestSubArray(new int[] {1,2,2,3,1}));
		assertEquals(6,instance.findShortestSubArray(new int[] {1,2,2,3,1,4,2}));
		assertEquals(7,instance.findShortestSubArray(new int[] {2,1,1,2,1,3,3,3,1,3,1,3,2}));
	}

}
