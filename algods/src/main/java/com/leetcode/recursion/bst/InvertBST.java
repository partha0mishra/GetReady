package com.leetcode.recursion.bst;
/* 226. Invert Binary Tree
 * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * */
public class InvertBST {
	public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp=root.left; root.left=root.right; root.right=temp;
        return root;
    }
}
