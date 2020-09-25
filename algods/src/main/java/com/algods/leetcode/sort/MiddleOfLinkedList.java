package com.algods.leetcode.sort;
/**
 * 876. Middle of the Linked List
 * 
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * Note:The number of nodes in the given list will be between 1 and 100.
 */
public class MiddleOfLinkedList {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	 public ListNode middleNode(ListNode head) {
        ListNode slow=head, fast=head;
        while(fast !=null && fast.next != null) {
        	slow=slow.next;
        	fast=fast.next.next;
        }
        return slow;
	 }
	public static void main(String[] args) {
		MiddleOfLinkedList instance = new MiddleOfLinkedList();
		ListNode head=instance.new ListNode(4);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(1);
		head.next.next.next=instance.new ListNode(3);
		ListNode result=instance.middleNode(head);
		System.out.println(result.val);
		
		head=instance.new ListNode(-1);
		head.next=instance.new ListNode(5);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(4);
		head.next.next.next.next=instance.new ListNode(0);
		ListNode result1=instance.middleNode(head);
		System.out.println(result1.val);
		
		head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(4);
		head.next.next.next.next=instance.new ListNode(5);
		ListNode result2=instance.middleNode(head);
		System.out.println(result2.val);
		
		head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(4);
		head.next.next.next.next=instance.new ListNode(5);
		head.next.next.next.next.next=instance.new ListNode(6);
		ListNode result3=instance.middleNode(head);
		System.out.println(result3.val);
	}
}
