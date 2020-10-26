package com.algods.learn.priorityqueue;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Max Heap using Binary Tree represented in an Array - 1-indexed
 * Parent(k) at k/2
 * Children of (k) at 2k and 2k+1
 * Parent is NO LESS than any child
 * Array is Resized
 */
public class BinaryHeap {
	private int[] items;
	private int n;
	public BinaryHeap() {
		items= new int[2];// keeping item[0] as blank; item[1] is max
		n=0;
	}
	public void insert(int x) {
		items[++n]=x;
		swim(n);
		if(n==items.length-1) resize(); 
//			resize(n+1);
	}
	public int delMax() {
		int max=items[1];
//		swap(1,n--);
		items[1]=items[n--];
		sink(1);
		if(n==items.length/4 && n>1) resize(); 
//			resize(n);
		return max;
	}
	private void swim(int k) {
		// when child's value is more than parent's
		while(k>1 && items[k/2] < items[k]) {
			swap(k,k/2);
			k=k/2;// propagate up
		}
	}
	private void sink(int k) {
		// when parent's value is less than any child's value
		while(2*k <= n) {
			int j=2*k;
			if(j < n && items[j]<items[j+1]) j++;
			if(items[k] >= items[j]) break;
			swap(k,j);
			k=j;
		}
	}
	private void resize(int origSize) {
		System.out.println("Resize called at: "+origSize);
		int[] tempItems= new int[2*origSize];
		System.arraycopy(items, 0, tempItems, 0, origSize);
//		for(int i=0; i< origSize; i++) {
//			tempItems[i]=items[i];
//		}
		items=tempItems;
	}
	private void resize() {
		System.out.println("Resize called at: "+n);
		int[] tempItems= new int[2*n+1];
		System.arraycopy(items, 0, tempItems, 0, n+1);
		items=tempItems;
	}
	private void swap(int i, int j) {
		int temp=items[i];
		items[i]=items[j];
		items[j]=temp;
	}
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		for(int i: items) 
			sb.append(i).append(".");
		return sb.substring(2, sb.length()-1).toString();
	}
	public static void main(String[] args) {
		final int NUM_ARRAY_SIZE=100;
		Random random= ThreadLocalRandom.current();
		//for(int i=0; i< NUM_ARRAY_SIZE; i++) {nums[i]= random.nextInt(NUM_ARRAY_SIZE);}
		HashSet<Integer> hm= new HashSet<Integer>();
		BinaryHeap instance= new BinaryHeap();
		for(int i=0; i< NUM_ARRAY_SIZE; ) {// let's make sure the numbers are distinct
			int newNum= random.nextInt(NUM_ARRAY_SIZE*10);
			if(hm.contains(newNum)) {
				continue;
			}else {
				instance.insert(newNum);
				i++;
				System.out.println(instance);
				hm.add(newNum);
			}
		}
		System.out.println(">>>> "+instance);
		int prev=instance.delMax();
		System.out.print(prev+".");
		for(int i=1; i< NUM_ARRAY_SIZE; i++) {
			int num=instance.delMax();
			System.out.print(num+".");
			if(num > prev) System.out.println("Error");
			else prev=num;
		}
		hm= new HashSet<Integer>();
		for(int i=0; i< NUM_ARRAY_SIZE; ) {// let's make sure the numbers are distinct
			int newNum= random.nextInt(NUM_ARRAY_SIZE*10);
			if(hm.contains(newNum)) {
				continue;
			}else {
				instance.insert(newNum);
				i++;
				System.out.println(instance);
				hm.add(newNum);
			}
		}
		System.out.println(">>>> "+instance);
		prev=instance.delMax();
		System.out.print(prev+".");
		for(int i=1; i< NUM_ARRAY_SIZE; i++) {
			int num=instance.delMax();
			System.out.print(num+".");
			if(num > prev) System.out.println("Error");
			else prev=num;
		}
	}

}
