package com.algods.leetcode;
/**
 * Given a collection of intervals, 
 * find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * 
 * Example 1
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * 
 * Example 2
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * 
 * Example 3
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * 
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */
import java.util.*;
public class NonOverlappingInterval {
	/* Approach 02: Explained https://leetcode.com/problems/non-overlapping-intervals/discuss/792771/Algorithm-Explained-or-Example-Dry-Run-or-Easy-to-Understand*/
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int minErase = 0;
        int prevEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (prevEnd > interval[0]) minErase++;
            else prevEnd = interval[1];
        }

        return minErase;
    }
	
	
	/* Approach 01: copied and then understood*/
//	public int eraseOverlapIntervals(int[][] intervals) {
//        if (intervals.length == 0)  return 0;
//
//        Arrays.sort(intervals, new MyComparator());
//        int end = intervals[0][1];
//        int count = 1;        
//
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i][0] >= end) {
//                end = intervals[i][1];
//                count++;
//            }
//        }
//        return intervals.length - count;
//    }
//    
//    class MyComparator implements Comparator<int[]> {
//        public int compare(int[] a, int[] b) {
//            return a[1] - b[1];
//        }
//    }
    public static void main(String[] args) {
    	int[][] input01= {{1,2},{2,3},{3,4},{1,3}};
    	int[][] input02= {{1,2},{1,2},{1,2}};
    	int[][] input03= {{1,2},{2,3}};
    	NonOverlappingInterval instance = new NonOverlappingInterval();
    	System.out.println(instance.eraseOverlapIntervals(input01));
    	System.out.println(instance.eraseOverlapIntervals(input02));
    	System.out.println(instance.eraseOverlapIntervals(input03));
    }
}
