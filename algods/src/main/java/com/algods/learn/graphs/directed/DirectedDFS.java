package com.algods.learn.graphs.directed;

public class DirectedDFS {
	private boolean[] marked;// marking of dfs
	private int count;
	public DirectedDFS(Digraph graph, int source) {
		marked= new boolean[graph.V()];
		count=0;
		dfs(graph, source);
	}
	private void dfs(Digraph graph, int node) {
		count++;
		if(!marked[node]) {// for cyclic graph
			marked[node]=true;
			for(int n: graph.adj(node)) {
//				if (!marked[n]) 
					dfs(graph, n);
			}
		}
	}
	public int count() {
		return count;
	}
	public boolean marked(int node) {
		return marked[node];
	}
	public static void main(String[] args) {
		Digraph graph= new Digraph(13);
		graph.addEdge(0,5);		graph.addEdge(0,1);		graph.addEdge(2,0);		graph.addEdge(2,3);
		graph.addEdge(3,5);		graph.addEdge(3,2);		graph.addEdge(4,3);		graph.addEdge(4,2);
		graph.addEdge(5,4);		graph.addEdge(6,9);		graph.addEdge(6,4);		graph.addEdge(6,8);
		graph.addEdge(6,0);		graph.addEdge(7,6);		graph.addEdge(7,9);		graph.addEdge(8,6);
		graph.addEdge(9,11);		graph.addEdge(9,10);		graph.addEdge(10,12);		graph.addEdge(11,4);
		graph.addEdge(11,12);		graph.addEdge(12,9);
		System.out.println(graph);
		int source=0;
		DirectedDFS ddfs= new DirectedDFS(graph, source);
		for(int v=0; v< graph.V(); v++) {
			if(ddfs.marked(v)) System.out.print(v+" ");
		}
	}

}
