package com.algods.leetcode;
/*
 * WEEKLY Contest 200
 * Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.

A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:

0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
Where |x| denotes the absolute value of x.

Return the number of good triplets.
 *
 *Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
Output: 4
Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].
 *
 *Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
Output: 0
Explanation: No triplet satisfies all conditions.
 *
 * Constraints
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 */
public class GoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        if(arr.length <=3) return 0;
        for(int i=0; i<arr.length -1; i++) {
        	for(int j=i+1; j<arr.length; j++) {
        		
        	}
        }
        
        return 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
