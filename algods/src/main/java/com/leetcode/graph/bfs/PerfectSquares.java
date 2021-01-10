package com.leetcode.graph.bfs;
/* 279. Perfect Squares
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class PerfectSquares {
	/* Complexity ??? */
	public int numSquares(int n) {
        if(n<1) return 0;
        int sqr=1;
        ArrayList<Integer> numbers=new ArrayList<>();
        Queue<Integer> q=new ArrayDeque<>();
        HashSet<Integer> considered= new HashSet<>();
        for(int i=1; sqr<=n; i++) {
        	sqr=i*i;
        	if(sqr ==n) return 1;
        	if(sqr > n) break;
        	numbers.add(sqr);
        	q.offer(sqr);// level 1
        	considered.add(sqr);// don't start with these numbers again
        }
        int level=1;
        while(!q.isEmpty()) {
        	int size=q.size();
        	level+=1;
        	for(int s=0; s< size; s++) {
        		int e=q.poll();
        		for(int i=0; i< numbers.size(); i++) {
        			int tmp=e+numbers.get(i);
        			if(tmp == n) return level;
        			if(tmp < n && considered.add(tmp))// smaller and was not considered earlier 
        				q.offer(tmp);
        		}
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		assertEquals(3, new PerfectSquares().numSquares(12));
	}

}
