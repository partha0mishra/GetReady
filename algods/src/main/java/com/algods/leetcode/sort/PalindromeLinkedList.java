package com.algods.leetcode.sort;
/**
 * 234. Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * Example 1:
 * Input: 1->2
 * Output: false
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	 public boolean isPalindrome(ListNode head) {
		 if(head == null) return true;
		 // let's find the middle first
		 ListNode slow=head, fast=head, prev=head;
		 while(fast != null && fast.next !=null) {
			 prev=slow;
			 slow=slow.next;
			 fast=fast.next.next;
		 }// now mid is @slow. Let's reverse the LL
		 while(slow !=null && slow.next !=null) {
			 ListNode toMove=slow.next;
			 slow.next=slow.next.next;
			 toMove.next=prev.next;
			 prev.next=toMove;
		 }
		 slow=prev.next;// starting comparison from here
		 prev=prev.next;// head ends before this
		 while(head !=prev && slow !=null) {
			 if(head.val != slow.val) return false;
			 head=head.next;
			 slow=slow.next;
		 }
		 return true;
	 }
	public static void main(String[] args) {
		PalindromeLinkedList instance = new PalindromeLinkedList();
		ListNode head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		boolean result=instance.isPalindrome(head);
		System.out.println(result);
		
		head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(2);
		head.next.next.next=instance.new ListNode(1);
		boolean result1=instance.isPalindrome(head);
		System.out.println(result1);
		
		head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(2);
		head.next.next.next.next=instance.new ListNode(1);
		boolean result2=instance.isPalindrome(head);
		System.out.println(result2);
		
		head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(3);
		head.next.next.next.next=instance.new ListNode(2);
		head.next.next.next.next.next=instance.new ListNode(1);
		boolean result3=instance.isPalindrome(head);
		System.out.println(result3);
	}
}
