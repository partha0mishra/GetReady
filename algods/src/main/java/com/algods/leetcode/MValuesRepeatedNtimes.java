package com.algods.leetcode;

import java.util.Arrays;

public class MValuesRepeatedNtimes {
    public boolean containsPattern(int[] arr, int m, int k) {
    	if(m > arr.length) return false;
    	int[] pattern= new int[m];
    	int repeat;
        for(int i=0; i<= arr.length-m;i++) {
        	System.arraycopy(arr, i, pattern, 0, m);
//        	System.out.println("searching for pattern: "+Arrays.toString(pattern));
        	repeat=1;
        	for(int j=i+m;j<= arr.length-m; j+=m) {
        		if(found(arr, j, pattern)) {
        			repeat++;
        		}else {
        			break;
        		}
        		if(repeat == k) return true;
        	}
        }
        return false;
    }
    private boolean found(int[] arr, int j, int[] pattern) {
    	for(int i=0; i<pattern.length; i++) {
    		if(arr[j+i] != pattern[i]) return false;
    	}
    	return true;
    }
	public static void main(String[] args) {
		MValuesRepeatedNtimes instance= new MValuesRepeatedNtimes();
		System.out.println(instance.containsPattern(new int[] {1,2,4,4,4,4}, 1, 3));// true
		System.out.println(instance.containsPattern(new int[] {1,2,1,2,1,1,1,3}, 2, 2));// true
		System.out.println(instance.containsPattern(new int[] {1,2,1,2,1,3}, 2, 3));// false
		System.out.println(instance.containsPattern(new int[] {1,2,3,1,2}, 2, 2));// false
		System.out.println(instance.containsPattern(new int[] {2,2,2,2}, 2, 3));// false
		System.out.println(instance.containsPattern(new int[] {2,2}, 1, 2));// true
		System.out.println(instance.containsPattern(new int[] {2,2,1,2,2,1,1,1,2,1}, 2, 2));// false
//		System.out.println(instance.containsPattern(new int[] {1,2,1,2,1,1,1,3}, 1, 1));
//		System.out.println(instance.containsPattern(new int[] {1,2,1,2,1,1,1,3}, 2, 1));
		
//		System.out.println(instance.containsPattern(new int[] {1,2,1,2,1,1,1,3}, 2, 3));
//		System.out.println(instance.containsPattern(new int[] {1,2,1,2,1,1,1,3}, 3, 2));
	}

}
