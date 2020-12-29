package com.leetcode.bst;
/* 104. Maximum Depth of Binary Tree
 * 
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 * */
import java.util.*;
public class BSTMaxDepth {
	/* Approach 02: BFS
	 * O(n) Time as DFS
	 * O(n) space in worst case
	 */
	public int maxDepth(TreeNode root) {
		int maxDepth=0;
		if(root == null) return maxDepth;
		Queue<TreeNode> queue=new ArrayDeque<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			maxDepth+=1;
			for(int i=0;i< size; i++) {
				TreeNode n=queue.poll();
				if(n.left != null) queue.offer(n.left);
				if(n.right != null) queue.offer(n.right);
			}
		}
		return maxDepth;
	}
	/* Approach 01: DFS 
	 * O(n) - each node gets visited once
	 * O(n) space - unbalanced binary tree >> height == number of nodes 
	 */
//	public int maxDepth(TreeNode root) {
//		if(root == null) return 0;
//		else return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
//	}
}
