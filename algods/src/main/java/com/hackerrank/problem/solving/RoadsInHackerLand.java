package com.hackerrank.problem.solving;

/**
 * John lives in HackerLand, a country with  cities and  bidirectional roads. Each of the roads has a distinct length, and each length is a power of two (i.e.,  raised to some exponent). It's possible for John to reach any city from any other city.

Given a map of HackerLand, can you help John determine the sum of the minimum distances between each pair of cities? Print your answer in binary representation.

Input Format

The first line contains two space-seperated integers denoting  (the number of cities) and  (the number of roads), respectively.
Each line  of the  subsequent lines contains the respective values of , , and  as three space-separated integers. These values define a bidirectional road between cities  and  having length .

Constraints

, 
If , then .
Output Format

Find the sum of minimum distances of each pair of cities and print the answer in binary representation.

Sample Input

5 6
1 3 5
4 5 0
2 1 3
3 2 1
4 3 4
4 2 2
Sample Output

1000100
 * 
 */
import java.util.*;
public class RoadsInHackerLand {
	static class Edge implements Comparable<Edge>{
		int src, dst, wt;
		public Edge(int s, int d, int w) {this.src=s; this.dst=d; this.wt=w;}
		public int compareTo(Edge e) {return Integer.compare(this.wt, e.wt);}
	}
	static long totalDistance=0;
	static String roadsInHackerland(int n, int[][] roads) {
		Edge[] edges=new Edge[roads.length];
		for(int i=0; i< roads.length; i++) {
			edges[i]=new Edge(roads[i][0], roads[i][1], roads[i][2]);
		}
		Arrays.sort(edges);
		HashSet<Integer> mstset= new HashSet<>();
		Map<Integer, Map<Integer,Long>> adj= new HashMap<>();
		int edgeCount=0;
		for(Edge e: edges) {
			if(mstset.add(e.src) || mstset.add(e.dst)) {
				adj.computeIfAbsent(e.src, v-> new HashMap<>()).put(e.dst,(long)Math.pow(2, e.wt));// src -> (dst, wt)
				adj.computeIfAbsent(e.dst, v-> new HashMap<>()).put(e.src,(long)Math.pow(2, e.wt));// dst -> (src, wt)
				edgeCount+=1;
				if(edgeCount == n-1) break;
			}
		}
		// dfs among pairs
		for(int source=1; source<n; source++) {
			for(int dest=source+1; dest <=n; dest++) {
				HashSet<Integer> visited=new HashSet<>();
				findDistance(source, dest,adj,0,visited);// source, destination, adj, distance
			}
		}
		
		return Long.toBinaryString(totalDistance);
    }
	private static void findDistance(int source, int dest, Map<Integer, Map<Integer, Long>> adj, long dist, HashSet<Integer> visited) {
		visited.add(source);
		if(source == dest) {
			totalDistance+=dist;
			return;
		}
		Iterator<Map.Entry<Integer, Long>> it=adj.get(source).entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer,Long> entry=it.next();
			int k=entry.getKey();
			long v=entry.getValue();
			if(!visited.contains(k)) {
				findDistance(k, dest, adj, dist+v, visited);
			}
		}
	}
	public static void main(String[] args) {
//		int[][] edges= {{1,3,5},{4,5,0},{2,1,3},{3,2,1},{4,3,4},{4,2,2}};
		// int n=5
		int[][] edges= {{5,12,18},{17,2,5},{7,18,3},{17,6,0}
					   ,{15,12,16},{2,3,8},{14,9,20},{4,9,11}
					   ,{13,1,21},{13,12,15},{15,12,10},{6,16,9}
					   ,{11,18,2},{9,16,17},{12,4,4},{7,4,19}
					   ,{17,1,12},{10,14,7},{8,5,13},{18,3,14}
					   ,{4,11,6},{15,3,1},{12,5,22}};
		int n=18;
		System.out.println(RoadsInHackerLand.roadsInHackerland(n,edges));
	}

}
