package com.leetcode.queue;

/* 622. Design Circular Queue
 * 
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

Your implementation should support following operations:

MyCircularQueue(k): Constructor, set the size of the queue to be k.
Front: Get the front item from the queue. If the queue is empty, return -1.
Rear: Get the last item from the queue. If the queue is empty, return -1.
enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
isEmpty(): Checks whether the circular queue is empty or not.
isFull(): Checks whether the circular queue is full or not.
 

Example:

MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
circularQueue.enQueue(1);  // return true
circularQueue.enQueue(2);  // return true
circularQueue.enQueue(3);  // return true
circularQueue.enQueue(4);  // return false, the queue is full
circularQueue.Rear();  // return 3
circularQueue.isFull();  // return true
circularQueue.deQueue();  // return true
circularQueue.enQueue(4);  // return true
circularQueue.Rear();  // return 4
 
Note:

All values will be in the range of [0, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in Queue library.
 * */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.assertFalse;

public class MyCircularQueue {/* O(1) O(N) */
	// lock for ThreadSafety - Doesn't change time/space complexity
	private ReentrantLock lock= new ReentrantLock();
	int[] items;
	int head, tail, lastIndex;
	 /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        items=new int[k];
        head=-1; tail=-1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
    	lock.lock();
    	try {
	    	if(isFull()) return false;
	        if(isEmpty()) {head=0;}// first item
	        tail+=1;
	        if(tail == items.length) tail=0;
	        items[tail]=value;
    	}finally {
    		lock.unlock();
    	}
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
    	lock.lock();
    	try {
	        if(isEmpty()) return false;
	        if(head == tail) {head=-1; tail=-1;}// empty, after deletion of current element of course
	        else {
	        	head+=1;
	        	if(head == items.length) head=0;// wrap
	        }
    	}finally {
    		lock.unlock();
    	}
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if(isEmpty()) return -1;
        return items[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if(isEmpty()) return -1;
        return items[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head==-1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (head == tail+1 || (head==0 && tail==items.length -1));
    }
	public static void main(String[] args) {
		MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
		assertTrue(circularQueue.enQueue(1));  // return true
		assertTrue(circularQueue.enQueue(2));  // return true
		assertTrue(circularQueue.enQueue(3));  // return true
		assertFalse(circularQueue.enQueue(4));  // return false, the queue is full
		assertEquals(3,circularQueue.Rear());  // return 3
		assertTrue(circularQueue.isFull());  // return true
		assertTrue(circularQueue.deQueue());  // return true
		assertTrue(circularQueue.enQueue(4));  // return true
		assertEquals(4,circularQueue.Rear());  // return 4
	}
}
