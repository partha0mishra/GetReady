package com.algods.leetcode.sort;
/**
 147. Insertion Sort List
 * 
 * Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */
public class InsertionSortList {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public ListNode insertionSortList(ListNode head) {
		if(head == null) return head;
		ListNode start=head;
		
		while(start.next !=null) {
			ListNode current=start.next, start2=head, prev=head;
			boolean shifted=false;
			while(start2 !=current) {
				if(current.val < start2.val) {
					start.next=current.next;// getting current out of the link
					current.next=start2;
					if(start2 == head) {
						head=current;
					}else{
						prev.next=current;
					}
					shifted=true;
					break;
				}
				prev=start2;
				start2=start2.next;
			}
			if(!shifted) start=start.next;
		}
		return head;
	}
	public static void main(String[] args) {
		InsertionSortList instance = new InsertionSortList();
		ListNode head=instance.new ListNode(4);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(1);
		head.next.next.next=instance.new ListNode(3);
		ListNode result=instance.insertionSortList(head);
		printList(result);
		
		head=instance.new ListNode(-1);
		head.next=instance.new ListNode(5);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(4);
		head.next.next.next.next=instance.new ListNode(0);
		ListNode result1=instance.insertionSortList(head);
		printList(result1);
		
		ListNode result2=instance.insertionSortList(null);
		printList(result2);
	}
	private static void printList(ListNode node) {
		while(node !=null) {
			System.out.print(node.val+" > ");
			node=node.next;
		}
		System.out.println();
	}
}
