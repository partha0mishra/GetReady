package com.leetcode.design;
// TODO Anki
/* 155. Min Stack : NOTE- not removing minimum value, only retrieval
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
Constraints:
Methods pop, top and getMin operations will always be called on non-empty stacks.
 * */
import java.util.*;
public class MinStack {
	class Element{
		int val;
		int minVal;
		public Element(int v, int mv) {
			this.val=v;
			this.minVal=mv;
		}
	}
	private Stack<Element> stack;
	 /** initialize your data structure here. */
    public MinStack() {
    	stack= new Stack<MinStack.Element>();
    }
    
    public void push(int x) {// pushes an element. sets minVal to minimum value so far
        if(stack.isEmpty()) stack.push(new Element(x,x));
        else stack.push(new Element(x,Math.min(x, stack.peek().minVal)));
    }
    
    public void pop() {// Removes the top element
        if(!stack.isEmpty()) stack.pop();
    }
    
    public int top() {// give the top number but DON'T POP
        return stack.peek().val;
    }
    
    public int getMin() {// give the minimum value but DON'T POP
        return stack.peek().minVal;
    }
}
