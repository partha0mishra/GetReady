package com.algods.leetcode.stack;
/* 1081. Smallest Subsequence of Distinct Characters
 * 316. Remove Duplicate Letters
 * 
 * Return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.
 * Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/
 * Example 1:
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
import java.util.*;
public class SmallestSubsequence {
	public String smallestSubsequence(String s) {
        Stack<Integer> stack= new Stack<Integer>();
        int[] last=new int[26], seen=new int[26];
        for(int i=0; i< s.length(); i++) {
        	last[s.charAt(i) - 'a']=i;
        }
        for(int i=0; i< s.length(); i++) {
        	int c=s.charAt(i)-'a';
        	if(seen[c]++ > 0) continue;
        	while(!stack.isEmpty() && stack.peek() > c && i< last[stack.peek()])
        		seen[stack.pop()]=0;
        	stack.push(c);
        }
        StringBuilder result= new StringBuilder();
        for(int i: stack) result.append((char)('a'+i));
        return result.toString();
    }
}
