package com.algods.leetcode;

import java.util.Arrays;

/*
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose 
 * start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point 
 * to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. 
 * Finally, you need output the stored value of each interval as an array.
 * 
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 * 
 * Example 1:
 * Input: [ [1,2] ]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * 
 * Example 2:
 * Input: [ [3,4], [2,3], [1,2] ]
 * Output: [-1, 0, 1]
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 * 
 * Example 3:
 * Input: [ [1,4], [2,3], [3,4] ]
 * Output: [-1, 2, -1]
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
import java.util.*;
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();
        
        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i][0], i);    
        }
        
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i][1]);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        
        return result;
    }
//	private Node root;
//	int[] result;
//	class Node{
//		int iLeft, iRight, index;
//		Node nLeft, nRight;
//		public Node(int index, int iLeft, int iRight) {
//			this.index=index;
//			this.iLeft=iLeft;
//			this.iRight=iRight;
//		}
//	}
//    public int[] findRightInterval(int[][] intervals) {
//    	result= new int[intervals.length];// let's update this
//    	Arrays.fill(result, -1);
//    	int index=0;
//    	for(int[] interval: intervals) {
//    		put(index++,interval[0], interval[1]);
//    	}
//        return result;
//    }
//    private void put(int index, int iLeft, int iRight) {
//    	root=put(root, index, iLeft, iRight);
//    }
//    private Node put(Node node, int index, int iLeft, int iRight) {
//    	if(node == null) return new Node(index, iLeft, iRight);
//    	int cmp=iLeft - node.iLeft;
//    	if(cmp < 0) node.nLeft=put(node.nLeft, index, iLeft, iRight);
//    	else if(cmp > 0) node.nRight=put(node.nRight, index, iLeft, iRight);
//    	
////    	result[node.index]=
//    	return node;
//    }
//    private int findRightInterval(Node node) {
//    	if(node.nRight == null) return -1;
//    	else return Math.max(a, b)
//    }
	public static void main(String[] args) {
		FindRightInterval instance= new FindRightInterval();
		int[][] interval01= new int[][] {{1,2}};
		System.out.println(Arrays.toString(instance.findRightInterval(interval01)));// -1
		int[][] interval02= new int[][] {{3,4},{2,3},{1,2}};
		System.out.println(Arrays.toString(instance.findRightInterval(interval02)));// -1,0,1
		int[][] interval03= new int[][] {{1,4},{2,3},{3,4}};
		System.out.println(Arrays.toString(instance.findRightInterval(interval03)));// -1,2,-1
	}

}
