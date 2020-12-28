package com.leetcode.bst;

import java.util.*;
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
