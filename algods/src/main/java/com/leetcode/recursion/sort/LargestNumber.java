package com.leetcode.recursion.sort;

import java.util.Arrays;

/**
 * 179. Largest Number
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
        String[] s=new String[nums.length];
        for(int i=0; i< nums.length; i++) {
        	s[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(s,(a,b) -> customSort(a,b));
        System.out.println(Arrays.asList(s));
        StringBuilder result= new StringBuilder();
        for(String e: s) {
        	result.append(e);
        }
        String tempResult=result.toString();
        int i=0;
        for(i=0; i< tempResult.length(); i++) {
        	if(tempResult.charAt(i) != '0') break;
        }
        if(i == tempResult.length()) i--;
        return result.substring(i);
    }
	private int customSort(String a, String b) {
		Long ab=Long.parseLong(a.concat(b));
		Long ba=Long.parseLong(b.concat(a));
		if(ab < ba) return 1;
		else if(ab > ba) return -1;
		
		return 0;
	}



	public static void main(String[] args) {
		LargestNumber instance= new LargestNumber();
		System.out.println(instance.largestNumber(new int[] {10,2}));
		System.out.println(instance.largestNumber(new int[] {3,30,34,5,9}));
		System.out.println(instance.largestNumber(new int[] {999999998,999999997,999999999}));
		System.out.println(instance.largestNumber(new int[] {0,0}));
	}

}
