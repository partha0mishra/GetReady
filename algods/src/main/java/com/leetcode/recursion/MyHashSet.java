package com.leetcode.recursion;
/*
 * Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 *
 *MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)
 *
 * NOTE:
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 */
class MyHashSet {
	private class Elements{ // resizing array of elements. One array per hashed value
		int size;
		int[] arrElements;
		Elements(){
			size=0;// position to fill
			arrElements= new int[1];// initial size
		}
		void add(int e) {
			if(!find(e)) {// it seems we don't need duplicates
				size++;
				if(size > arrElements.length) {
					expand();
				}
				arrElements[size-1]=e;
			}
		}
		boolean find(int e) {
			if(get(e) > -1) return true;
			return false;
		}
		int get(int e) {
			int index=-1;
			for(int i=0; i< size; i++) {
				if(arrElements[i]==e) index=i;
			}
			return index;
		}
		void remove(int e) {
			int index=get(e);// this is where the element is found
			
			if(index > -1) {
				while(index< size -1) {// done shifting
					arrElements[index++]=arrElements[index];
				}
				arrElements[index]=0;
				size --;// one less element to deal with
			}
			shrink();
		}
		
		void expand() {
			int[] tempArray=new int[arrElements.length*2];
			for(int i=0; i<arrElements.length; i++) {
				tempArray[i]=arrElements[i];
			}
			arrElements=tempArray;
		}
		void shrink() {
			if(size < arrElements.length/4) {
				int[] tempArray= new int[arrElements.length/4];
				for(int i=0; i< size; i++) {
					tempArray[i]=arrElements[i];
				}
				arrElements=tempArray;
			}
		}
	}
	
	private static final int HASH_NUM=1007;
	private Elements[] hashes;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashes= new Elements[HASH_NUM];
        for(int i=0; i< HASH_NUM; i++) {
        	hashes[i]= new Elements();
        }
    }
    
    public void add(int key) {
        int mod=key%HASH_NUM;
        hashes[mod].add(key);
    }
    
    public void remove(int key) {
        int mod=key%HASH_NUM;
        hashes[mod].remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int mod=key%HASH_NUM;
        return hashes[mod].find(key);
    }
    
    public static void main(String[] args) {
    	MyHashSet hashSet= new MyHashSet();
    	hashSet.add(1);         
    	hashSet.add(2);         
    	System.out.println(hashSet.contains(1));    // returns true
    	System.out.println(hashSet.contains(3));    // returns false (not found)
    	hashSet.add(2);          
    	System.out.println(hashSet.contains(2));    // returns true
    	hashSet.remove(2);
    	System.out.println(hashSet.contains(2));    // returns false (already removed)
    	System.out.println(hashSet.contains(0));    // returns false
    	hashSet.add(0);
    	System.out.println(hashSet.contains(0));    // returns true
    	hashSet.remove(0);
    	System.out.println(hashSet.contains(0));    // returns false
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
