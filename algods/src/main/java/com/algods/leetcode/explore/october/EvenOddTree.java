package com.algods.leetcode.explore.october;

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
