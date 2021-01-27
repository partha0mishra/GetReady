package com.leetcode._explore;

import java.util.LinkedList;
import java.util.Queue;

import com.algods.learn.util.*;

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class WidthOfBinaryTree {
//	public int widthOfBinaryTree(TreeNode node) {
//		int height = treeHeight(node);
//		int count[] = new int[height];
//		int level=0;
//		getMaxWidth(node, count, level);
//		return getMax(count, height);
//	}
	void getMaxWidth(TreeNode node,int[] count,int level) {
		if(node != null) {
			count[level]++; 
            getMaxWidth(node.left, count, level + 1); 
            getMaxWidth(node.right, count, level + 1);
		}
	}
	int getMax(int arr[], int n)  
    { 
        int max = arr[0]; 
        int i; 
        for (i = 0; i < n; i++)  
        { 
            if (arr[i] > max) 
                max = arr[i]; 
        } 
        return max; 
    } 
	
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int height=treeHeight(root);
		int maxWidth = 0;
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.add(root);

		
		while (!nodeQueue.isEmpty()) {
			int countNodes = nodeQueue.size();
			int width=0;// at this level, to start with
			int nulls=0;
			height--;
			
			while (countNodes-- > 0) {
				TreeNode tempNode = nodeQueue.remove();
				
				if(tempNode == null) {
					if(width >0) {// the null might be counted only if something is there before (and after)
						nulls+=2*height+1;
//						nodeQueue.add(null);
//						nodeQueue.add(null);
					}
					continue;// don't have children to push to queue
				}
				width+=nulls+1;
				nulls=0;
				
				nodeQueue.add(tempNode.left);
				nodeQueue.add(tempNode.right);
			}
			maxWidth = Math.max(maxWidth, width);
		}
		return maxWidth;
	}
	int treeHeight(TreeNode node) {
		if(node == null) return 0;
		else {
			int leftHeight = treeHeight(node.left);
			int rightHeight = treeHeight(node.right);
			
			return leftHeight > rightHeight? (leftHeight+1): (rightHeight+1);
		}
	}

	// Test it out
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(6);
		root.right.right.right = new TreeNode(7);
		// Should be 4 including nulls (3 excluding nulls)
		Stopwatch timer1=new Stopwatch();
		System.out.println("Max Width: " + new WidthOfBinaryTree()
				.widthOfBinaryTree(root)+": "+timer1.elapsedTime());
//				.widthOfBinaryTree(root));

		root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);
		// should be 4
		System.out.println("Max Width: " + new WidthOfBinaryTree()
				.widthOfBinaryTree(root));
//				.widthOfBinaryTree(root));

		root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		// should be 2
		System.out.println("Max Width: " + new WidthOfBinaryTree()
				.widthOfBinaryTree(root));
//				.widthOfBinaryTree(root));
		
		root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right= new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(7);
		// should be 8
		System.out.println("Max Width: " + new WidthOfBinaryTree()
				.widthOfBinaryTree(root));
//				.widthOfBinaryTree(root));
		
		root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right= new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.right = new TreeNode(1);
		root.left.left.left = new TreeNode(1);
		root.right.right.right = new TreeNode(1);
		// should be 8
		System.out.println("Max Width: " + new WidthOfBinaryTree()
				.widthOfBinaryTree(root));
//				.widthOfBinaryTree(root));
	}
}
