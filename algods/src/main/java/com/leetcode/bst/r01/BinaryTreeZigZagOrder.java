package com.leetcode.bst.r01;
/** TODO Anki
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7]
 * 
    3
   / \
  9  20
    /  \
   15   7
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 */
import java.util.*;

public class BinaryTreeZigZagOrder {
	//Definition for a binary tree node.
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	/**
	 * BFS, with a flag to toggle ordering
	 * Use a Deque and to be TRULY used as a Double-ended one
	 * 
	 * if(toggle) current=pollLast(), offerFirst(current.right), offerFirst(current.left)
	 * else       current=pollFirst(), offerLast(current.left),  offerLast(current.right)
	 * 
	 * O(N)/ O(leaves)=> O(N/2) => O(N)
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(root == null) return result;
		Deque<TreeNode> queue=new ArrayDeque<>();// use as a queue/ stack
		boolean right=true;
		queue.offerLast(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			ArrayList<Integer> thisLevel=new ArrayList<>();
			right=!right;
			for(int s=0; s< size; s++) {
				TreeNode current;
				if(right) {
					current=queue.pollLast();
					if(current.right != null) queue.offerFirst(current.right);
					if(current.left != null) queue.offerFirst(current.left);
				}else {
					current=queue.pollFirst();
					if(current.left != null) queue.offerLast(current.left);
					if(current.right != null) queue.offerLast(current.right);
				}
				thisLevel.add(current.val);
			}
			result.add(thisLevel);
		}
		return result;
	}
		
	/**
	 * Approach 01: similar one, but didn't know about Deque 
	 */
//	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//		if(root == null) return new ArrayList<List<Integer>>();
//		boolean moveRight=false; // false- right, true- left. We start with Left
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		Queue<TreeNode> nodeQueue= new LinkedList<TreeNode>();
//		nodeQueue.add(root);
//		
//		while(!nodeQueue.isEmpty()) {
//			int nodeCount= nodeQueue.size();
//			ArrayList<Integer> thisLevelNodes= new ArrayList<Integer>();
//			Stack<Integer> thisLevelStack= new Stack<Integer>();
//			while(nodeCount -- >0) {
//				TreeNode thisNode=nodeQueue.remove();
//				
//				if(thisNode !=null) {
//					nodeQueue.add(thisNode.left);
//					nodeQueue.add(thisNode.right);
//					
//					if(moveRight) {
//						// push to stack
//						thisLevelStack.add(thisNode.val);
//					}else {
//						// push to this level ArrayList
//						thisLevelNodes.add(thisNode.val);
//					}
//				}
//			}
//			if(moveRight) {// get from stack
//				while(!thisLevelStack.isEmpty()) {
////					System.out.println(thisLevelStack.peek());
//					thisLevelNodes.add(thisLevelStack.pop());
//				}
//			}
//			if(!thisLevelNodes.isEmpty()) {
//				result.add(thisLevelNodes);
//			}
//			moveRight= moveRight? false: true;// flip it
//		}
//		
//		return result;
//    }
	public static void main(String[] args) {
		BinaryTreeZigZagOrder instance = new BinaryTreeZigZagOrder();
		TreeNode root= instance.new TreeNode(3);
		root.left= instance.new TreeNode(9);
		root.right=instance.new TreeNode(20);
		root.right.left=instance.new TreeNode(15);
		root.right.right=instance.new TreeNode(7);
		
		System.out.println(instance.zigzagLevelOrder(root).toString());
		System.out.println(instance.zigzagLevelOrder(null).toString());// null returns []
	}

}
