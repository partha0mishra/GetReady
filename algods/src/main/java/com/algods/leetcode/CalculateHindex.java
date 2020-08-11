package com.algods.leetcode;

import java.util.Arrays;

/*
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
    public int hIndex(int[] citations) {
    	Arrays.sort(citations);
    	int hIndex=1;
    	for(int i=citations.length-1; i>=0;i--) {
    		if(citations[i] < hIndex) break;
    		hIndex++;
    	}
    	return hIndex-1;
    }
    public static void main(String[] args) {
    	CalculateHindex instance= new CalculateHindex();
    	System.out.println(instance.hIndex(new int[]{1,0,0,0,1}));//1
    	System.out.println(instance.hIndex(new int[]{3,0,6,1,5}));//3
    	System.out.println(instance.hIndex(new int[]{5,0,5,0,5}));//3
    }
}
