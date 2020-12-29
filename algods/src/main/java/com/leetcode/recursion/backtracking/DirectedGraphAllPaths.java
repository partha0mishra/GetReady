package com.leetcode.recursion.backtracking;
//TODO Anki
/*
 * Given a directed, acyclic graph of N nodes.  
 * Find all possible paths from node 0 to node N-1, and return them in any order.
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  
 * graph[i] is a list of all nodes j for which the edge (i, j) exists.
 * 
 * Example:
 * Input: [[1,2], [3], [3], []] 
 * Output: [[0,1,3],[0,2,3]] 
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |sw2w
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * 
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
import java.util.*;

public class DirectedGraphAllPaths {
	/* Backtracking way - re-implemented
	 * O(2^N.N) O(2^N.N) */
	public List<List<Integer>> allPathsSourceTarget(int[][] graph){
		List<List<Integer>> result= new ArrayList<>();
		List<Integer> partial= new ArrayList<>();
		partial.add(0);// it seems the first node is needed
		backtrack(graph,0,result,partial,graph.length-1);
		return result;
	}
	private void backtrack(int[][] graph, int node, List<List<Integer>> result, List<Integer> partial, int destination) {
		if(node == destination) {// reached
			result.add(new ArrayList<>(partial));// remember to create a copy
			return;
		}
		
		for(int n: graph[node]) {//neighbors 
			partial.add(n);// let's see what happens
			backtrack(graph, n, result, partial, destination);
			partial.remove(partial.size() -1);// backtracking to try out next neighbor
		}
	}
	/* Earlier try */
//	List<List<Integer>> result;
//	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        result=new ArrayList<List<Integer>>();
//        boolean[] isVisited= new boolean[graph.length];
//		ArrayList<Integer> pathList = new ArrayList<Integer>();
//		pathList.add(0);
//		findAllPaths(0, graph.length -1, isVisited, pathList, graph);
//		return result;
//    }
//	
//	void findAllPaths(int s, int d, boolean[] isVisited, ArrayList<Integer> pathList, int[][] graph) {
//		isVisited[s] = true;
//		
//		if(s == d) {
//			result.add(new ArrayList<Integer>(pathList));
//			isVisited[s]=false;
//			return;
//		}
//		for(Integer i: graph[s]) {
//			if(!isVisited[i]) {
//				pathList.add(i);
//				findAllPaths(i,d,isVisited,pathList, graph);
//				pathList.remove(i);
//			}
//		}
//		isVisited[s] = false;
//	}

	public static void main(String[] args) {
		DirectedGraphAllPaths instance= new DirectedGraphAllPaths();
		int[][] graph01={{1,2},{3},{3},{}};
		System.out.println(instance.allPathsSourceTarget(graph01));//[[0,1,3],[0,2,3]]
	}
}
