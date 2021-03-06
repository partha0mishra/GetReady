package com.leetcode._explore;
/**
 * 5503. Sum of All Odd Length Subarrays
 * 
 * Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
 * A subarray is a contiguous subsequence of the array.
 * Return the sum of all odd-length subarrays of arr.
 * Example 1:

Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
Example 2:

Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
Example 3:

Input: arr = [10,11,12]
Output: 66
 

Constraints:

1 <= arr.length <= 100
1 <= arr[i] <= 1000
 */
public class SumOddLengthSubarrays {
	public int sumOddLengthSubarrays(int[] arr) {
		int len=arr.length;
		if(len ==1) return arr[0];
		int sum=0;
		for(int sublen=1; sublen <= len; sublen+=2) {
			System.out.println("sublen:"+sublen);
			for(int i=0; i<= (len - sublen); i+=1) {
				System.out.println("i:"+i);
				for(int j=0; j< sublen; j++) {
					System.out.println("j:"+j);
					sum+=arr[i+j];
					System.out.println("pos "+(i+j)+" num:"+arr[i+j]+" sum: "+sum);
				}
			}
		}
		return sum;
    }
	public static void main(String[] args) {
		SumOddLengthSubarrays instance = new SumOddLengthSubarrays();
		System.out.println(instance.sumOddLengthSubarrays(new int[] {1,4,2,5,3}));
	}

}
