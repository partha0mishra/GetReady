package com.leetcode.recursion.geometry;
/* 874. Walking Robot Simulation
 * 
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:

-2: turn left 90 degrees
-1: turn right 90 degrees
1 <= x <= 9: move forward x units
Some of the grid squares are obstacles. 

The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])

If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)

Return the square of the maximum Euclidean distance that the robot will be from the origin.

 

Example 1:

Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: robot will go to (3, 4)
Example 2:

Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 

Note:

0 <= commands.length <= 10000
0 <= obstacles.length <= 10000
-30000 <= obstacle[i][0] <= 30000
-30000 <= obstacle[i][1] <= 30000
The answer is guaranteed to be less than 2 ^ 31.
 * */
import java.util.*;
public class WalkingRobotSimulation {
	public static final String SPACE=" ";
	public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set= new HashSet<String>();
        for(int[] o: obstacles) {
        	set.add(o[0]+SPACE+o[1]);
        }
        int[][] directions=new int[][] {{0,1},{1,0},{0,-1},{-1,0}};// clockwise from North
        int d=0, x=0, y=0, result=0;
        for(int c: commands) {
        	if(c == -1) {// clockwise
        		d++;
        		if(d == 4) d=0;
        	}else if(c ==-2) {// counter-clockwise
        		d--;
        		if(d == -1) d=3;
        	}else {
        		while(c-- > 0 && !set.contains((x+directions[d][0])+SPACE+(y+directions[d][1]))) {
        			x+=directions[d][0];
        			y+=directions[d][1];
        		}
        		result=Math.max(result, x*x+y*y);
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		System.out.println(new WalkingRobotSimulation().robotSim(new int[] {4,-1,3}, new int[][] {{}}));
		System.out.println(new WalkingRobotSimulation().robotSim(new int[] {4,-1,4,-2,4}, new int[][] {{2,4}}));
	}
}
