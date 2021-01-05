package com.leetcode.design;
/**
 * 379. Design Phone Directory
 * Design a Phone Directory which supports the following operations:

 

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
 

Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);
 

Constraints:

1 <= maxNumbers <= 10^4
0 <= number < maxNumbers
The total number of call of the methods is between [0 - 20000]
 */
import java.util.*;
public class PhoneDirectory {
	/**
	 * Another implementation using HashMap and Next pointer
	 * Similar performance
	 */
	HashMap<Integer, Integer> numsMap;
	int maxNum, current, next;
	/** Initialize your data structure here
	    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public PhoneDirectory(int maxNumbers) {
		this.numsMap=new HashMap<>();// keeping released numbers for searching
		this.maxNum=maxNumbers;// ending at less than this
		this.current=0;// starting from this number
		this.next=-1;// next number
	}
	
	/** Provide a number which is not assigned to anyone.
	    @return - Return an available number. Return -1 if none is available. */
	public int get() {
	    if(!numsMap.isEmpty()) {
	    	int result=next;
	    	next=numsMap.get(next);
	    	numsMap.remove(result);
	    	return result;
	    }
	    if(current< maxNum) return current++;// new
	    return -1;// exhausted
	}
	
	/** Check if a number is available or not. */
	public boolean check(int number) {
	    if(!(number < maxNum)) return false;// no going beyond maxNum
	    if( number < current) return numsMap.containsKey(number);// if it's used, we can only find it if it's released
	    return true;// current <= number < maxNum 
	}
	
	/** Recycle or release a number. */
	public void release(int number) {
		if(number < current && !numsMap.containsKey(number)) {// checking for validity: Edge Case
			numsMap.put(number, next);
			next=number;
		}
	}
	
//	/**
//	 * Keeping released numbers in both a HashSet (for quick search) and ArrayList (for quick delete)
//	 * Performance is faster for both O(T) and O(M)
//	 */
//	HashSet<Integer> released;
//	ArrayList<Integer> numList;
//	int maxNum, current;
//	/** Initialize your data structure here
//	    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
//	public PhoneDirectory(int maxNumbers) {
//		this.released=new HashSet<>();// keeping released numbers for searching
//		this.numList=new ArrayList<>();// keeping numbers again
//		this.maxNum=maxNumbers;// ending at less than this
//		this.current=0;// starting from this number
//	}
//	
//	/** Provide a number which is not assigned to anyone.
//	    @return - Return an available number. Return -1 if none is available. */
//	public int get() {
//	    if(!released.isEmpty()) {
//	    	int num=numList.get(0);
//	    	numList.remove(0);
//	    	released.remove(num);
//	    	return num;
//	    }
//	    if(current< maxNum) return current++;// new
//	    return -1;// exhausted
//	}
//	
//	/** Check if a number is available or not. */
//	public boolean check(int number) {
//	    if(!(number < maxNum)) return false;// no going beyond maxNum
//	    if( number < current) return released.contains(number);// if it's used, we can only find it if it's released
//	    return true;// current <= number < maxNum 
//	}
//	
//	/** Recycle or release a number. */
//	public void release(int number) {
//		if(number < current && released.add(number)) {// checking for validity: Edge Case
//			numList.add(number);
//		}
//	}
	
//	/**
//	 * Use HashSet instead of a Queue - much faster solution
//	 */
//	HashSet<Integer> released;
//	int maxNum, current;
//	/** Initialize your data structure here
//	    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
//	public PhoneDirectory(int maxNumbers) {
//		released=new HashSet<>();// keeping released numbers
//		this.maxNum=maxNumbers;// ending at less than this
//		this.current=0;// starting from this number
//	}
//	
//	/** Provide a number which is not assigned to anyone.
//	    @return - Return an available number. Return -1 if none is available. */
//	public int get() {
//	    if(!released.isEmpty()) {
//	    	int num=released.iterator().next();// recycle
//	    	released.remove(num);
//	    	return num;
//	    }
//	    if(current< maxNum) return current++;// new
//	    return -1;// exhausted
//	}
//	
//	/** Check if a number is available or not. */
//	public boolean check(int number) {
//	    if(!(number < maxNum)) return false;// no going beyond maxNum
//	    if( number < current) return released.contains(number);// if it's used, we can only find it if it's released
//	    return true;// current <= number < maxNum 
//	}
//	
//	/** Recycle or release a number. */
//	public void release(int number) {
//		if(number < current) // checking for validity: Edge Case
//			released.add(number);
//	}
	
	
//	/**
//	 * Tried with a Deque for released and nothing for allocation
//	 * Performance is NOT better somehow
//	 */
//	Deque<Integer> released;
//	int maxNum, current;
//	/** Initialize your data structure here
//	    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
//	public PhoneDirectory(int maxNumbers) {
//		released=new ArrayDeque<>();// keeping released numbers
//		this.maxNum=maxNumbers;// ending at less than this
//		this.current=0;// starting from this number
//	}
//	
//	/** Provide a number which is not assigned to anyone.
//	    @return - Return an available number. Return -1 if none is available. */
//	public int get() {
//	    if(!released.isEmpty()) return released.pollFirst();// recycle
//	    if(current< maxNum) return current++;// new
//	    return -1;// exhausted
//	}
//	
//	/** Check if a number is available or not. */
//	public boolean check(int number) {
//	    if(!(number < maxNum)) return false;// no going beyond maxNum
//	    if( number < current) return released.contains(number);// if it's used, we can only find it if it's released
//	    return true;// current <= number < maxNum 
//	}
//	
//	/** Recycle or release a number. */
//	public void release(int number) {
//		if(number < current && !released.contains(number)) // checking for validity: Edge Case
//			released.offerLast(number);
//	}
	
//	/**
//	 * Easy implementation with 2 HashSets - available and used
//	 * constructor: O(n)
//	 * get O(1), check O(1), release O(1)
//	 * extra space O(n)
//	 */
//	HashSet<Integer> available;
//	HashSet<Integer> used;
//	/** Initialize your data structure here
//	    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
//	public PhoneDirectory(int maxNumbers) {
//		available= new HashSet<>();
//		used=new HashSet<>();
//	    for(int i=0; i<maxNumbers; i++) available.add(i);
//	}
//	
//	/** Provide a number which is not assigned to anyone.
//	    @return - Return an available number. Return -1 if none is available. */
//	public int get() {
//	    if(available.size() ==0) return -1;
//	    int num=available.iterator().next();
//	    used.add(num);
//	    available.remove(num);
//	    return num;
//	}
//	
//	/** Check if a number is available or not. */
//	public boolean check(int number) {
//	    return available.contains(number);
//	}
//	
//	/** Recycle or release a number. */
//	public void release(int number) {
//	    used.remove(number);
//	    available.add(number);
//	}

	/**
	 * Your PhoneDirectory object will be instantiated and called as such:
	 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
	 * int param_1 = obj.get();
	 * boolean param_2 = obj.check(number);
	 * obj.release(number);
	 */
	public static void main(String[] args) {
	}

}
