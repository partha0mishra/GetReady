package com.algods.leetcode;

import java.lang.reflect.Array;

/*
 * Given an array of integers arr. Return the number of sub-arrays with odd sum.

As the answer may grow large, the answer must be computed modulo 10^9 + 7.

Input: arr = [1,3,5]
Output: 4
Explanation: All sub-arrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.

Input: arr = [2,4,6]
Output: 0
Explanation: All sub-arrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.

Input: arr = [1,2,3,4,5,6,7]
Output: 16

Input: arr = [100,100,99,99]
Output: 4

Input: arr = [7]
Output: 1

Constraints:
1 <= arr.length <= 10^5
1 <= arr[i] <= 100
 */
public class SubArraysOddSum {
	public int numOfSubarrays(int[] arr) {
		int result=0;
		int modNum=1000000007;
		// o(n2) sub-optimum
		for(int i=0; i< arr.length; i++) {
			int sum=0;
			for(int j=i; j< arr.length; j++) {
//				System.out.println("i: "+i+" j: "+j+" val: "+arr[j]);
				sum+=arr[j] %modNum;
//					System.out.println(arr[k]+" sum: "+sum);
				if(sum %2 ==1) result++;
			}
		}
		
		return result;
    }
	public static void main(String[] args) {
		SubArraysOddSum instance = new SubArraysOddSum();
		int[] input1={1,3,5};
		System.out.println(instance.numOfSubarrays(input1));// 4
		int[] input2= {2,4,6};
		System.out.println(instance.numOfSubarrays(input2));// 0
		int[] input3= {1,2,3,4,5,6,7};
		System.out.println(instance.numOfSubarrays(input3));// 16
		int[] input4= {100,100,99,99};
		System.out.println(instance.numOfSubarrays(input4));// 4
		int[] input5= {7};
		System.out.println(instance.numOfSubarrays(input5));// 1
		int[] input6= {42,47,89,21,62,43,62,46,93,7,78,97,81,71,39,66,76,8,30,34,76,28,20,83,66,48,27,87,100,73,16,73,40,40,97,70,28,49,36,5,13,70,4,96,83,59,71,18,45,45,32,2,83,47,8,62,63,71,33,19,59,78,51,82,2,24,48,29,77,66,33,74,8,18,79,21,29,61,9,70,45,61,47,58,97,20,83,32,43,94,36,32,37,93,14,37,44,10,42,35,94,14,38,9,75,52,34,82,52,7,95,33,48,2,10,43,87,8,22,93,16,20,31,14,96,38,97,18,25,13,79,57,32,11,94,33,25,92,72,38,25,56,84,46,83,69,26,93,16,32,13,42,78,100,41,17,83,5,39,50,43,70,50,39,27,13,86,95,85,76,69,63,30,17,20,75,32,76,77,90,40,95,23,25,77,55,27,85,9,3,58,99,68,36,32,26,60,29,7,9,2,86,17,3,78,80,6,36,65,27,38,56,62,2,23,15,50,72,22,3,36,33,97,34,36,46,76,29,10,56,27,69,46,36,2,73,35,92,83,92,62,7,91,82,43,54,52,64,39,16,49,79,77,17,33,76,94,23,30,91,51,52,15,98,47,48,33,33,90,84,28,55,1,51,82,88,3,62,50,69,54,39,43,19,12,98,17,80,70,89,38,27,7,33,37,39,92,46,17,55,59,27,10,60,39,62,77,31,96,73,66,68,15,91,30,37,54,53,79,8,62,82,69,78,13,73,48,17,80,69,80,28,36,64,94,32,62,47,79,61,99,14,100,81,3,38,89,65,88,89,28,90,79,36,59,21,42,29,97,86,40,40,6,27,63,28,100,71,51,51,39,60,82,70,54,37,40,28,96,47,97,35,21,28,27,33,77,84,36,41,40,51,39,27,86,24,28,45,64,91,85,93,92,31,94,59,89,90,17,72,30,75,58,42,19,61,85,24,93,14,46,76,24,13,3,93,100,16,13,90,22,70,53,66,13,74,29,26,77,86,32,97,44,20,54,25,59,63,82,23,13,39,79,7,93,44,27,67,57,28,72,7,92,58,18,87,51,34,6,8,16,36,41,33,4,81,96,38,30,71,43,51,84,59,5,53,45,56,61,57,20,51,9,76,1,97,8,71,79,96,30,53,87,59,33,2,59,63,82,73,46,78,36,70,39,44,70,17,12,31,100,66,65,27,69,14,71,49,62,74,52,100,3,73,54,65,24,97,57,13,10,80,30,81,66,37,86,2,3,62,32,43,31,84,94,36,59,99,10,95,71,67,12,67,3,46,43,50,79,10,14,36,27,65,48,61,43,67,1,65,27,91,19,5,56,15,8,82,24,33,70,63,36,28,65,31,25,13,80,90,70,84,41,59,88,77,56,94,75,19,43,83,75,18,99,50,60,88,83,69,60,55,19,7,66,61,72,34,25,29,85,35,66,22,68,86,16,70,82,63,63,46,44,52,40,59,18,97,20,83,38,57,96,43,58,88,10,80,87,93,26,57,99,47,80,60,63,97,9,73,92,20,75,82,71,46,83,66,8,40,9,25,74,74,89,39,41,45,61,23,73,79,83,19,40,6,73,97,6,3,30,90,54,49,85,52,4,45,89,72,60,19,9,8,59,58,9,88,98,38,25,16,9,29,90,86,47,26,52,32,45,81,14,27,19,12,52,32,70,73,25,47,37,51,80,82,96,84,79,37,98,28,81,78,43,32,47,46,73,14,15,74,46,53,39,94,41,23,31,52,43,8,78,87,85,1,73,30,81,9,31,2,86,95,36,76,77,50,50,34,50,61,43,24,3,79,74,33,60,2,87,95,39,2,53,35,32,68,64,19,28,52,30,9,66,32,86,46,7,66,90,22,47,14,10,75,26,90,98,65,86,10,64,33,81,73,4,81,61,55,57,80,81,25,64,42,66,33,17,49,36,17,76,91,74,47,68,86,11,98,78,54,98,58,37,14,95,57,60,91,2,66,40,63,45,18,39,62,92,16,82,84,6,18,5,31,10,94,27,93,65,75,56,14,99,81,97,47,1,79,55,28,31,2,82,71,40,58,3,91,87,22,51,29,87,58,38,4,89,6,19,98,65,21,75,6,44,14,19,63,42,18,71,25,64,48,20,58,51,54,23,66,36,91,90,71,52,96,67,10,15,17,61,34,23,5,65,18,64,59,9,58,61,87,3,77,46,49,93,76,52,77,9,77,53,18,4,68,100,94,94,29,64,85,75,83,5,86,69,5,41,64,79,15,68,71,46,70,38,68,94,27,54,86,52,45,25,54,5,13,31,23,35,75,10,64,38,67,23,12,66,80,69,35,50,80,6,30,35,38,58,39,95,5,54,66,64,3,20,59,2,12,12,94,49,8,92,6,84,22,79,67,5,82,88,43,25,6,1,95,99,49,8,14,94,23,86,24,59,87,69,56,55,8,62,66,38,87,13,21,72,37,45,34,90,56,72,9,12,34,38,10,7,26,11,47,60,49,6,3,50,50,53,1,72,40,62,65,64,95,88,62,16,9,92,98,94,13,4,14,87,47,57,73,65,84,44,60,33,76,75,78,67,46,78,53,41,82,96,92,8,64,90,64,97,17,55,10,35,81,79,30,72,27,24,99,5,55,56,46,80,70,65,86,41,92,95,23,22,4,72,32,92,33,68,53,26,99,58,8,25,98,40,100,56,96,86,70,71,37,17,69,13,24,57,7,20,24,96,95,51,69,56,99,36,66,60,96,12,70,84,66,21,57,60,29,44,25,72,59,91,96,14,54,43,25,8,87,23,54,76,71,96,82,65,33,56,44,48,70,63,40,48,95,48,43,17,62,72,76,24,8,78,43,57,24,54,38,31,8,13,24,50,71,35,76,99,14,84,51,97,65,37,60,70,13,46,13,38,98,20,17,86,66,64,12,17,56,27,36,65,89,91,50,11,76,76,14,51,79,97,50,92,73,27,17,76,41,70,65,63,57,24,52,92,99,10,69,4,4,93,16,67,3,93,81,53,58,100,25,11,6,20,17,48,69,84,20,32,70,37,54,31,27,5,88,54,32,99,59,24,9,13,74,28,56,89,77,59,33,14,82,20,28,60,55,69,13,52,10,61,1,6,14,32,41,14,92,65,12,23,59,86,67,83,80,14,36,69,17,62,96,63,53,27,57,15,16,21,89,32,21,5,26,52,12,79,31,3,7,77,82,3,100,20,83,87,74,31,42,19,9,14,96,48,8,4,11,67,3,77,26,11,34,54,17,75,39,85,93,97,99,99,44,65,37,15,57,80,76,27,30,76,41,90,44,46,54,74,27,26,11,89,22,5,91,98,41,56,66,38,39,21,55,77,58,100,99,51,87,38,65,12,60,86,85,93,68,33,37,40,20,5,97,57,16,38,4,26,40,86,10,63,78,75,26,42,37,30,74,39,24,22,74,95,54,61,78,89,45,57,62,73,54,79,33,83,58,58,54,60,85,52,42,94,28,96,41,63,33,5,43,100,96,43,100,17,65,51,89,5,5,81,92,49,12,100,46,73,17,47,62,88,13,56,81,28,72,8,28,95,45,55,78,4,11,54,93,86,14,22,58,85,82,38,56,66,77,46,68,12,2,33,2,42,54,26,68,25,13,22,44,75,88,91,81,45,57,56,60,2,89,61,77,10,86,82,75,61,74,31,64,28,46,45,28,18,35,55,53,11,49,4,72,74,64,79,50,80,59,28,78,57,52,87,55,26,75,29,28,60,93,77,3,59,45,92,63,7,86,76,66,81,29,82,84,72,56,63,33,31,50,64,82,61,39,2,39,91,2,92,28,100,47,45,39,25,39,70,85,64,35,64,81,58,20,87,90,96,30,17,84,98,88,46,28,21,14,17,33,75,60,7,57,40,50,86,42,15,51,64,30,58,44,87,69,36,64,40,79,54,34,3,17,2,77,25,88,11,58,88,74,21,40,100,73,26,16,96,96,4,43,1,95,23,13,8,31,63,63,62,46,52,56,91,36,82,71,5,9,61,48,73,90,20,72,7,99,95,76,99,46,75,91,52,28,23,87,34,80,2,34,56,51,13,12,18,20,73,88,7,38,68,71,59,77,7,11,65,75,77,51,72,62,97,19,48,52,25,47,50,43,36,69,37,68,52,43,9,74,91,17,88,30,67,50,49,52,8,6,51,90,72,69,46,90,78,27,88,9,74,29,47,70,4,66,61,76,85,89,54,92,45,61,79,19,23,67,30,87,74,21,69,41,55,26,56,16,81,6,48,99,77,62,8,44,32,92,29,7,52,15,43,23,39,100,36,27,54,34,52,60,41,43,57,53,85,82,2,55,86,25,24,28,99,42,49,68,69,36,50,54,8,7,68,27,20,6,98,49,48,16,59,91,3,59,9,96,13,20,51,32,41,20,36,56,3,62,45,40,36,55,90,77,27,26,96,92,55,77,37,49,9,65,71,42,70,45,89,38,83,33,3,15,56,55,51,15,26,18,31,25,40,42,86,38,89,72,95,54,95,89,14,82,52,73,11,32,83,65,66,87,6,68,35,98,33,17,2,17,80,42,70,11,52,59,69,79,27,91,37,6,11,96,86,32,4,100,77,8,77,24,96,53,75,52,14,42,66,30,7,52,14,41,51,62,39,7,39,83,25,81,26,76,10,35,35,46,80,15,90,26,60,44,71,56,84,65,74,8,8,97,18,69,31,95,64,94,34,65,67,81,34,81,4,44,49,83,60,37,34,8,14,98,100,61,85,31,86,83,60,21,97,79,80,24,55,84,39,19,70,86,81,49,20,21,4,73,79,26,65,27,75,46,35,99,24,96,39,50,22,3,21,91,20,68,31,40,17,99,32,82,90,20,60,9,11,89,85,13,67,51,79,68,33,86,11,85,51,99,42,51,45,83,4,7,17,7,64,25,20,64,54,27,32,90,42,89,13,88,20,38,36,9,64,27,50,93,7,41,49,60,45,90,49,25,15,13,26,88,56,3,38,97,51,37,39,56,4,79,82,10,88,28,3,8,56,29,46,75,38,86,84,45,17,34,79,64,49,48,1,43,4,39,77,45,64,51,57,79,37,87,32,20,60,42,22,43,13,100,2,2,10,34,36,3,60,57,52,72,80,40,32,24,37,70,52,84,35,43,2,60,45,79,22,19,68,46,73,60,41,99,100,83,25,59,43,99,16,18,67,20,55,93,58,99,5,81,64,34,16,28,63,17,87,82,83,67,21,5,18,93,25,85,89,78,27,88,80,12,42,88,58,1,34,27,11,90,4,6,86,24,19,19,63,100,24,1,64,51,34,41,52,63,99,53,68,46,51,37,52,24,3,84,93,32,33,29,60,48,49,41,58,78,96,17,86,63,54,51,90,1,58,58,10,86,54,7,95,77,83,16,47,94,68,26,94,73,52,32,19,76,21,15,29,93,21,33,48,54,43,67,12,2,41,16,30,92,53,73,57,45,12,76,33,82,57,91,97,61,14,80,40,19,51,77,32,55,73,83,2,22,25,93,88,25,58,46,3,58,44,12,72,81,83,49,31,48,92,29,89,8,72,63,84,72,50,30,83,67,61,76,23,86,85,25,52,27,23,56,82,40,7,69,96,73,61,44,63,77,62,79,95,25,72,22,90,13,9,55,48,88,20,44,35,67,2,52,94,61,32,37,85,74,88,24,6,45,89,67,33,11,4,23,73,47,64,16,40,99,76,52,60,41,46,32,66,13,22,23,98,43,98,40,83,22,18,45,41,5,98,22,62,95,71,52,6,27,80,52,31,13,33,64,95,77,36,67,17,59,18,98,29,64,41,58,21,45,67,74,33,58,69,38,25,18,89,94,85,13,9,76,41,69,15,36,15,64,74,25,20,51,82,63,18,52,60,13,3,33,97,66,4,92,14,72,9,47,58,51,61,7,33,36,6,46,44,82,100,100,35,20,8,47,34,85,3,25,38,82,71,7,2,100,31,57,53,89,35,50,93,3,83,85,57,19,40,27,30,8,43,50,89,74,84,66,21,77,37,78,41,100,100,55,27,92,94,42,89,98,17,27,73,60,91,8,27,94,28,70,98,45,26,3,87,68,58,67,44,33,86,85,92,37,42,19,22,40,14,74,40,38,64,35,12,41,10,59,88,35,18,22,62,53,37,43,61,36,40,69,5,8,99,86,15,82,92,63,39,2,29,75,45,68,62,76,69,5,30,35,12,69,92,77,53,80,71,82,14,11,23,88,59,14,58,84,47,36,67,5,81,17,70,90,45,30,48,30,69,10,2,69,16,21,50,7,29,39,84,6,75,49,54,85,78,77,20,99,59,72,39,23,40,40,65,15,98,77,6,29,47,11,60,84,47,94,23,81,81,98,26,100,69,16,63,10,99,94,26,2,65,75,51,38,15,99,79,14,42,83,10,52,73,3,72,19,63,52,84,34,91,43,97,7,86,31,62,77,53,24,68,61,4,9,29,47,75,45,31,87,84,25,77,41,58,83,84,12,63,86,92,85,29,96,31,61,91,92,12,51,90,92,10,33,92,92,54,61,94,72,100,51,54,10,88,18,92,52,8,14,18,97,62,9,65,49,54,5,86,89,8,57,15,41,30,45,93,68,92,10,35,96,97,85,69,1,69,22,3,76,97,77,82,90,37,82,45,50,21,90,51,4,27,1,100,11,77,6,99,47,47,4,45,62,40,17,57,58,75,85,12,84,52,25,27,83,70,12,21,31,3,51,81,26,13,9,81,76,86,4,19,70,9,77,3,44,4,12,1,83,57,74,81,29,69,99,80,6,84,37,10,87,5,97,96,54,100,75,56,87,93,73,94,86,100,52,22,57,90,52,34,34,16,40,14,40,55,91,3,20,60,99,21,54,71,86,30,45,2,9,74,98,44,5,44,3,77,98,21,97,30,11,50,25,74,85,88,73,9,81,21,59,63,36,39,94,94,60,86,36,39,52,90,83,74,88,71,28,86,60,53,57,98,64,1,41,78,19,22,41,48,62,37,99,92,13,30,37,64,8,19,49,41,63,99,37,70,30,9,45,22,31,46,25,41,16,99,17,7,61,94,8,62,56,44,13,86,76,27,94,43,30,16,41,12,49,51,51,28,62,44,84,88,75,23,63,99,95,85,57,85,58,55,79,37,34,24,65,62,52,27,54,11,32,97,55,10,13,45,94,94,45,45,25,82,76,35,12,27,43,17,8,9,54,63,82,14,91,25,6,88,88,98,17,73,44,11,89,65,14,18,88,75,96,94,45,79,90,82,66,97,51,66,42,39,75,49,43,13,3,71,96,7,38,52,90,21,79,75,10,2,5,92,86,68,67,45,46,27,97,71,99,28,41,83,98,75,12,37,13,40,98,27,59,24,24,66,46,20,42,79,32,74,59,86,34,97,3,60,82,75,15,97,14,90,84,97,43,61,18,72,50,72,47,30,35,90,74,74,61,90,8,77,6,27,46,3,54,65,46,91,44,93,90,84,3,95,70,98,33,80,45,43,8,71,8,41,17,97,51,43,94,38,43,63,33,66,53,98,13,64,19,4,14,8,86,19,87,81,47,81,10,72,94,98,20,23,74,38,99,47,50,88,80,81,18,47,31,94,75,74,10,15,100,49,96,80,21,98,43,69,97,70,81,51,41,47,94,23,34,99,16,97,18,42,57,34,19,44,30,30,9,75,11,56,65,50,43,67,44,26,84,21,1,68,90,83,67,24,73,65,100,3,80,10,47,86,7,22,18,68,76,100,35,73,4,17,37,84,4,39,5,16,80,96,88,39,98,30,94,57,10,84,82,15,4,75,62,16,56,49,54,23,20,29,82,91,22,24,80,66,100,29,37,13,15,35,9,78,18,95,80,40,93,79,47,81,20,47,30,19,70,75,17,64,26,69,90,49,30,91,95,16,95,62,85,56,49,42,10,20,62,93,79,66,45,48,74,75,7,44,73,100,52,15,11,78,64,21,49,18,12,24,39,79,96,89,26,27,60,74,68,16,63,18,10,7,94,91,36,65,26,8,55,14,22,71,26,66,59,31,99,4,97,45,8,64,56,19,93,96,15,86,65,77,24,17,89,15,34,34,94,17,55,42,46,16,10,41,53,37,2,6,21,77,2,91,88,75,8,27,91,39,10,17,70,83,75,19,17,93,15,69,45,19,96,29,81,55,60,98,86,98,57,14,14,80,46,54,27,61,39,4,99,45,24,18,19,21,11,100,44,17,7,94,21,58,46,44,53,45,73,84,73,14,78,16,94,62,87,27,87,25,37,3,21,83,89,16,36,18,99,47,83,16,25,90,11,57,100,42,18,86,40,88,4,75,24,62,89,98,50,49,33,8,73,62,10,85,42,85,88,21,85,83,83,34,73,33,48,30,69,82,96,3,8,51,77,68,81,57,95,41,82,75,51,5,28,59,17,53,34,41,56,17,72,76,87,96,61,30,13,31,65,62,64,43,14,62,58,5,86,24,76,99,58,13,6,98,78,98,67,48,17,77,18,33,35,85,2,48,25,21,74,20,31,55,15,5,69,5,54,18,3,68,49,75,34,31,48,18,26,3,2,39,6,69,28,76,53,50,77,12,45,84,68,12,32,14,27,78,27,30,96,75,71,33,70,72,44,21,28,89,76,35,26,91,82,56,16,26,38,54,74,44,45,20,3,95,19,89,5,23,90,75,40,4,71,95,95,87,14,89,19,98,86,77,73,73,98,54,3,72,69,94,46,93,35,98,86,53,59,54,6,25,7,71,69,63,42,38,62,47,15,83,27,69,86,23,60,3,56,25,42,19,86,47,45,98,5,8,3,84,97,66,18,81,91,95,74,89,66,90,85,93,43,47,73,3,11,57,100,66,59,72,65,8,97,71,60,54,6,69,51,88,18,57,59,42,36,29,28,5,78,18,11,82,47,100,44,77,94,47,17,100,96,40,21,45,94,40,53,74,41,58,93,59,71,81,4,75,73,24,83,67,2,4,50,95,40,77,95,40,63,70,16,68,53,65,60,26,48,81,35,38,99,36,70,39,9,32,36,77,83,34,35,10,49,73,93,5,75,11,97,91,5,84,58,11,13,72,13,32,70,67,93,7,14,22,93,9,76,71,80,29,3,48,43,9,74,92,65,85,48,24,76,5,81,29,54,88,8,16,98,87,35,79,89,13,75,99,34,53,4,50,6,14,14,83,66,11,73,8,8,31,32,90,13,16,63,28,71,31,93,10,91,18,79,95,14,75,86,6,7,85,11,46,6,94,6,17,67,31,72,66,25,55,12,79,21,46,37,35,24,44,22,92,71,5,73,85,89,24,66,94,26,38,54,61,11,81,67,82,7,57,59,10,89,13,60,21,79,51,28,40,75,90,22,36,95,57,82,60,82,82,92,32,9,79,97,83,61,65,63,33,63,74,34,44,66,47,36,49,77,31,56,98,5,50,53,18,8,5,50,100,41,51,14,81,79,81,81,20,59,76,20,37,57,57,18,39,57,43,37,93,40,69,88,43,78,19,95,91,91,53,47,35,83,19,37,86,33,89,15,67,22,46,24,45,33,93,19,93,8,64,76,43,75,32,96,12,53,77,30,66,93,4,18,81,75,37,58,63,84,98,36,66,40,12,40,90,98,23,58,57,98,61,88,32,2,3,66,11,97,71,98,49,42,37,77,51,45,27,62,97,56,55,80,43,10,7,96,28,46,35,87,35,51,64,33,42,72,26,42,55,63,84,10,82,33,81,11,35,63,37,20,8,38,79,65,48,58,72,94,34,72,70,67,75,100,78,40,9,16,87,37,84,99,20,5,57,67,15,75,55,43,58,74,15,37,84,87,2,41,89,10,6,63,44,10,35,20,5,36,28,68,93,54,54,72,30,78,77,82,27,83,54,24,38,68,45,15,44,58,91,35,94,52,18,78,99,17,89,43,75,24,51,56,8,35,18,7,23,36,13,7,35,8,64,88,66,53,5,14,9,90,41,8,31,86,24,12,37,72,96,24,43,87,21,88,49,89,71,50,100,6,7,57,4,74,1,19,89,76,87,53,67,15,87,81,4,72,40,49,6,22,95,24,57,48,91,17,72,87,66,64,38,97,42,31,96,69,92,53,85,52,86,96,37,45,98,80,39,100,82,47,48,7,62,4,58,33,86,57,20,83,27,100,59,79,70,63,2,54,72,30,4,17,38,88,25,62,35,29,4,61,52,92,8,63,42,25,70,44,53,70,78,58,61,76,21,93,92,29,64,68,46,18,49,56,70,53,50,7,25,23,10,6,95,47,44,77,55,16,96,39,15,57,7,49,28,6,45,50,55,22,68,98,43,71,2,83,66,75,42,85,61,1,91,96,58,39,83,20,54,87,13,66,35,100,23,65,69,96,58,27,56,9,92,87,55,8,73,78,11,19,12,99,15,42,62,100,9,26,65,3,28,4,10,100,48,37,67,84,65,80,62,3,21,69,58,70,32,86,96,42,87,92,15,40,69,32,46,26,24,86,52,2,57,34,91,84,90,19,83,36,49,39,76,3,43,12,10,14,72,47,23,89,62,32,53,21,53,3,5,11,78,59,21,30,37,2,47,47,95,72,28,10,46,81,6,85,94,28,59,86,3,34,86,9,82,43,86,11,35,76,17,46,83,10,28,96,45,76,23,83,46,71,65,16,72,40,36,64,13,78,87,55,5,14,41,39,28,6,76,11,81,43,18,10,11,26,7,82,79,14,63,25,37,92,69,94,39,26,24,13,75,91,56,77,70,64,88,30,14,62,65,20,91,63,55,89,16,80,38,62,13,35,49,78,25,79,82,23,28,9,71,71,80,11,77,91,56,75,35,43,24,78,9,61,80,25,48,64,74,30,32,35,42,38,37,4,73,18,60,72,13,32,45,92,3,37,37,33,94,58,23,31,30,4,74,34,51,51,11,41,100,69,99,95,73,67,62,41,85,99,42,40,45,81,24,23,16,47,100,67,100,27,69,37,55,32,57,28,9,13,51,39,72,4,62,66,58,1,93,96,53,79,13,34,21,11,91,65,54,77,85,44,10,20,58,93,64,45,86,44,46,72,99,36,56,5,24,7,12,21,79,86,79,88,75,51,11,31,87,2,34,21,24,96,7,3,54,57,88,27,62,45,90,3,69,52,33,96,100,61,71,31,52,15,24,99,77,74,66,93,85,22,7,69,75,29,14,38,49,55,73,62,91,89,17,94,100,65,13,70,38,70,87,57,15,15,28,22,83,25,74,55,2,58,20,90,93,10,40,24,40,65,15,12,24,10,85,67,100,81,13,22,92,26,20,86,100,2,69,64,11,58,37,2,84,30,35,41,67,76,40,4,23,3,54,27,1,91,30,68,99,20,87,62,60,94,60,24,81,52,5,22,26,11,12,39,81,93,60,42,70,32,6,51,13,5,50,18,66,41,4,73,52,84,36,92,26,5,85,24,87,72,73,6,54,65,81,19,80,91,75,72,96,10,87,71,51,15,44,11,56,76,43,15,19,38,1,83,70,86,67,5,22,11,7,37,83,52,37,64,82,66,98,52,71,24,17,92,47,62,94,35,34,14,10,14,7,84,68,89,40,80,56,6,43,79,94,37,73,52,58,2,66,55,59,26,47,39,34,90,88,47,10,42,55,29,24,48,73,71,63,34,28,10,9,46,49,6,39,71,55,61,97,87,17,19,16,30,75,93,32,63,59,93,48,76,5,34,74,34,72,31,14,48,47,40,78,68,7,20,18,21,50,83,70,2,13,48,58,2,77,70,83,69,6,24,19,37,74,14,94,36,40,81,4,86,95,48,68,55,61,57,5,23,95,81,51,97,96,51,89,83,55,90,23,69,11,12,86,79,79,89,4,35,7,86,97,26,54,69,48,41,61,97,10,53,97,80,65,31,5,27,55,24,62,22,85,27,57,72,32,35,62,80,76,8,61,85,52,26,45,56,11,71,8,7,22,74,31,13,53,55,50,31,64,50,49,83,75,38,63,51,81,12,12,7,6,46,79,99,77,64,72,52,18,73,55,83,30,71,76,40,3,29,54,72,15,31,18,20,81,62,58,80,96,8,73,79,93,51,63,77,94,47,95,37,43,40,92,18,45,58,29,21,74,22,6,48,38,100,10,57,36,22,8,90,87,61,97,34,16,82,65,38,17,26,5,18,98,61,40,7,2,66,64,97,61,65,21,69,31,94,65,40,20,70,2,99,78,92,58,87,75,81,63,100,39,1,77,92,8,83,79,7,41,91,98,3,18,78,73,41,75,44,74,62,52,9,29,15,89,80,3,96,50,27,1,33,38,12,67,21,32,28,28,57,67,47,46,16,81,66,44,45,95,96,34,25,95,63,20,18,69,70,70,81,78,48,22,38,29,75,10,71,54,4,39,30,3,96,42,62,11,87,63,21,64,82,27,15,53,65,35,31,50,46,29,4,47,94,10,68,61,68,98,50,29,74,77,91,32,21,55,99,13,68,39,26,7,72,3,93,62,10,55,63,3,18,66,32,82,51,92,48,89,19,71,25,60,95,9,63,3,88,98,15,25,44,70,62,48,63,24,67,8,68,68,40,69,50,54,8,9,72,80,94,88,72,25,61,32,35,77,12,72,2,73,15,6,4,93,13,16,77,19,9,87,66,74,29,25,30,6,4,87,46,58,55,39,2,94,24,43,53,14,36,73,92,49,4,84,20,67,92,46,100,53,14,54,61,75,79,59,31,43,97,71,79,53,7,77,73,74,90,28,98,9,43,40,74,31,5,88,92,25,19,75,56,79,16,72,69,6,75,89,22,58,99,55,29,50,82,93,69,41,55,46,91,68,31,21,68,31,87,18,44,49,10,61,51,38,19,43,59,18,69,3,20,33,57,66,4,92,81,96,44,29,54,13,64,4,25,83,23,74,50,60,89,94,89,53,17,47,56,74,9,72,35,57,54,8,78,80,54,46,77,80,91,70,52,65,23,3,82,52,28,18,26,68,59,82,59,85,37,48,22,73,78,79,61,62,54,63,43,30,68,59,52,73,90,18,73,85,26,11,37,63,91,13,2,99,11,57,22,85,85,24,91,36,96,14,67,2,5,47,22,29,33,20,82,48,94,64,1,65,34,50,83,77,8,87,53,64,67,48,16,58,41,67,55,64,49,78,49,79,21,12,82,53,42,3,8,69,60,2,99,47,96,81,46,18,60,41,33,82,22,26,78,57,61,25,29,5,34,57,59,40,33,97,36,20,49,68,19,100,2,51,36,73,81,39,26,13,22,30,24,8,91,67,54,11,33,74,40,33,50,98,64,51,77,26,91,87,45,57,83,10,49,71,55,39,25,59,50,70,57,39,23,45,65,43,65,85,19,55,24,79,84,21,70,42,99,100,40,57,46,7,60,59,33,85,73,28,65,34,12,44,70,6,74,94,70,43,64,96,23,12,18,8,2,69,55,96,74,12,22,58,97,33,52,88,52,33,9,4,57,41,6,41,18,78,12,55,5,89,53,99,80,35,23,87,10,7,41,21,27,60,9,7,25,4,18,61,38,90,14,10,63,24,63,67,35,97,19,84,11,84,58,77,71,59,73,97,90,77,55,3,1,23,5,14,2,68,15,81,69,64,59,92,27,9,50,4,33,16,61,48,33,52,86,55,67,75,65,23,97,93,75,8,60,40,37,14,35,71,22,8,19,67,78,70,93,94,63,71,45,15,75,24,53,86,3,95,3,73,45,78,52,55,42,87,69,77,60,57,100,3,51,36,52,63,85,40,74,93,18,75,34,65,2,92,51,39,67,35,85,7,69,45,29,13,55,45,74,13,12,74,22,33,19,78,85,75,90,7,3,47,69,59,62,94,1,15,7,78,31,99,61,55,78,57,8,8,76,53,40,74,81,5,13,92,96,66,2,100,55,30,28,83,70,87,50,93,39,67,92,28,93,95,61,77,31,95,91,17,36,48,14,100,78,91,49,58,17,50,86,77,89,27,35,29,97,51,44,72,47,59,13,90,38,81,78,80,31,20,63,94,7,50,89,96,100,63,79,96,78,26,80,63,65,42,1,82,39,98,75,19,93,75,25,92,93,48,44,99,53,48,52,17,9,79,10,35,13,31,48,63,7,31,35,62,42,91,30,66,34,10,69,92,53,93,50,21,4,65,98,49,55,87,93,21,13,63,52,61,85,51,52,95,81,46,21,93,3,24,59,13,55,59,97,19,50,91,25,97,82,79,11,81,44,11,67,100,69,92,54,99,89,52,54,87,19,21,53,96,44,19,10,80,74,17,3,37,6,12,87,8,67,9,79,10,63,51,59,98,76,98,24,10,30,10,30,19,88,42,23,15,51,42,69,50,59,48,69,13,54,69,76,38,5,86,38,41,60,48,37,20,35,70,55,67,77,15,98,87,7,3,52,98,36,37,16,30,85,84,98,38,84,74,99,70,99,98,40,44,100,20,57,71,39,33,7,26,31,58,94,52,4,42,37,80,22,49,99,20,65,19,93,68,92,73,58,44,76,79,66,37,54,60,66,95,32,43,25,23,78,35,99,69,23,79,88,59,11,91,88,59,77,53,85,53,37,40,36,96,57,73,56,97,47,88,3,78,78,93,54,53,53,53,73,79,27,28,73,15,4,46,60,5,94,36,55,45,28,39,15,63,59,81,67,77,27,60,37,44,35,16,99,60,7,93,55,65,90,53,6,98,53,21,42,52,92,71,18,59,11,90,76,64,50,86,5,27,12,49,20,90,43,26,37,78,49,88,80,97,3,40,47,16,12,56,20,69,51,54,24,41,43,16,71,10,26,50,37,51,81,21,59,61,43,11,25,20,98,52,85,9,14,68,64,73,83,80,80,14,96,58,65,97,63,92,3,50,70,78,57,10,31,30,45,25,63,96,42,71,52,60,77,22,42,25,80,50,40,86,83,80,33,31,73,77,43,87,60,80,98,9,100,73,65,88,50,6,55,87,47,6,85,8,61,28,6,76,20,25,43,99,68,39,76,30,88,71,88,48,25,25,26,13,12,24,77,26,3,7,46,22,43,28,16,43,14,7,29,54,60,21,10,47,55,23,62,80,33,53,31,93,39,1,4,51,90,38,15,61,30,71,76,83,83,67,40,41,71,72,72,8,34,35,66,58,62,56,77,70,75,48,48,85,6,91,71,97,55,76,68,18,16,83,15,99,92,82,61,13,42,97,23,42,47,99,16,7,60,50,44,98,7,5,43,69,31,99,15,73,100,10,51,35,40,59,23,36,52,2,57,30,95,33,38,16,58,7,2,34,78,42,50,100,10,12,19,6,27,64,63,69,84,18,67,85,38,88,65,13,55,68,47,19,55,60,77,65,29,33,51,24,78,43,80,87,14,65,82,32,90,13,49,53,60,14,63,12,35,60,77,32,67,77,62,26,90,21,79,42,70,2,30,36,32,99,91,19,87,61,91,50,72,16,81,97,22,2,26,90,3,59,14,38,83,7,8,50,23,28,75,11,17,30,93,28,55,68,93,75,47,4,49,79,10,10,10,59,91,99,65,38,69,95,82,16,66,57,54,14,64,87,77,37,4,14,56,14,61,3,3,65,74,12,86,74,13,91,30,3,19,98,92,15,78,82,28,46,2,54,90,93,69,92,57,83,11,74,100,61,24,28,44,97,29,84,72,99,2,95,68,97,82,70,38,43,10,25,32,83,67,38,94,17,26,85,8,79,11,46,97,31,28,24,51,74,33,18,4,50,54,23,38,45,77,2,17,60,34,65,12,21,75,81,29,43,87,53,39,38,27,24,10,27,79,31,100,73,88,47,66,71,84,60,75,17,37,65,76,100,69,76,69,16,17,64,60,51,11,10,19,22,42,53,78,76,36,87,7,63,50,78,77,4,86,34,82,2,32,71,64,26,14,26,84,46,82,8,52,15,93,52,30,58,49,37,69,34,67,68,16,41,7,70,53,82,34,35,14,22,69,28,46,81,61,27,88,93,95,2,25,64,15,35,36,5,15,90,33,42,77,54,55,78,50,74,33,14,77,57,46,85,78,30,19,85,100,95,15,87,4,9,43,15,12,21,36,33,73,65,24,87,17,63,24,2,19,81,32,51,1,76,99,30,24,68,53,8,14,40,9,35,21,59,89,93,25,52,20,2,34,26,78,81,41,88,24,93,15,11,26,66,51,76,20,70,10,91,68,25,25,29,97,14,73,43,3,31,59,89,26,100,38,74,94,64,88,19,83,35,41,27,4,29,34,33,88,25,85,85,99,26,75,65,16,20,67,27,46,75,28,38,65,91,97,80,76,3,51,87,7,20,51,75,67,22,98,98,16,92,12,27,56,32,49,72,22,1,64,69,23,51,69,73,55,83,29,39,96,7,97,52,30,37,91,95,60,39,99,93,33,72,18,56,59,91,53,81,4,27,63,58,87,80,89,93,38,8,99,18,79,91,60,64,35,50,95,75,7,38,47,32,62,73,47,3,96,30,6,55,76,44,68,77,19,78,15,27,50,70,48,79,66,27,62,12,80,55,7,69,76,20,45,68,46,93,36,28,49,62,74,51,41,38,39,52,47,65,69,61,42,64,44,78,52,43,30,22,75,54,84,25,85,40,96,34,38,37,60,27,48,88,43,38,20,82,92,20,99,29,27,29,93,20,97,43,3,91,62,62,28,61,16,93,99,42,8,63,64,10,86,71,32,4,63,66,75,25,14,66,71,27,62,49,89,25,56,72,83,39,99,88,38,74,10,36,75,79,57,42,53,95,92,12,10,3,5,86,57,11,40,21,52,78,52,29,62,64,78,29,31,27,63,30,71,84,70,14,49,33,100,42,61,30,96,89,63,90,74,45,4,15,63,32,26,16,87,99,9,23,52,61,90,30,43,52,39,72,8,11,61,18,10,84,53,1,37,64,34,89,46,65,74,96,75,23,69,73,78,64,95,82,62,27,54,54,46,84,30,31,28,82,6,63,34,17,85,12,89,68,44,78,34,19,31,16,82,48,74,91,27,71,51,19,48,59,67,96,54,76,7,94,21,32,43,20,29,12,20,38,97,52,68,80,36,13,80,53,12,53,26,90,36,3,25,12,40,20,50,91,29,27,100,86,55,39,91,38,22,20,74,80,2,100,44,96,35,83,17,48,82,78,35,69,94,100,75,85,24,100,90,70,2,97,10,4,78,28,37,4,8,95,70,43,53,16,38,62,76,55,68,55,4,46,95,18,99,9,12,87,10,10,39,68,89,40,39,66,41,66,82,5,13,91,64,34,22,39,61,36,83,62,18,72,98,43,9,28,67,14,58,17,47,17,31,34,58,100,7,24,83,93,6,19,24,93,100,84,86,70,75,14,59,52,45,100,100,32,51,20,33,72,39,63,82,97,2,92,50,59,23,70,83,42,38,69,47,35,66,60,27,97,17,10,96,10,70,99,60,78,42,22,45,67,91,83,94,55,36,91,6,59,100,52,73,70,14,78,52,78,16,56,4,69,89,81,5,74,86,63,85,27,71,15,28,8,58,14,65,5,84,71,25,4,62,31,96,36,52,2,37,53,72,82,59,36,37,50,9,94,97,94,32,100,41,87,24,27,44,26,18,77,84,12,86,32,7,14,20,13,53,5,32,42,70,33,44,61,23,67,41,22,2,61,37,80,55,84,100,72,37,27,29,87,71,44,52,35,91,6,60,27,80,90,47,81,48,48,67,98,8,26,18,44,21,21,15,15,25,94,2,41,100,77,34,90,34,26,4,16,75,45,4,28,38,52,78,7,87,73,37,58,8,89,44,62,98,91,23,22,6,96,59,82,38,70,88,73,99,64,68,99,60,63,63,70,17,78,15,29,60,77,42,81,32,29,45,29,75,9,33,27,41,98,54,80,12,12,22,27,98,34,60,94,30,23,30,85,46,62,15,39,98,24,99,17,83,53,48,25,23,87,25,98,77,21,78,98,14,11,66,3,66,59,48,94,5,8,89,82,87,46,45,4,80,82,17,71,77,39,40,37,35,53,84,58,39,32,22,47,85,33,73,49,42,48,31,3,92,13,46,71,56,32,2,91,69,56,24,28,65,43,42,56,25,80,9,92,86,36,6,66,12,61,52,94,51,44,61,15,43,16,44,90,69,38,49,7,41,73,89,42,32,23,12,86,99,100,92,75,42,49,10,36,70,86,79,74,51,66,63,38,53,17,13,22,3,98,88,28,60,43,61,42,55,41,19,45,91,51,92,48,86,32,5,19,11,16,91,7,10,55,52,5,11,76,39,73,38,93,30,18,62,36,5,66,20,62,84,33,81,45,22,37,80,51,40,29,81,92,8,7,64,7,5,98,56,96,44,96,47,73,31,65,17,48,80,56,76,11,10,45,23,95,64,69,69,30,92,52,33,82,32,94,85,70,89,69,3,43,41,21,40,79,38,31,95,5,96,89,70,48,34,17,92,93,79,95,52,72,31,12,83,99,57,81,55,96,25,30,72,20,47,56,38,32,4,79,92,3,71,67,61,40,70,8,46,47,82,42,42,92,22,40,95,39,76,89,44,50,1,33,100,15,42,7,68,93,4,51,76,66,81,90,9,32,2,56,47,80,64,38,8,19,14,80,96,69,11,82,47,84,58,94,16,70,81,88,57,70,39,72,38,2,3,35,24,26,74,86,15,98,24,5,74,33,77,33,10,72,3,21,36,42,5,74,44,48,35,46,61,65,86,23,65,26,39,86,5,33,7,10,10,78,46,59,55,73,12,46,92,83,5,61,100,15,33,5,85,3,65,97,56,75,7,6,58,68,13,86,66,48,63,95,86,6,8,73,62,89,15,60,23,17,19,83,100,60,44,42,28,78,59,13,41,40,94,93,89,26,73,68,100,2,26,40,64,29,78,98,86,98,33,29,38,92,78,66,78,18,97,99,14,56,69,37,31,19,15,5,81,71,35,2,35,70,6,20,46,77,43,9,30,54,31,82,3,34,72,94,32,84,40,46,40,59,10,86,43,36,50,11,32,71,74,3,94,79,63,62,45,21,6,76,49,58,56,11,7,12,85,3,13,49,24,16,66,28,99,57,37,80,48,86,30,42,95,32,42,21,86,99,7,92,18,85,6,19,81,72,22,77,92,32,80,76,2,2,55,43,67,12,65,30,11,69,12,30,50,35,45,34,96,29,39,98,53,28,69,97,67,15,93,12,94,6,15,96,34,71,53,76,83,97,4,73,47,92,64,21,67,60,46,42,64,69,55,69,98,18,97,46,85,54,46,100,48,32,37,85,45,74,30,46,82,4,12,89,70,80,76,47,28,87,34,3,40,72,54,54,40,67,77,59,17,18,13,92,78,60,58,21,5,42,62,76,3,54,87,13,16,60,89,74,3,53,82,15,58,49,85,45,84,58,85,22,29,74,93,87,1,1,79,19,88,70,95,21,32,97,61,16,82,23,13,83,33,48,48,34,44,17,64,3,38,65,46,50,68,26,1,12,18,8,45,99,92,72,33,14,94,44,73,25,33,71,38,59,97,62,89,70,12,50,62,79,79,25,94,47,59,73,27,36,59,89,32,45,70,5,53,62,15,18,23,69,67,57,61,44,28,45,93,15,36};
		System.out.println(instance.numOfSubarrays(input6));// 1
	}

}
