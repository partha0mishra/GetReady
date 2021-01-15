package com.leetcode.design;
/**
 * 449. Serialize and Deserialize BST
 * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

 

Example 1:

Input: root = [2,1,3]
Output: [2,1,3]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The input tree is guaranteed to be a binary search tree.
 */
import java.util.*;

import com.leetcode.bst.TreeNode;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root==null) return "[]";
        ArrayList<Integer> result=new ArrayList<Integer>();
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);
        boolean hasElements=q.size()>0;
        while(!q.isEmpty() && hasElements) {
        	int size=q.size();
        	ArrayList<Integer> level=new ArrayList<Integer>();
        	hasElements=false;
        	for(int s=0; s< size; s++) {
        		TreeNode node=q.poll();
        		if(node == null) {
        			level.add(null);
        		}else {
        			hasElements=true;
	        		level.add(node.val);
	        		q.offer(node.left);
	        		q.offer(node.right);
        		}
        	}
        	if(hasElements) {
        		result.addAll(level);
        	}
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	data=data.substring(1, data.length()-1).trim();
    	System.out.println(data);
    	if(data.length() ==0) return null;
        String[] tokens=data.split(",");
        System.out.println(tokens.length);
//        if(tokens.length < 1) return null;
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        int pos=0;
        TreeNode root=new TreeNode(Integer.valueOf(tokens[pos++].trim()));
        q.offer(root);
    	while(!q.isEmpty() && pos< tokens.length) {
    		TreeNode node=q.poll();
    		String left=tokens[pos++].trim();
    		String right=tokens[pos++].trim();
    		if(left.equals("null")) {    		
    			node.left=null;
    		}else {
    			node.left=new TreeNode(Integer.valueOf(left));
    			q.offer(node.left);
    		}
    		
    		if(right.equals("null")) {
    			node.right=null;
    		}else {
    			node.right=new TreeNode(Integer.valueOf(right));
    			q.offer(node.right);
    		}
    	}
    	return root;
    }


	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.right.left=new TreeNode(5);
		root.right.right=new TreeNode(6);
		root.right.left.right=new TreeNode(7);
		root.right.right.right=new TreeNode(8);
		root.right.right.right.left=new TreeNode(9);
		root.right.right.right.right=new TreeNode(10);
		// Your Codec object will be instantiated and called as such:
		 Codec ser = new Codec();
		 Codec deser = new Codec();
		 String tree = ser.serialize(root);
		 System.out.println(tree);
		 TreeNode ans = deser.deserialize(tree);
		 System.out.println(ser.serialize(ans));
		 TreeNode t1 = deser.deserialize("[]");
		 String st1=ser.serialize(t1);
		 System.out.println(st1);
		// return ans;
	}

}
