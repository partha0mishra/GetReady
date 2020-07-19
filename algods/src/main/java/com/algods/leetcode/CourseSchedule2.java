package com.algods.leetcode;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * @author Partha.X.Mishra
 *
 *Input: 2, [[1,0]] 
 *Output: [0,1]
 *Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
 *course 0. So the correct course order is [0,1] .
 *
 *Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 *Output: [0,1,2,3] or [0,2,1,3]
 *Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
 *courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
 *So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 */
import java.util.*;

public class CourseSchedule2 {
	private Iterable<Integer> order;
	
	class Bag<Item> implements Iterable<Item>{
		private Node<Item> first;
		private int n;
		
		private class Node<Item>{
			private Item item;
			private Node<Item> next;
		}
		public Bag() {
			first=null;
			n=0;
		}
		public boolean isEmpty() {
			return n==0;
		}
		public int size(){
			return n;
		}
		public void add(Item item) {
			Node<Item> oldFirst=first;
			first= new Node<Item>();
			first.item=item;
			first.next=oldFirst;
		}
		public Iterator<Item> iterator(){
			return new LinkedIterator(first);
		}
		private class LinkedIterator implements Iterator<Item> {
	        private Node<Item> current;

	        public LinkedIterator(Node<Item> first) {
	            current = first;
	        }

	        public boolean hasNext()  { return current != null;                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public Item next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            Item item = current.item;
	            current = current.next; 
	            return item;
	        }
	    }
	}
	class Digraph{
		private final int Vertices;
		private int Edges;
		private Bag<Integer>[] adjacents;
		private int[] indegree;
		
		public Digraph(int v) {
			this.Vertices=v;
			this.Edges=0;
			adjacents=(Bag<Integer>[]) new Bag[v];
			for (int i = 0; i < Vertices; i++) {
	            adjacents[v] = new Bag<Integer>();
	        }
		}
		public void addEdge(int v, int w) {
	        validateVertex(v);
	        validateVertex(w);
	        adjacents[v].add(w);
	        indegree[w]++;
	        Edges++;
	    }
		public Iterable<Integer> adj(int v) {
	        validateVertex(v);
	        return adjacents[v];
	    }
	    public int outdegree(int v) {
	        validateVertex(v);
	        return adjacents[v].size();
	    }
		public int V() {
			return Vertices;
		}
		public int E() {
			return Edges;
		}
		private void validateVertex(int v) {
	        if (v < 0 || v >= Vertices)
	            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (Vertices-1));
	    }
	    public String toString() {
	        StringBuilder s = new StringBuilder();
	        s.append(Vertices + " vertices, " + Edges + " edges \n");
	        for (int v = 0; v < Vertices; v++) {
	            s.append(String.format("%d: ", v));
	            for (int w : adjacents[v]) {
	                s.append(String.format("%d ", w));
	            }
	            s.append("\n");
	        }
	        return s.toString();
	    }
	}
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = null;
        Digraph G= new Digraph(prerequisites.length);
        for(int[] edge: prerequisites) {
        	G.addEdge(edge[0], edge[1]);
        }
        
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
            
        }
        
        return result;
    }
	public static void main(String[] args) {
		System.out.println(new CourseSchedule2().findOrder(2, new int[][]{{1,0}}));
		System.out.println(new CourseSchedule2().findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
	}

}
