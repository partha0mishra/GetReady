package com.leetcode.dp.strings;
/** TODO Anki
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
	 * Manacher's Algorithm: O(2*N) => O(N)
	 * 
	 */
	public String longestPalindrome(String s) {
		String T=preProcess(s);
		int n=T.length();
		int[] P=new int[n];
		int C=0, R=0;
		for(int i=1; i< n-1; i++) {
			int iMirror= 2*C -i; // i' = C - (i-C) = 2C -i
			P[i]= (R > i)? Math.min(R-i, P[iMirror]): 0;
			
			// Try expanding palindrome centered at i
			while(T.charAt(i+1+P[i]) == T.charAt(i-1-P[i])) P[i]+=1;
			
			// If palindrome centered at i expands past R
			// Adjust center based on Expanded palindrome
			if(i + P[i] > R) {
				C = i;
				R = i + P[i];
			}
		}
		// Let's find the max in P
		int maxLen=0, centerIndex=0;
		for(int i=0; i< n-1; i++) {
			if(P[i] > maxLen) {
				maxLen=P[i];
				centerIndex=i;
			}
		}
		int from=(centerIndex -1 -maxLen)/2;
		return s.substring(from, from+maxLen);
	}
	private String preProcess(String s) {
		int n=s.length();
		if(n == 0) return "^$";
		String ret="^";
		for(int i=0; i< n; i++)
			ret+="#"+s.charAt(i);
		ret+="#$";
		return ret;
	}
	/**
	 * Approach: expanding around center
	 * We observe that a palindrome mirrors around its center. 
	 * Therefore, a palindrome can be expanded from its center, and there are only 2n - 1 such centers.
	 * why 2n -1 and not n? 
	 * The reason is the center of a palindrome can be in between two letters. 
	 * Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
	 * O(n2)/ O(1)
	 */
//	public String longestPalindrome(String s) {
//	    if (s == null || s.length() < 1) return "";
//	    int start = 0, end = 0;
//	    for (int i = 0; i < s.length(); i++) {
//	        int len1 = expandAroundCenter(s, i, i);
//	        int len2 = expandAroundCenter(s, i, i + 1);
//	        int len = Math.max(len1, len2);
//	        if (len > end - start) {// that's a bigger length than previous, so start/ end of subarray to be modified
//	            start = i - (len - 1) / 2;// since the start will be i for length 2
//	            end = i + len / 2;// since end will be i+1 for length 2
//	        }
//	    }
//	    return s.substring(start, end + 1);
//	}
//
//	private int expandAroundCenter(String s, int left, int right) {
//	    int L = left, R = right;
//	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//	        L--;
//	        R++;
//	    }
//	    return R - L - 1;
//	}
	public static void main(String[] args) {
		assertEquals("a",new LongestPalindromicSubstring().longestPalindrome("a"));
		assertEquals(1,new LongestPalindromicSubstring().longestPalindrome("ac").length());// could be a or c
		assertEquals("bb",new LongestPalindromicSubstring().longestPalindrome("cbbd"));
		assertEquals("babab",new LongestPalindromicSubstring().longestPalindrome("babab"));
		assertEquals("baab",new LongestPalindromicSubstring().longestPalindrome("abaab"));
		assertEquals("baxabaxab",new LongestPalindromicSubstring().longestPalindrome("abaxabaxabb"));
		assertEquals("baxabybaxab",new LongestPalindromicSubstring().longestPalindrome("abaxabaxabybaxabyb"));
	}
}
