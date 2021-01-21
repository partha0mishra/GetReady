package com.leetcode;
/*
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
 */
public class DeleteNodeBST {
	/**
	 * Definition for a binary tree node.
	 */
	public static class TreeNode {
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
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;
		if(key < root.val) root.left=deleteNode(root.left,key);
		else if(key > root.val) root.right=deleteNode(root.right,key); 
		else {// found it
        	if(root.right == null) return root.left;
        	else if(root.left == null) return root.right;
        	else {
        		TreeNode left=root.left;
        		root=root.right;
        		TreeNode search= root;
        		while(search.left != null) search=search.left;
        		search.left=left;
        	}
        }
        return root;
    }
	public void printTree(TreeNode root) {
		if(root == null) return;
		printTree(root.left);
		System.out.print(root.val+ " ");
		printTree(root.right);
	}
	public static void main(String[] args) {
		DeleteNodeBST instance= new DeleteNodeBST();
		TreeNode root= new TreeNode(5);
		root.left=new TreeNode(3);
		root.right=new TreeNode(6);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(4);
		root.right.right=new TreeNode(7);
		instance.printTree(root);
		System.out.println();
		root=instance.deleteNode(root, 2);
		instance.printTree(root);
		System.out.println();
		root=instance.deleteNode(root, 3);
		instance.printTree(root);
		System.out.println();
		root=instance.deleteNode(root, 7);
		instance.printTree(root);
		System.out.println();
	}

}
