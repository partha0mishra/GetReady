package com.leetcode.recursion.queue;
/* 225. Implement Stack using Queues
 * 
 * Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. 
You may simulate a queue by using a list or deque (double-ended queue), 
as long as you use only standard operations of a queue.

You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 * */
import java.util.Queue;
import java.util.LinkedList;
public class MyStack {
	Queue<Integer> myStack;
	 /** Initialize your data structure here. */
    public MyStack() {
        myStack= new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        myStack.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int s=myStack.size();
        for(int i=0; i< s-1; i++) myStack.add(myStack.poll());
        int result= myStack.poll();
        return result;
    }
    
    /** Get the top element. */
    public int top() {
    	int s=myStack.size();
        for(int i=0; i< s-1; i++) myStack.add(myStack.poll());
        int result= myStack.poll();
        myStack.add(result);
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return myStack.isEmpty();
    }
	public static void main(String[] args) {
		MyStack stack = new MyStack();

		stack.push(1);
		stack.push(2);  
		System.out.println(stack.top());   // returns 2
		System.out.println(stack.pop());   // returns 2
		System.out.println(stack.empty()); // returns false
	}

}
