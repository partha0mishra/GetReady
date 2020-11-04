package com.algods.learn.graphs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	public BreadthFirstPaths(Graph G, int source) {
		marked= new boolean[G.V()];
		edgeTo= new int[G.V()];
		distTo= new int[G.V()];
		for(int i=0; i< G.V(); i++)
			distTo[i]=INFINITY;
		bfs(G,source);
	}
	private void bfs(Graph G, int source) {
		Queue<Integer> q= new ArrayDeque<Integer>();
		
		distTo[source]=0;
		marked[source]=true;
		q.offer(source);
		while(!q.isEmpty()) {
			int v=q.poll();
//			marked[v]=true; // NOOOOO
			for(int w: G.adj(v)) {
				if(!marked[w]) {
					edgeTo[w]=v;
					distTo[w]=distTo[v]+1;
					marked[w]=true;
					q.offer(w);
				}
			}
		}
	}
	public boolean hasPathTo(int node) {
		return marked[node];
	}
	public int distTo(int node) {
		return distTo[node];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path= new Stack<Integer>();
		while(v !=edgeTo[v]) {
			path.push(v);
			v=edgeTo[v];
		}
		path.push(v);
		return path;
	}
	public static void main(String[] args) {
		Graph graph= new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		System.out.println(graph);
		int source=0;
		BreadthFirstPaths bfp= new BreadthFirstPaths(graph, source);
		for(int destination=0; destination<graph.V(); destination++)
			if(bfp.hasPathTo(destination)) {
				System.out.print(source+" to "+destination+" : ");
				for(int x: bfp.pathTo(destination)) {
					if(x==source) System.out.print(x);
					else System.out.print(x+" <- ");
				}
				System.out.println();
			}else {
				System.out.println("No path from "+source+" to "+destination);
			}
	}
}
