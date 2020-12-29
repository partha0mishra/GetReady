package com.leetcode.recursion.bst;
/* 653. Two Sum IV - Input is a BST
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

 

Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
Example 3:

Input: root = [2,1,3], k = 4
Output: true
Example 4:

Input: root = [2,1,3], k = 1
Output: false
Example 5:

Input: root = [2,1,3], k = 3
Output: true
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
 */
import java.util.*;
public class TwoSum4 {
	private HashSet<Integer> hs= new HashSet<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(hs.contains(k-root.val)) return true;
        else {
            hs.add(root.val);
            return(findTarget(root.left,k)|| findTarget(root.right,k));
        }
    }
}
