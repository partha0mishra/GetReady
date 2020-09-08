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
		for(int i=1; i<=m; i++) {
			int add=Math.min(mid/i, n);
			if(add ==0) break;
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
