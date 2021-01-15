package com.leetcode.bst;
/* 
 * 938. Range Sum of BST
Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].

 

Example 1:


Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Example 2:


Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
 

Constraints:

The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.val <= 105
1 <= low <= high <= 105
All Node.val are unique.
*/
public class BstRangeSum {
	/**
	 * Approach 02: recursion without helper function
	 * O(N)/ O(N)
	 */
	public int rangeSumBST(TreeNode root, int L, int R) {
		 if(root == null) return 0;
		 if(root.val < L) return rangeSumBST(root.right, L, R);// some valid values can be at the right
		 else if(root.val > R) return rangeSumBST(root.left, L, R);// some valid values can be at the left
		 else return root.val+ rangeSumBST(root.left, L, R)+ rangeSumBST(root.right, L, R);// go both ways
	 }
	/**
	 * Approach 01: recursion using helper function
	 */
//	int sum=0;
//	public int rangeSumBST(TreeNode root, int low, int high) {
//        if(root == null) return 0;
//        rangeSum(root,low,high);
//        return sum;
//    }
//	private void rangeSum(TreeNode root, int low, int high) {
//		if(root == null) return;
//		if(low < root.val) rangeSum(root.left,low,high);
//		if(high > root.val) rangeSum(root.right,low,high);
//		if(low <= root.val && high >=root.val) sum+=root.val;
//	}
}
