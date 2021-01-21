package com.leetcode;
/*
 * Sum of Root To Leaf Binary Numbers
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.For all leaves in the tree, 
 * consider the numbers represented by the path from the root to that leaf.
 * Return the sum of these numbers.
 * Example 1:
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * Note:
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 */
import static org.junit.Assert.assertEquals;
public class SumRootToLeafBinaryNumbers {
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
	public int sumRootToLeaf(TreeNode root) {
		return sumNodes(root,0);
    }
	private int sumNodes(TreeNode node, int s) {
		if(node==null) return 0;
		int result=2*s+node.val;// need S to double going forward each level.
		// leaf node. can't return from under at (node == null) as there could be multiple nodes causing multiple returns
		if(node.left==null && node.right==null) return result;
		return sumNodes(node.left,result)+sumNodes(node.right,result);
	}
	public static void main(String[] args) {
		SumRootToLeafBinaryNumbers instance = new SumRootToLeafBinaryNumbers();
		TreeNode root= instance.new TreeNode(1);
		root.left=instance.new TreeNode(0);
		root.right=instance.new TreeNode(1);
		root.left.left=instance.new TreeNode(0);
		root.left.right=instance.new TreeNode(1);
		root.right.left=instance.new TreeNode(0);
		root.right.right=instance.new TreeNode(1);
		assertEquals(22,instance.sumRootToLeaf(root));
		
		root.left=instance.new TreeNode(0);
		root.right=instance.new TreeNode(1);
		root.left.left=instance.new TreeNode(0);
		assertEquals(7,instance.sumRootToLeaf(root));
	}
}
