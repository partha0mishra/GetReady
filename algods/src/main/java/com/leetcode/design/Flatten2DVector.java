package com.leetcode.design;
/** TODO Anki
 * 251. Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.

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
import java.util.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
public class Flatten2DVector {
	// Approach 03: using 2 pointers
	// if N = number of elements, V = number of arrays
	// Constructor => O(1)
	// goToNext => Going all the way O(N+V) in N moves. Amortized O( (N+V)/N )=> O(1+V/N) => O(V/N)
	// Space complexity => O(1)
	class Vector2D {
		int[][] elements;
		int arrayNo=0, elementNo=0;// two pointers
	    public Vector2D(int[][] v) {
	    	elements=v;
	    }
	    
	    public int next() {
	    	goToNext();// only if the current one is 
	        int result=elements[arrayNo][elementNo++];
	        return result;
	    }
	    
	    public boolean hasNext() {
	        goToNext();
	        return (arrayNo < elements.length);
	    }
	    
	    private void goToNext() {
	    	// NOTE: goToNext is not moving if the current place has a valid number
	    	while(arrayNo < elements.length && elements[arrayNo].length == elementNo) {
	        	arrayNo+=1;
	        	elementNo=0;
	        }
	    }
	}
	// Still a BAD approach since we're using O(N) extra space.
	// Doing a copy for iteration is NOT Acceptable
	// Approach 02: using Queue
//	class Vector2D {
//		Deque<Integer> queue;
//	    public Vector2D(int[][] v) {
//	    	queue=new ArrayDeque<>();
//	        for(int[] v1: v) {
//	        	for(int v2: v1) {
//	        		queue.offerLast(v2);
//	        	}
//	        }
//	    }
//	    
//	    public int next() {
//	        return queue.pollFirst();
//	    }
//	    
//	    public boolean hasNext() {
//	        return queue.peekFirst() != null;
//	    }
//	}
	// Approach 01: using ArrayList and Iterator interface
//	class Vector2D {
//		ArrayList<Integer> elements;
//		Iterator<Integer> it;
//	    public Vector2D(int[][] v) {
//	        elements= new ArrayList<>();
//	        for(int[] ve: v) {
//	        	for(int e: ve) {
//	        		elements.add(e);
//	        	}
//	        }
//	        it=elements.iterator();
//	    }
//	    
//	    public int next() {
//	        return it.next();
//	    }
//	    
//	    public boolean hasNext() {
//	        return it.hasNext();
//	    }
//	}
	public static void main(String[] args) {
		int[][] a1= {{},{}};
		Vector2D v1= new Flatten2DVector().new Vector2D(a1);
		assertFalse(v1.hasNext());// false
		
		int[][] a2= {{1},{}};
		Vector2D v2= new Flatten2DVector().new Vector2D(a2);
		assertTrue(v2.hasNext());
		assertEquals(1,v2.next());
		assertFalse(v2.hasNext());
		
		int[][] a3= {{},{1}};
		Vector2D v3= new Flatten2DVector().new Vector2D(a3);
		assertTrue(v3.hasNext());
		assertEquals(1,v3.next());
		assertFalse(v3.hasNext());
		
		int[][] a4= {{1,2},{3},{4}};
		Vector2D v4= new Flatten2DVector().new Vector2D(a4);
		assertTrue(v4.hasNext());
		assertEquals(1,v4.next());
		assertEquals(2,v4.next());
		assertEquals(3,v4.next());
		assertTrue(v4.hasNext());
		assertTrue(v4.hasNext());
		assertEquals(4,v4.next());
		assertFalse(v4.hasNext());
	}

}
