package com.algods.sedgewick.graphs.directed;

import java.util.*;
public class TopologicalSort {
	private Stack<Integer> order; // Stack with the topological sorted vertices
	private int[] rank; // rank[v] = rank of vertex v in order
	private boolean[] marked; // dfs marking
	public TopologicalSort(Digraph graph) {
		// skipping cycle finder. Topological sort doesn't work with cycles
		order= new Stack<Integer>();
		marked= new boolean[graph.V()];
		for(int v=0; v< graph.V(); v++) {
			if(!marked[v]) {
				dfs(graph, v);
				order.push(v);
			}
		}
	}
	private void dfs(Digraph graph, int v) {
		marked[v]=true;
		for(int i: graph.adj(v)) {
			if(!marked[i]) {
				dfs(graph, i);
				order.push(i);
			}
		}
	}
	public Iterable<Integer> getOrder(){
		return order;
	}
	public boolean marked(int node) {return marked[node];}
	public static void main(String[] args) {
		Digraph graph= new Digraph(13);
		graph.addEdge(2,3);		graph.addEdge(0,6);		graph.addEdge(0,1);		graph.addEdge(2,0);
		graph.addEdge(11,12);		graph.addEdge(9,12);		graph.addEdge(9,10);		graph.addEdge(9,11);
		graph.addEdge(3,5);		graph.addEdge(8,7);		graph.addEdge(5,4);		graph.addEdge(0,5);
		graph.addEdge(6,4);		graph.addEdge(6,9);		graph.addEdge(7,6);
		System.out.println(graph);
		TopologicalSort ts= new TopologicalSort(graph);
		for(int i: ts.getOrder()) System.out.print(i+" ");
	}

}
