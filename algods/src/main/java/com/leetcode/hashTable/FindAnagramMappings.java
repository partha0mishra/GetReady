package com.leetcode.hashTable;

import java.util.Arrays;

/**
 * 760. Find Anagram Mappings
 * Given two lists A and B, and B is an anagram of A. 
 * B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
Note:

A, B have equal lengths in range [1, 100].
A[i], B[i] are integers in range [0, 10^5].
 */
public class FindAnagramMappings {
	/**
	 * Approach 01: 
	 * keeping indices and sorting based on actual values
	 * O(N)/ O(N)
	 */
	public int[] anagramMappings(int[] A, int[] B) {
		Integer[] ai=new Integer[A.length], bi=new Integer[B.length];
		int[] result=new int[A.length];
		for(int i=0; i< A.length; i++) {
			ai[i]=i;
			bi[i]=i;
		}
		Arrays.sort(ai, (n1,n2) -> Integer.compare(A[n1], A[n2]));
		Arrays.sort(bi, (n1,n2) -> Integer.compare(B[n1], B[n2]));
		for(int i=0; i< A.length; i++) {
			result[ai[i]]=bi[i];
		}
		return result;
    }
	public static void main(String[] a) {
		new FindAnagramMappings().anagramMappings(new int[] {12, 28, 46, 32, 50}, new int[] {50, 12, 32, 46, 28});
	}
}
