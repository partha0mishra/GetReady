package com.leetcode.arrays;
/** TODO Anki
 * Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
import java.util.HashSet;
import static org.junit.Assert.assertEquals;
public class LongestSubstringNoRepeat {
	/**
	 * Approach 01: Sliding window
	 * O(n)/ O(1)
	 */
	public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int len=0,i=0, j=0;
        HashSet<Character> set=new HashSet<>();
        for(i=0, j=0; i< s.length();) {
        	char c=s.charAt(i);
        	if(set.contains(c)) {
        		len=Math.max(len, i-j);
        		set.remove(s.charAt(j));
        		j+=1;
        	}else {
        		set.add(c);
        		i+=1;
        	}
        }
        return Math.max(len, i-j);
    }
	public static void main(String[] args) {
		LongestSubstringNoRepeat lsnr= new LongestSubstringNoRepeat();
		assertEquals(3, lsnr.lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, lsnr.lengthOfLongestSubstring("bbbbb"));
		assertEquals(3, lsnr.lengthOfLongestSubstring("pwwkew"));
		assertEquals(0, lsnr.lengthOfLongestSubstring(""));
	}
}
