package com.algods.leetcode.arrays;
/* 1190. Reverse Substrings Between Each Pair of Parentheses
 * You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"
 

Constraints:

0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced.
 */
public class ReverseStringEachPairParentheses {
	public String reverseParentheses(String s) {
		return reverseParentheses(s,1);
	}
	public String reverseParentheses(String s, int level) {
//        System.out.println(s+" "+level);
		int begin=s.indexOf('(');
		if(begin ==-1) {
			if(level%2 == 0) return reverse(s);
			else return s;
		}
		int end=s.lastIndexOf(')');
        String part01=(level%2 ==0)? reverse(s.substring(0,begin)):s.substring(0,begin);
//        System.out.println("begin: "+part01);
        String part02=(level%2 ==0)? reverse(s.substring(end+1)):s.substring(end+1);
//        System.out.println("end: "+part02);
        String middle=s.substring(begin+1,end);
//        System.out.println("middle: "+middle);
        if(part01.length() == 0) {
        	return reverseParentheses(middle,level+1)+part02;
        }else if(part02.length() ==0) {
        	return part01+reverseParentheses(middle,level+1);
        }else if(level%2 ==0) {
        	return part02+reverseParentheses(middle,level+1)+part01;
        }else return part01+reverseParentheses(middle,level+1)+part02;
    }
	private String reverse(String s) {
        int n=s.length();
		char[] ca= new char[n];
        for(int i=0; i< n; i++){
            ca[i]=s.charAt(n-1-i);
        }
        return String.valueOf(ca);
	}
}
