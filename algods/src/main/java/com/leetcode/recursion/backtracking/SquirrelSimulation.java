package com.leetcode.recursion.backtracking;
/**
 * Squirrel Simulation
 * 
 * There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one. The squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.
Example 1:

Input: 
Height : 5
Width : 7
Tree position : [2,2]
Squirrel : [4,4]
Nuts : [[3,0], [2,5]]
Output: 12
Explanation:
​​​​​
Note:

All given positions won't overlap.
The squirrel can take at most one nut at one time.
The given positions of nuts have no order.
Height and width are positive integers. 3 <= height * width <= 10,000.
The given positions contain at least one nut, only one tree and one squirrel.
* Hints:
* - 
 */
public class SquirrelSimulation {
	/**
	 * Approach 01:
	 * Doesn't even need backtracking.
	 * For the first nut, it's distance from squirrel + distance from tree
	 * All other nuts, it's 2*distance from tree
	 */
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
		int[] firstDist=new int[nuts.length], restDist=new int[nuts.length];
		long totalDist=0;
		for(int i=0; i<nuts.length; i++) {
			int[] nut=nuts[i];
			int nutDistFromSquirrel=Math.abs(nut[0]-squirrel[0])+Math.abs(nut[1]-squirrel[1]);
			int nutDistFromTree=Math.abs(nut[0]-tree[0])+Math.abs(nut[1]-tree[1]);
			firstDist[i]=nutDistFromSquirrel;
			restDist[i]=nutDistFromTree;
			totalDist+=2*restDist[i];// total distance of all the nuts
		}
		long minDist=Integer.MAX_VALUE;
		for(int i=0; i<nuts.length; i++) {
			long localMin=firstDist[i] // squirrel to the nut
					+ totalDist // sum of all the distances *2 - to and from
					- restDist[i];// count it only once for the first reach
			
			minDist=Math.min(minDist, localMin);
		}
		return (int)minDist;
    }
	public static void main(String[] s) {
		SquirrelSimulation ss= new SquirrelSimulation();
		System.out.println(ss.minDistance(5, 7, new int[] {2,2}, new int[] {4,4}, new int[][] {{3,0},{2,5}}));
	}
}
