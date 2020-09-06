package com.algods.leetcode;

import java.util.*;
public class NumWaysSquareProductNums {
    public int numTriplets(int[] nums1, int[] nums2) {
    	int result=0;
    	if(nums1.length ==1 || nums2.length ==1) return 0;
        HashMap<Long,Integer> num1Square= new HashMap<Long, Integer>();
        HashMap<Long, Integer> num2Square= new HashMap<Long, Integer>();
        for(int i=0; i<nums1.length; i++) {
        	long val=(long) (nums1[i]*nums1[i]);
        	num1Square.put(val, num1Square.getOrDefault(val, 0)+1);
        }
        for(int i=0; i<nums2.length; i++) {
        	long val=(long) (nums2[i]*nums2[i]);
        	num2Square.put(val, num2Square.getOrDefault(val, 0)+1);
        }
        for(int i=0; i<nums1.length-1; i++) {
        	for(int j=i+1; j<nums1.length; j++) {
        		long val=(long)(nums1[i]*nums1[j]);
        		if(num2Square.containsKey(val)) result+=num2Square.get(val);
        	}
        }
        for(int i=0; i<nums2.length-1; i++) {
        	for(int j=i+1; j<nums2.length; j++) {
        		long val=(long)(nums2[i]*nums2[j]);
        		if(num1Square.containsKey(val)) result+=num1Square.get(val);
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		NumWaysSquareProductNums instance= new NumWaysSquareProductNums();
		System.out.println(instance.numTriplets(new int []{1}, new int[] {2}));
		System.out.println(instance.numTriplets(new int []{1,2}, new int[] {2}));
		System.out.println(instance.numTriplets(new int []{1}, new int[] {1,2}));
		System.out.println(instance.numTriplets(new int []{7,4}, new int[] {5,2,8,9}));
		System.out.println(instance.numTriplets(new int []{1,1}, new int[] {1,1,1}));
		System.out.println(instance.numTriplets(new int []{7,7,8,3}, new int[] {1,2,9,7}));
		System.out.println(instance.numTriplets(new int []{4,7,9,11,23}, new int[] {3,5,1024,12,18}));
	}

}
