package com.algods.misc.sorting;

public class BubbleSort {
	public void sort(int[] array) {
		boolean isSorted = false;
		int tempVal=0;
		while(!isSorted) {
			isSorted=true;
			for(int i=0; i<array.length -1; i++) {
				if(array[i] > array[i+1]) {
					tempVal=array[i];
					array[i]=array[i+1];
					array[i+1]=tempVal;
					isSorted=false;
				}
			}
		}
	}
}
