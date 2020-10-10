package com.algods.leetcode.interval;

import java.util.Arrays;

/* Minimum Number of Arrows to Burst Balloons
 * There are some spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and end of the diameter suffice. The start is always smaller than the end.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps traveling up infinitely.

Given an array points where points[i] = [xstart, xend], return the minimum number of arrows that must be shot to burst all balloons.

 

Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
Example 2:

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2
Example 4:

Input: points = [[1,2]]
Output: 1
Example 5:

Input: points = [[2,3],[2,3]]
Output: 1
 

Constraints:

0 <= points.length <= 104
points.length == 2
-231 <= xstart < xend <= 231 - 1
 */
public class MinArrowsBurseBaloons {
	public int findMinArrowShots(int[][] points) {
		if(points.length < 2) return points.length;// 0 or 1
		int result=1;// for the last one standing
		// USE INTEGER.COMPARE. Arrays.sort() doesn't work well with Integer.MIN_VALUE/ MAX_VALUE
		// Comparator.comparingInt(int i1, int i2) is also a good idea
		// in fact, you can do Comparator.comparingInt(int i1, int i2).reversed() - Awesome!!
		Arrays.sort(points, (p1, p2) -> Integer.compare(Integer.valueOf(p1[0]), Integer.valueOf(p2[0])));
		int[] current=points[0];// current intercept
		for(int i=1; i< points.length; i++) {
			int[] next=points[i];
			if(next[0] <= current[1]) {
				current[0]=Math.max(current[0], next[0]);// Start from the later start
				current[1]=Math.min(current[1], next[1]);// end at the earlier end
			}else {
				result+=1;
				current=next;
			}
		}
		return result;
    }
	public static void main(String[] args) {
		MinArrowsBurseBaloons instance= new MinArrowsBurseBaloons();
		System.out.println(instance.findMinArrowShots(new int[][] {{-2147483646,-2147483645},{2147483646,2147483647}}));
	}
}
