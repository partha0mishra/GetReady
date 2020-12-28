package com.leetcode.graph;
/* 1042. Flower Planting With No Adjacent
 * You have n gardens, labeled from 1 to n, and an array paths where paths[i] = [xi, yi] describes the existence 
 * of a bidirectional path from garden xi to garden yi. 
 * In each garden, you want to plant one of 4 types of flowers.
 * There is no garden that has more than three paths coming into or leaving it.
 * Your task is to choose a flower type for each garden such that, 
 * for any two gardens connected by a path, they have different types of flowers.
 * Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)th garden.  
 * The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.
 * 
 * Example 1:
 * Input: n = 3, paths = [[1,2],[2,3],[3,1]]
 * Output: [1,2,3]
 * Example 2:
 * Input: n = 4, paths = [[1,2],[3,4]]
 * Output: [1,2,1,2]
 * Example 3:
 * Input: n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * Output: [1,2,3,4]
 * Constraints:
 * 1 <= n <= 104
 * 0 <= paths.length <= 2 * 104
 * paths[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * No garden has four or more paths coming into or leaving it.
 */
import java.util.*;
public class FlowerPlantingNoAdjacent {
	public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer,Set<Integer>> graph= new HashMap<>();// simplistic representation of a graph
        for(int i=0; i< n; i++) graph.put(i,new HashSet<Integer>());// initialize the adjacency sets
        for(int[] p: paths) {// Add the paths. Bidirectional. Convert from 1-based to 0 based.
        	graph.get(p[0]-1).add(p[1]-1);
        	graph.get(p[1]-1).add(p[0]-1);
        }
        int[] garden= new int[n];// gardens
        int[] colors=new int[] {1,2,3,4};// available flowers
        for(int i=0; i< n; i++) {// Let's populate Greedily
        	HashSet<Integer> neighbors= new HashSet<Integer>();
        	for(int adj: graph.get(i)) {
        		neighbors.add(garden[adj]);
        	}
        	for(int color: colors) {
        		if(!neighbors.contains(color)) {garden[i]=color;break;}
        	}
        }
        return garden;
    }
	public static void main(String[] args) {
		int[][] input=new int[][] 
				{{1,2},{2,3},{1,3}};int n=3;
//				{{1,2},{3,4}};int n=4;
//				{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};int n=4;
//				{{3,4},{4,2},{3,2},{1,3}}; int n=4;
//				{{3,4},{4,5},{3,2},{5,1},{1,3},{4,2}}; int n=5;
//				{{4,2},{6,2},{6,3},{2,3},{5,3},{6,5},{5,4},{4,1}}; int n=6;
		int[] result=new FlowerPlantingNoAdjacent().gardenNoAdj(n, input);
		System.out.println();
		for(int r: result) {
			System.out.print(r);
		}
	}
}
