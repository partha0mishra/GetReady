package com.algods.learn.graphs.mst;
/*
 * KRUSKAL's algo for MST
 * 1. Sort all the edges in non-decreasing order of their weight. 
 * 2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. If cycle is not formed, include this edge. Else, discard it. 
 * 3. Repeat step#2 until there are (V-1) edges in the spanning tree.
 */
import java.util.Arrays;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;
public class MyKruskalMst2 {
	class Edge implements Comparable<Edge>{
		int source, destination, weight;
		public Edge(int s, int d, int w) {this.source=s; this.destination=d; this.weight=w;}
		public int compareTo(Edge e) {return Integer.compare(this.weight,e.weight);}
	}
	class Graph{
		int V, E, eTemp=0;
		Edge[] edges;
		public Graph(int v, int e) {
			this.V=v; this.E=e;
			edges= new Edge[E];
		}
		public void addEdge(int s,int d, int w) {
			if(eTemp ==E) throw new IllegalArgumentException("This is edge "+eTemp);
			edges[eTemp++]=new Edge(s,d,w); 
		}
	}
	
	Edge[] mst;
	public void calculateKruskalMST(Graph g) {
		mst= new Edge[g.V-1];
		Arrays.sort(g.edges);
		HashSet<Integer> mstSet= new HashSet<>();
		int eCount=0;
		for(Edge e: g.edges) {
			if(mstSet.contains(e.source) && mstSet.contains(e.destination)) {
				continue;
			}else {
				mst[eCount++]=e;
				mstSet.add(e.source);
				mstSet.add(e.destination);
				if(eCount == g.V -1) break;
			}
		}
	}
	public Edge[] getMst() { return mst;}
	public static void main(String[] args) {
		/* Let us create following weighted graph
				10
			0--------1
			|  \	 |
		   6|   5\   |15
			|	   \ |
			2--------3
				4	 */

		MyKruskalMst2 instance = new MyKruskalMst2();
		Graph graph= instance.new Graph(4, 5);
		graph.addEdge(0, 1, 10);// 0-1
		graph.addEdge(0, 2,  6);// 0-2
		graph.addEdge(0, 3,  5);// 0-3
		graph.addEdge(1, 3, 15);// 1-3
		graph.addEdge(2, 3,  4);// 2-3
		instance.calculateKruskalMST(graph);
		
		int pathWeight=0;
		for(Edge e: instance.getMst()) {
			System.out.println(e.source+" "+e.destination+"["+e.weight+"]");
			pathWeight+=e.weight;
		}
		System.out.println("Total weight of MST: "+pathWeight);
	}

}
