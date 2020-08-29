package com.algods.sedgewick.graphs;

import java.util.Stack;

public class DepthFirstPaths {
	private boolean[] marked;// s-v path exists
	private int[] edgeTo;// previous one in the path
	private final int s;// source vertex
	public DepthFirstPaths(Graph G, int s) {
		this.s=s;
		edgeTo=new int[G.V()];
		marked=new boolean[G.V()];
		dfs(G,s);
	}
	private void dfs(Graph G, int v) {
		marked[v]=true;
		for(int w: G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w]=v;
				dfs(G,w);
			}
		}
	}
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path=new Stack<Integer>();
		for(int x=v; x !=s; x=edgeTo[x])// track back source from the node
			path.push(x);
		path.push(s);
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
		DepthFirstPaths dfp=new DepthFirstPaths(graph, source);
		for(int destination=0; destination < graph.V(); destination++)
			if(dfp.hasPathTo(destination)) {
				System.out.print(source+" to "+destination+" : ");
				for(int node: dfp.pathTo(destination)) {
					if(node == source) System.out.print(node);
					else System.out.print(node+" <- ");
				}
				System.out.println();
			}else {
				System.out.println("No path found from "+source+" to "+destination);
			}
	}

}
