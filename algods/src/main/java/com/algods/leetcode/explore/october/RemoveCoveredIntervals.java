package com.algods.leetcode.explore.october;

import java.util.Arrays;

/* 1288 Remove Covered Intervals
 * Given a list of intervals, remove all intervals that are covered by another interval in the list.

Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.

After doing so, return the number of remaining intervals.

 

Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
Example 2:

Input: intervals = [[1,4],[2,3]]
Output: 1
Example 3:

Input: intervals = [[0,10],[5,12]]
Output: 2
Example 4:

Input: intervals = [[3,10],[4,10],[5,11]]
Output: 2
Example 5:

Input: intervals = [[1,2],[1,4],[3,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= intervals[i][0] < intervals[i][1] <= 10^5
All the intervals are unique.
 * */
public class RemoveCoveredIntervals {
	public int removeCoveredIntervals(int[][] intervals) {
        if(intervals.length < 2) return intervals.length;
        int result=1;// Starts from 1- IMPORTANT. The last interval of comparison doesn't get added
        Arrays.sort(intervals, (i1,i2) -> getDiff(i1,i2));
        int[] current=intervals[0];
        for(int i=1; i< intervals.length;i++) {
        	int[] next=intervals[i];
            // System.out.println(current[0]+" "+current[1]+" - "+next[0]+" "+next[1]);
        	if(current[0] <= next[0] && current[1] >= next[1]) {}
        	else {
                result+=1;
        	    current=next;
            }
        }
        return result;
    }

	private int getDiff(int[] i1, int[] i2) {
		int diff=i1[0]-i2[0];
		if(diff == 0) {
			diff=i2[1]-i1[1];
		}
		return diff;
	}
}
