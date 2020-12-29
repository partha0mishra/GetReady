package com.leetcode.recursion.stack;
/* 682. Baseball Game
 * You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.

Example 1:
Input: ["5","2","C","D","+"]
Output: 30
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get 2 points. The sum is: 7.
Operation 1: The round 2's data was invalid. The sum is: 5.  
Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
Example 2:
Input: ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get -2 points. The sum is: 3.
Round 3: You could get 4 points. The sum is: 7.
Operation 1: The round 3's data is invalid. The sum is: 3.  
Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
Round 5: You could get 9 points. The sum is: 8.
Round 6: You could get -4 + 9 = 5 points. The sum is 13.
Round 7: You could get 9 + 5 = 14 points. The sum is 27.
Note:
The size of the input list will be between 1 and 1000.
Every integer represented in the list will be between -30000 and 30000.
 * */
import java.util.*;
public class BaseballGame {
	 public int calPoints(String[] ops) {
		 Stack<Integer> stack=new Stack<Integer>();
		 for(String s: ops) {
			 if(s.equals("C")) {if(!stack.isEmpty()) stack.pop();}
			 else if(s.equals("D")) {if(!stack.isEmpty()) stack.push(2*stack.peek());}
			 else if(s.equals("+")) {
				 int a1= stack.isEmpty() ? Integer.MIN_VALUE:stack.pop();
				 int a2= stack.isEmpty() ? Integer.MIN_VALUE:stack.peek();
				 if(a1 > Integer.MIN_VALUE) stack.push(a1);
				 int val= (a1 == Integer.MIN_VALUE)? 0: a1;
				 val+= (a2 == Integer.MIN_VALUE) ? 0: a2;
				 stack.push(val);
			 }
			 else stack.push(Integer.valueOf(s));
		 }
		 int result=0;
		 for(int i: stack) {
			 System.out.println(i);
			 result+=i;
		 }
		 return result;
	 }
	 public static void main(String[] args) {
//		 System.out.println(new BaseballGame().calPoints(new String[] {"5","2","C","D","+"}));
//		 System.out.println(new BaseballGame().calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
//		 System.out.println(new BaseballGame().calPoints(new String[] {"5"}));
//		 System.out.println(new BaseballGame().calPoints(new String[] {"C"}));
//		 System.out.println(new BaseballGame().calPoints(new String[] {"D"}));
//		 System.out.println(new BaseballGame().calPoints(new String[] {"+"}));
//		 System.out.println(new BaseballGame().calPoints(new String[] {"1","C","D","+"}));
		 System.out.println(new BaseballGame().calPoints(new String[] {"15788","25148","-24609","24869","D","-23282","14614","-2921","C","-26517","1891","C","-18324","+","+","-23184","D","-12585","C","D","7308","-11988","-16148","+","8834","+","+","D","19519","+","11289","+","D","C","-13033","D","+","-278","-14043","C","-906","C","28518","C","-29295","-22758","-13872","-20255","29870","-1104"}));
	 }
}
