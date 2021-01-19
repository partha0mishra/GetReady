package com.leetcode;
/*
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes 
 * that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * Input:
 * "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
import java.util.*;
public class LongestPalindrome {
	/* Approach 01: with HashSet*/
    public int longestPalindrome(String s) {
    	if(s == null || s.length()==0) return 0;
        HashSet<Character> hs= new HashSet<Character>();
        int result=0;
        for(Character c:s.toCharArray()) {
        	if(hs.contains(c)) {
        		result++;
        		hs.remove(c);// to make sure 4 As make 2 pairs.
        	}else {
        		hs.add(c);
        	}
        }
        result*=2;
        if(hs.size()>0) result=result+1;// there can be only 1 in the middle 
        return result;
    }
	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));// 7
		System.out.println(new LongestPalindrome().longestPalindrome(""));// 0
		System.out.println(new LongestPalindrome().longestPalindrome("aa"));// 2
	}

}
