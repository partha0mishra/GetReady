package com.algods.leetcode.bst;
/* Recover Binary Search Tree
 * You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 

Constraints:

The number of nodes in the tree is in the range [2, 1000].
-2^31 <= Node.val <= 2^31 - 1
 */
public class RecoverBinaryTree {
	/* learnt from here: https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
	 * That solution fails at root=Integer.MIN-VALUE
	 * Therefore, setting prev as null */
	private TreeNode first;
    private TreeNode second;
    private TreeNode pre;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        first = null;
        second = null;
        pre = null;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        
        if(first==null && (pre==null ||pre.val>=root.val)){
            first = pre;
        }
        if(first!=null && pre.val>=root.val){
            second = root;
        }
        pre = root;
        inorder(root.right);
    }
}
