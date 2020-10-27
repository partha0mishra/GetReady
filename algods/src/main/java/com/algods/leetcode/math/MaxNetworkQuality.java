package com.algods.leetcode.math;
/* 5528. Coordinate With Maximum Network Quality
 * You are given an array of network towers towers and an integer radius, where towers[i] = [xi, yi, qi] denotes the ith network tower with location (xi, yi) and quality factor qi. All the coordinates are integral coordinates on the X-Y plane, and the distance between two coordinates is the Euclidean distance.

The integer radius denotes the maximum distance in which the tower is reachable. The tower is reachable if the distance is less than or equal to radius. Outside that distance, the signal becomes garbled, and the tower is not reachable.

The signal quality of the ith tower at a coordinate (x, y) is calculated with the formula ⌊qi / (1 + d)⌋, where d is the distance between the tower and the coordinate. The network quality at a coordinate is the sum of the signal qualities from all the reachable towers.

Return the integral coordinate where the network quality is maximum. If there are multiple coordinates with the same network quality, return the lexicographically minimum coordinate.

Note:

A coordinate (x1, y1) is lexicographically smaller than (x2, y2) if either x1 < x2 or x1 == x2 and y1 < y2.
⌊val⌋ is the greatest integer less than or equal to val (the floor function).
 

Example 1:


Input: towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
Output: [2,1]
Explanation: 
At coordinate (2, 1) the total quality is 13
- Quality of 7 from (2, 1) results in ⌊7 / (1 + sqrt(0)⌋ = ⌊7⌋ = 7
- Quality of 5 from (1, 2) results in ⌊5 / (1 + sqrt(2)⌋ = ⌊2.07⌋ = 2
- Quality of 9 from (3, 1) results in ⌊9 / (1 + sqrt(1)⌋ = ⌊4.5⌋ = 4
No other coordinate has higher quality.
Example 2:

Input: towers = [[23,11,21]], radius = 9
Output: [23,11]
Example 3:

Input: towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2
Output: [1,2]
Example 4:

Input: towers = [[2,1,9],[0,1,9]], radius = 2
Output: [0,1]
Explanation: Both (0, 1) and (2, 1) are optimal in terms of quality but (0, 1) is lexicograpically minimal.
 

Constraints:

1 <= towers.length <= 50
towers[i].length == 3
0 <= xi, yi, qi <= 50
1 <= radius <= 50
 */
import java.util.*;
public class MaxNetworkQuality {
	public int[] bestCoordinate(int[][] towers, int radius) {
		int numTowers=towers.length;
		int minx=Integer.MAX_VALUE, maxx=Integer.MIN_VALUE, miny=Integer.MAX_VALUE, maxy=Integer.MIN_VALUE;
		for(int[] t: towers) {
			minx=Math.min(minx, t[0]);
			maxx=Math.max(maxx, t[0]);
			miny=Math.min(miny, t[1]);
			maxy=Math.max(maxy, t[1]);
		}
		int[] coordinates=new int[]{-1,-1};
		int maxSignal=Integer.MIN_VALUE;
        for(int x=0; x<=50; x++)
        	for(int y=0; y<=50; y++) {
        		int signal=0;
        		for(int i=0; i< numTowers; i++) {
        			double distance=Math.sqrt(
							(towers[i][0]-x)*(towers[i][0]-x)
							+(towers[i][1]-y)*(towers[i][1]-y)
							);
        			if(distance <=radius) {
        			signal+=(int)Math.floor(towers[i][2]/(1+Math.sqrt(
							(towers[i][0]-x)*(towers[i][0]-x)
							+(towers[i][1]-y)*(towers[i][1]-y)
							)));
        			}
        		}
        		
        		if(signal > maxSignal) {
        			coordinates[0]=x; coordinates[1]=y;
        			maxSignal=signal;
                    System.out.println(x+" "+y+" "+signal);
        		}else if(signal == maxSignal) {
        			if(x <coordinates[0] || (x == coordinates[0] && y< coordinates[1])) {
        				coordinates[0]=x; coordinates[1]=y;
        			}
                    System.out.println(x+" "+y+" "+signal);
        		}
        	}
       return coordinates;
    }
	public static void main(String[] args) {
		MaxNetworkQuality instance= new MaxNetworkQuality();
//		instance.bestCoordinate(new int[][] {{32,36,27},{17,22,43},{8,11,41},{46,28,7},{22,4,35},{41,8,33},
//			{32,29,4},{44,32,16},{33,20,16},{3,38,35},{17,47,23},{33,0,29},{29,19,6},{4,50,46},
//			{19,47,6},{48,6,41},{20,26,35}}, 4);
		
		instance.bestCoordinate(new int[][] {{3,23,47},{32,31,47},{5,2,34},{10,47,0},{4,10,41},{3,36,42}
		,{0,24,29},{47,28,35},{20,15,42},{32,32,50},{28,13,5},{24,42,21},{42,4,7},{37,3,47},{33,36,43}
		,{43,14,44},{34,23,23},{43,42,39},{25,48,47}},8);
	}
}
