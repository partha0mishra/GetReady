package com.leetcode.linkedList.r01;
/**
 * 382. Linked List Random Node
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? 
Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
 */
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.leetcode.linkedList.ListNode;
public class LLRandomNode {
	/**
	 * Approach 02: Reservoir Sampling
	 * O(N)/ O(1)
	 */
	private ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LLRandomNode(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int scope = 1, chosenValue = 0;
        ListNode curr = this.head;
        while (curr != null) {
            // decide whether to include the element in reservoir
            if (Math.random() < 1.0 / scope)
                chosenValue = curr.val;
            // move on to the next node
            scope += 1;
            curr = curr.next;
        }
        return chosenValue;
    }
	/**
	 * Approach 01:
	 * Keeping the nodes in a HashMap and returning one at Random.
	 * O(N)/ O(N)
	 */
//	ListNode h;
//	int len;
//	HashMap<Integer,Integer> indexVals;
//	/** @param head The linked list's head.
//    Note that the head is guaranteed to be not null, so it contains at least one node. */
//	public LLRandomNode(ListNode head) {
//	    this.h=head;
//	    indexVals= new HashMap<>();
//	    len=0;
//	    while(head != null) {
//	    	indexVals.put(len, head.val);
//	    	len+=1;
//	    	head=head.next;
//	    }
//	}
//	
//	/** Returns a random node's value. */
//	public int getRandom() {
//	    Random random= ThreadLocalRandom.current();
//	    int r=random.nextInt(len);
//	    return indexVals.get(r);
//	}
}
