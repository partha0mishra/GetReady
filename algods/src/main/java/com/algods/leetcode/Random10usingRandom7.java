package com.algods.leetcode;
/*
 * Given a function rand7 which generates a uniform random integer in the range 1 to 7, 
 * write a function rand10 which generates a uniform random integer in the range 1 to 10.
 * Do NOT use system's Math.random().
 * 
 * Example 1:
 * Input: 1
 * Output: [7]
 * 
 * Example 2:
 * Input: 2
 * Output: [8,4]
 * 
 * Example 3:
 * Input: 3
 * Output: [8,1,10]
 * 
 * Note:
 * rand7 is predefined.
 * Each testcase has one argument: n, the number of times that rand10 is called.
 * 
 * Follow up:
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 */
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Random10usingRandom7 {
	public int rand7() {
		Random random= ThreadLocalRandom.current();
		return random.nextInt(7);
	}
	/* Approach 01: Copied
	 * https://leetcode.com/problems/implement-rand10-using-rand7/discuss/150301/Three-line-Java-solution-the-idea-can-be-generalized-to-%22Implement-RandM()-Using-RandN()%22 */
	public int rand10() {
	    int result = 40;
	    while (result >= 40) {result = 7 * (rand7() - 1) + (rand7() - 1);}
	    return result % 10 + 1;
	}
	public static void main(String[] args) {
		Random10usingRandom7 instance= new Random10usingRandom7();
		for(int i=0; i<100; i++) System.out.println(">"+instance.rand10());
	}
}
