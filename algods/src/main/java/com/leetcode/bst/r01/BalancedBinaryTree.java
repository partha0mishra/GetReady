package com.leetcode.bst.r01;

import com.leetcode.bst.TreeNode;

// TODO Anki
/* 110. Find if a BST is balanced
 * Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:
Input: root = []
Output: true
Constraints:
The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */
public class BalancedBinaryTree {
	/* bottom up recursion
	 * NOTE: when we are going to send something as return, 
	 * we can rely on calculating left first and then right to do a post-order by default
	 * O(n) O(n)*/
	boolean balanced=true;
	public boolean isBalanced(TreeNode root) {
        populateHeights(root);
        return balanced;
    }
	private int populateHeights(TreeNode node) {
		if(!balanced || node == null) return -1;// check if the balance is already decided
		int left=populateHeights(node.left);
        if(!balanced) return -1;// if the left subtree is not balanced
		int right=populateHeights(node.right);
		if(Math.abs(left-right) > 1) {balanced=false; return -1;}// get out if it's not balanced
		return 1+ Math.max(left, right);
	}
}
