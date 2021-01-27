package com.leetcode._explore;
/*
 * Detect Pattern of Length M Repeated K or More Times
 * Given an array of positive integers arr,  find a pattern of length m that is repeated k or more times.

A pattern is a subarray (consecutive sub-sequence) that consists of one or more values, repeated multiple times consecutively without overlapping. A pattern is defined by its length and the number of repetitions.

Return true if there exists a pattern of length m that is repeated k or more times, otherwise return false.

 

Example 1:

Input: arr = [1,2,4,4,4,4], m = 1, k = 3
Output: true
Explanation: The pattern (4) of length 1 is repeated 4 consecutive times. Notice that pattern can be repeated k or more times but not less.
Example 2:

Input: arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
Output: true
Explanation: The pattern (1,2) of length 2 is repeated 2 consecutive times. Another valid pattern (2,1) is also repeated 2 times.
Example 3:

Input: arr = [1,2,1,2,1,3], m = 2, k = 3
Output: false
Explanation: The pattern (1,2) is of length 2 but is repeated only 2 times. There is no pattern of length 2 that is repeated 3 or more times.
Example 4:

Input: arr = [1,2,3,1,2], m = 2, k = 2
Output: false
Explanation: Notice that the pattern (1,2) exists twice but not consecutively, so it doesn't count.
Example 5:

Input: arr = [2,2,2,2], m = 2, k = 3
Output: false
Explanation: The only pattern of length 2 is (2,2) however it's repeated only twice. Notice that we do not count overlapping repetitions.
 

Constraints:

2 <= arr.length <= 100
1 <= arr[i] <= 100
1 <= m <= 100
2 <= k <= 100
 */

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
