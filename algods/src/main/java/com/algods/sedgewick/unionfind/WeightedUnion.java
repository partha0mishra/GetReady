package com.algods.sedgewick.unionfind;
/**
 * @author Partha.X.Mishra
 * 
 * WeightedUnion
 * Making shorter tree child of a taller tree
 * Reduces worst-time complexity to log(N)
 * Additional space O(N) to keep sizes
 */
public class WeightedUnion {
	private int[] id;
	private int[] size;
	public void initialize(int n) {
		id=new int[n];
		size=new int[n];
		for(int i=0; i<n; i++) {
			id[i]=i;
			size[i]=1;// it would be a disaster to keep it 0
		}
	}
	public void union(int p, int q) {// check the size before union
		System.out.println("Union: "+p+" & "+q);
		int rootP=root(p);
		int rootQ=root(q);
		if(size[rootP] > size[rootQ]) {id[rootQ]=rootP;size[rootP]+=size[rootQ];}
		else {id[rootP] = rootQ; size[rootQ]+=size[rootP];}
	}
	private int root(int p) {
		while(p != id[p]) p=id[p];
		return p;
	}
	public boolean connected(int p, int q) {
		return root(p)==root(q);
	}
	private void print() {
		System.out.printf ("i : ");
		for(int i=0; i<id.length; i++) System.out.printf("%2d",i);
		System.out.printf ("\nid: ");
		for(int i=0; i<id.length; i++) System.out.printf("%2d",id[i]);
		System.out.printf ("\nsz: ");
		for(int i=0; i<id.length; i++) System.out.printf("%2d",size[i]);
		System.out.println("\n-----------------------------------");
	}
	public static void main(String[] args) {
		WeightedUnion instance= new WeightedUnion();
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
