package com.algods.leetcode.linkedList;

/**
 * 83. Remove Duplicates from Sorted List
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesSortedList {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        Integer val=head.val;// initial value
        ListNode prev=head;
        ListNode start=head.next;// first place where duplicates can be
        while(start !=null){
            if(start.val != val) {
                val=start.val;
                prev=start;
                start=start.next;
            }else{
                start=start.next;
                prev.next=start;
            }
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
