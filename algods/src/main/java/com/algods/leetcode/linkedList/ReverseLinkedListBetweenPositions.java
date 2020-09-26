package com.algods.leetcode.linkedList;

/**
 * 92. Reverse Linked List II
 * 
 * Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListBetweenPositions {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode start=head, prev=null;
		int pos=1;
		while(pos < m) {
			prev=start;
			start=start.next;
			pos++;
		}
		
		while(pos < n && start!=null && start.next != null) {
			pos++;
			ListNode toMove=start.next;
			start.next=start.next.next;
			if(prev==null) {// IMPORTANT
				toMove.next=head;
				head=toMove;
			}else {
				toMove.next=prev.next;
				prev.next=toMove;
			}
		}
		return head;
	 }
	public static void main(String[] args) {
		ReverseLinkedListBetweenPositions instance = new ReverseLinkedListBetweenPositions();
		ListNode head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(4);
		head.next.next.next.next=instance.new ListNode(5);
		printList(head);
//		printList(instance.reverseBetween(head,1,2));
//		printList(instance.reverseBetween(head,2,3));
//		printList(instance.reverseBetween(head,3,4));
//		printList(instance.reverseBetween(head,4,5));
//		printList(instance.reverseBetween(head,1,5));
//		printList(instance.reverseBetween(head,2,4));
		printList(instance.reverseBetween(head,2,5));
	}
	private static void printList(ListNode node) {
		while(node !=null) {
			System.out.print(node.val+" > ");
			node=node.next;
		}
		System.out.println();
	}
}
