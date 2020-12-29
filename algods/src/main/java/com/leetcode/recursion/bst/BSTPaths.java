package com.leetcode.recursion.bst;
/* 257. Binary Tree Paths
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
	 List<String> result;
	    public List<String> binaryTreePaths(TreeNode root) {
	        // if(root == null) return "";// need a [] when root is null
	        result=new ArrayList<String>();
	        buildPath(root, "");
	        return result;
	    }
	    private void buildPath(TreeNode root, String path){// using String path as it's immutable. 
	    	//Any collection structure for the "path" would have gotten updated UNNECESSARILY
	        if(root == null) return;
	        if(path.length() > 0){
	            path=path.concat("->");
	        }
	        path=path.concat(String.valueOf(root.val));
	        if(root.left == null && root.right == null){
	            result.add(path);
	            return;
	        }
	        if(root.left != null) buildPath(root.left, path);
	        if(root.right != null) buildPath(root.right, path);
	    }
}
