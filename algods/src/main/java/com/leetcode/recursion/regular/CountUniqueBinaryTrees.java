package com.leetcode.recursion;
/** TODO Anki
 * 96. Unique Binary Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 

Constraints:

1 <= n <= 19
 */
import static org.junit.Assert.assertEquals;
public class CountUniqueBinaryTrees {
	/** dp [also below is a recursive/ backtracking approach that got TLE ]
	 * let's say we have 7 numbers 1,2,3,4,5,6,7
	 * if F(i,n) is a function of number of trees at position i for a total number of n points
	 * then G(n), a fundtion of TOTAL number of trees for n points = sum( for i: from 1 to n) F(i, n)
	 * Interestingly, F(i, n) is ... e.g.
	 * F(3,7) = we are taking 3 as root. so, (3-1)= 2 points before this and (7-3)= 4 points after this
	 * => F(3,7) = trees of 2 points * trees of 4 points
	 * => F(3,7) = G(2) * G(4) -> it doesn't matter which point, only the COUNT Matters
	 * i.e. F(i,n) = G(i-1) * G(n-i)
	 *
	 * So, G(n) is sum(i: 1-> n) F(i,n) and F(i,n)= G(i-1) * G(n-i)
	 * => G(n) = sum(i: 1-> n) G(i-1) * G(n-i)
	 *
	 * So, we'll have to compute G[1] to G[n] and G[n] is the answer
	 * G[0]=1 and G[1]=0 as in both cases, the number of combinations will be 1
	 * G[n]=> for i: from 1 to n => for j: from 1 to i => G[i]+=G(j-1) * G(i-j)
	 */
	public int numTrees(int n) {
      if(n==0) return 0;
      int[] dp=new int[n+1];
      dp[0]=1;
      dp[1]=1;
      for(int i=2; i<=n; i++)
    	  for(int j=1; j<=i; j++)
    		  dp[i]+=dp[j-1]*dp[i-j];
      return dp[n];
    }
	/* Recursive approach - TLE @ n=18. needs memo/ dp */
//	public int numTrees(int n) {
//        if(n==0) return 0;
//        return numTrees(1,n);
//    }
//	private int numTrees(int start, int end) {
//		int treesAtThisLevel=0;
//		if(start > end) return 1;
//		for(int i=start; i<= end; i++) {
//			int leftTrees=numTrees(start,i-1);
//			int rightTrees=numTrees(i+1,end);
//			treesAtThisLevel+=leftTrees*rightTrees;
//		}
//		return treesAtThisLevel;
//	}
	public static void main(String[] args) {
		assertEquals(0,new CountUniqueBinaryTrees().numTrees(0));
		assertEquals(1,new CountUniqueBinaryTrees().numTrees(1));
		assertEquals(2,new CountUniqueBinaryTrees().numTrees(2));
		assertEquals(5,new CountUniqueBinaryTrees().numTrees(3));
	}

}
