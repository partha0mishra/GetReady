package com.leetcode.linkedList;

/**
 * 82. Remove Duplicates from Sorted List II
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveAllDuplicatesSortedList {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 // Done again, with the help of Dummy node this time
	 public ListNode deleteDuplicates(ListNode head) {
		 if(head == null || head.next == null) return head;
		 ListNode dummy=new ListNode();
		 ListNode prev=dummy, current=head; prev.next=current;
		 boolean marked=false;
		 while(current != null) {// current node might need Deletion while being the last one
			 if(current.next != null && current.val == current.next.val) {
				 prev.next=current.next;
				 marked=true;
			 }else if (marked) {// last one in the series of dups
				 prev.next=current.next;
				 marked=false;
			 } else prev=current;
			 current=current.next;
		 }
		 return dummy.next;
	 }
	 // previous approach
//	 public ListNode deleteDuplicates(ListNode head) {
//	        if(head == null) return head;
//	        ListNode previous=head, prevParent=head;
//	        boolean marked=false;
//	        ListNode current=previous.next;
//	        while(current !=null){
//	            if(current.val == previous.val){
//	                marked=true;
//	                // delete current
//	                previous.next=current.next;
//	            }else{
//	                if(marked){
//	                    marked=false;
//	                    // delete previous
//	                    if(previous==head) head=current;
//	                    else  prevParent.next=current;
//	                }else{
//	                    prevParent=previous;
//	                }
//	                previous=current;
//	            }
//	            current=current.next;
//	        }
//	        if(marked){// The last of the duplicates
//	            if(previous==head) head=current;
//	            else  prevParent.next=current;
//	        }
//	        return head;
//	    }
	public static void main(String[] args) {
	}

}
