package com.algods.learn.graphs;

public class ConnectedComponents {
	private boolean[] marked; // for dfs
	private int[] id; // id of connected component
	private int[] size; // size of connected component id
	private int count; // number of connected components
	public ConnectedComponents(Graph graph) {
		marked= new boolean[graph.V()];
		id= new int[graph.V()];
//		size= new int[graph.V()];
		for(int v=0; v<graph.V(); v++) {// check for all vertices
			if(!marked[v]) {
				dfs(graph, v);
				count++;
			}
		}
		size=new int[count+1];
		for(int c: id) size[c]+=1;
	}
	public void dfs(Graph graph, int node) {
		marked[node]=true;// marked in the dfs path
		id[node]=count;// the CC this node belongs to
//		size[count]++;// adding 1 to the size of this CC
		for(int w: graph.adj(node)) {
			if(!marked[w])
			dfs(graph, w);
		}
	}
	public int id(int node) {
		return id[node];
	}
	public int count() {
		return count;
	}
	public boolean connected(int node1, int node2) {
		return id[node1] == id[node2];
	}
	public int size(int c) { return size[c];}
	public static void main(String[] args) {
		Graph graph= new Graph(12);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(10,11);
		
		System.out.println(graph);
		ConnectedComponents cc= new ConnectedComponents(graph);
		int m=cc.count();
		System.out.println("Number of Components: "+m);
		for(int i=0; i< m; i++) System.out.println("Size of CC "+(i+1)+": "+cc.size(i));
	}

}
