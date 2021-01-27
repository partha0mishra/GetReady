package com.leetcode._explore;
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
public class Random10usingRandom7 {
	public int rand7() {
		Random random= new Random();
		int result=0;
		while(result ==0) result=random.nextInt(7);
		
		return result;
	}
	/*Approach 03: 
	 * The idea is as follows:
	 * We can't get an equal distribution between 1 and 10 by simply generating a single integer between 1 and 7. 
	 * But we can generate two random numbers. 
	 * The first, i, will tell us whether the final answer is in the range 1-5 or 6-10. 
	 * The second, j, tells us whether the final answer is the first, second, ..., fifth number in the selected range.
	 * 
	 * We can check whether i is even or odd--i % 2 == 0 tells us if it's even--
	 * but rand7() generates four odd numbers (1, 3, 5, 7) and only three evens (2, 4, 6). 
	 * So we have to discard one of the odds in order to have equal probability of getting an even or an odd. 
	 * OP chose to discard 7. We exit the first while loop with i equal to one of (1, 2, 3, 4, 5, 6) with equal probability.
	 * 
	 * If j is one of (1, 2, 3, 4, 5) then we can just use it as is, but there is a chance it will take the value of 6 or 7. 
	 * So the second while loop ensures that we keep trying until j is one of (1, 2, 3, 4, 5). This too is with equal probability.
	 * Finally, if i is even, we just return j. If i is odd, we just add five to get one of (6, 7, 8, 9, 10).
	 * Got it?*/
	public int rand10() {
	    int i,j;
	    while( (i = rand7()) > 6);  // P(i is even) = P(i is odd) = 0.5
	    while( (j = rand7()) > 5);  // P(j==1) = P(j==2) = P(j==3) = P(j==4) = P(j==5) = 0.2
	    return (i%2==0) ? j : j+5;
	}
	/* Approach 02: Rejection Sampling
	 * Generate a 7x7 grid and pick from it*/
//	int[][] grid;
//	public Random10usingRandom7() {
//		grid=new int[7][7];
//		int val=1;
//		int end=40;
//		int run=1;
//		for(int i=0; i<7; i++) {
//			for(int j=0; j<7; j++) {
//				if(run <= end) {
//					grid[i][j]=val++;
//					run++;
//				}else {
//					grid[i][j]=-1;
//				}
//				if(val > 10) val=1;
//				System.out.print(grid[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
//	public int rand10() {
//		int result=-1;
//		while(result == -1){
//			result=grid[rand7()-1][rand7()-1];
//		}
//		return result;
//	}
	/* Approach 01: Copied
	 * https://leetcode.com/problems/implement-rand10-using-rand7/discuss/150301/Three-line-Java-solution-the-idea-can-be-generalized-to-%22Implement-RandM()-Using-RandN()%22 */
//	public int rand10() {
//	    int result = 40;
//	    while (result >= 40) {result = 7 * (rand7() - 1) + (rand7() - 1);}
//	    return result % 10 + 1;
//	}
	
	public static void main(String[] args) {
		Random10usingRandom7 instance= new Random10usingRandom7();
		for(int i=0; i<10; i++) System.out.println(">"+instance.rand10());
	}
}
