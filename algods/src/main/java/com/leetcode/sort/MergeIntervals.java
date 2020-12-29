package com.leetcode.sort;

import java.util.Arrays;

/**
 * 56. Merge Intervals
 * 
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 

Constraints:

intervals[i][0] <= intervals[i][1]
 */
import java.util.*;
public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if(intervals.length <=1) return intervals;
		List<int[]> result=new ArrayList<int[]>();
		Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
		int[] current=intervals[0];
		for(int i=1; i< intervals.length; i++) {
			int[] next=intervals[i];
			if(next[0] <= current[1]) current[1]=Math.max(current[1],next[1]);// WATCH OUT
			else {
				result.add(current);
				current=next;
			}
		}
		result.add(current);
		return result.toArray(new int[result.size()][]);
    }
	public static void main(String[] args) {
		MergeIntervals instance= new MergeIntervals();
		int[][] input01=new int[][] {{1,3},{2,6},{8,10},{15,18}};//[[1,6],[8,10],[15,18]]
		printOutput(instance.merge(input01));
		int[][] input02=new int[][] {{1,4},{4,5}};// [[1,5]]
		printOutput(instance.merge(input02));
		int[][] input03=new int[][] {{1,4},{2,3}};// [[1,4]]
		printOutput(instance.merge(input03));
	}
	private static void printOutput(int[][] result) {
		for(int i=0; i< result.length; i++) 
			System.out.print("["+result[i][0]+","+result[i][1]+"]");
		System.out.println();
	}
}
