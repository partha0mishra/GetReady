package com.algods.sedgewick.unionfind;

import static org.junit.Assert.assertTrue;

/**
 * QuickFind:
 * Initialize O(N), Union O(N), Find O(1)
 * 
 * Eager approach -> do a thorough union -> change id[all belonging to the group] to the new id.
 * To run Union on N elements, it actually ends up taking N2 time, as each run will take O(N) time.
 */
public class QuickFind {
	private int[] id;
	public QuickFind(int n) {
		id= new int[n];
		for(int i=0; i<n ; i++) id[i]=i;
	}
	public void union(int p, int q) {
		if(connected(p,q)) return;// don't waste time if they're already connected.
		int pid= id[p];
		for(int i=0; i<id.length; i++)
			if(id[i] == pid) id[i]=id[q];
	}
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	public void print() {
		for(int i=0; i<id.length; i++) {
			System.out.println(i+" "+id[i]);
		}
		System.out.println("---");
	}
	public static void main(String[] args) {
		QuickFind instance= new QuickFind(10);
		instance.print();
		instance.union(2, 4);
		System.out.println(instance.connected(0, 1));
		instance.print();
		instance.union(4, 5);
		instance.print();
		instance.union(8, 9);
		instance.print();
		instance.union(1, 9);
		instance.print();
		instance.union(0, 3);
		instance.print();
		instance.union(5, 3);
		instance.print();
		instance.union(6, 7);
		instance.print();
		instance.union(6, 9);
		instance.print();
		instance.union(0, 1);
		instance.print();
		assertTrue(instance.connected(0, 1));
		System.out.println(instance.connected(0, 1));
	}
}
