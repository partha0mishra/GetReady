package com.leetcode;
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
public class RandomMUsingRandomN {
	public int randN() {
		Random random= new Random();
		int result=0;
		while(result ==0) result=random.nextInt(N);
		
		return result;
	}
	/* Approach 02: Rejection Sampling
	 * Generate a 7x7 grid and pick from it*/
	int[][] grid;
	int M, N;
	public RandomMUsingRandomN(int M, int N) {
		if(M > N*N) throw new IllegalArgumentException("M is greater than N^2");
		this.M=M;
		this.N=N;
		grid=new int[N][N];
		int val=1;// starting value
		int end=N*N - (N*N %M);// These many places to be filled in the grid
		int run=1;// places filled - to compare against end
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(run <= end) {
					grid[i][j]=val++;
					run++;
				}else {
					grid[i][j]=-1;
				}
				if(val > M) val=1;
//				System.out.print(grid[i][j]+" ");
			}
//			System.out.println();
		}
	}
	public int randM() {
		int result=-1;
		while(result == -1){
			result=grid[randN()-1][randN()-1];
		}
		return result;
	}
	public static void main(String[] args) {
		RandomMUsingRandomN instance= new RandomMUsingRandomN(10,7);
		for(int i=0; i<10; i++) System.out.println(">"+instance.randM());
	}
}
