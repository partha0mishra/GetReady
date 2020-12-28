package com.leetcode.recursion;
/* 344. Reverse String
 * Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {
	/* Approach 02: tail recursion O(n) O(1) 
	 * Swap first and last character of the array
	 * Recursive call for the next characters inside */
    public void reverseString(char[] s) {
      helper(0, s.length - 1, s);
    }

    private void helper(int start, int end, char [] s) {
      if (start >= end) {
        return;
      } 
      // swap between the first and the last elements.
      char tmp = s[start];
      s[start] = s[end];
      s[end] = tmp;
       
      helper(start + 1, end - 1, s);
   }
	/* Approach 01: two pointer O(n) O(n) */
//	public void reverseString(char[] s) {
//        int n=s.length;
//        for(int i=0; i< n/2; i++){
//            char c=s[i];
//            s[i]=s[n-1-i];
//            s[n-1-i]=c;
//        }
//    }
}
