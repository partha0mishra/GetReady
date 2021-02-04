package com.leetcode.hashTable;
// TODO Anki
/**
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 

Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class LongestSubstringAtMostKDistinctChars {
	/**
	 * Two pointers with count of chars in a HashMap
	 * O(N) O(K)
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if(k ==0) return 0;
        HashMap<Character,Integer> hm= new HashMap<>();
        int i, j, maxLen=0;
        for(i=0, j=0; i< s.length();) {
        	char c=s.charAt(i);
        	if(!hm.containsKey(c)) {
        		if(hm.size()<k) {hm.put(c, hm.getOrDefault(c, 0)+1); i+=1;}
        		else {// make space
        			int len=i-j;
        			maxLen=Math.max(maxLen, len);
        			int count=hm.get(s.charAt(j));
        			if(count ==1) hm.remove(s.charAt(j));
        			else hm.put(s.charAt(j), count-1);
        			j+=1;
        		}
        	}else {
        		hm.put(c, hm.getOrDefault(c, 0)+1); i+=1;
        	}
        }
        return Math.max(maxLen, i-j);
    }
	public static void main(String[] args) {
		assertEquals(3,new LongestSubstringAtMostKDistinctChars().lengthOfLongestSubstringKDistinct("eceba", 2));
		assertEquals(2,new LongestSubstringAtMostKDistinctChars().lengthOfLongestSubstringKDistinct("aa", 1));
		assertEquals(3,new LongestSubstringAtMostKDistinctChars().lengthOfLongestSubstringKDistinct("aabbabbaaa", 1));
		assertEquals(0,new LongestSubstringAtMostKDistinctChars().lengthOfLongestSubstringKDistinct("a", 0));
	}

}
