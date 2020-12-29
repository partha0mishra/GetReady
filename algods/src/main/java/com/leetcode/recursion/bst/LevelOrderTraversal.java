package com.leetcode.recursion.bst;
// TODO Anki
/* 102. Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
import java.util.*;
public class LevelOrderTraversal {
	/* Easy BFS - O(N)/ O(N)*/
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        if(root == null) return result;
        Deque<TreeNode> q= new ArrayDeque<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> thisLevel= new ArrayList<Integer>();
            for(int i=0; i< size; i++){
                TreeNode node=q.poll();
                if(node == null) continue;
                thisLevel.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(thisLevel);
        }
        return result;
    }
}
