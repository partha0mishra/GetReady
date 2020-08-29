package com.algods.sedgewick.graphs;

import java.util.*;
public class Graph {
	private static final String NEWLINE = System.getProperty("line.separator");
	private final int V;// number of vertices
	private int E;// number of Edges
	private HashSet<Integer>[] adj;// Adjacency array
	public Graph(int V) {
		this.V=V;
		this.E=0;
		adj=(HashSet<Integer>[])new HashSet[V];
		for(int i=0; i<V; i++) {
			adj[i]=new HashSet<Integer>();
		}
	}
	public int V() {return V;}
	public int E() {return E;}
	public void addEdge(int v, int w) {// edge between v and w
		if(adj[v].contains(w)) return;// this edge already exists
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public int degree(int v) {
		return adj[v].size();
	}
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
	public static void main(String[] args) {
		Graph graph= new Graph(13);
		graph.addEdge(0, 6);
		graph.addEdge(0, 2);
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(7, 8);
		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		graph.addEdge(9, 12);
		graph.addEdge(11, 12);
		graph.addEdge(12, 11);// Testing if this gets added :D
		System.out.println(graph.E());
		System.out.println(graph);
	}

}
