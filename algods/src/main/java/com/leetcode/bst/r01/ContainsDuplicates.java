package com.leetcode.bst.r01;
/**
 * 220. Contains Duplicates III
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
	 * Approach 01: O(n logK) COPIED -> Understood.
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
		// probably good idea to have <Long> set instead of Integer to avoid overflow during floor/ ceiling
		TreeSet<Integer> set = new TreeSet<>();// keeping things sorted and using ceiling/ floor
		// Note: don't worry about duplicates. Duplicates will be <=t apart anyway

		int i = 0;
		while (i < nums.length) {// where does nums[i] fit? are the two nearest numbers within 't' range??
			Integer floor = set.floor(nums[i]);// previous number
			Integer ceiling = set.ceiling(nums[i]);// next number
			if ((floor != null && nums[i] - floor <= t ) || // NOTE: floor & ceiling are NOT '<= t' apart 
					(ceiling != null && ceiling - nums[i] <= t)) {// otherwise this would have returned true
				return true;// when the later of the two were inserted in the first place
			}
			set.add(nums[i++]);// no luck. add this number to the set
			if (i > k) {// we don't need to keep numbers more distant than k
				set.remove(nums[i - k - 1]);// prune the oldest one
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
