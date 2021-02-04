package com.leetcode.linkedList.r01;
/** TODO Anki
 * 142. Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by 
 * continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer 
 * is connected to. Note that pos is not passed as a parameter.
 * Notice that you should not modify the linked list.
 * Follow up:
 * Can you solve it using O(1) (i.e. constant) memory?
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * Constraints:
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 */
import java.util.*;

import com.leetcode.linkedList.ListNode;
public class LinkedListCycle2 {
	/* Approach 02: 
	 * where the slow and fast pointers meet, if slow has taken k steps, the fast has taken 2k steps
	 * and 2k -k = n*r where r is radius of the cycle => k=nr 
	 * If the distance to the cycle-start is s from head 
	 * s= k - m (<- distance from meeting point to the slow pointer) 
	 * => s= nr -m = (n-1)r + (r-m) 
	 * Therefore, one pointer starting from Head and another from the Meeting point where slow pointer already is
	 * there will meet at the meeting point 
	 * 
	 * Another way of looking at it
	 * let : 
	 * a= head to the start of cycle
	 * b= start of cycle to the meeting of slow and fast pointer 
	 * c= meeting point to start of cycle 
	 * so, the slow pointer has traveled (a+b) 
	 * and the fast pointer has traveled (a+b+c+b)
	 * Considering fast pointer has traveled double the distance, 2(a+b)=(a+2b+c) => a=c*/
	public ListNode detectCycle(ListNode head) {
		if(head == null) return null;
		ListNode result=null, slow=head, fast=head;
		boolean hasCycle=false;
		while(fast.next !=null && fast.next.next != null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow == fast) {hasCycle=true; break;}
		}
		
		if(hasCycle) {
			fast=head;// just reusing
			while(fast != slow) {
				fast=fast.next;
				slow=slow.next;
			}
			result=fast;// or slow
		}
		
		return result;
	}
	/* Approach 01: Brute - using HashSet */
//	HashSet<ListNode> hs= new HashSet<>();
//	public ListNode detectCycle(ListNode head) {
//		if(head == null) return null;
//        ListNode result=null;
//        while(head.next != null) {
//        	if(hs.contains(head)) {
//        		result=head; break;
//        	}
//        	else hs.add(head);
//        	head=head.next;
//        }
//        return result;
//    }
}
