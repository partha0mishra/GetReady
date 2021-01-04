package com.leetcode.design;
/**
 * 716. Max Stack
 * Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.

Implement the MaxStack class:

MaxStack() Initializes the stack object.
void push(int x) Pushes element x onto the stack.
int pop() Removes the element on top of the stack and returns it.
int top() Gets the element on the top of the stack without removing it.
int peekMax() Retrieves the maximum element in the stack without removing it.
int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
 

Example 1:

Input
["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
[[], [5], [1], [5], [], [], [], [], [], []]
Output
[null, null, null, null, 5, 5, 1, 5, 1, 5]

Explanation
MaxStack stk = new MaxStack();
stk.push(5);   // [5] the top of the stack and the maximum number is 5.
stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
stk.top();     // return 5, [5, 1, 5] the stack did not change.
stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
stk.top();     // return 1, [5, 1] the stack did not change.
stk.peekMax(); // return 5, [5, 1] the stack did not change.
stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
stk.top();     // return 5, [5] the stack did not change.
 

Constraints:

-107 <= x <= 107
At most 104 calls will be made to push, pop, top, peekMax, and popMax.
There will be at least one element in the stack when pop, top, peekMax, or popMax is called.
 

Follow up: Could you come up with a solution that supports O(1) for each top call and O(logn) for each other call? 
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class MaxStack {
	/**
	 * Approach 02: 
	 * ArrayDeque - keep elements
	 * TreeMap - keep max
	 */
	Deque<Integer> stack;
	TreeMap<Integer, Integer> map;
	 /** initialize your data structure here. */
    public MaxStack() {
    	stack= new ArrayDeque<>();
    	map= new TreeMap<>();
    }
    /** push element into stack */
    public void push(int x) {
        stack.offerFirst(x);
        map.put(x, map.getOrDefault(x, 0)+1);
    }
    /** Removes element at Top and returns */
    public int pop() {
    	int result=stack.pollFirst();
    	if(map.get(result) > 1) map.put(result, map.get(result)-1);
    	else map.remove(result);
    	return result;
    }
    /** Gets element at Top. NO Removal */
    public int top() {
        return stack.peekFirst();
    }
    /** Gets Max element. NO Removal */
    public int peekMax() {
        return map.lastKey();
    }
    /** Returns Max element. Removes it/ top one if multiple */
    public int popMax() {
        int max=map.lastKey();
        if(map.get(max) >1) map.put(max, map.get(max)-1);
        else map.remove(max);
        stack.remove(max);
        return max;
    }
	/**
	 * Approach 01: using ArrayDeque - loaning all the stack operations O(1)
	 * using Element(val, maxSoFar) to allow quicker peekMax() at O(1)
	 * O(n) extra space
	 * popTop() is O(n)
	 */
//	class Element{
//		int val, max;
//		public Element(int v, int m) {this.val=v; this.max=m;}
//	}
//	Deque<Element> stack;
//	 /** initialize your data structure here. */
//    public MaxStack() {
//    	stack= new ArrayDeque<>();
//    }
//    /** push element into stack */
//    public void push(int x) {
//        if(stack.isEmpty()) {
//        	stack.offerFirst(new Element(x,x));
//        }else {
//        	stack.offerFirst(new Element(x, Math.max(x, stack.peekFirst().max)));
//        }
//    }
//    /** Removes element at Top and returns */
//    public int pop() {
//        return stack.pollFirst().val;
//    }
//    /** Gets element at Top. NO Removal */
//    public int top() {
//        return stack.peekFirst().val;
//    }
//    /** Gets Max element. NO Removal */
//    public int peekMax() {
//        return stack.peekFirst().max;
//    }
//    /** Returns Max element. Removes it/ top one if multiple */
//    public int popMax() {
//        int max=peekMax();
//        Deque<Integer> temp= new ArrayDeque<>();
//        while(!stack.isEmpty()) {
//        	int i=stack.pop().val;
//        	if(i == max) {
//        		while(!temp.isEmpty()) {
//        			push(temp.pop());// pushing back the elements
//        		}
//        		break;
//        	}else temp.push(i);
//        }
//        return max;
//    }
	public static void main(String[] args) {
		MaxStack ms= new MaxStack();
		ms.push(5);
		ms.push(1);
		ms.push(5);
		assertEquals(5,ms.top());// 5
		assertEquals(5,ms.popMax());// 5
		assertEquals(1,ms.top());// 1
		assertEquals(5,ms.peekMax());// 5
		assertEquals(1,ms.pop());// 1
		assertEquals(5,ms.top());// 5
//		/***/
		ms= new MaxStack();
		ms.push(5);
		ms.push(1);
		ms.push(6);
		assertEquals(6, ms.peekMax());//6
		assertEquals(6, ms.popMax());//6
		assertEquals(5, ms.popMax());//5
		assertEquals(1, ms.top());//1
		/**
		 * ["MaxStack","push","popMax","push","push","push","pop","peekMax","push",
		 * "pop","pop","push","peekMax","peekMax","push","peekMax","push","peekMax"]
		 * [[],[-2],[],[-45],[-82],[29],[],[],[40],
		 * [],[],[66],[],[],[-61],[],[98],[]]
		 * */
		ms= new MaxStack();
		ms.push(-2);
		assertEquals(-2, ms.popMax());
		ms.push(-45);
		ms.push(-82);
		ms.push(29);
		assertEquals(29, ms.pop());
		assertEquals(-45,ms.peekMax());
		ms.push(40);
		assertEquals(40, ms.pop());
		assertEquals(-82, ms.pop());
		ms.push(66);
		assertEquals(66,ms.peekMax());
		assertEquals(66,ms.peekMax());
		ms.push(98);
		assertEquals(98,ms.peekMax());
	}

}
