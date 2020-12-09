package com.algods.leetcode.stack;
/* Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
import java.util.*;
import static org.junit.Assert.*;
public class EvaluateRPN {
	public int evalRPN(String[] tokens) {
        Deque<Integer> stack= new ArrayDeque<>();
        for(String token: tokens) {
        	if(token.length() == 1 && "+-*/".contains(token)) {
        		int num2=stack.pollFirst();
        		int num1=stack.pollFirst();
        		switch(token.charAt(0)) {
        		case '+':
        			stack.offerFirst(num1+num2);
        			break;
        		case '-':
        			stack.offerFirst(num1-num2);
        			break;
        		case '*':
        			stack.offerFirst(num1*num2);
        			break;
        		case '/':
        			stack.offerFirst(num1/num2);
        		}
        	}else {
        		stack.offerFirst(Integer.parseInt(token));
        	}
        }
        return stack.pollFirst();
    }
	public static void main(String[] args) {
		assertEquals(9, new EvaluateRPN().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		assertEquals(6, new EvaluateRPN().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
		assertEquals(22, new EvaluateRPN().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
		
	}

}
