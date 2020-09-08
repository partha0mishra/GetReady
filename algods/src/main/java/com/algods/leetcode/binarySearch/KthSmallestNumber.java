package com.algods.leetcode.binarySearch;
/*
 * 668. Kth Smallest Number in Multiplication Table - HARD
 * 
 * Nearly every one have used the Multiplication Table. 
 * But could you find out the k-th smallest number quickly from the multiplication table?
 * Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, 
 * you need to return the k-th smallest number in this table.
 * Example 1:
 * Input: m = 3, n = 3, k = 5
 * Output: 3
 * Explanation: 
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 * 
 * Example 2:
 * Input: m = 2, n = 3, k = 6
 * Output: 6
 * Explanation: 
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 * The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
 * Note:
 * The m and n will be in the range [1, 30000].
 * The k will be in the range [1, m * n]
 */
import static org.junit.Assert.assertEquals;
/**
 * For Kth-Smallest problems like this, what comes to our mind first is Heap. Usually we can maintain a Min-Heap and 
 * just pop the top of the Heap for k times. However, that doesn't work out in this problem. We don't have every single number 
 * in the entire Multiplication Table, instead, we only have the height and the length of the table. 
 * If we are to apply Heap method, we need to explicitly calculate these m * n values and save them to a heap. 
 * The time complexity and space complexity of this process are both O(mn), which is quite inefficient. 
 * This is when binary search comes in. Remember we say that designing condition function is the most difficult part? 
 * In order to find the k-th smallest value in the table, we can design an enough function, given an input num, 
 * determine whether there're at least k values less than or equal to num. 
 * The minimal num satisfying enough function is the answer we're looking for. 
 * Recall that the key to binary search is discovering monotonicity. In this problem, if num satisfies enough, 
 * then of course any value larger than num can satisfy. This monotonicity is the fundament of our binary search algorithm.
 * Let's consider search space. Obviously the lower bound should be 1, and the upper bound should be the largest value in 
 * the Multiplication Table, which is m * n, then we have search space [1, m * n]. The overwhelming advantage of binary search 
 * solution to heap solution is that it doesn't need to explicitly calculate all numbers in that table, all it needs is just 
 * picking up one value out of the search space and apply enough function to this value, to determine should we keep the left 
 * half or the right half of the search space. In this way, binary search solution only requires constant space complexity, 
 * much better than heap solution.
 * Next let's consider how to implement enough function. 
 * It can be observed that every row in the Multiplication Table is just multiples of its index. 
 * For example, all numbers in 3rd row [3,6,9,12,15...] are multiples of 3. 
 * Therefore, we can just go row by row to count the total number of entries less than or equal to input num. 
 *
 */
public class KthSmallestNumber {
	public int findKthNumber(int m, int n, int k) {
        int left=1, right=m*n;
        while(left < right) {
        	int mid=left+(right-left)/2;
        	if(isFeasible(m,n,k,mid)) right=mid;
        	else left=mid+1;
        }
        return left;
    }
	
	private boolean isFeasible(int m, int n, int k, int mid) {
		int count=0;
		for(int i=1; i<=m; i++) {// this is from 1 to m indeed
			int add=Math.min(mid/i, n);// how many numbers are less than 'mid' in a row?
			if(add ==0) break; // no more new smaller numbers can be found. let's get out. Early exit.
			count+= add;
			if(count>=k) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		KthSmallestNumber instance= new KthSmallestNumber();
		assertEquals(3,instance.findKthNumber(3, 3, 5));
		assertEquals(6,instance.findKthNumber(2, 3, 6));
		assertEquals(3597,instance.findKthNumber(30000, 30000, 29999));
	}

}
