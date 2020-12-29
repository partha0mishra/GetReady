package com.leetcode.recursion.sweepLine;
/* 218. The Skyline Problem: https://leetcode.com/problems/the-skyline-problem/
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. 
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

Buildings Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 */
import java.util.*;
public class SkyLineProblem {
	class BuildingPoint implements Comparable<BuildingPoint>{
		int x, height; boolean isStart;
		public BuildingPoint(int xx, int hh, boolean ss) {this.x=xx; this.height=hh; this.isStart=ss;}
		@Override
		public int compareTo(BuildingPoint o) {
			if(this.x != o.x) return Integer.compare(this.x, o.x);
			else {
				return (this.isStart? -this.height:this.height)- (o.isStart? -o.height:o.height);
			}
		}
	}
public List<List<Integer>> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints= new BuildingPoint[2*buildings.length];
        for(int index=0; index<buildings.length; index++) {
        	buildingPoints[2*index]=new BuildingPoint(buildings[index][0],buildings[index][2],true);
        	buildingPoints[2*index+1]=new BuildingPoint(buildings[index][1],buildings[index][2],false);
        }
        Arrays.sort(buildingPoints);
        TreeMap<Integer,Integer> queue=new TreeMap<>();
        queue.put(0, 1);// max, num of values
        int prevMaxHeight=0;
        List<List<Integer>> result= new ArrayList<>();
        for(BuildingPoint bp: buildingPoints) {
        	if(bp.isStart) {
        		queue.compute(bp.height, (key,value) -> {
        			if(value !=null) return value+1;
        			else return 1;
        		});
        	}else {
        		queue.compute(bp.height, (key,value) -> {
        			if(value ==1) return null;
        			else return value-1;
        		});
        	}
        	int currentMaxHeight=queue.lastKey();
        	if(currentMaxHeight != prevMaxHeight) {
        		ArrayList<Integer> e=new ArrayList<>();
        		e.add(bp.x);
        		e.add(currentMaxHeight);
        		result.add(e);
        		prevMaxHeight=currentMaxHeight;
        	}
        }
        return result;
    }
}
