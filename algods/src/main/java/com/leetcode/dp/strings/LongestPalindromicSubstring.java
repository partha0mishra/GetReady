package com.leetcode.dp.strings;
/**
 * 5. Longest Palindromic Substring
 * 
 * Given a string s, return the longest palindromic substring in s.
Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
*
* Hints:
* How can we reuse a previously computed palindrome to compute a larger palindrome?
* If “aba” is a palindrome, is “xabax” and palindrome? Similarly is “xabay” a palindrome?
* Complexity based hint:
* If we use brute-force and check whether for every start and end position a substring is a palindrome 
* we have O(n^2) start - end pairs and O(n) palindromic checks. Can we reduce the time for palindromic checks 
* to O(1) by reusing some previous computation.
 */
import static org.junit.Assert.assertEquals;
public class LongestPalindromicSubstring {
	/**
	 * Approach: expanding around center
	 * We observe that a palindrome mirrors around its center. 
	 * Therefore, a palindrome can be expanded from its center, and there are only 2n - 1 such centers.
	 * why 2n -1 and not n? 
	 * The reason is the center of a palindrome can be in between two letters. 
	 * Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
	 * O(n2)/ O(1)
	 */
	public String longestPalindrome(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
