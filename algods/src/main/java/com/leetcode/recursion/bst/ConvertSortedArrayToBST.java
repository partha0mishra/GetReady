package com.leetcode.recursion.bst;
/* 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 * */
public class ConvertSortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
        return getTree(nums,0,nums.length-1);
    }
    private TreeNode getTree(int[] nums,int left, int right){
        if(left > right) return null;
        int mid=left+(right-left)/2;
        // System.out.println(nums[mid]);
        TreeNode root=new TreeNode(nums[mid]);
        root.left=getTree(nums,left,mid-1);
        root.right=getTree(nums,mid+1,right);
        return root;
    }
}
