package com.algods.sedgewick.symboltable;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
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
			resize(totalPairs,tableSize);
		}
	}
	private void resize(int totPairs, int tabSize) {
		if(totPairs/tabSize < 10 )return;
		System.out.println("Resize called at: "+tabSize);
		LinkedList<KVP>[] newTable= new LinkedList[2*tabSize];
		for(int i=0; i<newTable.length; i++) {
			newTable[i]=new LinkedList<KVP>();
		}
		tableSize=2*tableSize;// otherwise the hash function would go for a TOSS
		for(int i=0; i<tabSize; i++) {
			for(int j=0; j<table[i].size();j++) {
				KVP kvp=table[i].get(j);
				newTable[hash(kvp.key)].add(kvp);
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
        return (key & 0x7fffffff) % tableSize;
    }
	
	public void printTable() {
		for(int i=0; i<table.length; i++) {
			for(int j=0; j< table[i].size(); j++) {
				System.out.print(table[i].get(j).key+"("+table[i].get(j).val+")");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		HashingSeparateChainingLinkedList instance= new HashingSeparateChainingLinkedList();
		int numbers=10;
		Random random= ThreadLocalRandom.current();
		instance.put(0, 10);
		instance.printTable();
		System.out.println(instance.get(0));
		instance.put(0, 20);
		System.out.println(instance.get(0));
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
