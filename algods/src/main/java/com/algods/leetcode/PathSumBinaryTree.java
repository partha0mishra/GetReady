package com.algods.leetcode;
/* Path Sum III
 * 
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * 
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
public class PathSumBinaryTree {
/**
 * Definition for a binary tree node. */
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
	int paths=0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        
        findPaths(root,sum);// DFS from root
        pathSum(root.left,sum);// DFS from left
        pathSum(root.right,sum);// DFS from right
    	return paths;
    }
    private void findPaths(TreeNode root, int sum) {
    	if(root != null) {
    		if(root.val == sum) {// sum matched here
    			paths++;
    		}
    		sum -= root.val;
    		findPaths(root.left,sum);// takes root's value into account
    		findPaths(root.right,sum);// takes root's value into account
    	}
    }
	public static void main(String[] args) {
		PathSumBinaryTree instance = new PathSumBinaryTree();
		TreeNode root=instance.new TreeNode(10);
		root.left=instance.new TreeNode(5);
		root.right=instance.new TreeNode(-3);
		root.left.left=instance.new TreeNode(3);
		root.left.right=instance.new TreeNode(2);
		root.right.right=instance.new TreeNode(11);
		root.left.left.left=instance.new TreeNode(3);
		root.left.left.right=instance.new TreeNode(-2);
		root.left.right.right=instance.new TreeNode(1);
		System.out.println(instance.pathSum(root, 8));
	}
}
