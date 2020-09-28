package com.algods.leetcode.linkedList;

/**
 * 21. Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new sorted list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeSortedLinkedLists {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 if(l1 == null) return l2;
		 if(l2 == null) return l1;
		 ListNode head=null, prev=null, current;
		 while(l1 != null || l2 != null) {
			 if(l1 == null) {
				 current=new ListNode(l2.val);
				 l2=l2.next;
			 }else if(l2 == null) {
				 current=new ListNode(l1.val);
				 l1=l1.next;
			 }else if(l1.val <= l2.val) {
				 current=new ListNode(l1.val);
				 l1=l1.next;
			 }else {
				 current=new ListNode(l2.val);
				 l2=l2.next;
			 }
			 
			 if(prev==null) {
				 head=current;
				 prev=current;
			 }else {
				 prev.next=current;
				 prev=current;
			 }
		 }
		 return head;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
