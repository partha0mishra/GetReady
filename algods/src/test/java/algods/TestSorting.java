package algods;

import static org.junit.jupiter.api.Assertions.*;
import algods.sorting.*;

import org.junit.jupiter.api.Test;

class TestSorting {

	public int[] testNums1= {5,8,3,20,13,6,12,18,16,11,15,4,10,1,2,19,7,9,14,17};
	
	boolean isSorted(int[] array) {
		for(int i=0; i<array.length -1; i++) {
			if(array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	
	/*
	 * @Test void testBubbleSort() { int[] testArray=testNums1.clone();
	 * printArray(testArray); new BubbleSort().sort(testArray);
	 * printArray(testArray); assertTrue(isSorted(testArray)); }
	 */ 
	@Test void testMergeSort() { int[] testArray=testNums1.clone();
	printArray(testArray); new MergeSort().sort(testArray);
	printArray(testArray); assertTrue(isSorted(testArray)); }
	 
}
