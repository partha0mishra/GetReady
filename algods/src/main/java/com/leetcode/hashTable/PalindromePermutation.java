package com.leetcode.hashTable;
/** TODO Anki
 * 266. Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        int[] counts=new int[256];
        for(char c: s.toCharArray()) counts[c]+=1;
        int numOdds=0;
        for(int c: counts) {
        	if(c%2 !=0) numOdds+=1;
        	if(numOdds >1) return false;
        }
        return true;
    }
	public static void main(String[] args) {
		PalindromePermutation pp= new PalindromePermutation();
		assertFalse(pp.canPermutePalindrome("code"));
		assertTrue(pp.canPermutePalindrome("aab"));
		assertTrue(pp.canPermutePalindrome("carerac"));
		assertFalse(pp.canPermutePalindrome("AaBb//a"));
	}

}
