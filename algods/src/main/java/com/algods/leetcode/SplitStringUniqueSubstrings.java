package com.algods.leetcode;
/*
 * DOESN'T work
 * 5520. Split a String Into the Max Number of Unique Substrings
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
public class SplitStringUniqueSubstrings {
	int max=1;
	public int maxUniqueSplit(String s) {
        for(int i=0; i< s.length(); i++) {
        	findSubArrays(s, s.length(), i, new HashSet<String>(), 0,0);
        }
        return max;
    }
	private void findSubArrays(String s, int length, int sublength, HashSet<String> hashSet, int start, int count) {
		if(start == length -1) {
			if(count > max) max=count;
			return;
		}
		String sub=s.substring(start, start+sublength-1);
		if(hashSet.contains(sub)) {
			findSubArrays(s,length,sublength+1,hashSet,start,count);
		}else {
			hashSet.add(sub);
			findSubArrays(s, length, sublength, hashSet, start+sublength, count);
		}
	}
	public static void main(String[] args) {
		SplitStringUniqueSubstrings instance = new SplitStringUniqueSubstrings();
		System.out.println(instance.maxUniqueSplit("ababccc"));
	}

}
