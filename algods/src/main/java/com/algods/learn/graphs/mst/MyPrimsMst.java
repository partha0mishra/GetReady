package com.algods.learn.graphs.mst;
import java.util.LinkedList; 
import java.util.TreeSet; 
import java.util.Comparator; 
/*
 * https://www.geeksforgeeks.org/prims-mst-for-adjacency-list-representation-greedy-algo-6/
 * 1) Create a set mstSet that keeps track of vertices already included in MST. 
 * 2) Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE. Assign key value as 0 for the first vertex so that it is picked first. 
 * 3) While mstSet doesn’t include all vertices 
 * ….a) Pick a vertex u which is not there in mstSet and has minimum key value. 
 * ….b) Include u to mstSet. 
 * ….c) Update key value of all adjacent vertices of u. To update the key values, 
 * 		iterate through all adjacent vertices. For every adjacent vertex v, 
 * 		if weight of edge u-v is less than the previous key value of v, 
 * 		update the key value as weight of u-v
 * The idea of using key values is to pick the minimum weight edge from cut. 
 * The key values are used only for vertices which are not yet included in MST, 
 * the key value for these vertices indicate the minimum weight edges connecting them to the set of vertices included in MST. 
 */
import java.util.*;
public class MyPrimsMst {
		static class EdgeTo {	
			int dest, weight; 
			EdgeTo(int d, int w) { dest = d; weight = w;}
		}
		static class Graph { 
			int V; 
			// List of adjacent nodes of a given vertex 
			LinkedList<EdgeTo>[] adj; 
			Graph(int v) { 
				V = v; 
				adj = new LinkedList[V]; 
				for (int i = 0; i < V; i++) 
					adj[i] = new LinkedList<>(); 
			} 
			// method to add an edge between two vertices 
			void addEdge(int src, int dest, int weight) { 
				adj[src].addLast(new EdgeTo(dest,weight)); 
				adj[dest].addLast(new EdgeTo(src,weight));
			}
		} 

		// class to represent a node in PriorityQueue 
		// Stores a vertex and its corresponding key value 
		class Vertex implements Comparator<Vertex>{
			int id, cost;
			public Vertex() {}
			public Vertex(int i, int c) { this.id=i; this.cost=c;}
			@Override
			public int compare(Vertex v1, Vertex v2) {return Integer.compare(v1.cost, v2.cost);}
		} 
		int[] parent;
		void primsMst(Graph graph) { 
			// Whether a vertex is in PriorityQueue or not 
			HashSet<Integer> mstSet = new HashSet<Integer>(); 
			Vertex[] vertices = new Vertex[graph.V];
			parent=new int[graph.V];
			for (int i = 0; i < graph.V; i++) { 
				// Initialize key values to infinity 
				vertices[i]=new Vertex(i,Integer.MAX_VALUE);
			}
			// Set key value to 0 so that it is extracted first out of PriorityQueue 
			vertices[0].cost = 0; 
			// Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java. 
			TreeSet<Vertex> queue = new TreeSet<Vertex>(new Vertex()); 
			for (int i = 0; i < graph.V; i++) 
				queue.add(vertices[i]); 
			// Loops until the queue is not empty 
			while (!queue.isEmpty()) { 
				// Extracts a node with min key value 
				Vertex u = queue.pollFirst(); 
				// Include that node into mstset 
				mstSet.add(u.id); 
				// For all adjacent vertex of the extracted vertex V 
				for (EdgeTo edge : graph.adj[u.id]) {
					// If V is in queue
					int v=edge.dest;
					if (!mstSet.contains(v)) { 
						// If the key value of the adjacent vertex is more than the extracted key 
						// update the key value of adjacent vertex to update first remove and add the updated vertex 
						if (vertices[v].cost > edge.weight) { // edge.weight needs to be the distance of this vertex from the MST (any node)
							queue.remove(vertices[v]); 
							vertices[v].cost = edge.weight; 
							queue.add(vertices[v]);
							parent[v]=u.id;
						} 
					} 
				} 
			} 

			// Prints the vertex pair of mst 
			for (int o = 1; o < graph.V; o++) 
				System.out.println(parent[o] + " "
								+ "-"
								+ " " + o); 
		} 

		public static void main(String[] args) { 
			int V = 9; 
			Graph graph = new Graph(V); 
			MyPrimsMst pmst = new MyPrimsMst(); 
			graph.addEdge(0, 1, 4); 
			graph.addEdge(0, 7, 8); 
			graph.addEdge(1, 2, 8); 
			graph.addEdge(1, 7, 11); 
			graph.addEdge(2, 3, 7); 
			graph.addEdge(2, 8, 2); 
			graph.addEdge(2, 5, 4); 
			graph.addEdge(3, 4, 9); 
			graph.addEdge(3, 5, 14); 
			graph.addEdge(4, 5, 10); 
			graph.addEdge(5, 6, 2); 
			graph.addEdge(6, 7, 1); 
			graph.addEdge(6, 8, 6); 
			graph.addEdge(7, 8, 7); 

			// Method invoked 
			pmst.primsMst(graph); 
		} 
	} 
	// This code is contributed by Vikash Kumar Dubey 
