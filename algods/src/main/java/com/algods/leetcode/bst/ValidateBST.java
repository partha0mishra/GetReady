package com.algods.leetcode.bst;

import com.algods.leetcode.bst.RangeSumBST.TreeNode;

public class ValidateBST {
	/**
	 * Definition for a binary tree node.*/
	 class TreeNode {
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
	long tmp=Long.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		if(root.left == null && root.right == null) {
			return validate(root.val);
		}else if(root.left == null) {
			return validate(root.val) && isValidBST(root.right);
		}else
			return isValidBST(root.left) && validate(root.val) && isValidBST(root.right);
	}
	private boolean validate(long val) {
		boolean b=val>tmp;
		tmp=val;
		return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
