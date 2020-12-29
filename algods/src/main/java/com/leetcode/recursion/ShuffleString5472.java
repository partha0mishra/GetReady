package com.leetcode.recursion;

import java.util.Arrays;

/*
 * Given a string s and an integer array indices of the same length.
 * The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 * Return the shuffled string.
 * 
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Output: "leetcode"
Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.

Input: s = "abc", indices = [0,1,2]
Output: "abc"
Explanation: After shuffling, each character remains in its position.

Input: s = "aiohn", indices = [3,1,4,2,0]
Output: "nihao"

Input: s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
Output: "arigatou"

Input: s = "art", indices = [1,0,2]
Output: "rat"

 * Constraints
 * s.length == indices.length == n
1 <= n <= 100
s contains only lower-case English letters.
0 <= indices[i] < n
All values of indices are unique (i.e. indices is a permutation of the integers from 0 to n - 1).
 */
public class ShuffleString5472 {
	public String restoreString(String s, int[] indices) {
        char[] result= new char[indices.length];
        for(int i=0; i<s.length(); i++) {
        	result[indices[i]]=s.charAt(i);
        }
        
        return new String(result);
    }
	public static void main(String[] args) {
		ShuffleString5472 instance= new ShuffleString5472();
		int[] indices1= {4,5,6,7,0,2,1,3};
		System.out.println(instance.restoreString("codeleet", indices1));//leetcode
		int[] indices2= {0,1,2};
		System.out.println(instance.restoreString("abc", indices2));//abc
		int[] indices3= {3,1,4,2,0};
		System.out.println(instance.restoreString("aiohn", indices3));//nihao
		int[] indices4= {4,0,2,6,7,3,1,5};
		System.out.println(instance.restoreString("aaiougrt", indices4));//arigatou
		int[] indices5= {1,0,2};
		System.out.println(instance.restoreString("art", indices5));//rat
	}

}
