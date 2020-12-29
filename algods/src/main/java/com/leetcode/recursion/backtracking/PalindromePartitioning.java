package com.leetcode.recursion.backtracking;
/* 131. Palindrome Partitioning
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
 * */
import java.util.*;
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<List<String>>();
        backtrack(s,result,new ArrayList<String>(),0);// 0: starting index
        return result;
    }
	private void backtrack(String s, List<List<String>> result, ArrayList<String> temp, int start) {
		if(s.length() == start) {
			result.add(new ArrayList<String>(temp));
			return;
		}
		for(int i=start; i< s.length(); i++) {
			String sub=s.substring(start,i+1);
			if(isPalindrome(sub)) {
				temp.add(sub);
				backtrack(s, result, temp, i+1);
				temp.remove(temp.size()-1);
			}
		}
	}
	private boolean isPalindrome(String sub) {
		int left=0, right=sub.length()-1;
		while(left< right) {
			if(sub.charAt(left++) != sub.charAt(right--)) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new PalindromePartitioning().partition("aab"));
	}

}
