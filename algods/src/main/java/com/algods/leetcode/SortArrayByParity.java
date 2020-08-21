package com.algods.leetcode;
/*
 * Sort Array By Parity
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Note:
1 <= A.length <= 5000
0 <= A[i] <= 5000
 */
import java.util.*;
public class SortArrayByParity {
	/* Approach 01: Naive O(n)/ O(n)*/
    public int[] sortArrayByParity(int[] A) {
    	if(A.length < 2) return A;// empty array or with only one element
    	int[] result=new int[A.length];
    	ArrayList<Integer> odds= new ArrayList<Integer>();
    	int index=0;
    	for(int i: A) {
    		if(i%2 ==0) result[index++]=i;
    		else odds.add(i);
    	}
    	for(Integer i: odds) {
    		result[index++]=i;
    	}
        return result;
    }
	public static void main(String[] args) {
		SortArrayByParity instance= new SortArrayByParity();
		System.out.println(Arrays.toString(instance.sortArrayByParity(new int[] {})));
		System.out.println(Arrays.toString(instance.sortArrayByParity(new int[] {1})));
		System.out.println(Arrays.toString(instance.sortArrayByParity(new int[] {1,1})));
		System.out.println(Arrays.toString(instance.sortArrayByParity(new int[] {0})));
		System.out.println(Arrays.toString(instance.sortArrayByParity(new int[] {3,1,2,4})));
	}

}
