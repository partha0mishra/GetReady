package com.leetcode.arrays;

import java.util.Arrays;

/***
 * 1389. Create Target Array in the Given Order
 * 
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:

Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.

 

Example 1:

Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
Example 2:

Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
Output: [0,1,2,3,4]
Explanation:
nums       index     target
1            0        [1]
2            1        [1,2]
3            2        [1,2,3]
4            3        [1,2,3,4]
0            0        [0,1,2,3,4]
Example 3:

Input: nums = [1], index = [0]
Output: [1]
 

Constraints:

1 <= nums.length, index.length <= 100
nums.length == index.length
0 <= nums[i] <= 100
0 <= index[i] <= i
 */
public class CreateTargetArrayGivenOrder {
	/* Approach 03: Reverse of Approach 02
	 * At any position, find how many indices are there which are smaller than this
	 * Increment 'this' value by those many. Using MergeSort =>> O(nLogn)
	 * Code is complex and copied here from
	 * https://leetcode.com/problems/create-target-array-in-the-given-order/discuss/549583/O(nlogn)-based-on-%22smaller-elements-after-self%22.*/
	public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = i;
        }
        helper(a, 0, n, index, new int[n]);
        int[] result = new int[n];
        for(int i = 0; i < n; ++i) {
            result[index[i]] = nums[i];
        }
        return result;
    }
    
    static void helper(int[] a, int i, int j, int[] index, int[] tmp) {
        if (j - i <= 1) {
            return;
        }
        int k = (i + j) >>> 1;
        helper(a, i, k, index, tmp);
        helper(a, k, j, index, tmp);
        int x = i;
        int y = k;
        int z = 0;
        int count = 0;
        while(x < k && y < j) {
            while(y < j && index[a[y]] <= index[a[x]] + count) {
                ++count;
                tmp[z++] = a[y++];
            }
            index[a[x]] += count;
            tmp[z++] = a[x++];
        }
        while(x < k) {
            index[a[x]] += count;
            tmp[z++] = a[x++];
        }
        while(y < j) {
            tmp[z++] = a[y++];
        }
        for(int p = i, q = 0; p < j; ++p, ++q) {
            a[p] = tmp[q];
        }
    }
	/* Approach 02: Any index >= current value at the left of current position gets incremented
	 * Still O(n2)*/
//	public int[] createTargetArray(int[] nums, int[] index) {
//		for(int i=1; i< index.length; i++)
//			for(int j=0; j< i; j++)
//				if(index[j] >=index[i]) index[j]++;
//		int[] result=new int[nums.length];
//		for(int i=0; i< index.length; i++)
//			result[index[i]]=nums[i];
//		return result;
//	}
	/* Approach 01: Brute*/
//	public int[] createTargetArray(int[] nums, int[] index) {
//        int[] result=new int[nums.length];
//        Arrays.fill(result, -1);;
//        for(int i=0; i< index.length; i++) {
//        	if(result[index[i]] != -1)
//        		for(int j=result.length-1;j> index[i]; j--) {
//        			result[j]=result[j-1];
//        		}
//        	result[index[i]]=nums[i];
//        }
//        return result;
//    }
}
