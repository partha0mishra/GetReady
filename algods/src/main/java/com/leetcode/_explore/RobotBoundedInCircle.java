package com.leetcode._explore;
/**
 * Robot Bounded in Circle
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degress to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 * Example 1:
 * Input: "GGLLGG"
 * Output: true
 * Explanation: 
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 * Example 2:
 * Input: "GG"
 * Output: false
 * Explanation: 
 * The robot moves north indefinitely.
 * Example 3:
 * Input: "GL"
 * Output: true
 * Explanation: 
 * The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 * Note:
 * 1 <= instructions.length <= 100
 * instructions[i] is in {'G', 'L', 'R'}
 * 
 * HINT 01: Calculate the final vector of how the robot travels after executing all instructions once 
 * - it consists of a change in position plus a change in direction.
 * 
 * HINT 02: The robot stays in the circle iff (looking at the final vector) 
 * it changes direction (ie. doesn't stay pointing north), or it moves 0.
 */
import static org.junit.Assert.assertTrue;
public class RobotBoundedInCircle {
	/* Copied approach : calculation centric*/
	/**
	public boolean isRobotBounded(String ins) {
        int x = 0, y = 0, i = 0, d[][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        for (int j = 0; j < ins.length(); ++j)
            if (ins.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (ins.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += d[i][0]; y += d[i][1];
            }
        return x == 0 && y == 0 || i > 0;
    }
	*/
	static enum Direction{NORTH, SOUTH, EAST, WEST}
	private int x=0, y=0;
	private Direction dir=Direction.NORTH;
	public boolean isRobotBounded(String instructions) {
		if(instructions.length() ==0) return true;
		for(int i=0; i< instructions.length(); i++) {
			char c=instructions.charAt(i);
			if(c =='G') go();
			else turn(c);
		}
		double distance=Math.sqrt(x*x + y*y);
//		System.out.println("distance: "+distance+" direction: "+dir.toString());
		if(distance == 0 || dir!=Direction.NORTH) return true;
		return false;
    }
	private void go() {
		switch(dir) {
		case NORTH: y+=1; break;
		case SOUTH: y-=1; break;
		case EAST:  x-=1; break;
		case WEST:  x+=1; break;
		}
	}
	private void turn(char c) {
		switch(c) {
		case 'L': turnLeft(); break;
		case 'R': turnRight(); break;
		}
	}
	private void turnLeft() {
		switch(dir) {
		case NORTH: dir=Direction.WEST; break;
		case SOUTH: dir=Direction.EAST; break;
		case EAST:  dir=Direction.NORTH; break;
		case WEST:  dir=Direction.SOUTH; break;
		}
	}
	private void turnRight() {
		switch(dir) {
		case NORTH: dir=Direction.EAST; break;
		case SOUTH: dir=Direction.WEST; break;
		case EAST:  dir=Direction.SOUTH; break;
		case WEST:  dir=Direction.NORTH; break;
		}
	}
	public static void main(String[] args) {
		RobotBoundedInCircle instance= new RobotBoundedInCircle();
		assertTrue(instance.isRobotBounded("GGLLGG"));
		assertTrue(instance.isRobotBounded("GG"));
		assertTrue(instance.isRobotBounded("GL"));
	}

}
