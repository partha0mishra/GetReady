package com.algods.misc.sorting;

public class QuickSort {
	public void sort(int[] array) {
		quicksort(array, 0, array.length-1);
	}

	private void quicksort(int[] array, int start, int end) {
		if(start >= end) {
			return;
		}
		int pivot=(start+end)/2;
	}
}
