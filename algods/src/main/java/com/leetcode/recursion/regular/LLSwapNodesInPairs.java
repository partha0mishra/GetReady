package com.leetcode.recursion.regular;

import com.leetcode.linkedList.ListNode;
// TODO Anki
/* 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes. Only nodes itself may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 */
public class LLSwapNodesInPairs {
	/* Approach 02: Iterative
	 * WATCH OUT for the dummy node
	 * O(N) O(1) */
	public ListNode swapPairs(ListNode head) {
//		if(head == null || head.next== null) return head;
		ListNode dummy=new ListNode(-1);
		dummy.next=head;
		ListNode prevNode= dummy;
		
		while(head != null && head.next != null) {
			ListNode first=head;
			ListNode second=head.next;
			// swap
			prevNode.next=second;// new head/ attachment
			first.next=second.next;// taking the rest of the list behind first node
			second.next=first;// new order
			prevNode=first;// for next iteration
			head=first.next;// jumping for the next loop
		}
		return dummy.next;
	}
	/* Approach 01: swap the first two nodes and Recurse with the rest of the list. 
	 * O(N) O(N) for recursion stack */
//	public ListNode swapPairs(ListNode head) {
//        if(head == null || head.next== null) return head;
//        ListNode hn= head.next;
//        head.next=swapPairs(head.next.next);
//        hn.next=head;
//        return hn;
//    }
}
