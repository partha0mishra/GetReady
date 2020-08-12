package com.algods.leetcode;
/*
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * 
 * Example:
 * Input: 3
 * Output: [1,3,3,1]
 * Could you optimize your algorithm to use only O(k) extra space?
 */
import java.util.*;
public class PascalsTriangle2 {
	/* Approach 04: more intuitive. starting with an array filled with 1 */
//	public List<Integer> getRow(int k) {
//        Integer[] arr = new Integer[k + 1];
//        Arrays.fill(arr, 1);
//        
//        for (int i = 1; i <= k; i++) 
//            for (int j = i-1; j > 0; j--) 
//                arr[j] = arr[j] + arr[j - 1];
//        
//        return Arrays.asList(arr);
//    }
	/* Approach 03: use Integer[] instead of int[] to avoid shameful conversion to ArrayList*/
//    public List<Integer> getRow(int rowIndex) {// index starting from 0
//        Integer[] resultInts=new Integer[rowIndex+1];// size
//        resultInts[0]=1;// starting number is always 1
//    	for(int i=1; i<= rowIndex; i++) {
//    		// last place is 1
//    		resultInts[i]=1;
//    		// go from penultimate to 2nd place
//    		for(int j=i-1; j>0; j--) {
//    			resultInts[j]=resultInts[j]+resultInts[j-1];
//    		}
//    	}
//        return Arrays.asList(resultInts);
//    }
	/* Approach 02: Use the same array, update from the end */
    public List<Integer> getRow(int rowIndex) {// index starting from 0
    	List<Integer> result= new ArrayList<Integer>();
        int[] resultInts=new int[rowIndex+1];// size
        resultInts[0]=1;// starting number is always 1
    	for(int i=1; i<= rowIndex; i++) {
    		// last place is 1
    		resultInts[i]=1;
    		// go from penultimate to 2nd place
    		for(int j=i-1; j>0; j--) {
    			resultInts[j]=resultInts[j]+resultInts[j-1];
    		}
    	}
        for(int i: resultInts) result.add(i);// shame
        return result;
    }
	
	/* Approach 01: using a temporary array*/
//    public List<Integer> getRow(int rowIndex) {// index starting from 0
//    	List<Integer> result= new ArrayList<Integer>();
//        int[] resultInts=new int[rowIndex+1];// size
//        int[] tempInts=new int[rowIndex+1];// O(n) tempSpace
//        resultInts[0]=1;// starting number is always 1
//    	for(int i=1; i<= rowIndex; i++) {
//    		// Copy results to temp array to work with
//    		System.arraycopy(resultInts, 0, tempInts, 0, resultInts.length);
//    		// last place is 1
//    		resultInts[i]=1;
//    		// go from 2nd to penultimate place
//    		// result[i]=temp[i]+temp[i-1]
//    		for(int j=1; j<i; j++) {
//    			resultInts[j]=tempInts[j]+tempInts[j-1];
//    		}
//    	}
//        for(int i: resultInts) result.add(i);// shame
//        return result;
//    }
     
	public static void main(String[] args) {
		PascalsTriangle2 instance= new PascalsTriangle2();
		List<Integer> result;
		result=instance.getRow(0); instance.printList(result);
		result=instance.getRow(1); instance.printList(result);
		result=instance.getRow(2); instance.printList(result);
		result=instance.getRow(3); instance.printList(result);
		result=instance.getRow(4); instance.printList(result);
		result=instance.getRow(5); instance.printList(result);
	}
	private void printArray(int[] a) {
    	for(int i:a) System.out.printf("%3d",i);
    	System.out.println();
    }
	private void printList(List<Integer> a) {
		for(Integer i: a) System.out.printf("%3d",i);
		System.out.println();
	}
}
