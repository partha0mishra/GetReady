package com.leetcode;

import java.util.Arrays;

public class MakeArraySumDivisibleByP {
	public int minSubarray(int[] nums, int p) {
//		System.out.println("arraySum "+Arrays.stream(nums).sum());
		long sum=0;
		for(int n: nums) {
			sum+=n;
		}
//		System.out.println("sum: "+sum);
		if(sum < p) return -1;
		int mod=(int)(sum% (long)p);
		if(mod ==0) return 0;
		int left=1, right=nums.length;
		while(left < right) {
			int mid=left + (right-left)/2;
			if(isEnough(mid, nums, p, sum)) right=mid;
			else left=mid+1;
		}
//		System.out.println(" sum: "+sum+" mod:"+mod+" left:"+left);
		
		return (left < nums.length) ? left: -1;
    }
	private boolean isEnough(int n, int[] nums, int p, long sum) {
		for(int i=0; i<= nums.length-n; i++) {
			long total=0;
			for(int j=0; j< n; j++) {
				total+=nums[i+j];
				if(total > sum) break;
				if((sum-total)%p ==0) return true;
			}
//			System.out.println("n: "+n+" total: "+total+" sum: "+sum);
			System.out.println(n+" - "+total+" s-t "+(sum-total)+" mod "+(sum-total)%p);
		}
		return false;
	}
	public static void main(String[] args) {
		MakeArraySumDivisibleByP instance = new MakeArraySumDivisibleByP();
//		System.out.println(instance.minSubarray(new int[] {3,1,4,2}, 6));//1
//		System.out.println(instance.minSubarray(new int[] {6,3,5,2}, 9));//2
//		System.out.println(instance.minSubarray(new int[] {1,2,3}, 3));//0
//		System.out.println(instance.minSubarray(new int[] {1,2,3}, 7));// -1
//		System.out.println(instance.minSubarray(new int[] {1000000000,1000000000,1000000000}, 3));//0
//		System.out.println(instance.minSubarray(new int[] {4,4,2}, 7));//-1
//		System.out.println(instance.minSubarray(new int[] {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3}, 26));//3
//		System.out.println(instance.minSubarray(new int[] {8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2},148));//7
//		System.out.println(instance.minSubarray(new int[] {19,25,39,31,20,10,40,38,28,35,11,11,18,26,26,24,29,14,10,37},23));//1
		System.out.println(instance.minSubarray(new int[] {30,13,2,33,32,3,19,30,33,18,19,12,13,25,8,23,16},292));//2
	}

}
