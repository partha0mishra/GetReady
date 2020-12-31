package com.leetcode.heap;
// TODO Anki
/* 973. K Closest Points to Origin
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000
 */
import java.util.*;
public class KClosestPoints {
	/* Approach 02: less code */
//	public int[][] kClosest(int[][] points, int K) {
//        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
//        return Arrays.copyOfRange(points, 0, K);
//    }
	/* Approach 01: cleaner */
	public int[][] kClosest(int[][] points, int K) {
		if(K >= points.length) return points;// all of them qualify
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i=0; i< points.length; i++) hm.put(i, points[i][0]*points[i][0]+points[i][1]*points[i][1]);
        PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue<>(K, (a,b) -> a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> e: hm.entrySet()) {
        	pq.offer(e);
        }
        int[][] result=new int[K][2];
        for(int i=0; i<K; i++){
            System.out.println(i+" "+pq.peek().getKey()+" "+pq.peek().getValue());
        	result[i]=points[pq.poll().getKey()];
        }
        return result;
    }
	public static void main(String[] args) {
		KClosestPoints instance= new KClosestPoints();
		System.out.println(instance.kClosest(new int[][] {{1,3},{-2,2}}, 1));
	}
}
