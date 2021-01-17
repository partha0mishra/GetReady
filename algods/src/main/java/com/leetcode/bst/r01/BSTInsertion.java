package com.leetcode.bst.r01;

import com.leetcode.bst.TreeNode;

/** TODO Anki
 *  701 Insert into a Binary Search Tree
 * 
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. 
 * Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. 
You can return any of them.

Example 1:
Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:

Example 2:
Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]
Example 3:

Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]
 
Constraints:
The number of nodes in the tree will be in the range [0, 104].
-108 <= Node.val <= 108
All the values Node.val are unique.
-108 <= val <= 108
It's guaranteed that val does not exist in the original BST.
 * */
public class BSTInsertion {
	/** 
	 * Approach 02: Trying Iterative
	 * Actually easy: go where the value takes us
	 * O(H)/ O(1) as recursion is converted to Iteration
	 */
	 public TreeNode insertIntoBST(TreeNode root, int val) {
		 TreeNode current=root, prev=root, newNode=new TreeNode(val);
		 if(root ==null) return newNode;
		 while(current !=null) {
			 prev=current;
			 if(val > current.val) {
				 current=current.right;
				 if(current==null) prev.right=newNode;
			 }
			 else {
				 current=current.left;
				 if(current==null) prev.left=newNode;
			 }
		 }
		 return root;
	 }
	/**
	 * Approach 01: Recursive
	 * Actually easy: go where the value takes us
	 * O(H)/ O(H) due to recursion
	 */
//	 public TreeNode insertIntoBST(TreeNode root, int val) {
//		 if(root==null) return new TreeNode(val);
//		 if(val < root.val) root.left= insertIntoBST(root.left,val);
//		 else root.right= insertIntoBST(root.right,val);
//		 return root;
//	 }
}
