package com.algods.learn.graphs.directed;

public class DirectedCycle {
	private boolean[] marked;// marking of dfs
	public boolean hasCycle(Digraph graph) {
		
		for(int v=0; v< graph.V(); v++) {
			marked= new boolean[graph.V()];// start afresh, otherwise
			// even a previously marked vertex at downstream will cause issues
				if(hasCycle(graph,v)) return true;
		}
		return false;
	}
	private boolean hasCycle(Digraph g, int v) {
		marked[v]=true;
		for(int w: g.adj(v)) {
			if(marked[w]) return true;
			if(hasCycle(g,w)) return true;
		}
		marked[v]=false;// can't keep it marked for a DIRECTED cycle
		return false;
	}
	public boolean marked(int node) {
		return marked[node];
	}
	public static void main(String[] args) {
		Digraph graph= new Digraph(13);
		graph.addEdge(0,5);		graph.addEdge(0,1);		graph.addEdge(2,0);		graph.addEdge(2,3);
		System.out.println(graph);
		System.out.println(new DirectedCycle().hasCycle(graph));// no cycle
		
//		graph.addEdge(3,5);// not a DIRECTED cycle
//		System.out.println(graph);
//		System.out.println(new DirectedCycle().hasCycle(graph));// no cycle
		graph.addEdge(3,2);// creates a cycle
		System.out.println(graph);
		System.out.println(new DirectedCycle().hasCycle(graph));// has cycle
		
				graph.addEdge(4,3);		graph.addEdge(4,2);
		graph.addEdge(5,4);		graph.addEdge(6,9);		graph.addEdge(6,4);		graph.addEdge(6,8);
		graph.addEdge(6,0);		graph.addEdge(7,6);		graph.addEdge(7,9);		graph.addEdge(8,6);
		graph.addEdge(9,11);		graph.addEdge(9,10);		graph.addEdge(10,12);		graph.addEdge(11,4);
		graph.addEdge(11,12);		graph.addEdge(12,9);
		
	}

}
