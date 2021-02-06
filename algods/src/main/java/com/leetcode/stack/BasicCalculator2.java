package com.leetcode.stack;
/**
 *  227 Basic Calculator II ?? what if the numbers are NOT SINGLE DIGITS ??
 * 
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class BasicCalculator2 {
	/**
	 * Approach 01: one Queue for numbers another for operations.
	 * quite redundant although O(N)/ O(N)
	 */
//	public static final char PLUS='+';
//	public static final char MINUS='-';
//	public static final char MULT='*';
//	public static final char DIVIDE='/';
//	public static final char SPACE=' ';
//	public static final char ZERO='0';
//	public int calculate(String s) {
//        Deque<Integer> nums= new ArrayDeque<Integer>();
//        Deque<Character> ops= new ArrayDeque<Character>();
//        for(int index=0; index< s.length();) {
//        	char c=s.charAt(index);
//        	if(c == SPACE) {
//        		index+=1;
//        		continue;
//        	}
//        	if(Character.isDigit(c)) {
//        		int n=0;
//        		while(index< s.length() && Character.isDigit(s.charAt(index))){
//        			n=10*n+(s.charAt(index) -ZERO);
//        			index++;
//        		}
////        		System.out.println(n);
//        		nums.addLast(n);
//        		if(ops.isEmpty()) continue;
//        		char op=ops.peekLast();
//        		if(op == MULT || op == DIVIDE) {
//        			op=ops.removeLast();
//        			int num2=nums.removeLast();
//        			int num1=nums.removeLast();
//        			
//        			if(op == MULT) nums.addLast(num1 * num2);
//        			else nums.addLast(num1 / num2);
//        		}
//        	}else {
//        		index+=1;
//        		ops.addLast(c);
//        	}
//        }
//        if(nums.isEmpty()) return 0;
//
//        int result=nums.removeFirst();
//        while(!nums.isEmpty() && !ops.isEmpty()) {
//        	int num=nums.removeFirst();
//        	char op=ops.removeFirst();
//        	if(op == PLUS) result+=num;
//        	else result-=num;
//        }
//        
//        return result;
    }
	public static void main(String[] args) {
		BasicCalculator2 instance= new BasicCalculator2();
//		assertEquals(5,(instance.calculate("5")));
//		assertEquals(0,(instance.calculate("/")));
//		assertEquals(0,(instance.calculate(" ")));
		assertEquals(3,(instance.calculate("1+2")));
		assertEquals(-1,(instance.calculate("1-2")));
		assertEquals(1,(instance.calculate("2-1")));
		assertEquals(6,(instance.calculate("2*3")));
		assertEquals(0,(instance.calculate("2/3")));
		assertEquals(1,(instance.calculate("3/2")));
		assertEquals(1,(instance.calculate("1+2/3")));
		assertEquals(2,(instance.calculate("1+3/2")));
		assertEquals(7,(instance.calculate("3+2*2")));
		assertEquals(1,(instance.calculate(" 3/2 ")));
		assertEquals(5,(instance.calculate(" 3+5 / 2 ")));
		assertEquals(1,(instance.calculate("1+2/3*2")));
		assertEquals(42,(instance.calculate("42")));
		assertEquals(47,(instance.calculate("42+5")));
		assertEquals(66,(instance.calculate("42+24")));
		assertEquals(18,(instance.calculate("42-24")));
		assertEquals(34,(instance.calculate("42-24/3")));
		assertEquals(42,(instance.calculate("42-24/30*12")));
		assertEquals(1,(instance.calculate("1-1+1")));
	}
}
