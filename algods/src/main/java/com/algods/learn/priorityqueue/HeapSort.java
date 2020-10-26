package com.algods.learn.priorityqueue;

import java.util.Arrays;
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
public class HeapSort {
	private int[] items;
	private int n;
	public HeapSort() {
		items= new int[2];// keeping item[0] as blank; item[1] is max
		n=0;
	}
	public void insert(int x) {
		items[++n]=x;
		swim(n);
		if(n==items.length-1) resize(n+1);
	}
	public int delMax() {
		int max=items[1];
		swap(1,n--);
		sink(1);
//		if(n==items.length/4 && n>1) resize(n);// Don't resize as we need it
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
			if(items[k]>= items[j]) break;
			swap(k,j);
			k=j;
		}
	}
	private void resize(int origSize) {
		System.out.println("Resize called at: "+origSize);
		int[] tempItems= new int[2*origSize];
		for(int i=0; i< origSize; i++) {
			tempItems[i]=items[i];
		}
		items=tempItems;
	}
	private void swap(int i, int j) {
		int temp=items[i];
		items[i]=items[j];
		items[j]=temp;
	}
	public String toString() {
		StringBuilder sb= new StringBuilder();
		for(int i: items) sb.append(i).append(".");
		return sb.substring(2, sb.length()-1);
	}
	public int[] sort() {
//		System.out.println("n: "+n);
//		int[] result=new int[n];
//		for(int i=0; i< result.length; i++) {
//			delMax();
//		}
//		System.arraycopy(items, 1, result, 0, result.length);
		// OLD CODE Above
		int numElements=n;
		int[] result=new int[numElements-1];
		while (n > 1) {
			swap(1, n--);// can't use numElements as 'n' is used in sink()
			sink(1);
		}
		System.arraycopy(items, 1, result, 0, numElements-1);
		return result;
	}
	public static void main(String[] args) {
		final int NUM_ARRAY_SIZE=100;
		Random random= ThreadLocalRandom.current();
		//for(int i=0; i< NUM_ARRAY_SIZE; i++) {nums[i]= random.nextInt(NUM_ARRAY_SIZE);}
		HashSet<Integer> hm= new HashSet<Integer>();
		HeapSort instance= new HeapSort();
		for(int i=0; i< NUM_ARRAY_SIZE; ) {// let's make sure the numbers are distinct
			int newNum= random.nextInt(NUM_ARRAY_SIZE*10);
			if(hm.contains(newNum)) {
				continue;
			}else {
				instance.insert(newNum);
				i++;
//				System.out.println(instance);
				hm.add(newNum);
			}
		}
//		System.out.println(instance);
		int[] sorted=instance.sort();
//		System.out.println(instance);
		System.out.println("Result: "+Arrays.toString(sorted));
		instance.validate(sorted,0,sorted.length-1);
	}
	private void validate(int[] nums, int lo, int hi) {
		for(int i=lo; i<hi-1; i++) {
//			System.out.println(nums[i]+" "+nums[i+1]);
			if(nums[i] > nums[i+1]) {
				System.out.println("Debug - wrong: "+nums[i]+" > "+nums[i+1]);
				break;
			}
		}
	}

}
