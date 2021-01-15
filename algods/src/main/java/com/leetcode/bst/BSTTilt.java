package com.leetcode.bst;
/** TODO Anki
 * 563 Binary Tree Tilt
 * Given the root of a binary tree, return the sum of every tree node's tilt.

The tilt of a tree node is the absolute difference between the sum of all left subtree node values 
and all right subtree node values. If a node does not have a left child, then the sum of the 
left subtree node values is treated as 0. The rule is similar if there the node does not have a right child.
Example 1:
Input: root = [1,2,3]
Output: 1
Explanation: 
Tilt of node 2 : |0-0| = 0 (no children)
Tilt of node 3 : |0-0| = 0 (no children)
Tile of node 1 : |2-3| = 1 (left subtree is just left child, so sum is 2; right subtree is just right child, so sum is 3)
Sum of every tilt : 0 + 0 + 1 = 1
Example 2:


Input: root = [4,2,9,3,5,null,7]
Output: 15
Explanation: 
Tilt of node 3 : |0-0| = 0 (no children)
Tilt of node 5 : |0-0| = 0 (no children)
Tilt of node 7 : |0-0| = 0 (no children)
Tilt of node 2 : |3-5| = 2 (left subtree is just left child, so sum is 3; right subtree is just right child, so sum is 5)
Tilt of node 9 : |0-7| = 7 (no left child, so sum is 0; right subtree is just right child, so sum is 7)
Tilt of node 4 : |(3+5+2)-(9+7)| = |10-16| = 6 (left subtree values are 3, 5, and 2, which sums to 10; right subtree values are 9 and 7, which sums to 16)
Sum of every tilt : 0 + 0 + 0 + 2 + 7 + 6 = 15
Example 3:


Input: root = [21,7,14,1,1,2,2,3,3]
Output: 9
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
* 
* 
 */
import java.util.*;
public class BSTTilt {
	/**
	 * Approach 03: little more streamlined
	 * findSum() - sums up values to parent nodes and adds to the global tilt while doing so
	 * O(N)/ O(N) but way faster.
	 */
	int totalTilt=0;
	public int findTilt(TreeNode root) {
		findSum(root);
		return totalTilt;
	}
	private int findSum(TreeNode node) {
		if(node == null) return 0;
		int leftSum=findSum(node.left), rightSum=findSum(node.right);
		totalTilt+=Math.abs(leftSum - rightSum);
		return node.val+leftSum+rightSum;
	}
	/**
	 * Approach 02: Trying to avoid storing sum in HM
	 * GatherTilt - adds to global tilt and sums values in that process
	 * O(N)/ O(N) but way faster.
	 */
//	int totalTilt=0;
//	public int findTilt(TreeNode root) {
//		if(root != null) gatherTilt(root);
//		return totalTilt;
//	}
//	private int gatherTilt(TreeNode node) {
//		if(node == null) return 0;
//		node.val+=gatherTilt(node.left)+gatherTilt(node.right);
//		int leftVal= node.left==null? 0: node.left.val;
//		int rightVal= node.right==null? 0: node.right.val;
//		totalTilt+=Math.abs(leftVal - rightVal);
//		return node.val;
//	}
	/** Approach 01: keeping sum at node levels in an HM
	 *  O(N)/ O(N)
	 */
//	HashMap<TreeNode,Integer> dp=new HashMap<TreeNode,Integer>();
//	public int findTilt(TreeNode root) {
//        if(root == null) return 0;
//        return findTilt(root.left)
//        		+findTilt(root.right)
//        		+Math.abs(sum(root.right)-sum(root.left));
//    }
//	private int sum(TreeNode node) {
//		if(node == null) return 0;
//		if(dp.containsKey(node)) return dp.get(node);
//		int sum=node.val+sum(node.left)+sum(node.right);
//		dp.put(node, sum);
//		return sum;
//	}
}
