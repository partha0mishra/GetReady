package com.leetcode.recursion.stack;
/* 1047. Remove All Adjacent Duplicates In String
 * 
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 

Note:

1 <= S.length <= 20000
S consists only of English lowercase letters.
 * */
import java.util.*;
public class RemoveAllAdjacentDuplicates {
	public String removeDuplicates(String S) {
		/* Approach 02: Use StringBuilder as a stack*/
		StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
		/* Approach 01: Stack based */
//        Stack<Character> stack= new Stack<Character>();
//        for(char c: S.toCharArray()) {
//        	if(!stack.isEmpty() && stack.peek()==c) {
//        		while(!stack.isEmpty() && stack.peek() == c)
//        			stack.pop();
//        		
//        	}else stack.push(c);
//        }
//        StringBuilder result= new StringBuilder();
//        for(int i=0; i< stack.size(); i++){
//        	result.append(stack.get(i));
//        }
//        return result.toString();
    }
	public static void main(String[] args) {
		System.out.println(new RemoveAllAdjacentDuplicates().removeDuplicates("a"));
		System.out.println(new RemoveAllAdjacentDuplicates().removeDuplicates("aa"));
		System.out.println(new RemoveAllAdjacentDuplicates().removeDuplicates("ab"));
		System.out.println(new RemoveAllAdjacentDuplicates().removeDuplicates("abbaca"));
	}
}
