package com.leetcode.bst;
/* 1120. Maximum Average Subtree
 * Given the root of a binary tree, find the maximum average value of any subtree of that tree.

(A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of its values, divided by the number of nodes.)

 

Example 1:



Input: [5,6,1]
Output: 6.00000
Explanation: 
For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
For the node with value = 6 we have an average of 6 / 1 = 6.
For the node with value = 1 we have an average of 1 / 1 = 1.
So the answer is 6 which is the maximum.
 

Note:

The number of nodes in the tree is between 1 and 5000.
Each node will have a value between 0 and 100000.
Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 */
import java.util.HashMap;
public class MaxAvgSubtree {
	/* 02: lesser code. still O(n) O(n)
	 * keeping state
	 * double[] {sum, count, avg} at each node 
	 */
	public double maximumAverageSubtree(TreeNode root) {
        return helper(root)[2];
    }
    private double[] helper(TreeNode n) {
        if (n == null)  // base case.
            return new double[]{0, 0, 0}; // sum, count  & average of nodes
        double[] l = helper(n.left), r = helper(n.right); // recurse to children.
        double child = Math.max(l[2], r[2]); // larger of the children (avg)
        double sum = n.val + l[0] + r[0], cnt = 1 + l[1] + r[1]; // sum & count of subtree rooted at n.
        double maxOfThree = Math.max(child, sum  / cnt); // largest out of n and its children.
        return new double[]{sum, cnt, maxOfThree}; 
    }
	
	/* 01: Brute force - DFS - Seems this is the only way
	 * O(n) time : each node is visited once
	 * O(n) space: 2 HashMaps of length N
	 */
//	double maxAvg=0;// since all values are positive
//	HashMap<TreeNode, Integer> nodeVals=new HashMap<>();
//	HashMap<TreeNode, Integer> nodeCounts=new HashMap<>();
//	public double maximumAverageSubtree(TreeNode root) {
//		populateSumCount(root);
//		return maxAvg;
//    }
//	private int sum(TreeNode root) {
//		if(root == null) return 0;
//		if(!nodeVals.containsKey(root)) {
//			nodeVals.put(root, root.val+sum(root.left)+sum(root.right));
//		}
//		return nodeVals.get(root);
//	}
//	private int count(TreeNode root) {
//		if(root == null) return 0;
//		if(!nodeCounts.containsKey(root)) {
//			nodeCounts.put(root, 1+count(root.left)+count(root.right));
//		}
//		return nodeCounts.get(root);
//	}
//	private void populateSumCount(TreeNode root) {
//		if(root.left != null) populateSumCount(root.left);
//		if(root.right != null) populateSumCount(root.right);
//		double avg=(double)sum(root)/count(root);
//		if(avg> maxAvg) maxAvg=avg;
//	}
}
