package com.algods.leetcode;
/*
 * Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumLeftLeaves {
	/**
	 * Definition for a binary tree node.*/
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	/* Approach 02: more concise*/
	public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.left.left == null && root.left.right == null) 
        	return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
	/* Approach 01: Straight*/
//	private static int sum=0;
//    public int sumOfLeftLeaves(TreeNode root) {
//    	sum=0;
//        traverse(root, false);
//        return sum;
//    }
//    private void traverse(TreeNode node, boolean sumNeeded) {
//    	if(node == null) return;
//    	traverse(node.left, true);
//    	// check if this is Left AND a leaf
//    	if(sumNeeded && node.left== null && node.right==null) sum+=node.val;
//    	traverse(node.right, false);
//    }
	public static void main(String[] args) {
		SumLeftLeaves instance= new SumLeftLeaves();
		TreeNode root= instance.new TreeNode(3);
		root.left=instance.new TreeNode(9);
		root.right=instance.new TreeNode(20);
		root.right.left=instance.new TreeNode(15);
		root.right.right=instance.new TreeNode(7);
		System.out.println(instance.sumOfLeftLeaves(root));// 34
		root=null;
		System.out.println(instance.sumOfLeftLeaves(null));// 0
	}

}
