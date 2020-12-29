package com.leetcode.recursion.stack;
/* 856. Score of Parentheses
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6
 

Note:

S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50
 */
import java.util.*;
public class ScoreOfParentheses {
	/* Approach 02: Stack - only keeping the score
	 * cur record the score at the current layer level.

If we meet '(',
we push the current score to stack,
enter the next inner layer level,
and reset cur = 0.

If we meet ')',
the cur score will be doubled and will be at least 1.
We exit the current layer level,
and set cur = stack.pop() + cur

Complexity: O(N) time and O(N) space */
	public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }
	
	/* Approach 01: Stack - crude version*/
//	public int scoreOfParentheses(String S) {
//        Stack<String> ss= new Stack<String>();
//        int num=0;
//        for(char c: S.toCharArray()) {
//        	if(c == '(') ss.push(String.valueOf(c));
//        	else {// ")"
//        		String p=ss.pop();
//        		if(p.equals("(")) {
//        			num=1;
//        		}else {// it's a number
//        			num=2*Integer.parseInt(p);
//        			ss.pop();// pop out the starting brace
//        		}
//        		if(!ss.isEmpty()) {
//    				String q=ss.peek();
//    				if(! q.equals("(")) num=num+Integer.valueOf(ss.pop());
//    			}
//        		ss.push(String.valueOf(num));
//        	}
//        }
//        return num;
//    }
}
