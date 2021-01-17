package com.leetcode.binarySearch;
/**
 * 35 Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 */
import static org.junit.Assert.assertEquals;
/**
 * Very classic application of binary search. We are looking for the minimal k value satisfying nums[k] >= target, 
 * and we can just copy-paste our template. Notice that our solution is correct regardless of whether the input array nums 
 * has duplicates. Also notice that the input target might be larger than all elements in nums and therefore 
 * needs to placed at the end of the array. That's why we should initialize right = len(nums) instead of right = len(nums) - 1. 
 *
 */
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		if(target > nums[nums.length-1]) return nums.length;// bigger than the biggest one
        int left=0, right=nums.length-1;// the target could be bigger than the biggest element
        while(left < right) {
        	int mid=left + (right-left)/2;
        	if(nums[mid] >= target) right=mid;// = when there ARE duplicates and we need to add it in the FIRST available slot
        	else left=mid+1;
        }
        return left;
    }
//	public int searchInsert(int[] nums, int target) {
//        int left=0, right=nums.length;// the target could be bigger than the biggest element
//        while(left < right) {
//        	int mid=left + (right-left)/2;
//        	if(nums[mid] >= target) right=mid;
//        	else left=mid+1;
//        }
//        return left;
//    }
	public static void main(String[] args) {
		SearchInsertPosition instance = new SearchInsertPosition();
		assertEquals(2,instance.searchInsert(new int[]{1,3,5,6},5));
		assertEquals(1,instance.searchInsert(new int[]{1,3,5,6},2));
		assertEquals(4,instance.searchInsert(new int[]{1,3,5,6},7));
		assertEquals(0,instance.searchInsert(new int[]{1,3,5,6},0));
	}

}
