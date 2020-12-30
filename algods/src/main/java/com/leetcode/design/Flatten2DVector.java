package com.leetcode.design;
/** TODO Anki
 * Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.

 

Example:

Vector2D iterator = new Vector2D([[1,2],[3],[4]]);

iterator.next(); // return 1
iterator.next(); // return 2
iterator.next(); // return 3
iterator.hasNext(); // return true
iterator.hasNext(); // return true
iterator.next(); // return 4
iterator.hasNext(); // return false
 

Notes:

Please remember to RESET your class variables declared in Vector2D, as static/class variables are persisted across multiple test cases. Please see here for more details.
You may assume that next() call will always be valid, that is, there will be at least a next element in the 2d vector when next() is called.
 

Follow up:

As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
public class Flatten2DVector {
	// Approach 01: using ArrayList and Iterator interface
	class Vector2D {
		ArrayList<Integer> elements;
		Iterator<Integer> it;
	    public Vector2D(int[][] v) {
	        elements= new ArrayList<>();
	        for(int[] ve: v) {
	        	for(int e: ve) {
	        		elements.add(e);
	        	}
	        }
	        it=elements.iterator();
	    }
	    
	    public int next() {
	        return it.next();
	    }
	    
	    public boolean hasNext() {
	        return it.hasNext();
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
