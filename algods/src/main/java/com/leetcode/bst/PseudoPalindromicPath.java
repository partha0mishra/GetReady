package com.leetcode.bst;
// TODO Anki
/**
 * Pseudo Palindromic Paths in a Binary Tree
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
Example 1:
Input: root = [2,3,1,3,1,null,1]
Output: 2 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 2:
Input: root = [2,1,1,1,3,null,null,null,null,null,1]
Output: 1 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 3:

Input: root = [9]
Output: 1
Constraints:

The given binary tree will have between 1 and 10^5 nodes.
Node values are digits from 1 to 9.
 */
public class PseudoPalindromicPath {
	// Keep a count[] - it will have a SINGLE ODD value to be pseudo-palindromic
	// DFS on BST
	// O(N) O(H)
	int paths=0;
	public int pseudoPalindromicPaths (TreeNode root) {
        int[] count= new int[10];
        dfs(root,count);
        return paths;
    }
	private void dfs(TreeNode root, int[] count) {
		count[root.val]+=1;
		if(root.left== null && root.right==null) {
			paths+=pseudoPalin(count);
		}
		if(root.left !=null) dfs(root.left,count);
		if(root.right != null) dfs(root.right,count);
		count[root.val]-=1;
	}
	// pseudo Palindromic - needs to have only 1 odd-count
	private int pseudoPalin(int[] count) {
		int oddCount=0;
		for(int c: count) {
			if(c%2 !=0) oddCount+=1;
			if(oddCount > 1) return 0;
		}
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
