package com.leetcode.bst;

/** TODO Anki
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
	 * We have to do normal post order tree traversal.
	 * The trick is to keep track of number of leaf nodes with a particular distance. The arrays are used for this purpose.
	 * For this we maintain an array of size = max distance.
	 * 
	 * In above example , assume maximum distance = 4. So we maintain an array of size 4.
	 * For root node 1,
	 * left = [ 0,0,1,0,0]
	 * right = [0,1,0,0,0]
	 * Here, left[2] = 1, which denotes that there is one leaf node with distance 2 in left subtree of root node 1.
	 * right[1] = 1, which denotes that there is one leaf node with distance 1 in right subtree of root node 1.
	 * In this way, we have to recursively, calculate the left and right subtree of every root node.
	 * Once we have both left and right arrays for a particular root, we have to just calculate total number of good node pairs formed using result += left[l]*right[r];
	 * Before we backtrack to parent, we have to return the distance for parents by adding up left and right subtrees of current node. 
	 * Note that we are doing - res[i+1] = left[i]+right[i];
	 * The intuition is that, if a leaf node is at distance i from current node, it would be at distance i+1 from its parent. 
	 * Hence, will building the res array, we are adding sum in i+1 th position and return to parent.
	 */
    int result = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return result;
    }
    
    int[] dfs(TreeNode root,int distance){
        if(root == null)
            return new int[distance+1];
        if(root.left == null && root.right == null){
            int res[] = new int[distance+1];
            res[1]++;
            return res;
        }
        int[] left = dfs(root.left,distance);
        int[] right = dfs(root.right,distance);
        for(int l=1;l<left.length;l++){
            for(int r = distance-1;r>=0;r--){
                if(l+r <=distance)
                result += left[l]*right[r];
            }
        }
        int res[] = new int[distance+1];
        //shift by 1
        for(int i=res.length-2;i>=1;i--){
            res[i+1] = left[i]+right[i];
        }
        
        return res;
    }
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
//	int count=0;
//	public int countPairs(TreeNode root, int distance) {
//		if(root == null) return 0;
//        traverse(root, distance);
//        return count;
//    }
//	private List<Integer> traverse(TreeNode node, int dist) {
//		List<Integer> result= new ArrayList<>();
//		if(node == null) return result;// null node
//		if(node.left == null && node.right==null) {result.add(1); return result;}// LEAF node
//		List<Integer> lefts=traverse(node.left, dist);
//		List<Integer> rights=traverse(node.right, dist);
//		for(int l: lefts) {
//			for(int r: rights) {
//				if(l+r <= dist) {
//					count+=1;// one pair found
//				}
//			}
//		}
//		for(int l: lefts) result.add(l+1);// adding 1 while propagating up
//		for(int r: rights) result.add(r+1);// adding 1 while propagating up
//		return result;
//	}
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
