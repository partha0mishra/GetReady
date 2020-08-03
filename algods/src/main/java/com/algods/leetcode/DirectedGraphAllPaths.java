package com.algods.leetcode;

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
	List<List<Integer>> result;
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result=new ArrayList<List<Integer>>();
        boolean[] isVisited= new boolean[graph.length];
		ArrayList<Integer> pathList = new ArrayList<Integer>();
		pathList.add(0);
		findAllPaths(0, graph.length -1, isVisited, pathList, graph);
		return result;
    }
	
	void findAllPaths(int s, int d, boolean[] isVisited, ArrayList<Integer> pathList, int[][] graph) {
		isVisited[s] = true;
		
		if(s == d) {
			result.add(new ArrayList<Integer>(pathList));
			isVisited[s]=false;
			return;
		}
		for(Integer i: graph[s]) {
			if(!isVisited[i]) {
				pathList.add(i);
				findAllPaths(i,d,isVisited,pathList, graph);
				pathList.remove(i);
			}
		}
		isVisited[s] = false;
	}

	public static void main(String[] args) {
		DirectedGraphAllPaths instance= new DirectedGraphAllPaths();
		int[][] graph01={{1,2},{3},{3},{}};
		System.out.println(instance.allPathsSourceTarget(graph01));//[[0,1,3],[0,2,3]]
	}

/** SECOND SUCCESSFUL TRY BEFORE OVERHAUL **/
//	class DAG  {  
//	    private int V;
//	    private int[][] adj;
//	    List<List<Integer>> result;
//	    
//	    DAG(int v){
//	        V = v;
//	        adj = new int[v][];
//	        result= new ArrayList<List<Integer>>();
//	    }  
//	        
//	    List<List<Integer>> allPaths(int source, int destination) {
//			boolean[] isVisited= new boolean[V];
//			ArrayList<Integer> pathList = new ArrayList<Integer>();
//			pathList.add(source);
//			findAllPaths(source, destination, isVisited, pathList);
//			return result;
//		}
//	    
//		void findAllPaths(int s, int d, boolean[] isVisited, ArrayList<Integer> pathList) {
//			isVisited[s] = true;
//			
//			if(s == d) {
//				result.add(new ArrayList(pathList));
//				isVisited[s]=false;
//				return;
//			}
//			for(Integer i: adj[s]) {
//				if(!isVisited[i]) {
//					pathList.add(i);
//					findAllPaths(i,d,isVisited,pathList);
//					pathList.remove(i);
//				}
//			}
//			
//			isVisited[s] = false;
//		}
//
//		void addEdges(int index, int[] js) {
//			adj[index]=Arrays.copyOf(js, js.length);
//		}
//	}
//
//	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        DAG G= new DAG(graph.length);
//        for(int i=0; i<graph.length; i++)
//        	G.addEdges(i, graph[i]);
//        return G.allPaths(0, graph.length -1);       
//    }
/** FIRST SUCCESSFUL TRY **/
//	class DAG1  {  
//	    private int V;
//	    private ArrayList<Integer>[] adj;
//	    List<List<Integer>> result;
//	    
//	    DAG1(int v){  
//	        V = v;
//	        adj = new ArrayList[v];
//	        for (int i=0; i<v; i++)  
//	            adj[i]= new ArrayList<Integer>();
//	        result= new ArrayList<List<Integer>>();
//	    }  
//	    
//	    void addEdge(int v,int w) { 
//	    	adj[v].add(w); 
//	    }
//	    
//	    List<List<Integer>> allPaths(int source, int destination) {
//			boolean[] isVisited= new boolean[V];
//			ArrayList<Integer> pathList = new ArrayList<Integer>();
//			pathList.add(source);
//			findAllPaths(source, destination, isVisited, pathList);
//			return result;
//		}
//	    
//		void findAllPaths(int s, int d, boolean[] isVisited, ArrayList<Integer> pathList) {
////			System.out.println(s+" "+d+" "+pathList);
//			isVisited[s] = true;
//			
//			if(s == d) {
////				System.out.println("path: "+pathList);
//				result.add((List<Integer>) pathList.clone());
////				System.out.println(result);
//				// add this pathlist to the paths
//				isVisited[s]=false;
//				return;
//			}
//			for(Integer i: adj[s]) {
//				if(!isVisited[i]) {
//					pathList.add(i);
//					findAllPaths(i,d,isVisited,pathList);
//					pathList.remove(i);
//				}
//			}
//			
//			isVisited[s] = false;
//		}
//	    int numVertices() {
//	    	return V;
//	    }
//
//		ArrayList<Integer> adj(int vertex) {
//			return adj[vertex];
//		}
//
//		void addEdges(int index, int[] js) {
//			for(int i=0; i<js.length; i++) {
//				addEdge(index,js[i]);
//			}
//		}
//	}
}
