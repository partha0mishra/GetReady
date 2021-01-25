package com.leetcode._explore;

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
	
	class Digraph  {  
	    private int V;
	    private ArrayList<ArrayList<Integer>> adj;
	    private boolean hasCycle;
	    private int[] edgeTo;
	    private boolean[] onStack;
	    boolean visited[];
	    private Stack<Integer> stackCycle;
	    
	    Digraph(int v){  
	        V = v;
	        adj = new ArrayList<ArrayList<Integer>>(v);  
	        for (int i=0; i<v; i++)  
	            adj.add(new ArrayList<Integer>());
	        hasCycle=false;
	        edgeTo=new int[v];
	        onStack=new boolean[v];
	        visited= new boolean[v];
	        for (int i = 0; i < V; i++)  
	            visited[i] = false;
	    }  
	    
	    void addEdge(int v,int w) { 
	    	adj.get(v).add(w); 
	    }  
	    
	    void dfs(int v, ArrayList<Integer> courses) { 
	        visited[v] = true;
	        onStack[v] = true;
	        
	        Iterator<Integer> it = adj.get(v).iterator();  
	        while (it.hasNext())  {
	        	int w = it.next();
	        	if(stackCycle != null) {
		        	System.out.println("- cycle- short - circuit -");
		        	return;
		        } else if (!visited[w]) {
		        	edgeTo[w]=v;
		        	dfs(w, courses);
		        } else if(onStack[w]) {// visited already, but remember, this is a Directed graph
//		        	System.out.println("ever");
		        	stackCycle = new Stack<Integer>();
		        	for(int x=v; x !=w; x = edgeTo[x])
		        		stackCycle.push(x);
		        	stackCycle.push(w);
//		        	stackCycle.push(v);
		        	
		        	if(stackCycle !=null) {
		        		int first = -1, last = -1;
		                for (int c : stackCycle) {
		                    if (first == -1) first = c;
		                    last = c;
		                }
		                if (first != last) {
//		                    System.err.printf("cycle begins with %d and ends with %d\n", first, last);
		                    hasCycle=true;
		                }
		        	}
		        }
	        }
	        onStack[v]=false;
	        courses.add(v);
	    }  
	    
	    int[] topologicalSort(int numCourses)  {  
	        ArrayList<Integer> courses = new ArrayList<Integer>();
	        int[] result;
	        for (int i = 0; i < V; i++)
	            if (visited[i] == false && !hasCycle) {
	            	dfs(i, courses);
	            }
	    
	        int c=0;
	        if(hasCycle) {
	        	result= new int[0];
//	        	System.out.println("in "+result);
	        }else {
	        	result=new int[numCourses];
		        for(int i: courses) {
//		        	System.out.println(i+" ");
		        	result[c++]=i;
		        }
	        }
	        return result;
	    }
	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result;
        Digraph G= new Digraph(numCourses);
        for(int[] edge: prerequisites) {
        	G.addEdge(edge[0], edge[1]);
        }
        
        result= G.topologicalSort(numCourses);
//        System.out.println(Arrays.toString(result));
        return result;
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new CourseSchedule2().findOrder(2, new int[][]{{1,0}})));
		System.out.println(Arrays.toString(new CourseSchedule2().findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
		System.out.println(Arrays.toString(new CourseSchedule2().findOrder(2, new int[][]{{1,0},{0,1}})));// should be empty set
		System.out.println(Arrays.toString(new CourseSchedule2().findOrder(3, new int[][]{{0,1},{0,2},{1,2}})));
	}

}
