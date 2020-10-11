package com.algods.leetcode.stack;
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
	public int scoreOfParentheses(String S) {
        Stack<String> ss= new Stack<String>();
        int num=0;
        for(char c: S.toCharArray()) {
        	if(c == '(') ss.push(String.valueOf(c));
        	else {// ")"
        		String p=ss.pop();
        		if(p.equals("(")) {
        			num=1;
        		}else {// it's a number
        			num=2*Integer.parseInt(p);
        			ss.pop();// pop out the starting brace
        		}
        		if(!ss.isEmpty()) {
    				String q=ss.peek();
    				if(! q.equals("(")) num=num+Integer.valueOf(ss.pop());
    			}
        		ss.push(String.valueOf(num));
        	}
        }
        return num;
    }
}
