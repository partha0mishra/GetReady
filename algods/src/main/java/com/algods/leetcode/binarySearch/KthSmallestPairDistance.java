package com.algods.leetcode.binarySearch;
/**
 * 719. Find K-th Smallest Pair Distance - HARD
 * 
 * Given an integer array, return the k-th smallest distance among all the pairs. 
 * The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0 
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
public class KthSmallestPairDistance {
	/**
	 * Very similar to LC 668 above, both are about finding Kth-Smallest. 
	 * Just like LC 668, We can design an enough function, given an input distance, determine whether there're at least k pairs 
	 * whose distances are less than or equal to distance. We can sort the input array and use two pointers 
	 * (fast pointer and slow pointer, pointed at a pair) to scan it. Both pointers go from leftmost end. 
	 * If the current pair pointed at has a distance less than or equal to distance, all pairs between these pointers are valid 
	 * (since the array is already sorted), we move forward the fast pointer. Otherwise, we move forward the slow pointer. 
	 * By the time both pointers reach the rightmost end, we finish our scan and see if total counts exceed k. 
	 * Here is the implementation:
	 */
	public int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		int left=0,right=nums[nums.length -1]-nums[0];
		while(left<right) {
			int mid=left+(right-left)/2;
			if(isFeasible(nums, k, mid)) right=mid;
			else left=mid+1;
		}
		return left;
    }
	private boolean isFeasible(int[] nums, int k, int distance) {
		int count=0;
		for(int i=0, j=0; i< nums.length; i++) {// NO NEED for "|| j< nums.length"
			// IMPORTANT: Don't break the loop when J reaches end. 
			// It's possible that the distance qualifies for the next value of i 
			while(j< nums.length && (nums[j] -nums[i]) <=distance) j++;
			count+=j-i-1;
//			System.out.println(" d: "+distance+" count: "+count);
			if(count >=k) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		KthSmallestPairDistance instance= new KthSmallestPairDistance();
		assertEquals(0,instance.smallestDistancePair(new int[] {1,3,1}, 1));
		assertEquals(5,instance.smallestDistancePair(new int[] {1,6,1}, 3));
		assertEquals(2,instance.smallestDistancePair(new int[] {9,10,7,10,6,1,5,4,9,8}, 18));
	}

}
