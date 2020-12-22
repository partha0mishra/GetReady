package com.algods.leetcode.bst;

/*
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
public class BinaryTreeGoodLeafNodePairs5474 {
	
	 /* Definition for a binary tree node. */
	 public class TreeNode {
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
	 class Node {
	    TreeNode node;
	    int d;
	    
	    public Node(TreeNode node, int d) {
	        this.node = node;
	        this.d = d;
	    }
	 }
    int count = 0;
    
    private List<Node> traverse(TreeNode root, int distance) {
        if(root==null) return new ArrayList<>();
        if(root.left==null && root.right==null) {
            return Arrays.asList(new Node(root, 1));
        }

        List<Node> left = traverse(root.left, distance);
        List<Node> right = traverse(root.right, distance);
        // System.out.println(left.size());
        // System.out.println(right.size());
        List<Node> res = new ArrayList<>();
        for(Node l: left) {
            for(Node r: right) {
                if(l.d+r.d<=distance) {
                    // System.out.println(root.val+"<"+r.node.val+","+l.node.val);
                    count++;
                }
            }
        }
        for(Node r: right) {
            res.add(new Node(r.node, r.d+1));
        }
        for(Node l: left) {
            res.add(new Node(l.node, l.d+1));
        }
        return res;
    }
    
    public int countPairs(TreeNode root, int distance) {
        traverse(root, distance);
        return count;
    }

	 
	 
	/* First Try - sub- optimal 
	 * public int countPairs(TreeNode root, int distance) { int count=0; // get all
	 * leaf nodes ArrayList<TreeNode> leafNodes= new ArrayList<TreeNode>();
	 * populateLeafNodes(root,leafNodes);
	 * 
	 * // get distances between each pair and match against the given distance
	 * for(int i=0; i< leafNodes.size() -1; i++) { for(int j=i+1; j<
	 * leafNodes.size(); j++) { int
	 * d=distance(root,leafNodes.get(i),leafNodes.get(j)); //
	 * System.out.println(leafNodes.get(i).val+" "+leafNodes.get(j).val+" > "+d);
	 * if(d <= distance) count++; } } return count; } private void
	 * populateLeafNodes(TreeNode root, ArrayList<TreeNode> leafNodes) { if(root ==
	 * null) return; if(root.left == null && root.right == null)
	 * leafNodes.add(root); populateLeafNodes(root.left,leafNodes);
	 * populateLeafNodes(root.right,leafNodes); } private TreeNode lca(TreeNode
	 * root, TreeNode first, TreeNode second) { if(root == null) return root;
	 * if(root.equals(first) || root.equals(second)) return root;
	 * 
	 * TreeNode left= lca(root.left,first,second); TreeNode right=
	 * lca(root.right,first,second);
	 * 
	 * if(left != null && right != null) return root; if(left != null) return left;
	 * else return right; } private int distance(TreeNode root, TreeNode first,
	 * TreeNode second) { TreeNode lca=lca(root,first,second); //
	 * System.out.print("lca: "+lca.val); int l1=findLevel(lca,first,0); //
	 * System.out.print("  l1 :"+l1); int l2=findLevel(lca,second,0); //
	 * System.out.println("  l2 :"+l2); return l1+l2; } private int
	 * findLevel(TreeNode lca, TreeNode node, int level) { if(lca == null) return
	 * -1; if(lca.equals(node)) return level; int
	 * leftLevel=findLevel(lca.left,node,level+1); if(leftLevel == -1) { return
	 * findLevel(lca.right,node,level+1); } return leftLevel; }
	 */
	public static void main(String[] args) {
		BinaryTreeGoodLeafNodePairs5474 instance= new BinaryTreeGoodLeafNodePairs5474();
		TreeNode root= instance.new TreeNode(1);
		root.left= instance.new TreeNode(2);
		root.right= instance.new TreeNode(3);
		root.left.right=instance.new TreeNode(4);
		System.out.println(instance.countPairs(root, 3));// 1

		root.left.left= instance.new TreeNode(4);
		root.left.right= instance.new TreeNode(5);
		root.right.left= instance.new TreeNode(6);
		root.right.right= instance.new TreeNode(7);
		System.out.println(instance.countPairs(root,3));// 2
	}

}
