package com.leetcode.dfs;
/**
 * 1593. Split a String Into the Max Number of Unique Substrings
 * 
 * Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "ababccc"
Output: 5
Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
Example 2:

Input: s = "aba"
Output: 2
Explanation: One way to split maximally is ['a', 'ba'].
Example 3:

Input: s = "aa"
Output: 1
Explanation: It is impossible to split the string any further.
 

Constraints:

1 <= s.length <= 16

s contains only lower case English letters.
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class SplitStringUniqueSubstrings {
	/* DFS + Backtracking */
	int result=0;
	public int maxUniqueSplit(String s) {
		result=0;// for multiple calling of this method on the same instance of class
        backtrack(s,0,new HashSet<String>());
        return result;
    }
	private void backtrack(String s, int start, HashSet<String> set) {
		if(s.length() == start) {
			result=Math.max(result, set.size());
//			System.out.println("--"+result);
		}else {
			for(int i=start+1; i<= s.length(); i++) {
				String sub=s.substring(start, i);
				if(set.add(sub)) {// false if it's already in there
//					System.out.println(sub);
					backtrack(s, i, set);
					set.remove(sub);// for backtracking
				}
			}
		}
	}
	public static void main(String[] args) {
		SplitStringUniqueSubstrings instance = new SplitStringUniqueSubstrings();
		assertEquals(5,instance.maxUniqueSplit("ababccc"));
		assertEquals(2,instance.maxUniqueSplit("aba"));
		assertEquals(1,instance.maxUniqueSplit("aa"));
	}

}
