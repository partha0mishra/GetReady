package com.leetcode;
/*
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 * Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].

Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].

Constraints: 0 <= low <= high <= 10^9
 */
public class OddCountInRange {
	public int countOdds(int low, int high) {
		int result= (high-low)/2;
		if(low %2 ==0 && high %2 ==0) {
			return result;
		}
		return result+1;
    }
	public static void main(String[] args) {
		OddCountInRange instance= new OddCountInRange();
		System.out.println(instance.countOdds(0,0));
		System.out.println(instance.countOdds(3,7));
		System.out.println(instance.countOdds(8,10));
		System.out.println(instance.countOdds(3,10));
		System.out.println(instance.countOdds(2,7));
	}

}
