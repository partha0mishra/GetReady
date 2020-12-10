package com.algods.leetcode.recursion;
/* 95. Unique Binary Trees II
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 

Constraints:

0 <= n <= 8
 */
import java.util.*;

import com.algods.leetcode.bst.TreeNode;

public class CreateUniqueBinaryTrees {
	public List<TreeNode> generateTrees(int n) {
        if(n==0) return new LinkedList<TreeNode>();
        return generateTrees(1,n);
    }
	private List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> allTreesAtThisLevel= new LinkedList<>();
		if(start > end) {
			allTreesAtThisLevel.add(null);
			return allTreesAtThisLevel;
		}
		for(int i=start; i<= end; i++) {// picking each number as a root
			// getting all trees with the left of the number
			List<TreeNode> leftTrees=generateTrees(start,i-1);
			// getting all trees with the right of the number
			List<TreeNode> rightTrees=generateTrees(i+1,end);
			// now creating all trees at this level
			for(TreeNode left: leftTrees)
				for(TreeNode right: rightTrees) {
					TreeNode root=new TreeNode(i);
					root.left=left;
					root.right=right;
					allTreesAtThisLevel.add(root);
				}
		}
		
		return allTreesAtThisLevel;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
