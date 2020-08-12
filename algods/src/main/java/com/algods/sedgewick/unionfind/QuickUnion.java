package com.algods.sedgewick.unionfind;
/**
 * @author Partha.X.Mishra
 * 
 * QuickUnion - LAZY implementation
 * Doing a union only as a minimum work
 * Finding ROOT is the way of finding connection. Find() takes o(N)
 */
public class QuickUnion {
	private int[] id;
	public void initialize(int n) {
		id= new int[n];
		for(int i=0; i<n; i++) id[i]=i;
	}
	public void union(int p, int q) {
		id[root(p)]=root(q);
	}
	private int root(int p) {
		while(p != id[p]) p=id[p];
		return p;
	}
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	private void print() {
		System.out.printf ("i : ");
		for(int i=0; i<id.length; i++) System.out.printf("%2d",i);
		System.out.printf ("\nid: ");
		for(int i=0; i<id.length; i++) System.out.printf("%2d",id[i]);
		System.out.println("\n-----------------------------------");
	}
	public static void main(String[] args) {
		QuickUnion instance= new QuickUnion();
		instance.initialize(10);
		instance.print();
		instance.union(2, 4);
		System.out.println(instance.connected(0, 1));
		instance.print();
		instance.union(4, 5);
		instance.print();
		instance.union(8, 9);
		System.out.println(instance.connected(2, 4));
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
		System.out.println(instance.connected(0, 1));
	}
}
