package com.algods.leetcode.backtracking;
/* 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 */
import java.util.*;
public class GenerateParentheses {
	/* Backtracking
	 * keep count of left and right
	 * at each level, try doing both
	 * O(4^n/ root-n)/ O(4^n/ root-n) */
	private static final String LEFT="(";
	private static final String RIGHT=")";
	public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        generate(n,result,0,0, "");
        return result;
    }
	private void generate(int n, List<String> result, int left, int right, String partial) {
		if(partial.length() == 2*n) {
			result.add(partial);
			return;
		}
		if(left < n) generate(n, result, left+1, right, partial+LEFT);// till LEFT < N
		if(right < left) generate(n, result, left, right+1, partial+RIGHT);// till RIGHT < LEFT
	}
	public static void main(String[] args) {
		GenerateParentheses gp= new GenerateParentheses();
		System.out.println(gp.generateParenthesis(3));
	}
}
