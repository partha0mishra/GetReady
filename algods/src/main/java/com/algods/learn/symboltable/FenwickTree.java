package com.algods.learn.symboltable;
/**
 * Binary Indexed Tree (BIT) aka Fenwick Tree
 * Create  : O(N logN)
 * Update  : O(  logN)
 * SumRange: O(  logN) <= O(H)
 * Space   : O(MAX +2) <= MAX = max number in the array
 */
public class FenwickTree {
	int[] items;
	int mod=1000000007;
	public FenwickTree(int length) {
		items=new int[length];
	}
	public FenwickTree(int[] arr) {
		int max=0;
		for(int a: arr) max=Math.max(max, a);
		items=new int[max+2];// for 5 elements, I need from 0 (dummy) to 6
		// Creating the tree is just like update
		for(int i=0; i< arr.length; i++) {
			update(arr[i],1);
		}
	}
	public int sumRange(int start, int end) {
		return sum(end+1)-sum(start);// 2 to 5 includes element at 2
	}
	public int sum(int index) {
		long sum=0;
		while(index >0) {
			sum+=items[index];
			sum%=mod;
			index-=index&-index;// getParent = index - (index & 2's complement of index)
		}
		return (int)sum;
	}
	public void update(int index, int val) {// same as create
		index+=1;
		while(index < items.length) {
			items[index]+=val;
			index+=index&-index;// getNext = index +(index & 2's complement of index)
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
