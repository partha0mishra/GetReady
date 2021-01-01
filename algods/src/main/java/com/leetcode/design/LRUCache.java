package com.leetcode.design;
/** TODO Anki
 * LRU Cache
 * 
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
Follow up:
Could you do get and put in O(1) time complexity?

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
At most 3 * 104 calls will be made to get and put.
 */
import java.util.*;
public class LRUCache {
	// keep key-access time in a linkedList/ queue
	// keep key-<val, access time> in a hashmap
	// search in the hashmap for get()
	// at put, add an entry to the end of LinkedList/ queue
	// evict from the beginning of the LinkedList. Check whether the accessTime matches (latest) for that key in HM
	class KeyAccess{
		int accessTime, key;
		public KeyAccess(int k, int a) {this.key=k; this.accessTime=a;}
	}
	class ValAccess{
		int accesstime, val;
		public ValAccess(int v, int a) {this.val=v; this.accesstime=a;}
	}
	HashMap<Integer,ValAccess> keyVal;
	LinkedList<KeyAccess> keyAccessList;
	static int accessNo=0;
	int capacity;
	public LRUCache(int capacity) {
        keyVal=new HashMap<Integer,ValAccess>();
        keyAccessList=new LinkedList<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!keyVal.containsKey(key)) return -1;
        keyAccessList.add(new KeyAccess(key, accessNo));
        int value=keyVal.get(key).val;
        keyVal.put(key, new ValAccess(value, accessNo));
        accessNo+=1;
        return value;
    }
    public void put(int key, int value) {
        keyVal.put(key, new ValAccess(value,accessNo));
        keyAccessList.add(new KeyAccess(key, accessNo));
        accessNo+=1;
        evict();
    }
    private void evict() {
    	while(keyVal.size() > capacity) {
    		KeyAccess ka=keyAccessList.get(0);
    		int k=ka.key, at=ka.accessTime;
    		keyAccessList.remove(0);
    		if(keyVal.get(k).accesstime == at) {
    			keyVal.remove(k);
    			System.out.println("Evicted "+k+" new size:"+keyVal.size());
    		}
    	}
    }
	public static void main(String[] args) {
		LRUCache lc = new LRUCache(2);
		lc.put(1, 1);
		lc.put(2, 2);
		System.out.println(lc.get(1));
		lc.put(3, 3);
		System.out.println(lc.get(2));
		lc.put(4, 4);
		System.out.println(lc.get(1));
		System.out.println(lc.get(3));
		System.out.println(lc.get(4));
	}
}
