package com.leetcode.bst;
/**
 * Binary Tree Right Side View
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
import java.util.*;
public class BinaryTreeRightSideView {
	/**
	 * Easy BFS/ level order traversal
	 * keeping only the last node of each level in the result list
	 * O(N)/ O(N)
	 */
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> queue= new ArrayDeque<>();
        queue.offerLast(root);
        while(!queue.isEmpty()) {
        	int size=queue.size();
        	for(int i=1; i<=size; i++) {
        		TreeNode current= queue.pollFirst();
            	if(current.left != null) queue.offerLast(current.left);
            	if(current.right != null) queue.offerLast(current.right);
            	if(i==size) result.add(current.val);
        	}
        }
        return result;
    }
}
