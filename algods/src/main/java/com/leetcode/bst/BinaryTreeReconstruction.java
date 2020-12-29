package com.leetcode.bst;
/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 */
import java.util.*;
public class BinaryTreeReconstruction {
	HashMap<Integer,Integer> hmPost;
	HashMap<Integer,Integer> hmIn;
	int[] inOrder;
	int[] postOrder;
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length ==0 ) return null;
        hmPost= new HashMap<Integer, Integer>();
        hmIn=new HashMap<Integer, Integer>();
        for(int i=0; i< inorder.length; i++) {// populating for quicker access later o(n)
        	hmPost.put(postorder[i], i);
        	hmIn.put(inorder[i], i);
        }
        this.inOrder=inorder;
        this.postOrder=postorder;
    	TreeNode root= buildTree(0, inorder.length-1);
        return root;
    }
    // root is the one with max index at post-order
    
    private TreeNode buildTree(int inOrderFrom, int inOrderTo) {
    	int rootElement= getMaxIndexedInorderElement(inOrderFrom, inOrderTo);
    	TreeNode root= new TreeNode(rootElement);
    	if(hmIn.get(rootElement) == inOrderFrom){
    		root.left= null;
    	}else {
    		root.left=buildTree(inOrderFrom, hmIn.get(rootElement)-1);
    	}
    	if(hmIn.get(rootElement) == inOrderTo) {
    		root.right= null;
    	}else {
    		root.right=buildTree(hmIn.get(rootElement)+1,inOrderTo);
    	}
    	
    	return root;
    }
	private int getMaxIndexedInorderElement(int inOrderFrom, int inOrderTo) {
		// we don't need to know where, just which element (under consideration) is at the right-most index in post-order
		if (inOrderFrom == inOrderTo) return inOrder[inOrderFrom];// single element - just return that element
		int maxIndex=0;
		for(int i=inOrderFrom; i<= inOrderTo; i++) {
			int thisIndex = hmPost.get(inOrder[i]);
			if(thisIndex > maxIndex) maxIndex = thisIndex;
		}
		return postOrder[maxIndex];// this is the right-most element in PostOrder array
	}
	public static void main(String[] args) {
		int[] inorder= {9,3,15,20,7};
		int[] postorder= {9,15,7,20,3};
		BinaryTreeReconstruction instance= new BinaryTreeReconstruction();
		System.out.println(instance.buildTree(inorder, postorder));
	}
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
}
