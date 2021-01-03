package com.leetcode.design;
/** TODO Anki
 * Flatten Nested List Iterator
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
	public class NestedIterator implements Iterator<Integer> {
		List<NestedInteger> nestedList;
		int arrayNo, elementNo;
	    public NestedIterator(List<NestedInteger> nestedList) {
	        this.nestedList=nestedList;
	        arrayNo=0; elementNo=0;
	    }

	    @Override
	    public Integer next() {
	    	gotoNext();
	    	Integer result;
	    	if(nestedList.get(arrayNo).isInteger()) result=nestedList.get(arrayNo).getInteger();
	    	else result=nestedList.get(arrayNo).getList().get(elementNo++).getInteger();
	    	return result;
	    }

	    @Override
	    public boolean hasNext() {
	        gotoNext();
	        return arrayNo < nestedList.size();
	    }

		private void gotoNext() {
			while(arrayNo < nestedList.size() && getSize(nestedList.get(arrayNo))==elementNo) {
				arrayNo+=1;
				elementNo=0;
			}
		}
		private int getSize(NestedInteger ni) {
			if(ni.isInteger()) return 1;
			else return ni.getList().size();
		}
	}
	/**
	 * Your NestedIterator object will be instantiated and called as such:
	 * NestedIterator i = new NestedIterator(nestedList);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
	public static void main(String[] args) {
	}
}
