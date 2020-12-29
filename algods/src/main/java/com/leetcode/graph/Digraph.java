package com.leetcode.graph;

import java.util.*;
public class Digraph {
	private final int V;// number of vertices
	private int E;// number of edges
	private HashSet<Integer>[] adj;// Adjacency 
	private int[] indegree;
	public Digraph(int v) {
		this.V=v;
		this.E=0;
		adj= (HashSet<Integer>[])new HashSet[V];
		for(int i=0; i< V; i++) {
			adj[i]=new HashSet<Integer>();
		}
		indegree= new int[V];
	}
	public int V() {return this.V;}
	public int E() {return this.E;}
	public Iterable<Integer> adj(int v){return adj[v];}
	public int degree(int v) {return adj[v].size();}
	public void addEdge(int v,int w) {
		if(!adj[v].contains(w)) {
			adj[v].add(w);
			indegree[w]+=1;
			E+=1;
		}
	}
	public int indegree(int v) {return indegree[v];}
}
