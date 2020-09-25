package com.algods.leetcode.sort;

import java.util.Arrays;

/**
 * 75. Sort Colors
 * 
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color 
 * are adjacent, with the colors in the order red, white, and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Follow up:
 * Could you solve this problem without using the library's sort function?
 * Could you come up with a one-pass algorithm using only O(1) constant space?
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 * Input: nums = [1]
 * Output: [1]
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 */
public class SortColors {
	/* Approach 02: Dutch National Flag Problem 
	 * This is a dutch partitioning problem. We are classifying the array into four groups: red, white, unclassified, and blue. 
	 * Initially we group all elements into unclassified. 
	 * We iterate from the beginning as long as the white pointer is less than the blue pointer.
	 * If the white pointer is red (nums[white] == 0), we swap with the red pointer and move both white and red pointer forward. 
	 * If the pointer is white (nums[white] == 1), the element is already in correct place, so we don't have to swap, 
	 * just move the white pointer forward. If the white pointer is blue, we swap with the latest unclassified element.*/
//	public void sortColors(int[] nums) {
//		int red=0, white=0, blue=nums.length-1;
//		while(white<=blue) {
//			if(nums[white] == 0) {swap(nums,red,white); red++; white++;}
//			else if(nums[white] == 2) {swap(nums,blue,white); blue--;}
//			else white++;
//			printit(nums);
//		}
////		printit(nums);
//	}
	public void sortColors(int[] nums) {
		int left=0, right=nums.length-1;
		for(int i=0; i<= right;){
			int n=nums[i];
			if(n == 0) {
				swap(nums,i,left);
				left++;
                i++;
			}
			else if(n == 2) {
				swap(nums,i,right);
				right--;
			}else i++;
//			printit(nums);
		}
		printit(nums);
	}
	private void swap(int[] nums,int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	/* Approach 01: Brute - with Arrays.sort*/
//	public void sortColors(int[] nums) {
//        for(int i=1;i< nums.length; i++) {
//        	Arrays.sort(nums,0,i+1);
////        	printit(nums);
//        }
//    }
	private void printit(int[] nums) {
		for(int i=0; i< nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		SortColors instance= new SortColors();
		instance.sortColors(new int[] {2,0,2,1,1,0});
		instance.sortColors(new int[] {2,0,1});
		instance.sortColors(new int[] {1,0,2});
		instance.sortColors(new int[] {1,2,0});
		instance.sortColors(new int[] {0});
		instance.sortColors(new int[] {1});
	}

}
