package com.leetcode.recursion.bst;
/* 530. Minimum Absolute Difference in BST
 * Same as
 * 783. Minimum Distance Between BST Nodes
 * 
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.
 * 
 * */
import java.util.*;
public class MinimumAbsoluteDifference {
	 public int getMinimumDifference(TreeNode root) {
	        ArrayList<Integer> al= new ArrayList<Integer>();
	        traverse(root, al);
	        Collections.sort(al);
	        int min=Integer.MAX_VALUE;
	        for(int i=1; i< al.size(); i++){
	            int diff=al.get(i)-al.get(i-1);
	            if(diff < min) min=diff;
	        }
	        return min;
	    }
	    private void traverse(TreeNode root,ArrayList<Integer> al){
	        if(root == null) return;
	        traverse(root.left, al);
	        al.add(root.val);
	        traverse(root.right, al);
	    }
}
