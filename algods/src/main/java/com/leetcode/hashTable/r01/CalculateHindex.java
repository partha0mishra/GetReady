package com.leetcode.hashTable.r01;

import java.util.Arrays;
import java.util.Collections;

/**
 * 274. Calculate H Index
 * Given an array of citations (each citation is a non-negative integer) of a researcher, 
 * write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: 
 * "A scientist has index h if h of his/her N papers have at least h citations each, 
 * and the other N − h papers have no more than h citations each."
 * 
 * Example:
 * Input: citations = [3,0,6,1,5]
 * Output: 3 
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
 * 
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class CalculateHindex {
    /* Approach 02: Count Sort - O(N) */
//	public int hIndex(int[] citations) {
//		int[] countOfCitations= new int[citations.length+2];
//    	for(int i =0; i< citations.length; i++)	{
//    		int citation= citations[i] > citations.length? citations.length: citations[i];
//    		countOfCitations[citation]++;
//    	}
//    	
//    	for(int i=citations.length; i>=0; i--) {
//    		// Accumulation: This is the reason behind citations.length+2
//    		countOfCitations[i]+=countOfCitations[i+1];
//    		// we don't have to go backward if a higher number is matched.
//    		if(countOfCitations[i] >= i) return i;
//    	}
//    	return 0;
//    }
	/**
	 * Count sort:
	 * Also, citations more than n doesn't matter
	 * O(n)/ O(n)
	 * 
	 * [1,3,2,3,100] -> one paper having 100 means at least 1 has 100. so, this value is going to cascade down
	 * [0,1,1,2,0,1] <- 100 is cascading down to 5 and then cascading down to 0 during accumulation as
	 * [5,5,4,3,1,1] -> since we're accumulating from right side, as soon as we find for i=3, acc[i] >=i, we return
	 */
	public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // counting papers for each citation number
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // finding the h-index
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k])
            k--;
        return k;
    }
	/* Approach 01: sort and find from last: Sub-optimum 
	 * O(nlogn)/ O(1) */
//    public int hIndex(int[] citations) {
//    	Arrays.sort(citations);
//    	int hIndex=1;
//    	for(int i=citations.length-1; i>=0;i--) {
//    		if(citations[i] < hIndex) break;
//    		hIndex++;
//    	}
//    	return hIndex-1;
//    }
    public static void main(String[] args) {
    	CalculateHindex instance= new CalculateHindex();
    	System.out.println(instance.hIndex(new int[]{1,0,0,0,1}));//1
    	System.out.println(instance.hIndex(new int[]{3,0,6,1,5}));//3
    	System.out.println(instance.hIndex(new int[]{5,0,5,0,5}));//3
    }
}
