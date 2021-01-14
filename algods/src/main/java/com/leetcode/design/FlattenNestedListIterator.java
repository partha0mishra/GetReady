package com.leetcode.design;
/** TODO Anki
 * 341. Flatten Nested List Iterator
 * Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
 */
import java.util.*;
public class FlattenNestedListIterator {
	/**
	 * // This is the interface that allows for creating nested lists.
	 * // You should not implement it, or speculate about its implementation */
	public interface NestedInteger {
	   // @return true if this NestedInteger holds a single integer, rather than a nested list.
	   public boolean isInteger();
	   // @return the single integer that this NestedInteger holds, if it holds a single integer
	   // Return null if this NestedInteger holds a nested list
	   public Integer getInteger();
	   // @return the nested list that this NestedInteger holds, if it holds a nested list
	   // Return null if this NestedInteger holds a single integer
	   public List<NestedInteger> getList();
	}
	/**
	 * Approach 02: Iterative, keeping index
	 * 
	 */
	public class NestedIterator implements Iterator<Integer> {
		int arrayNo;// keeping similar to the vector2D iterator
		NestedIterator element;
		List<NestedInteger> nestedList;
	    public NestedIterator(List<NestedInteger> nestedList) {
	    	this.nestedList=nestedList;
	    	element=null;
	    }

	    @Override
	    public Integer next() {
	    	hasNext();
	    	if(!nestedList.get(arrayNo).isInteger()) return element.next();
	    	return nestedList.get(arrayNo++).getInteger();
	    }

	    @Override
	    public boolean hasNext() {
	        while(true) {
	        	if(arrayNo >= nestedList.size()) {// passed last element in the original list
	        		return false;
	        	}
	        	if(nestedList.get(arrayNo).isInteger()) {// this element is available to be served in next()
	        		return true;
	        	}
	        	if(element == null) {// next element is not an integer, we know by now. let's have the list
	        		element=new NestedIterator(nestedList.get(arrayNo).getList());
	        	}
	        	if(element.hasNext()) return true;// either an empty list or the end of list
	        	element=null;// element doesn't have anything next. setting it to null so that it's re-populated above
	        	arrayNo+=1;// next element to be looked at in the nestedList
	        }
	    }
	}
	/**
	 * Approach 01- to flatten the list and save it
	 * NOT the best approach as it's consuming extra space
	 * 
	 * Constructor O(N+L) Number of lists + number of iterations
	 * next() O(1)
	 * hasNext() O(1)
	 * extra space: O(N+D) - numbers saved in a separate list + depth of recursion during flattening
	 * 
	 */
//	public class NestedIterator implements Iterator<Integer> {
//		List<Integer> flattenedList;
//		Iterator<Integer> it;
//	    public NestedIterator(List<NestedInteger> nestedList) {
//	    	flattenedList= new ArrayList<>();
//	        flatten(nestedList, flattenedList);
//	        it=flattenedList.iterator();
//	    }
//	    private void flatten(List<NestedInteger> nested, List<Integer> flattened) {
//	    	for(int i=0; i< nested.size(); i++) {
//	    		if(nested.get(i).isInteger()) flattened.add(nested.get(i).getInteger());
//	    		else flatten(nested.get(i).getList(),flattened);
//	    	}
//	    }
//
//	    @Override
//	    public Integer next() {
//	    	return it.next();
//	    }
//
//	    @Override
//	    public boolean hasNext() {
//	        return it.hasNext();
//	    }
//	}
	/**
	 * Your NestedIterator object will be instantiated and called as such:
	 * NestedIterator i = new NestedIterator(nestedList);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
	public static void main(String[] args) {
	}
}
