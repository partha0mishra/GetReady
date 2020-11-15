package com.algods.leetcode._explore;
/* 5532. Even Odd Tree
 * A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.

 

Example 1:



Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
Output: true
Explanation: The node values on each level are:
Level 0: [1]
Level 1: [10,4]
Level 2: [3,7,9]
Level 3: [12,8,6,2]
Since levels 0 and 2 are all odd and increasing, and levels 1 and 3 are all even and decreasing, the tree is Even-Odd.
Example 2:



Input: root = [5,4,2,3,3,7]
Output: false
Explanation: The node values on each level are:
Level 0: [5]
Level 1: [4,2]
Level 2: [3,3,7]
Node values in the level 2 must be in strictly increasing order, so the tree is not Even-Odd.
Example 3:



Input: root = [5,9,1,3,5,7]
Output: false
Explanation: Node values in the level 1 should be even integers.
Example 4:

Input: root = [1]
Output: true
Example 5:

Input: root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
Output: true
 

Constraints:

The number of nodes in the tree is in the range [1, 105].
1 <= Node.val <= 106
 * */
import java.util.*;
public class EvenOddTree {
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
	 public boolean isEvenOddTree(TreeNode root) {
	     Queue<TreeNode> q= new LinkedList<TreeNode>();
	     q.add(root);
	     boolean evenLevel=false;
	     int lastVal=-1;
	     while(!q.isEmpty()) {
	    	 evenLevel=!evenLevel;
	    	 if(evenLevel) lastVal=-1;
	    	 else lastVal=Integer.MAX_VALUE;
	    	 int size=q.size();
	    	 for(int i=0; i< size; i++) {
	    		 TreeNode node=q.poll();
		    	 int v=node.val;
//		    	 System.out.println(evenLevel+" "+lastVal+" "+v);
		    	 if(evenLevel) {
//		    		 System.out.println("01"+evenLevel+" "+lastVal+" "+v+" "+(v<lastVal));
		    		 if (!(v%2 ==1) || !(v < lastVal)) return false;// even level needs odd values, increasing
		    	 }else {
//		    		 System.out.println("02"+evenLevel+" "+lastVal+" "+v+" "+(v>lastVal));
		    		 if (!(v%2 ==0) || !(v > lastVal)) return false;// odd  level needs even values, decreasing
		    	 }
		    	 lastVal=v;
		    	 if(node.left != null) q.offer(node.left);
		    	 if(node.right !=null ) q.offer(node.right);
	    	 }
	     }
	     
		 return true;
	 }
	 public static void main(String[] args) {
		 EvenOddTree instance = new EvenOddTree();
		 TreeNode root=instance.new TreeNode(5);
		 root.left=instance.new TreeNode(4);
		 root.right=instance.new TreeNode(2);
		 root.left.left=instance.new TreeNode(3);
		 root.left.right=instance.new TreeNode(3);
		 root.right.left=instance.new TreeNode(7);
		 System.out.println(instance.isEvenOddTree(root));
	 }
}
