package com.algods.leetcode;
/**
 * Design an Iterator class, which has:
 * A constructor that takes a string characters of sorted distinct lowercase English letters and 
 * a number combinationLength as arguments.
 * A function next() that returns the next combination of length combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there exists a next combination.
 * 
 * Example:
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
 * iterator.next(); // returns "ab"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "ac"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "bc"
 * iterator.hasNext(); // returns false
 * 
 * Constraints:
 * 1 <= combinationLength <= characters.length <= 15
 * There will be at most 10^4 function calls per test.
 * It's guaranteed that all calls of the function next are valid.
 */
import java.util.*;
class CombinationIterator {
    
    Stack<Character> st; // stack to store the characters leading to the creation of a single combination
	Map<Character, Integer> ch2Idx; // map to store character to index
    String result, str; // str - same as characters. result -- the result string representing a combination
    int combLength; // same as combinationLength
 
    public CombinationIterator(String characters, int combinationLength) {
        combLength = combinationLength;
        ch2Idx = new HashMap<Character, Integer>();
        str = characters;
        st = new Stack<Character>();
        result = "";
		// create the first combination
        for (Character ch : characters.toCharArray()) {
            st.push(ch);
            result = result + ch;
            if (st.size()==combinationLength) break;
        }
        int idx = 0;
		// set up the mapping between character --> index
        for (Character ch : characters.toCharArray()) {
            ch2Idx.put(ch, idx++);
        }
    }
    
    public String next() {
        String currResult = result;
        // process the next result
      
        int idx = str.length()-1;
		// keep on removing the last character from the stack/result till the position where idx can be moved ahead
        while (!st.isEmpty() && ch2Idx.get(st.peek())==idx) {
            st.pop();
            idx--;
            result = result.substring(0, result.length()-1);  
        }
        if (st.isEmpty()) return currResult; // there is no next result to pre-process
        
        idx = ch2Idx.get(st.pop()); // we need to add elements after this idx
        result = result.substring(0, result.length()-1);
        
        while (st.size()!=combLength) {
            Character temp = str.charAt(++idx);
            result+=temp;
            st.push(temp);
        }
        
        return currResult;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

	public static void main(String[] args) {
		 CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
		 iterator.next(); // returns "ab"
		 iterator.hasNext(); // returns true
		 iterator.next(); // returns "ac"
		 iterator.hasNext(); // returns true
		 iterator.next(); // returns "bc"
		 iterator.hasNext(); // returns false
	}
}
/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
