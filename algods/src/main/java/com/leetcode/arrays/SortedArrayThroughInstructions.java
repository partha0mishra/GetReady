package com.leetcode.arrays;
/** TODO Anki
 * Given an integer array instructions, you are asked to create a sorted array from the elements in instructions. You start with an empty container nums. For each element from left to right in instructions, insert it into nums. The cost of each insertion is the minimum of the following:

The number of elements currently in nums that are strictly less than instructions[i].
The number of elements currently in nums that are strictly greater than instructions[i].
For example, if inserting element 3 into nums = [1,2,3,5], the cost of insertion is min(2, 1) (elements 1 and 2 are less than 3, element 5 is greater than 3) and nums will become [1,2,3,3,5].

Return the total cost to insert all elements from instructions into nums. Since the answer may be large, return it modulo 109 + 7

 

Example 1:

Input: instructions = [1,5,6,2]
Output: 1
Explanation: Begin with nums = [].
Insert 1 with cost min(0, 0) = 0, now nums = [1].
Insert 5 with cost min(1, 0) = 0, now nums = [1,5].
Insert 6 with cost min(2, 0) = 0, now nums = [1,5,6].
Insert 2 with cost min(1, 2) = 1, now nums = [1,2,5,6].
The total cost is 0 + 0 + 0 + 1 = 1.
Example 2:

Input: instructions = [1,2,3,6,5,4]
Output: 3
Explanation: Begin with nums = [].
Insert 1 with cost min(0, 0) = 0, now nums = [1].
Insert 2 with cost min(1, 0) = 0, now nums = [1,2].
Insert 3 with cost min(2, 0) = 0, now nums = [1,2,3].
Insert 6 with cost min(3, 0) = 0, now nums = [1,2,3,6].
Insert 5 with cost min(3, 1) = 1, now nums = [1,2,3,5,6].
Insert 4 with cost min(3, 2) = 2, now nums = [1,2,3,4,5,6].
The total cost is 0 + 0 + 0 + 0 + 1 + 2 = 3.
Example 3:

Input: instructions = [1,3,3,3,2,4,2,1,2]
Output: 4
Explanation: Begin with nums = [].
Insert 1 with cost min(0, 0) = 0, now nums = [1].
Insert 3 with cost min(1, 0) = 0, now nums = [1,3].
Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3].
Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3,3].
Insert 2 with cost min(1, 3) = 1, now nums = [1,2,3,3,3].
Insert 4 with cost min(5, 0) = 0, now nums = [1,2,3,3,3,4].
​​​​​​​Insert 2 with cost min(1, 4) = 1, now nums = [1,2,2,3,3,3,4].
​​​​​​​Insert 1 with cost min(0, 6) = 0, now nums = [1,1,2,2,3,3,3,4].
​​​​​​​Insert 2 with cost min(2, 4) = 2, now nums = [1,1,2,2,2,3,3,3,4].
The total cost is 0 + 0 + 0 + 0 + 1 + 0 + 1 + 0 + 2 = 4.
 

Constraints:

1 <= instructions.length <= 105
1 <= instructions[i] <= 105
 */
import static org.junit.Assert.assertEquals;
public class SortedArrayThroughInstructions {
	/**
	 * Approach 04: Merge Sort - elements jumping from left to right during Stable sort
	 * O(N logN)/ O(N) 
	 */
    int[] smaller;
    int[] larger;
    int[][] temp; // record some temporal information

    public int createSortedArray(int[] instructions) {
        int n = instructions.length;
        smaller = new int[n];
        larger = new int[n];
        temp = new int[n][];
        long cost = 0;
        long MOD = 1000000007;

        int[][] arrSmaller = new int[n][];
        int[][] arrLarger = new int[n][];
        for (int i = 0; i < n; i++) {
            arrSmaller[i] = new int[] { instructions[i], i };
            arrLarger[i] = new int[] { instructions[i], i };
        }

        sortSmaller(arrSmaller, 0, n - 1);
        sortLarger(arrLarger, 0, n - 1);

        for (int i = 0; i < n; i++) {
            cost += Math.min(smaller[i], larger[i]);
        }
        return (int) (cost % MOD);
    }

    private void sortSmaller(int[][] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        sortSmaller(arr, left, mid);
        sortSmaller(arr, mid + 1, right);
        mergeSmaller(arr, left, right, mid);
    }

    private void mergeSmaller(int[][] arr, int left, int right, int mid) {
        // merge [left, mid] and [mid+1, right]
        int i = left;
        int j = mid + 1;
        int k = left;
        // use temp[left...right] to temporarily store sorted array
        while (i <= mid && j <= right) {
            if (arr[i][0] < arr[j][0]) {
                temp[k++] = arr[i];
                i++;
            } else {
                temp[k++] = arr[j];
                smaller[arr[j][1]] += i - left;
                j++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i];
            i++;
        }
        while (j <= right) {
            temp[k++] = arr[j];
            smaller[arr[j][1]] += i - left;
            j++;
        }
        // restore from temp
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    private void sortLarger(int[][] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        sortLarger(arr, left, mid);
        sortLarger(arr, mid + 1, right);
        mergeLarger(arr, left, right, mid);
    }

    private void mergeLarger(int[][] arr, int left, int right, int mid) {
        // merge [left, mid] and [mid+1, right]
        int i = left;
        int j = mid + 1;
        int k = left;
        // use temp[left...right] to temporarily store sorted array
        while (i <= mid && j <= right) {
            if (arr[i][0] <= arr[j][0]) {
                temp[k++] = arr[i];
                i++;
            } else {
                temp[k++] = arr[j];
                larger[arr[j][1]] += mid - i + 1;
                j++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i];
            i++;
        }
        while (j <= right) {
            temp[k++] = arr[j];
            larger[arr[j][1]] += mid - i + 1;
            j++;
        }
        // restore from temp
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
	/**
	 * Approach 03: Binary Indexed Tree
	 * O(N logM)/ O(M)
	 */
//	 public int createSortedArray(int[] instructions) {
//	        int m = 100002;
//	        int[] bit = new int[m];
//	        long cost = 0;
//	        long MOD = 1000000007;
//
//	        for (int i = 0; i < instructions.length; i++) {
//	            int leftCost = query(instructions[i] - 1, bit);
//	            int rightCost = i - query(instructions[i], bit);
//	            cost += Math.min(leftCost, rightCost);
//	            update(instructions[i], 1, bit, m);
//	        }
//	        return (int) (cost % MOD);
//	    }
//
//	    // implement Binary Index Tree
//	    private void update(int index, int value, int[] bit, int m) {
//	        index++;
//	        while (index < m) {
//	            bit[index] += value;
//	            index += index & -index;
//	        }
//	    }
//
//	    private int query(int index, int[] bit) {
//	        index++;
//	        int result = 0;
//	        while (index >= 1) {
//	            result += bit[index];
//	            index -= index & -index;
//	        }
//	        return result;
//	    }
	/**
	 * Approach 02: Segment Tree
	 * O(N logM)/ O(M)
	 */
//	 public int createSortedArray(int[] instructions) {
//	        int m = (int) 1e5 + 1;
//	        int[] tree = new int[m * 2];
//
//	        long cost = 0;
//	        long MOD = (int) 1e9 + 7;
//	        for (int x : instructions) {
//	            cost += Math.min(query(0, x, tree, m), query(x + 1, m, tree, m));
//	            update(x, 1, tree, m);
//	        }
//	        return (int) (cost % MOD);
//	    }
//
//	    // implement Segment Tree
//	    private void update(int index, int value, int[] tree, int m) {
//	        index += m;
//	        tree[index] += value;
//	        for (index >>= 1; index > 0; index >>= 1)
//	            tree[index] = tree[index << 1] + tree[(index << 1) + 1];
//	    }
//
//	    private int query(int left, int right, int[] tree, int m) {
//	        int result = 0;
//	        for (left += m, right += m; left < right; left >>= 1, right >>= 1) {
//	            if ((left & 1) == 1)
//	                result += tree[left++];
//	            if ((right & 1) == 1)
//	                result += tree[--right];
//	        }
//	        return result;
//	    }
	/**
	 * Approach 01: Brute - just like Insertion Sort : TLE as expected
	 * O(N^2)/ O(1)
	 */
//	public int createSortedArray(int[] instructions) {
//		int result=0;
//        for(int i=1; i< instructions.length; i++) {
//        	int current=instructions[i], min=0, max=0;
////        	System.out.println(current);
//        	for(int j=0; j<i; j++) {
////        		System.out.println(instructions[j]);
//        		if(instructions[j] < current) min+=1;
//        		if(instructions[j] > current) max+=1;
//        	}
//        	result+=Math.min(min, max)%1000000007;
//        	result%=1000000007;
//        }
//        return result%1000000007;
//    }
	public static void main(String[] a) {
		SortedArrayThroughInstructions sati= new SortedArrayThroughInstructions();
		assertEquals(1,sati.createSortedArray(new int[] {1,5,6,2}));
		assertEquals(3,sati.createSortedArray(new int[] {1,2,3,6,5,4}));
		assertEquals(4,sati.createSortedArray(new int[] {1,3,3,3,2,4,2,1,2}));
	}
}
