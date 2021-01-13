package com.algods.learn.symboltable;

public class FenwickTree {
	int[] items;
	int mod=1000000007;
	public FenwickTree(int length) {
		items=new int[length];
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
	public void update(int index, int val) {
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
