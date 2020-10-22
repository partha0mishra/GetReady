package com.algods.leetcode.bst;
/* Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 * Constraints:
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 */
public class MinDepthBST {
	int minDepth=Integer.MAX_VALUE;
	public int minDepth(TreeNode root) {
        if(root == null) return 0;
        findMinDepth(root,1);
        return minDepth;
    }
	private void findMinDepth(TreeNode node, int i) {
		if(node.left == null && node.right== null) {minDepth=Math.min(minDepth,i); return;}
		if(node.left != null) findMinDepth(node.left,i+1);
		if(node.right != null) findMinDepth(node.right,i+1);
	}
}
