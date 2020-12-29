package com.leetcode._explore;
/* Plus One Linked List
 * 
 * Given a non-negative integer represented as a linked list of digits, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list.
 * Example 1:
 * Input: head = [1,2,3]
 * Output: [1,2,4]
 * Example 2:
 * Input: head = [0]
 * Output: [1]
 * Constraints:
 * The number of nodes in the linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * The number represented by the linked list does not contain leading zeros except for the zero itself. 
 */
public class PlusOneLinkedList {
	/**
	* Definition for singly-linked list.
	*/
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public ListNode plusOne(ListNode head) {
	    // sentinel head
	    ListNode sentinel = new ListNode(0);
	    sentinel.next = head;
	    ListNode notNine = sentinel;
	    
	    // find the rightmost not-nine digit
	    while (head != null) {
	      if (head.val != 9) notNine = head;
	      head = head.next;
	    }
	    
	    // increase this rightmost not-nine digit by 1
	    notNine.val++;
	    notNine = notNine.next;
	    
	    // set all the following nines to zeros
	    while (notNine != null) {
	      notNine.val = 0;
	      notNine = notNine.next;
	    }
	    
	    return sentinel.val != 0 ? sentinel : sentinel.next;
	  }
	/* Recursive - O(N) O(N)*/
//	public ListNode plusOne(ListNode head) {
//		int carry=addOne(head);
//		if(carry>0) {
//			ListNode newHead=new ListNode(carry);
//			newHead.next=head;
//			head=newHead;
//		}
//		return head;
//    }
//	private int addOne(ListNode node) {
//		if(node==null) {
//			return 1;
//		}
//		node.val+=addOne(node.next);
//		int carry=node.val/10;
//		node.val%=10;
//		return carry;
//	}
	public static void main(String[] args) {
	}
}
