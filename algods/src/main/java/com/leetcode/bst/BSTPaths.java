package com.leetcode.bst;
/** EASY
 * 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * */
import java.util.*;
public class BSTPaths {
	/**
	 * Trying out with StringBuilder.
	 * Trick is to keep the length same as while going in as it's mutable
	 */
	List<String> result;
	public List<String> binaryTreePaths(TreeNode root) {
		// if(root == null) return "";// need a [] when root is null
		result=new ArrayList<String>();
        if(root == null) return result;
		buildPath(root, new StringBuilder());
		return result;
	}
	private void buildPath(TreeNode root, StringBuilder sb){
        int len = sb.length();// Original length, to be reverted to
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            result.add(sb.toString());// NOTE: can't return before setting the original length
        } else {
            sb.append("->");
            if(root.left != null) buildPath(root.left, sb);
            if(root.right != null) buildPath(root.right, sb);
        }
        sb.setLength(len);// reverting back
	}
	/**
	 * Approach 01: regular recursion
	 * O(N)/ O(N)
	 */
//	List<String> result;
//	public List<String> binaryTreePaths(TreeNode root) {
//		// if(root == null) return "";// need a [] when root is null
//		result=new ArrayList<String>();
//        if(root == null) return result;
//		buildPath(root, "");
//		return result;
//	}
//	private void buildPath(TreeNode root, String path){// using String path as it's immutable. 
//		//Any collection structure for the "path" would have gotten updated UNNECESSARILY
//		path=path.concat(String.valueOf(root.val));
//		if(root.left == null && root.right == null){
//			result.add(path);
//			return;
//		}
//		path=path.concat("->");// we need it anyway if we're going to next level
//		if(root.left != null) buildPath(root.left, path);
//		if(root.right != null) buildPath(root.right, path);
//	}
}
