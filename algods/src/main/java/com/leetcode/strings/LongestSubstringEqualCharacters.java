package com.leetcode.strings;
/* 5543. Largest Substring Between Two Equal Characters
 * Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.
Example 2:

Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".
Example 3:

Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.
Example 4:

Input: s = "cabbac"
Output: 4
Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".
 

Constraints:

1 <= s.length <= 300
s contains only lowercase English letters.
 */
import java.util.*;
public class LongestSubstringEqualCharacters {
	public int maxLengthBetweenEqualCharacters(String s) {
		HashMap<Character,Integer> hm= new HashMap<Character, Integer>();
		int maxLength=-1;
        for(int i=0; i< s.length(); i++) {
        	char c= s.charAt(i);
        	int length=0;
        	if(hm.containsKey(c)) {
                length=i-hm.get(c)-1;
        		maxLength=Math.max(maxLength, length);
        	}else hm.put(c,i);
        }
        return maxLength;
    }
}
