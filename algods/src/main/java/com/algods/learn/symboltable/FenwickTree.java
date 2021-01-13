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
		return sum(end+1)-sum(start);
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
		int[] input= {1,2,3,4,1,2,3,1,2,1,4,3,2,4,3,4,8,9,8};
		FenwickTree ft= new FenwickTree(input);
		// Sums exclude the right-side limit
		assert 0 ==ft.sum(1);//  [0 -1>
		assert 4 ==ft.sum(2);//  [0 -2>
		assert 8 ==ft.sum(3);//  [0 -3>
		assert 12==ft.sum(4);//  [0 -4>
		assert 16==ft.sum(5);//  [0 -5>
		assert 16==ft.sum(6);//  [0 -6>
		assert 16==ft.sum(7);//  [0 -7>
		assert 18==ft.sum(8);//  [0 -8>
		assert 18==ft.sum(9);//  [0 -9>
		assert 19==ft.sum(10);// [0 -10>
		// sumRange includes both. 
		// sumRange(a,b) => sum(b+1) - sum(a)=> sum(0,1,..,b) - sum(0,1,..,a-1)
		assert 8 ==ft.sumRange(1, 2);// 4 ones and 4 twos
	}
}
