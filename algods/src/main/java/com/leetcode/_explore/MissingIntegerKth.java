package com.leetcode._explore;
/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * Find the kth positive integer that is missing from this array.
 * 
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 *
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 * 
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 */
public class MissingIntegerKth {
    public int findKthPositive(int[] arr, int k) {
    	int i=0, pos=0;
    	while (k > 0) {
    		i++;
    		if(pos < arr.length && arr[pos] == i) {
    			pos++;
    		}else {
    			k--;
    		}
    	}
    	return i;
    }
	public static void main(String[] args) {
		MissingIntegerKth instance = new MissingIntegerKth();
		int[] input01= {2,3,4,7,11};
		System.out.println(instance.findKthPositive(input01, 5));// 9
		System.out.println(instance.findKthPositive(input01, 1));//1
		System.out.println(instance.findKthPositive(input01, 0));// invalid value as K>0
		int[] input02= {1,2,3,4};
		System.out.println(instance.findKthPositive(input02, 2));// 2
		
	}

}
