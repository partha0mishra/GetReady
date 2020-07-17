package com.algods.leetcode;
import java.util.Arrays;
/*
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
//		System.out.println(Arrays.toString(nums)+" "+k);
		int size=nums.length;
		Map<Integer,Integer> hmNumFrequency= new HashMap<Integer, Integer>();
		int[] result;
		
		// Populate HashMap
		for(int i=0; i<size; i++) {
				hmNumFrequency.put(nums[i], hmNumFrequency.getOrDefault(nums[i], 0)+1);
		}
		// Populate MaxHeap with Values
		PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(
				(a,b) -> a.getValue().equals(b.getValue()) ? 
						Integer.compare(b.getKey(), a.getKey()): Integer.compare(b.getValue(), a.getValue())
						);
		for(Map.Entry<Integer, Integer> e: hmNumFrequency.entrySet())
			pq.offer(e);
		// where K > distinct nums
		int resultSize=Math.min(k, pq.size());
		result= new int[resultSize];
		
		for(int i=0; i<resultSize; i++) {
			result[i]=pq.poll().getKey();
		}
		
        return result;
    }
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int k=2;
		System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(nums, k)));// [1,2]

		int [] nums1= {1};
		int k1=1;
		System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(nums1, k1)));// [1]
	}
}
