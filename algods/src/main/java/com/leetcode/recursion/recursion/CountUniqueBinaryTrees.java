package com.leetcode.recursion.recursion;
/* 96. Unique Binary Trees
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
	/* dp
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
