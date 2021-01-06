package com.leetcode.design;
/** TODO Anki
 * Serialize/ De-serialize Binary Tree
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
 */
import java.util.*;
public class SerializeDeSerializeBinaryTree {
	/**
	 * Approach : BFS with Queue
	 * O(N) O(N)
	 * Serialize >> using SPACE as Separator and . to indicate null
	 * offerLast() node into queue
	 * pollFirst() node, add to StringBuffer, getLeft and getRight and offerLast() them, even when null. if not null, turn on a layer level flag
	 * if the layer level flag is off, all were null. we don't need to persist these values
	 * 
	 * De-serialize >>
	 * tokenize the string
	 * take the first token and put to a queue
	 * go through the tokens till it ends
	 * take one element from queue and two tokens, assign them to left and right of the element from queue. if a token is not null, add to queue
	 */
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public class Codec {
		final String SEP=" ";
		final String NULL=".";
	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        StringBuilder sb=new StringBuilder();
	        if(root == null) return sb.toString();
	        Deque<TreeNode> queue= new LinkedList<>();
	        queue.offerLast(root);
	        while(!queue.isEmpty()) {
	        	int size= queue.size();
	        	StringBuilder sbLayer= new StringBuilder();
	        	boolean notNull=false;
	        	for(int s=0; s< size; s++) {
	        		TreeNode tn= queue.pollFirst();
	        		if(tn != null) {
	        			notNull=true;
	        			queue.offerLast(tn.left);
	        			queue.offerLast(tn.right);
	        			sbLayer.append(tn.val);
	        		}else sbLayer.append(NULL);
	        		sbLayer.append(SEP);
	        	}
	        	if(notNull) sb.append(sbLayer);// not adding the last layer of all nulls
	        }
//	        System.out.println("Serialized String:"+sb.toString());
	        return sb.substring(0, sb.length()-1).toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        if(data.length() < 1) return null;
	        String[] tokens=data.split(SEP);
	        LinkedList<TreeNode> parents=new LinkedList<>();// ArrayDeque doesn't support null
	        TreeNode head=null;
	        if(!tokens[0].equals(NULL)) head=new TreeNode(Integer.parseInt(tokens[0]));
	        parents.add(head);
	        int c=1;// starting of child token position
	        while(!parents.isEmpty() && c < tokens.length) {
	        	int size=parents.size();
	        	for(int s=0; s< size; s++) {
	        		TreeNode parent=parents.pollFirst();
	        		if(parent==null) continue;// skip the nulls
	        		String left=tokens[c++], right=tokens[c++];
		        	if(!left.equals(NULL)) parent.left=new TreeNode(Integer.parseInt(left));
		        	if(!right.equals(NULL)) parent.right=new TreeNode(Integer.parseInt(right));
		        	parents.offerLast(parent.left);
		        	parents.offerLast(parent.right);
	        	}
	        }
	        return head;
	    }
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
	public static void main(String[] args) {
		SerializeDeSerializeBinaryTree instance= new SerializeDeSerializeBinaryTree();
		TreeNode root= null;
//		root= instance.new TreeNode(1);								// 1
//		root.left=instance.new TreeNode(2);							// 1 2 .
//		root.right=instance.new TreeNode(3);						// 1 2 3
//		root.left.left=instance.new TreeNode(4);					// 1 2 3 4 . . .
//		root.right.left=instance.new TreeNode(5);					// 1 2 3 4 . 5 .
//		root.right.right=instance.new TreeNode(6);					// 1 2 3 4 . 5 6
//		root.left.left.right=instance.new TreeNode(7);				// 1 2 3 4 . 5 6 . 7 . . . .
//		root.right.right.left=instance.new TreeNode(8);				// 1 2 3 4 . 5 6 . 7 . . 8 .
//		root.right.right.right=instance.new TreeNode(9);			// 1 2 3 4 . 5 6 . 7 . . 8 9
//		root.left.left.right.left=instance.new TreeNode(10);		// 1 2 3 4 . 5 6 . 7 . . 8 9 10 . .  .  .  .
//		root.right.right.left.left=instance.new TreeNode(11);		// 1 2 3 4 . 5 6 . 7 . . 8 9 10 . 11 .  .  .
//		root.right.right.left.right=instance.new TreeNode(12);		// 1 2 3 4 . 5 6 . 7 . . 8 9 10 . 11 12 .  .
//		root.right.right.right.right=instance.new TreeNode(13);		// 1 2 3 4 . 5 6 . 7 . . 8 9 10 . 11 12 . 13
		Codec codec=instance.new Codec();
		String data=codec.serialize(root);
		System.out.println(data);
		TreeNode newRoot=codec.deserialize(data);
		System.out.println(codec.serialize(newRoot));
	}

}
