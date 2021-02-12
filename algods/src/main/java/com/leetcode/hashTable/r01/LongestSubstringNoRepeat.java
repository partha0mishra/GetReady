package com.leetcode.hashTable.r01;
/** TODO Anki
 * 3. Longest Substring Without Repeating Characters
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
import java.util.*;
import static org.junit.Assert.assertEquals;
public class LongestSubstringNoRepeat {
	/**
	 * Approach 03: Sliding window with more slide - similar to approach 02 but using array[]
	 * If we keep the index of a character, we can skip till there+1 if we encounter the character again
	 * O(n)/ O(M)
	 */
	public int lengthOfLongestSubstring(String s) {
        int maxLen=0, n=s.length(),i=0, j=0;
        if(n ==0) return 0;
        int[] index=new int[128];// 26 for a-z OR A-Z, 128 for ASCII, 256 for Extended ASCII
        for(i=0, j=0; i< n;i++) {
        	if(index[s.charAt(i)] !=0) {
        		maxLen=Math.max(maxLen, i-j);
        		j=Math.max(j, index[s.charAt(i)]);
        	}
        	index[s.charAt(i)]=i+1;// starting with 1 so that 0 can be the 'default' value
        }
        return Math.max(maxLen, i-j);
    }
	/**
	 * Approach 02: Sliding window with more slide
	 * If we keep the index of a character, we can skip till there+1 if we encounter the character again
	 * O(n)/ O(Min(M,N)) <= Important as we're going to keep the max substring in temporary variable
	 */
//	public int lengthOfLongestSubstring(String s) {
//        if(s.length() == 0) return 0;
//        int len=0,i=0, j=0;
//        HashMap<Character,Integer> map=new HashMap<>();// keeping char and index
//        for(i=0, j=0; i< s.length();i++) {
//        	char c=s.charAt(i);
//        	if(map.containsKey(c)) {
//        		len=Math.max(len, i-j);
//        		j=Math.max(j, map.get(c)+1);// abba where first a again matches with last a but we can't decrease j
//        	}
//        	map.put(c, i);
//        }
//        return Math.max(len, i-j);
//    }
	/**
	 * Approach 01: Sliding window
	 * O(n)/ O(Min(M,N)) <= Important as we're going to keep the max substring in temporary variable
	 */
//	public int lengthOfLongestSubstring(String s) {
//        if(s.length() == 0) return 0;
//        int len=0,i=0, j=0;
//        HashSet<Character> set=new HashSet<>();
//        for(i=0, j=0; i< s.length();) {
//        	char c=s.charAt(i);
//        	if(set.contains(c)) {
//        		len=Math.max(len, i-j);
//        		set.remove(s.charAt(j));
//        		j+=1;
//        	}else {
//        		set.add(c);
//        		i+=1;
//        	}
//        }
//        return Math.max(len, i-j);
//    }
	public static void main(String[] args) {
		LongestSubstringNoRepeat lsnr= new LongestSubstringNoRepeat();
		assertEquals(3, lsnr.lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, lsnr.lengthOfLongestSubstring("bbbbb"));
		assertEquals(3, lsnr.lengthOfLongestSubstring("pwwkew"));
		assertEquals(0, lsnr.lengthOfLongestSubstring(""));
		assertEquals(2, lsnr.lengthOfLongestSubstring("abba"));
	}
}
