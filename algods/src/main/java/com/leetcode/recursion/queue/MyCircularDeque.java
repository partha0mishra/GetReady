package com.leetcode.recursion.queue;

import java.util.Arrays;

/* 641. Design Circular Deque
 * Design your implementation of the circular double-ended queue (deque).

Your implementation should support following operations:

MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not. 
isFull(): Checks whether Deque is full or not.
 

Example:

MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
circularDeque.insertLast(1);			// return true
circularDeque.insertLast(2);			// return true
circularDeque.insertFront(3);			// return true
circularDeque.insertFront(4);			// return false, the queue is full
circularDeque.getRear();  			// return 2
circularDeque.isFull();				// return true
circularDeque.deleteLast();			// return true
circularDeque.insertFront(4);			// return true
circularDeque.getFront();			// return 4
 

Note:

All values will be in the range of [0, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in Deque library.
 * */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class MyCircularDeque {
	int[] queue;
	int head, tail, lastIndex;
	/** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        queue= new int[k];
        Arrays.fill(queue, -1);
        head=0; tail=0; lastIndex=k-1;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        int pos=(head ==0)? lastIndex: head-1;
        if(queue[pos] ==-1) {// empty position
        	queue[pos] = value;
        	head=pos;
        	return true;
        }
        return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(queue[tail] == -1) {// empty position
        	queue[tail++] = value;
        	if(tail > lastIndex) tail =0;
        	return true;
        }
        return false;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(queue[head] != -1) {// not empty
        	queue[head++] =-1;
        	if(head > lastIndex) head=0;
        	return true;
        }
        return false;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        int pos=(tail ==0)? lastIndex:tail-1;
        if(queue[pos] !=-1) {
        	queue[pos]=-1;
        	tail=pos;
        	return true;
        }
        return false;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return queue[head];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return queue[(tail ==0)? lastIndex:tail-1];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return queue[head] == -1;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return queue[tail] !=-1;
    }
	public static void main(String[] args) {
		MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
		assertTrue(circularDeque.insertLast(1));			// return true
		assertTrue(circularDeque.insertLast(2));			// return true
		assertTrue(circularDeque.insertFront(3));			// return true
		assertFalse(circularDeque.insertFront(4));			// return false, the queue is full
		assertEquals(2,circularDeque.getRear());  			// return 2
		assertTrue(circularDeque.isFull());				// return true
		assertTrue(circularDeque.deleteLast());			// return true
		assertTrue(circularDeque.insertFront(4));			// return true
		assertEquals(4,circularDeque.getFront());			// return 4
	}
}
