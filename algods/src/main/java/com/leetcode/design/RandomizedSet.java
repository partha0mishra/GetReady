package com.leetcode.design;
/** TODO Anki
 * Randomized Set
 * Implement the RandomizedSet class:

bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
Follow up: Could you implement the functions of the class with each function works in average O(1) time?

 

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 

Constraints:

-231 <= val <= 231 - 1
At most 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.
 */
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
public class RandomizedSet {
	/**
	 * Using ArrayList to keep data and HashMap to keep indices
	 * remove() swaps the element with the last one and then deletes the last one
	 */
	List<Integer> elements;
	Map<Integer, Integer> indices;
	Random random=new Random();
	public RandomizedSet() {
		elements= new ArrayList<>();
		indices=new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(indices.containsKey(val)) return false;
        indices.put(val, elements.size());
        elements.add(elements.size(),val);// this has to come second as the list.size() increases
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(!indices.containsKey(val)) return false;
    	
    	int lastElement=elements.get(elements.size()-1);
    	int index=indices.get(val);
    	elements.set(index, lastElement);
    	indices.put(lastElement,index);// update
    	
    	elements.remove(elements.size()-1);
    	indices.remove(val);// remove the key
    	
    	return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	return elements.get(random.nextInt(elements.size()));
    }
	
	// Approach 01: using HashSet
	// getRandom() is amortized O(1) but not in worst case
//	HashSet<Integer> set;
//	Integer[] elements;
//	boolean changed=false;
//	int position=0;
	/** Initialize your data structure here. */
//    public RandomizedSet() {
//        set=new HashSet<>();
//    }
//    
//    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//    public boolean insert(int val) {
//        boolean result= set.add(val);
//        if(!changed) changed=result;
//        return result;
//    }
//    
//    /** Removes a value from the set. Returns true if the set contained the specified element. */
//    public boolean remove(int val) {
//        boolean result= set.remove(val);
//        if(!changed) changed=result;
//        return result;
//    }
//    
//    /** Get a random element from the set. */
//    public int getRandom() {
//    	if(changed) {
//    		Random r= ThreadLocalRandom.current();
//    		position=0;
//    		elements=set.toArray(new Integer[0]);
//    		for(int i=0; i< elements.length; i++) {
//    			int from=i, to=r.nextInt(i+1), tmp=elements[from];
//    			elements[from]=elements[to]; elements[to]=tmp;
//    		}
//    	}
//    	return elements[position++];
//    }
	public static void main(String[] args) {
		RandomizedSet instance= new RandomizedSet();
		assertTrue(instance.insert(1));
		assertFalse(instance.remove(2));
		assertTrue(instance.insert(2));
		System.out.println(instance.getRandom());
		assertTrue(instance.remove(1));
		assertEquals(2,instance.getRandom());
	}

}
