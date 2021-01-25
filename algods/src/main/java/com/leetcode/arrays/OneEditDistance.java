package com.leetcode.arrays;
/**
 * One Edit Distance
 * Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

A string s is said to be one distance apart from a string t if you can:

Insert exactly one character into s to get t.
Delete exactly one character from s to get t.
Replace exactly one character of s with a different character to get t.
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "", t = ""
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "a", t = ""
Output: true
Example 4:

Input: s = "", t = "A"
Output: true
Constraints:

0 <= s.length <= 104
0 <= t.length <= 104
s and t consist of lower-case letters, upper-case letters and/or digits.
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
	    int ns = s.length();
	    int nt = t.length();

	    // Ensure that s is shorter than t.
	    if (ns > nt)
	      return isOneEditDistance(t, s);

	    // The strings are NOT one edit away distance  
	    // if the length diff is more than 1.
	    if (nt - ns > 1)
	      return false;

	    for (int i = 0; i < ns; i++)
	      if (s.charAt(i) != t.charAt(i))
	        // if strings have the same length
	        if (ns == nt)
	          return s.substring(i + 1).equals(t.substring(i + 1));
	        // if strings have different lengths
	        else
	          return s.substring(i).equals(t.substring(i + 1));

	    // If there is no diffs on ns distance
	    // the strings are one edit away only if
	    // t has one more character. 
	    return (ns + 1 == nt);
	  }
	public static void main(String[] args) {
		assertFalse(new OneEditDistance().isOneEditDistance("", ""));
		assertFalse(new OneEditDistance().isOneEditDistance("c", "c"));
		assertFalse(new OneEditDistance().isOneEditDistance("", "ab"));
		assertTrue(new OneEditDistance().isOneEditDistance("", "a"));
		assertTrue(new OneEditDistance().isOneEditDistance("a", ""));
		assertTrue(new OneEditDistance().isOneEditDistance("a", "b"));
		assertTrue(new OneEditDistance().isOneEditDistance("A", ""));
		assertTrue(new OneEditDistance().isOneEditDistance("", "A"));
		assertTrue(new OneEditDistance().isOneEditDistance("ab", "acb"));
		assertFalse(new OneEditDistance().isOneEditDistance("abc", "ccc"));// extra > 1 in first block
		assertFalse(new OneEditDistance().isOneEditDistance("aaa", "bbb"));// diff > 2 in first block
		assertFalse(new OneEditDistance().isOneEditDistance("aaaa", "abbb"));// diff > 2 in first block
		assertFalse(new OneEditDistance().isOneEditDistance("cc", "ab"));// extra > 1 in second block
		assertFalse(new OneEditDistance().isOneEditDistance("ccc", "abc"));// diff > 2 in second block
		// True scenarios
		assertTrue(new OneEditDistance().isOneEditDistance("abc", "ab"));// delete one uncommon
		assertTrue(new OneEditDistance().isOneEditDistance("ab", "abc"));// add one uncommon
		assertTrue(new OneEditDistance().isOneEditDistance("abb", "ab"));// delete one common
		assertTrue(new OneEditDistance().isOneEditDistance("ab", "abb"));// add one common
		assertTrue(new OneEditDistance().isOneEditDistance("abbccc", "aabccc"));// replace one
		assertTrue(new OneEditDistance().isOneEditDistance("aabccc", "abbccc"));// replace one
	}
}
