package com.algods.leetcode.dp;
// TODO Anki
import com.algods.leetcode.bst.TreeNode;

/* 337. House Robber III
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII {
	
	/* Earlier approach - less learning, more copying */
	public int rob(TreeNode root) {
        int[] result=dfs(root);
        return Math.max(result[0], result[1]);
    }
	private int[] dfs(TreeNode node) {
		if(node == null) return new int[2];
		int[] left=dfs(node.left);
		int[] right=dfs(node.right);
		int[] result=new int[2];
		result[0]= node.val+left[1]+right[1];// here[taken]=here.val+left[not taken]+right[not taken]
		result[1]= Math.max(left[0], left[1])+ Math.max(right[0], right[1]);// here[not taken] = left[taken] + right[taken]
		return result;
	}
}
