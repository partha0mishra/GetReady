package com.algods.leetcode.sort;

import java.util.Arrays;

/**
 * Insert Interval
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
import java.util.*;
public class InsertMergeInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] allIntervals=new int[intervals.length+1][];
        int i=0;
        for(; i<intervals.length; i++) allIntervals[i]=intervals[i];
        allIntervals[i]=newInterval;
        if(allIntervals.length ==1) return allIntervals;
        List<int[]> result= new ArrayList<int[]>();
        Arrays.sort(allIntervals,(i1, i2) -> i1[0]-i2[0]);
        int[] current=allIntervals[0];
        i=1;
        for(;i<allIntervals.length; i++) {
        	if(current[1] < allIntervals[i][0]) {
        		result.add(current);
        		current=allIntervals[i];
        	}else {
        		current[1]=Math.max(current[1],allIntervals[i][1]);
        	}
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
	public static void main(String[] args) {
		InsertMergeInterval instance= new InsertMergeInterval();
		int[][] input01=new int[][] {{1,3},{6,9}};
		int[] add01=new int[] {2,5};
		printOutput(instance.insert(input01, add01));
		int[][] input02=new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] add02=new int[] {4,8};
		printOutput(instance.insert(input02, add02));
	}
	private static void printOutput(int[][] result) {
		for(int i=0; i< result.length; i++) 
			System.out.print("["+result[i][0]+","+result[i][1]+"]");
		System.out.println();
	}
}
