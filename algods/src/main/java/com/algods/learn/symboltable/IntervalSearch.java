package com.algods.learn.symboltable;

public class IntervalSearch {
	class Node{
		int rangeLeft, rangeRight;// (2,5) left(l) is the Key
		int size,maxEndpoint;// max end-point(r) at a right subtree
		Node left, right;
		public Node(int l, int r, int maxEndPoint, int size) {
			this.rangeLeft=l;
			this.rangeRight=r;
			this.maxEndpoint=maxEndPoint;
			this.size=size;
		}
	}
	private Node root;
	public void put(int rangeLeft, int rangeRight) {
		root= put(root, rangeLeft, rangeRight);
	}
	private Node put(Node node, int rangeLeft, int rangeRight) {
		if(node == null) return new Node(rangeLeft, rangeRight, rangeRight, 1);
		int cmp=rangeLeft - node.rangeLeft;// assuming the intervals don't have the same starting point
		if(cmp < 0) node.left=put(node.left, rangeLeft, rangeRight);
		else if(cmp > 0) node.right=put(node.right, rangeLeft, rangeRight);
		//node.size=1+size(node.left)+size(node.right);
		node.maxEndpoint=getMaxEndpoint(node);
		return node;
	}
	private int getMaxEndpoint(Node node) {
		if(node == null) return 0;
		return Math.max(node.maxEndpoint, getMaxEndpoint(node.right));
	}
	public static void main(String[] args) {
		IntervalSearch instance= new IntervalSearch();
	}

}
