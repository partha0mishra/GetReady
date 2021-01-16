package com.leetcode.bst;

/**
 * 1530 Number of Good Leaf Node Pairs
 * 
 * Given the root of a binary tree and an integer distance. 
 * A pair of two different leaf nodes of a binary tree is said to be good if the length of the 
 * shortest path between them is less than or equal to distance.
 * Return the number of good leaf node pairs in the tree.
 * 
 * Input: root = [1,2,3,null,4], distance = 3
Output: 1
Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3. This is the only good pair.

Input: root = [1,2,3,4,5,6,7], distance = 3
Output: 2
Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2. The pair [4,6] is not good because the length of ther shortest path between them is 4.

Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
Output: 1
Explanation: The only good pair is [2,5].

Input: root = [100], distance = 1
Output: 0

Input: root = [1,1,1], distance = 2
Output: 1

Constraints:
The number of nodes in the tree is in the range [1, 2^10].
Each node's value is between [1, 100].
1 <= distance <= 10
 */

import java.util.*;
public class BinaryTreeGoodLeafNodePairs {
	
	/**
	 * Approach 01 in July: copied from GFG and got TLE. Didn't understand much
	 * Approach 02 below: 
	 * probably from Naresh's solve: add a measure 'distance' to each node
	 * post order traversal, result = list of distances of leaf nodes
	 * if it's leaf node, distance= 1 (from the next parent node)
	 * for each distance coming from distance list of left and right, see how many add up to or less than intended distance
	 * add the left and right nodes and send them back.
	 * Approach 03: Since I know now that we don't need to add a variable if we can send out the number
	 * The post-order traversal takes care of accumulating from left and right to the parent and up
	 */
	int count=0;
	public int countPairs(TreeNode root, int distance) {
		if(root == null) return 0;
        traverse(root, distance);
        return count;
    }
	private List<Integer> traverse(TreeNode node, int dist) {
		List<Integer> result= new ArrayList<>();
		if(node == null) return result;// null node
		if(node.left == null && node.right==null) {result.add(1); return result;}// LEAF node
		List<Integer> lefts=traverse(node.left, dist);
		List<Integer> rights=traverse(node.right, dist);
		for(int l: lefts) {
			for(int r: rights) {
				if(l+r <= dist) {
					count+=1;// one pair found
				}
			}
		}
		for(int l: lefts) result.add(l+1);// adding 1 while propagating up
		for(int r: rights) result.add(r+1);// adding 1 while propagating up
		return result;
	}
	 /**
	  * Approach 02: adding distance attribute to Nodes
	  */
//	 class Node {
//	    TreeNode node;
//	    int d;// Distance for each node - to be calculated.
//	    
//	    public Node(TreeNode node, int d) {
//	        this.node = node;
//	        this.d = d;
//	    }
//	 }
//    int count = 0;
//    
//    private List<Node> traverse(TreeNode node, int distance) {
//        if(node==null) return new ArrayList<>();
//        if(node.left==null && node.right==null) {// leaf node
//            return Arrays.asList(new Node(node, 1));
//        }
//
//        List<Node> left = traverse(node.left, distance);
//        List<Node> right = traverse(node.right, distance);
//        List<Node> res = new ArrayList<>();
//        for(Node l: left) {
//            for(Node r: right) {
//                if(l.d+r.d<=distance) {
//                    count++;
//                }
//            }
//        }
//        for(Node r: right) {
//            res.add(new Node(r.node, r.d+1));
//        }
//        for(Node l: left) {
//            res.add(new Node(l.node, l.d+1));
//        }
//        return res;
//    }
//    
//    public int countPairs(TreeNode root, int distance) {
//        traverse(root, distance);
//        return count;
//    }
	
	public static void main(String[] args) {
		BinaryTreeGoodLeafNodePairs instance= new BinaryTreeGoodLeafNodePairs();
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.right= new TreeNode(3);
		root.left.right= new TreeNode(4);
		System.out.println(instance.countPairs(root, 3));// 1

		root.left.left= new TreeNode(4);
		root.left.right= new TreeNode(5);
		root.right.left= new TreeNode(6);
		root.right.right= new TreeNode(7);
		System.out.println(instance.countPairs(root,3));// 3
	}

}
