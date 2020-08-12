package com.algods.misc.sorting;

public class MergeSort {
	public void sort(int[] array) {
		int[] temp=new int[(array.length)];
		mergeSort(array,temp, 0, array.length -1);
	}
	
	public void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd) {
			return;
		}
		
		int leftEnd=(leftStart+rightEnd)/2;
		int rightStart=leftEnd+1;
		mergeSort(array, temp, leftStart, leftEnd);
		mergeSort(array, temp, rightStart, rightEnd);
		mergeHalves(array, temp, leftStart, leftEnd, rightStart, rightEnd);
	}
	
	public void mergeHalves(int[] array, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		int left=leftStart;
		int right=rightStart;
		int index=leftStart;
		while(left <= leftEnd && right <= rightEnd) {
			printArray(array);
			if(array[left] < array[right]) {
				temp[index] = array[left];
				left++;
			}else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		System.arraycopy(array, left, temp, index, leftEnd-left+1);
		System.arraycopy(array, right, temp, index, rightEnd-right+1);
		//printArray(temp);
		System.arraycopy(temp, leftStart, array, leftStart, rightEnd-leftStart+1);
	}
	
	void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
