package com.leetcode.recursion.backtracking;
/**
 * Count Sorted Vowel Strings
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
Example 3:

Input: n = 33
Output: 66045
 

Constraints:

1 <= n <= 50 
 */
import static org.junit.Assert.assertEquals;
public class CountSortedVowelStrings {
	/**
	 * Approach 01: Backtracking
	 * O(5^N)/ O(5^N)
	 */
	int count;
	public int countVowelStrings(int n) {
		count=0;
        for(int i=1; i<=5; i++) backtrack(i,n-1);
        return count;
    }
	private void backtrack(int start, int remaining) {
//		System.out.println(":"+start);
		if(remaining == 0) {
			count+=1;
			return;
		}
		for(int i=start; i<=5; i++) {
			backtrack(i,remaining-1);
		}
	}
	public static void main(String[] args) {
		CountSortedVowelStrings csvs= new CountSortedVowelStrings();
		assertEquals(5,csvs.countVowelStrings(1));
		assertEquals(15,csvs.countVowelStrings(2));
		assertEquals(66045,csvs.countVowelStrings(33));
	}
}
