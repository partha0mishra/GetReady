package com.algods.learn.graphs.shortestpath;
/*
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
 * 
 * 1) Create a set sptSet (shortest path tree set) that keeps track of vertices included in shortest path tree, 
 * i.e., whose minimum distance from source is calculated and finalized. Initially, this set is empty.
2) Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE. 
Assign distance value as 0 for the source vertex so that it is picked first.
3) While sptSet doesn’t include all vertices
….a) Pick a vertex u which is not there in sptSet and has minimum distance value.
….b) Include u to sptSet.
….c) Update distance value of all adjacent vertices of u. To update the distance values, iterate through all adjacent vertices. 
For every adjacent vertex v, if sum of distance value of u (from source) and weight of edge u-v, is less than the distance value of v, 
then update the distance value of v.
 */
//Java implementation of Dijkstra's Algorithm 
//using Priority Queue 
import java.util.*; 
public class MyDijkstraPQ {
	//Class to represent a node in the graph 
	class Node implements Comparable<Node> { 
		public int id, dist;
		public Node(int i, int d)	{ this.id = i; this.dist = d; } 
		@Override
		public int compareTo(Node n) { return Integer.compare(dist, n.dist);}
	}
	private int[] dist;
	private Set<Integer> sptSet; 
	private TreeSet<Node> pq; 
	private int V; // Number of vertices 
	List<List<Node> > adj; 

	public MyDijkstraPQ(int V) { 
		this.V = V; 
		dist = new int[V];
		sptSet = new HashSet<Integer>(); 
		pq = new TreeSet<Node>(); 
	} 
	// Function for Dijkstra's Algorithm 
	public void dijkstra(List<List<Node> > adj, int src) { 
		this.adj = adj; 

		for (int i = 0; i < V; i++) 
			dist[i] = Integer.MAX_VALUE; 

		// Add source node to the priority queue 
		pq.add(new Node(src, 0)); 

		// Distance to the source is 0 
		dist[src] = 0; 
		while (sptSet.size() != V) { 
			// remove the minimum distance node from the priority queue 
			int u = pq.pollFirst().id; 
			// adding the node whose distance is finalized 
			sptSet.add(u); 
			processNeighbors(u); 
		} 
	} 
	public Iterable<Integer> getSpt() {
		return sptSet;
	}

	// Function to process all the neighbors of the passed node 
	private void processNeighbors(int u) { 
		System.out.println("S P T node< "+u+" > cost: "+dist[u]+" pq-size "+pq.size());
		// All the neighbors of v 
		for (Node v : adj.get(u)) { 
			// If current node hasn't already been processed 
			if (!sptSet.contains(v.id)) { 
				int newDist = dist[u]+v.dist; 
				// If new distance is cheaper in cost 
				if (newDist < dist[v.id]) 
					dist[v.id] = newDist; 
				// Add the current node to the queue 
				pq.add(new Node(v.id, dist[v.id]));
				System.out.println("added node< "+v.id+" > cost: "+dist[v.id]+" pq-size "+pq.size());
			} 
		} 
	} 

	// Driver code 
	public static void main(String arg[]) { 
		int V = 5; 
		int source = 0; 

		// Adjacency list representation of the connected edges 
		List<List<Node> > adj = new ArrayList<List<Node> >(); 

		// Initialize list for every node 
		for (int i = 0; i < V; i++) { 
			List<Node> item = new ArrayList<Node>(); 
			adj.add(item); 
		} 
		MyDijkstraPQ dpq = new MyDijkstraPQ(V);
		// Inputs for the DPQ graph 
		adj.get(0).add(dpq.new Node(1, 9)); 
		adj.get(0).add(dpq.new Node(2, 6)); 
		adj.get(0).add(dpq.new Node(3, 5)); 
		adj.get(0).add(dpq.new Node(4, 3)); 

		adj.get(2).add(dpq.new Node(1, 2)); 
		adj.get(2).add(dpq.new Node(3, 4));
		// result 0 8 6 5 3
		adj.get(4).add(dpq.new Node(2, 2));
		// result 0 7 5 5 3
		adj.get(4).add(dpq.new Node(3, 1));
		// result 0 7 5 4 3

		// Calculate the single source shortest path 
		dpq.dijkstra(adj, source); 

		// Print the shortest path to all the nodes 
		// from the source node 
		System.out.println("The shortest path from node : "+ source);
		for(int n: dpq.getSpt()) {
			System.out.println("Node "+n+" distance "+dpq.dist[n]);
		}
//		for (int i = 0; i < dpq.dist.length; i++) 
//			System.out.println(source + " to " + i + " is "
//							+ dpq.dist[i]); 
	} 
} 

