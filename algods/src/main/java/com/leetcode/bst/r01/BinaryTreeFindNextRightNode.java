package com.leetcode.bst.r01;
// TODO Anki
/* 1602. Find Nearest Right Node in Binary Tree
 * Given the root of a binary tree and a node u in the tree, 
 * return the nearest node on the same level that is to the right of u, 
 * or return null if u is the rightmost node in its level.
Example 1:
Input: root = [1,2,3,null,4,5,6], u = 4
Output: 5
Explanation: The nearest node on the same level to the right of node 4 is node 5.
Example 2:
Input: root = [3,null,4,2], u = 2
Output: null
Explanation: There are no nodes to the right of 2.
Example 3:

Input: root = [1], u = 1
Output: null
Example 4:

Input: root = [3,4,2,null,null,null,1], u = 4
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [1, 105].
1 <= Node.val <= 105
All values in the tree are distinct.
u is a node in the binary tree rooted at root.
 */
import java.util.*;

import com.leetcode.bst.TreeNode;
public class BinaryTreeFindNextRightNode {
	/**
	 * BFS. If node found, see if it's the last one in the level.
	 * If so, return null. else return queue.pollFirst().
	 * NOTE: don't insert null nodes
	 */
	public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
		// if(root == null) return null;
		Deque<TreeNode> queue=new ArrayDeque<TreeNode>();
		queue.offerLast(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int s=0; s< size; s++) {
				TreeNode tn=queue.pollFirst();
				if(tn==u) {// node found
					if(s == size-1) return null;// this is the last node of the level
                    else return queue.pollFirst();// this is the next node of the level
				}
				if(tn.left != null) queue.offerLast(tn.left);
				if(tn.right != null) queue.offerLast(tn.right);
			}
		}
        return null;
    }
	/* Approach 01: BFS on BST
	 * O(N) - visiting each node at worst case
	 * O(2^h-1) - max nodes in a level */
//	TreeNode result= null;
//	public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
//		Deque<TreeNode> queue=new ArrayDeque<TreeNode>();
//		queue.offerLast(root);
//		boolean found=false;
//		while(!queue.isEmpty()) {
//			int size=queue.size();
//			for(int i=0; i< size; i++) {
//				TreeNode tn=queue.pollFirst();
//				if(tn == null) continue;// skip
//				if(found) {result=tn; break;}
//				if(tn.val==u.val) found=true;
//				if(tn.left != null) queue.offerLast(tn.left);
//				if(tn.right != null) queue.offerLast(tn.right);
//			}
//			if(found) break;// either next node is there or none left at this level
//		}
//        return result;
//    }
}
