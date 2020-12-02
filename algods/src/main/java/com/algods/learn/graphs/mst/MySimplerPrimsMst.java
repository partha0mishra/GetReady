package com.algods.learn.graphs.mst;
/*
 * Trying to implement it using Dijkstra-style template
 * ref: MySimplerDijkstraPQ
 */
import java.util.*;

public class MySimplerPrimsMst {
	class Node implements Comparable<Node>{
		int id, dist;
		public Node(int i, int d) {this.id=i; this.dist=d;}
		@Override
		public int compareTo(Node n) {
			int diff= Integer.compare(dist, n.dist);
			return (diff ==0)? Integer.compare(id, n.id): diff;
		}
	}
	private int[] dist;
	private Set<Integer> mstSet;
	private TreeSet<Node> pq;
	private int V;
	private List<List<Node>> adj;
	public MySimplerPrimsMst(int v) {// initialize all
		this.V=v;
		mstSet= new HashSet<Integer>();
		pq=new TreeSet<Node>();
		dist=new int[V];
		for(int i=0; i< V; i++) dist[i]=Integer.MAX_VALUE;
	}
	public void primsMst(List<List<Node>> a) {// pass the adjacency list
		this.adj=a;
		pq.add(new Node(0,0));// starting with vertex 0, distance/ weight 0
		dist[0]=0;
		int[] parent=new int[V];
		while(mstSet.size() != V && !pq.isEmpty()) {
			int u=pq.pollFirst().id;
			if(mstSet.add(u)) {// new node added. let's process the neighbors
				System.out.println("Added to mst: "+u);
				for(Node v: adj.get(u)) {
					if(!mstSet.contains(v.id) && v.dist<dist[v.id]) {// no point adding a longer edge for the same vertex
						pq.add(new Node(v.id,v.dist));
						dist[v.id]=v.dist;
						parent[v.id]=u;
						System.out.println("Adding link "+u+" - "+v.id+" ["+v.dist+"]");
					}
				}
			}
		}
		// Prints the vertex pair of mst
		System.out.println("from - to");
		for (int o = 1; o < V; o++) 
			System.out.println("   "+parent[o] + " "
							+ "-"
							+ " " + o); 
	}
	public static void main(String[] args) { 
		int V = 9;
		MySimplerPrimsMst pmst = new MySimplerPrimsMst(V);
		// Adjacency list representation of the connected edges 
		List<List<Node> > adj = new ArrayList<List<Node> >();
		// Initialize list for every node 
		for (int i = 0; i < V; i++) { 
			List<Node> item = new ArrayList<Node>(); 
			adj.add(item); 
		}
		// Inputs for the DPQ graph 
		adj.get(0).add(pmst.new Node(1, 4));
		adj.get(0).add(pmst.new Node(7, 7));// for 0-> (7,8), the edges (0-7) and (1-2) are interchangeable in MST
		adj.get(1).add(pmst.new Node(2, 8));
		adj.get(1).add(pmst.new Node(7, 11));
		adj.get(2).add(pmst.new Node(3, 7));
		adj.get(2).add(pmst.new Node(8, 2));
		adj.get(2).add(pmst.new Node(5, 4));
		adj.get(3).add(pmst.new Node(4, 9));
		adj.get(3).add(pmst.new Node(5, 14));
		adj.get(4).add(pmst.new Node(5, 10));
		adj.get(5).add(pmst.new Node(6, 2));
		adj.get(6).add(pmst.new Node(7, 1));
		adj.get(6).add(pmst.new Node(8, 6));
		adj.get(7).add(pmst.new Node(8, 7));
	
		// Method invoked 
		pmst.primsMst(adj); 
		} 
	} 