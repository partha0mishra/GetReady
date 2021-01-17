package com.leetcode.bst;
// TODO Anki
/* 94. Binary Tree InOrder Traversal
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [2,1]
Example 5:


Input: root = [1,null,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up:

Recursive solution is trivial, could you do it iteratively?
 */
import java.util.*;
public class BinaryTreeInOrderTraversal {
	/* Morris In-order traversal using Threaded Binary Tree O(n) O(1)
	 * Step 1: Initialize current as root
	 * Step 2: While current is not NULL,
	 * If current does not have left child
	 * a. Add current’s value
	 * b. Go to the right, i.e., current = current.right
	 * Else
	 * a. In current's left subtree, make current the right child of the rightmost node
	 * b. Go to this left child, i.e., current = current.left
	 * */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		TreeNode curr = root;
		TreeNode pre;
		while (curr != null) {
			if (curr.left == null) {
				res.add(curr.val);
				curr = curr.right; // move to next right node
			} else { // has a left subtree
				pre = curr.left;
				while (pre.right != null) { // find rightmost
					pre = pre.right;
				}
				pre.right = curr; // put cur after the pre node
				TreeNode temp = curr; // store cur node
				curr = curr.left; // move cur to the top of the new tree
				temp.left = null; // original cur left needs to be null, avoid infinite loops
			}
		}
		return res;
	}
	/* Iterative with Stack 
	 * O(n) O(n)*/
//	 public List < Integer > inorderTraversal(TreeNode root) {
//	        List < Integer > res = new ArrayList < > ();
//	        Stack < TreeNode > stack = new Stack < > ();
//	        TreeNode curr = root;
//	        while (curr != null || !stack.isEmpty()) {
//	            while (curr != null) {
//	                stack.push(curr);
//	                curr = curr.left;
//	            }
//	            curr = stack.pop();
//	            res.add(curr.val);
//	            curr = curr.right;
//	        }
//	        return res;
//	    }
	/* Recursive O(n) O(n) worst case */
//	public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        inorder(root, result);
//        return result;
//    }
//    private void inorder(TreeNode node, List<Integer> result){
//        if(node == null) return;
//        inorder(node.left, result);
//        result.add(node.val);
//        inorder(node.right,result);
//    }
}
