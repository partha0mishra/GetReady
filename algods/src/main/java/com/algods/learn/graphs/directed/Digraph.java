package com.algods.learn.graphs.directed;

import java.util.*;
public class Digraph {
	private static final String NEWLINE = System.getProperty("line.separator");
	private final int V;// Number of Vertices
	private int E;// Number of Edges
	private HashSet<Integer>[] adj;// Adjacency array
	private int[] indegree;
	
	public Digraph(int V) {
		this.V=V;
		this.E=0;
		this.indegree=new int[V];
		adj= (HashSet<Integer>[])new HashSet[V];
		for(int v=0; v<V; v++)
			adj[v]=new HashSet<Integer>();
	}
	public void addEdge(int from, int to) {
		adj[from].add(to);
		indegree[to]++;
		E++;
	}
	public int V() {return V;}
	public int E() {return E;}
	public Iterable<Integer> adj(int node){	return adj[node];}
	public int outdegree(int node) {return adj[node].size();}
	public int indegree(int node) {return indegree[node];}
	public Digraph reverse() {
		Digraph reverseDigraph= new Digraph(V);
		for(int from=0; from<V; from++) {
			for(int to: adj(from)) {
				reverseDigraph.addEdge(to, from);
			}
		}
		return reverseDigraph;
	}
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
	public static void main(String[] args) {
		Digraph graph= new Digraph(13);
		graph.addEdge(0,5);
		graph.addEdge(0,1);
		graph.addEdge(2,0);
		graph.addEdge(2,3);
		graph.addEdge(3,5);
		graph.addEdge(3,2);
		graph.addEdge(4,3);
		graph.addEdge(4,2);
		graph.addEdge(5,4);
		graph.addEdge(6,9);
		graph.addEdge(6,4);
		graph.addEdge(6,8);
		graph.addEdge(6,0);
		graph.addEdge(7,6);
		graph.addEdge(7,9);
		graph.addEdge(8,6);
		graph.addEdge(9,11);
		graph.addEdge(9,10);
		graph.addEdge(10,12);
		graph.addEdge(11,4);
		graph.addEdge(11,12);
		graph.addEdge(12,9);
		System.out.println(graph);
	}

}
