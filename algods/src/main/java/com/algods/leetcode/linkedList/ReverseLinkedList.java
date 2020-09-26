package com.algods.leetcode.linkedList;

/**
 * 206. Reverse Linked List
 * 
 * Reverse a singly linked list.
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	 public ListNode reverseList(ListNode head) {
		 if(head == null || head.next == null) return head;
		 ListNode current=head;
		 while(current !=null && current.next !=null) {
			 ListNode toMove=current.next;
			 current.next=current.next.next;
			 toMove.next=head;
			 head=toMove;
		 }
		 return head;
	 }
	 
	public static void main(String[] args) {
		ReverseLinkedList instance = new ReverseLinkedList();
		ListNode head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		ListNode result=instance.reverseList(head);
		printList(result);
		
		head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(2);
		head.next.next.next=instance.new ListNode(1);
		ListNode result1=instance.reverseList(head);
		printList(result1);
		
		head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(2);
		head.next.next.next.next=instance.new ListNode(1);
		ListNode result2=instance.reverseList(head);
		printList(result2);
		
		head=instance.new ListNode(-1);
		head.next=instance.new ListNode(5);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(4);
		head.next.next.next.next=instance.new ListNode(0);
		ListNode result3=instance.reverseList(head);
		printList(result3);
		
		instance.reverseList(null);
		printList(instance.reverseList(instance.new ListNode(99)));
	}
	private static void printList(ListNode node) {
		while(node !=null) {
			System.out.print(node.val+" > ");
			node=node.next;
		}
		System.out.println();
	}
}
