package com.algods.leetcode;
/**
 * Contains Duplicates III
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the absolute difference between nums[i] and nums[j] is at most t 
 * and the absolute difference between i and j is at most k.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * 
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * 
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
import java.util.*;
public class ContainsDuplicates {
	/**
	 * Approach 01: O(n logK) COPIED
	 * https://leetcode.com/problems/contains-duplicate-iii/discuss/61655/Java-O(N-lg-K)-solution
	 * 
	 * This problem requires to maintain a window of size k of the previous values that can be queried for value ranges. 
	 * The best data structure to do that is Binary Search Tree. As a result maintaining the tree of size k will result in time 
	 * complexity O(N lg K). In order to check if there exists any value of range abs(nums[i] - nums[j]) to simple queries 
	 * can be executed both of time complexity O(lg K). Here is the whole solution using TreeMap.
	 * 
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length < 2 || k == 0) {
			return false;
		}
		TreeSet<Long> set = new TreeSet<>();

		int i = 0;
		while (i < nums.length) {
			Long floor = set.floor((long) nums[i]);
			Long ceiling = set.ceiling((long) nums[i]);
			if ((floor != null && nums[i] - floor <= t ) ||
					(ceiling != null && ceiling - nums[i] <= t)) {
				return true;
			}
			set.add((long) nums[i++]);
			if (i > k) {
				set.remove((long) nums[i - k - 1]);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		ContainsDuplicates instance = new ContainsDuplicates();
		System.out.println(instance.containsNearbyAlmostDuplicate(new int[] {1,2,3,1}, 3,0));// true
		System.out.println(instance.containsNearbyAlmostDuplicate(new int[] {1,0,1,1}, 1,2));// true
		System.out.println(instance.containsNearbyAlmostDuplicate(new int[] {1,5,9,1,5,9}, 2,3));// false
		System.out.println(instance.containsNearbyAlmostDuplicate(new int[] {-1,2147483647},1,2147483647));// false
		System.out.println(instance.containsNearbyAlmostDuplicate(new int[] {2147483647,-2147483645},1,5));// false
		System.out.println(instance.containsNearbyAlmostDuplicate(new int[] {-2147483648,-2147483647},3,3)); // true
	}
}
