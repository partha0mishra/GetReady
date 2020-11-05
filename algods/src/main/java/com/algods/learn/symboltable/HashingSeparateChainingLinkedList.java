package com.algods.learn.symboltable;

import java.util.*;
public class HashingSeparateChainingLinkedList{
	class KVP{
		int key, val;
		public KVP(int k, int v) {
			this.key=k;
			this.val=v;
		}
	}
	
	private LinkedList<KVP>[] table;
	int tableSize=4;
	int totalPairs=0;
	public HashingSeparateChainingLinkedList() {
		table= new LinkedList[tableSize];
		for(int i=0; i<tableSize; i++)
			table[i]= new LinkedList<KVP>();
	}
	public void put(int key, int value) {
		Iterator<KVP> it=table[hash(key)].iterator();
		boolean modified=false;
		while(it.hasNext()) {
			KVP kvp=it.next();
			if(kvp.key==key) {
				kvp.val=value;
				modified=true;
				return;
			}
		}
		if(!modified) {
			System.out.println("New Entry "+key+" "+value);
			table[hash(key)].add(new KVP(key, value));
			totalPairs++;
			resize();
		}
	}
	private void resize() {
		if(totalPairs/tableSize < 10 )return;
		System.out.println("Resize called at: "+tableSize);
		tableSize=3*tableSize+1;// otherwise the hash function would go for a TOSS
		LinkedList<KVP>[] newTable= new LinkedList[tableSize];
		for(int i=0; i<tableSize; i++) {
			newTable[i]=new LinkedList<KVP>();
		}
		for(int i=0; i<table.length; i++) {
			Iterator<KVP> it= table[i].iterator();
			while(it.hasNext()) {
				KVP element=it.next();
				newTable[hash(element.key)].add(element);
			}
		}
		printTable();
		table=newTable;
		printTable();
	}
	public int get(int key) {
		return search(key, false);
	}
	public int remove(int key) {
		return search(key, true);
	}
	private int search(int key, boolean remove) {
		int result=-1;
		Iterator<KVP> it=table[hash(key)].iterator();
		while(it.hasNext()) {
			KVP kvp=it.next();
			if(kvp.key==key) {
				result=kvp.val;
				if(remove) it.remove();
				break;
			}
		}
		return result;
	}
	private int hash(int key) {
//		return key% tableSize;
		// -1 % 10 == -1 which we certainly don't want for indexing into an array. 
		// Forcing the sign bit to 0 avoids this problem
        return (key & 0x7fffffff) % tableSize;
    }
	
	public void printTable() {
		for(int i=0; i<table.length; i++) {
			for(int j=0; j< table[i].size(); j++) {
				System.out.print("("+table[i].get(j).key+","+table[i].get(j).val+") ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		HashingSeparateChainingLinkedList instance= new HashingSeparateChainingLinkedList();
		int numbers=100;
		instance.put(0, 10);
		instance.printTable();
		instance.put(0, 20);
		for(int i=0; i<numbers; i++) {
			int val=i*10;//random.nextInt();
			instance.put(i, val);
			int check=instance.get(i);
			if(val != check) System.out.println("Wrong "+val+" <> "+check);
		}
		instance.get(4);
		instance.printTable();
		instance.remove(4);
		instance.printTable();
		instance.remove(20);
		instance.remove(36);
		instance.remove(52);
		instance.remove(68);
		instance.remove(84);
		instance.printTable();
		instance.remove(4);
		// check that put() updates existing value
		for(int i=0; i<numbers; i++) {
			int val=i*10+1;//random.nextInt();
			instance.put(i, val);
			int check=instance.get(i);
			if(val != check) System.out.println("Wrong "+val+" <> "+check);
		}
		instance.printTable();
	}

}
