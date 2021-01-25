package com.leetcode._explore;

/*
 * Largest Time for Given Digits
 * 
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""

Note:

A.length == 4
0 <= A[i] <= 9
 */
public class LargestTimeGivenDigits {
	/*
	 * Approach 02: Copied again - from the LC provided Solution
	 */
	private int max_time = -1;

    public String largestTimeFromDigits(int[] A) {
        this.max_time = -1;
        permutate(A, 0);
        if (this.max_time == -1)
            return "";
        else
            return String.format("%02d:%02d", max_time / 60, max_time % 60);
    }

    protected void permutate(int[] array, int start) {
        if (start == array.length) {
            this.build_time(array);
            return;
        }
        for (int i = start; i < array.length; ++i) {
            this.swap(array, i, start);
            this.permutate(array, start + 1);
            this.swap(array, i, start);
        }
    }

    protected void build_time(int[] perm) {
        int hour = perm[0] * 10 + perm[1];
        int minute = perm[2] * 10 + perm[3];
        if (hour < 24 && minute < 60)
            this.max_time = Math.max(this.max_time, hour * 60 + minute);
    }

    protected void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
	
	/* Approach 01: copied
	 * The inner most loop at most iterates 4 * 4 * 4 = 64 times.
	 * A[i], A[j], A[k], & A[l] are the 4 elements of A, where i, j, k & l are the permutation of 0, 1, 2, & 3. 
	 * Therefore, since i + j + k + l = 0 + 1 + 2 + 3 = 6, we have l = 6 - i - j - k.
	 */
//	public String largestTimeFromDigits(int[] A) {
//        String ans = "";
//        for (int i = 0; i < 4; ++i) {
//            for (int j = 0; j < 4; ++j) {
//                for (int k = 0; k < 4; ++k) {
//                    if (i == j || i == k || j == k) continue; // avoid duplicate among i, j & k.
//                    String h = "" + A[i] + A[j], m = "" + A[k] + A[6 - i - j - k], t = h + ":" + m; // hour, minutes, & time.
//                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && ans.compareTo(t) < 0) ans = t; // hour < 24; minute < 60; update result.
//                }
//            }
//        }
//        return ans;
//    }
	public static void main(String[] args) {
		LargestTimeGivenDigits instance=new LargestTimeGivenDigits();
		System.out.println(instance.largestTimeFromDigits(new int[] {1,2,3,4}));
		System.out.println(instance.largestTimeFromDigits(new int[] {5,5,5,5}));
		System.out.println(instance.largestTimeFromDigits(new int[] {1,2,0,0}));
		System.out.println(instance.largestTimeFromDigits(new int[] {0,0,0,0}));
		System.out.println(instance.largestTimeFromDigits(new int[] {0,1,0,1}));
		System.out.println(instance.largestTimeFromDigits(new int[] {1,0,1,0}));
		System.out.println(instance.largestTimeFromDigits(new int[] {9,0,7,7}));
		System.out.println(instance.largestTimeFromDigits(new int[] {2,0,6,6}));
	}

}
