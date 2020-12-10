package com.algods.leetcode.arrays;
/* Valid Mountain Array
 * Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < A[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class ValidMountainArray {
	/* Scanning array: O(n) O(1)*/
	public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        boolean upward=false, downward=false;
        int current=arr[0];
        for(int i=1; i< arr.length; i++) {
        	int n=arr[i];
        	if(n > current) {
        		if(!upward) upward=true;// it's either going upward or just started
        		if(downward) return false;// it started going downward. this breaks the mountain
        	}else if(n < current){
        		if(!upward) return false;// never went up and already going down
        		if(!downward) downward=true;
        	}else return false;// no leveling allowed
        	current=n;
        }
        return upward && downward;
    }
	public static void main(String[] args) {
		assertTrue(new ValidMountainArray().validMountainArray(new int[] {1,2,3,2}));
		assertTrue(new ValidMountainArray().validMountainArray(new int[] {1,2,3,2,1}));
		assertTrue(new ValidMountainArray().validMountainArray(new int[] {1,2,1}));
		assertFalse(new ValidMountainArray().validMountainArray(new int[] {1}));
		assertFalse(new ValidMountainArray().validMountainArray(new int[] {1,1}));
		assertFalse(new ValidMountainArray().validMountainArray(new int[] {1,1,1}));
		assertFalse(new ValidMountainArray().validMountainArray(new int[] {1,1,1,1}));
		assertFalse(new ValidMountainArray().validMountainArray(new int[] {3,2,1}));
		assertFalse(new ValidMountainArray().validMountainArray(new int[] {3,2,2}));
		assertFalse(new ValidMountainArray().validMountainArray(new int[] {1,2,3}));
		assertFalse(new ValidMountainArray().validMountainArray(new int[] {1,2,2}));
		assertFalse(new ValidMountainArray().validMountainArray(new int[] {1,2,3,3}));
		assertFalse(new ValidMountainArray().validMountainArray(new int[] {1,2,3,2,2}));
		assertFalse(new ValidMountainArray().validMountainArray(new int[] {1,2,2,3}));
	}
}
