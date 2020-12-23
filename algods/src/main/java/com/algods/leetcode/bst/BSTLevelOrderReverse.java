package com.algods.leetcode.bst;
// TODO Anki
/* 107. Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 * */
import java.util.*;
public class BSTLevelOrderReverse {
	/* Easy BFS. 
	 * NOTE : Collections.reverse(result)
	 * O(n)/ O(n)*/
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> q= new LinkedList<TreeNode>();
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
        Collections.reverse(result);
        return result;
    }
}
