package com.algods.leetcode;
/*
 * Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.

You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.
 * 
 * Input: s = "(()))"
Output: 1
Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to to add one more ')' at the end of the string to be "(())))" which is balanced.
 * 
 * Input: s = "())"
Output: 0
Explanation: The string is already balanced.
 * 
 * Input: s = "))())("
Output: 3
Explanation: Add '(' to match the first '))', Add '))' to match the last '('.
 * 
 * Input: s = "(((((("
Output: 12
Explanation: Add 12 ')' to balance the string.
 * 
 * Input: s = ")))))))"
Output: 5
Explanation: Add 4 '(' at the beginning of the string and one ')' at the end. The string becomes "(((())))))))".
 * 
 * Constraints:
 * 1 <= s.length <= 10^5
s consists of '(' and ')' only.
 * 
 */
import java.util.Stack;
/* COPIED ONLY*/
public class BalanceParenthesesMinInsertions {
/* Approach 02: without using Stack*/
	public int minInsertions(String s) {
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // when (
                left++;
            } else if (i == s.length() - 1 || s.charAt(i + 1) == '(') { // when single )
                if (left > 0) {
                    res++;
                    left--;
                } else {
                    res += 2;
                }
            } else { // when double )
                if (left > 0) left--;
                else res++;
                i++; // advance pointer since we have process double ) in a time
            }
        }
        res += left * 2;
        return res;
    }
	
	/* Approach 01: using Stack*/
//    public int minInsertions(String s) {
//        Stack<Character> stack = new Stack<>();
//        int count = 0;
//        for (char c : s.toCharArray()) {
//            if (c == ')') {
//                if (!stack.isEmpty()) {
//                    if (stack.peek() == ')') {
//                        stack.pop();
//                        stack.pop();
//                    } else {
//                        stack.add(c);
//                    }
//                } else {
//                    count++;
//                    stack.add('(');
//                    stack.add(c);
//                }
//            } else {
//                if (!stack.isEmpty()) {
//                    if (stack.peek() == '(') {
//                        stack.add(c);
//                    } else {
//                        count++;
//                        stack.pop();
//                    }
//                } else {
//                    stack.add(c);
//                }
//            }
//        }
//
//        while (!stack.isEmpty()) {
//            if (stack.peek() == '(') {
//                count += 2;
//                stack.pop();
//            } else {
//                count++;
//                stack.pop();
//                stack.pop();
//            }
//        }
//
//        return count;
//    }
	
	public static void main(String[] args) {
		BalanceParenthesesMinInsertions instance = new BalanceParenthesesMinInsertions();
		System.out.println(instance.minInsertions("(()))"));//1
		System.out.println(instance.minInsertions("())"));//0
		System.out.println(instance.minInsertions("))())("));//3
		System.out.println(instance.minInsertions("(((((("));//12
	}

}
