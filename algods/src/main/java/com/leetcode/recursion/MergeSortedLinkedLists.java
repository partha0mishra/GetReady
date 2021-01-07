package com.leetcode.recursion;

/** TODO Anki
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
	 /* Approach 03: Iterative O(m+n) O(1)*/
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ListNode dummy= new ListNode(-1);
		 ListNode current=dummy;
		 while(l1 != null || l2 != null) {
			 if(l1 == null) {current.next=l2; break;}
			 if(l2 == null) {current.next=l1; break;}
			 if(l1.val < l2.val) {current.next=l1; l1=l1.next;}
			 else {current.next = l2; l2=l2.next;}
			 current=current.next;
		 }
		 return dummy.next;
	 }
	 /* Approach 02: recursive O(m+n) O(m+n) */
//	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//	        if(l1 == null) return l2;
//	        if(l2 == null) return l1;
//	        ListNode head;
//	        if(l1.val < l2.val) {
//	            head= l1;
//	            l1=l1.next;
//	        }else{
//	            head=l2;
//	            l2=l2.next;
//	        }
//	        head.next=mergeTwoLists(l1,l2);
//	        return head;
//	    }
	 /* Approach 01: Brute*/
//	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		 if(l1 == null) return l2;
//		 if(l2 == null) return l1;
//		 ListNode head=null, prev=null, current;
//		 while(l1 != null || l2 != null) {
//			 if(l1 == null) {
//				 current=new ListNode(l2.val);
//				 l2=l2.next;
//			 }else if(l2 == null) {
//				 current=new ListNode(l1.val);
//				 l1=l1.next;
//			 }else if(l1.val <= l2.val) {
//				 current=new ListNode(l1.val);
//				 l1=l1.next;
//			 }else {
//				 current=new ListNode(l2.val);
//				 l2=l2.next;
//			 }
//			 
//			 if(prev==null) {
//				 head=current;
//				 prev=current;
//			 }else {
//				 prev.next=current;
//				 prev=current;
//			 }
//		 }
//		 return head;
//	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
