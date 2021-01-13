package com.algods.learn.symboltable;

/**
 * Segment Tree - for a Min(Range) query
 * for a Max(Range) query, need to initialize array (and use default return value as) with MIN_VALUE instead of MAX_VALUE
 */
public class SegmentTree {
	public enum ST_TYPE{MIN,MAX};
	int[] tree;
	final ST_TYPE treeType;// determine at the beginning
	final int defaultValue;// set only once
	final int maxInt;
	public SegmentTree(int[] input, ST_TYPE type) {
		int nextPowerOfTwo= nextPowerOfTwo(input.length);// we need [2*these many -1] elements
		tree= new int[2*nextPowerOfTwo -1];
		maxInt=input.length-1;// input array contains the frequency of corresponding numbers at those indices
		treeType= type;
		defaultValue= (treeType==ST_TYPE.MIN)? Integer.MAX_VALUE: Integer.MIN_VALUE;
		for(int i=0; i< tree.length; i++) tree[i]=defaultValue;
		constructTree(input, tree, 0, input.length -1, 0);
		for(int t: tree) System.out.printf("%3d", t);
		System.out.println();
	}
	private void constructTree(int[] input, int[] tree, int low, int high, int pos) {
		if(low == high) {tree[pos]=input[low]; return;}
		int mid=low+(high-low)/2;
		constructTree(input, tree, low, mid, 2*pos+1);// left child
		constructTree(input, tree, mid+1, high, 2*pos+2);// right child
		tree[pos]=(treeType == ST_TYPE.MIN)? Math.min(tree[2*pos+1], tree[2*pos+2])
				: Math.max(tree[2*pos+1], tree[2*pos+2]);// propagate min/ max upward
	}
	public int rangeQuery(int queryLow, int queryHigh) {
		return rangeQuery(queryLow, queryHigh, 0, maxInt, 0);
	}
	private int rangeQuery(int queryLow, int queryHigh, int low, int high, int pos) {
		if(queryLow <= low && queryHigh >= high) return tree[pos];// Total Overlapped range
		if(queryLow > high || queryHigh < low)   return defaultValue;// MIN or MAX depending on the tree type
		int mid=low+(high-low)/2;
		int left=rangeQuery(queryLow, queryHigh, low, mid, 2*pos+1);
		int right=rangeQuery(queryLow, queryHigh, mid+1, high, 2*pos+2);
		return (treeType == ST_TYPE.MIN)? Math.min(left, right): Math.max(left, right);
	}
	// utility method
	public int nextPowerOfTwo(int num) {
		if(Integer.bitCount(num) ==1) return num;
		return Integer.highestOneBit(num)<<1;
	}
	public static void main(String[] args) {
		int[] input= {0,3,4,2,1,6,-1};// frequencies
		SegmentTree st= new SegmentTree(input, ST_TYPE.MIN);// creating a segment tree for min range queries
		assert -1 == st.rangeQuery(0, 6);
		assert  0 == st.rangeQuery(0, 3);
		assert  1 == st.rangeQuery(2, 5);
		assert  6 == st.rangeQuery(5, 5);
//		for(int i=0; i< 20; i++) System.out.println(i+" "+st.nextPowerOfTwo(i));// testing out utility method
	}

}
