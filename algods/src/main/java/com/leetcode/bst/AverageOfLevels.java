package com.leetcode.bst;
/** EASY 
 * 637. Average of Levels in Binary Tree
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 * */
import java.util.*;
public class AverageOfLevels {
	/**
	 * EASY BFS - O(N)/ O(N)
	 */
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<Double>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            double sum=0;// IMPORTANT 
            int size=q.size();
            for(int i=0; i< size; i++){
                TreeNode node=q.remove();
                sum+=node.val;
                if(node.left != null) q.add(node.left);
                if(node.right !=null) q.add(node.right);
            }
            result.add(sum/size);
        }
        return result;
    }
}
