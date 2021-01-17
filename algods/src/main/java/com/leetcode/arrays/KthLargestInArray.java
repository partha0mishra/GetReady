package com.leetcode.arrays;
/**
 * 215. Kth Largetst Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class KthLargestInArray {
	/**
	 * QuickSelect: Simpler Implementation
	 */
	public int findKthLargest(int[] nums, int k) {
        if(nums.length < 1 || k < 1 || k > nums.length) return -1;
        if(nums.length < 2) return nums[0];
        partition(nums,0,nums.length-1,nums.length-k);
        return nums[nums.length-k];
    }
    public void partition(int[] nums,int start,int end, int k){
        int left=start,right=end;
        int mid=(end+start)/2;
        int pivot=nums[mid];
        while(left<=right){
            while(left<=right && nums[left]<pivot) left++;
            while(left<=right && nums[right]>pivot) right--;
            if(left<=right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if(k>=left) partition(nums,left,end,k);
        if(k<=right) partition(nums,start,right,k);
    }
    
        public void swap(int[] nums, int a, int b) {
            if(a == b) return;
            nums[a] += nums[b];
            nums[b] = nums[a] - nums[b];
            nums[a] -= nums[b];
    }
	/**
	 * Approach 04: using QuickSelect O(N) avg, O(N2) worst. 
	 * Kth largest= size-k th (0-indexed) smallest 
	 */
//	int[] nums;
//	public int findKthLargest(int[] nums, int k) {
//		this.nums=nums;
//		return quickSelect(0, nums.length -1, nums.length -k);
//	}
//	private int quickSelect(int left, int right, int kSmallest) {
//		if(left == right) return nums[left];
//		Random random= new Random();
//		int pivotIndex=left+random.nextInt(right-left);
//		pivotIndex=partition(left, right, pivotIndex);
//		if(kSmallest == pivotIndex) return nums[pivotIndex];
//		else if(kSmallest < pivotIndex) return quickSelect(left, pivotIndex-1, kSmallest);
//		else return quickSelect(pivotIndex+1, right, kSmallest);
//	}
//	private int partition(int left, int right, int pivotIndex) {
//		int pivot=nums[pivotIndex];
//		swap(pivotIndex, right);
//		int storeIndex=left;
//		for(int i=left; i<=right; i++) {
//			if(nums[i] < pivot) {
//				swap(storeIndex, i);
//				storeIndex+=1;
//			}
//		}
//		swap(storeIndex, right);
//		return storeIndex;
//	}
//	private void swap(int a, int b) {
//		int t=nums[a]; nums[a]=nums[b]; nums[b]=t;
//	}
	/**
	 * Approach 03: same as earlier but using PriorityQueue instead of TreeSet
	 * It seems this time it's faster and consumes less memory
	 */
//	public int findKthLargest(int[] nums, int k) {
//		PriorityQueue<Integer> pq= new PriorityQueue<>();
//		for(int n: nums) {
//            pq.add(n);
//            if(pq.size() > k) pq.poll();
//        }
//		return pq.poll();
//    }
	/**
	 * Approach 02
	 * TreeSet as PQ, keep duplicates
	 * improving space to O(N logK) by pruning
	 */
//	public int findKthLargest(int[] nums, int k) {
//		TreeSet<Integer> pq= new TreeSet<>((i1,i2) -> {
//			int diff=Integer.compare(i1,i2);
//			return (diff == 0)? 1: diff;
//		});
//		for(int n: nums) {
//            pq.add(n);
//            if(pq.size() > k) pq.pollFirst();
//        }
//		return pq.pollFirst();
//    }
	/** Approach 01
	 * TreeSet as PQ, Sort Descending and allow duplicates
	 * insert O(N logN), delete O(1) for K elements
	 * space O(N logN)
	 */
//	public int findKthLargest(int[] nums, int k) {
//		TreeSet<Integer> pq= new TreeSet<>((i1,i2) -> {
//			int diff=Integer.compare(i2,i1);
//			return (diff == 0)? 1: diff;
//		});
//		for(int n: nums) pq.add(n);
//		for(int i=1; i< k; i++) System.out.println(pq.pollFirst());
//		return pq.pollFirst();
//    }
	public static void main(String[] args) {
		KthLargestInArray klia=new KthLargestInArray();
		assertEquals(5,klia.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
		assertEquals(4,klia.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
	}

}
