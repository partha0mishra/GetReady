package com.algods.leetcode;
/*
 * Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

 Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 */
 
class SameBinaryTrees {
	// Definition for a binary tree node.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
//    	System.out.println("p: "+p+" q: "+q);
    	if(p == null && q == null) return true;
    	else if(p == null && q != null) return false;
    	else if(p != null && q == null) return false;
    	else if(p.val == q.val 
    			&& isSameTree(p.left, q.left)
    			&& isSameTree(p.right, q.right)) return true;
    	else return false;
    }
    
    public static void main(String[] args) {
    	SameBinaryTrees sbt= new SameBinaryTrees();
    	TreeNode p= sbt.new TreeNode(1);
    	TreeNode q= sbt.new TreeNode(1);
    	
    	p.left=sbt.new TreeNode(2);
    	q.right=sbt.new TreeNode(2);
    	
    	System.out.println("Result: "+sbt.isSameTree(p, q));
    	
    	p.left=sbt.new TreeNode(2);
    	q.left=sbt.new TreeNode(2);
    	p.right=sbt.new TreeNode(3);
    	q.right=sbt.new TreeNode(3);
    	System.out.println("Result: "+sbt.isSameTree(p, q));
    }
}