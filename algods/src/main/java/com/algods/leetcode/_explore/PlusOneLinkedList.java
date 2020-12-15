package com.algods.leetcode._explore;
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
		int carry=addOne(head);
		if(carry>0) {
			ListNode newHead=new ListNode(carry);
			newHead.next=head;
			head=newHead;
		}
		return head;
    }
	private int addOne(ListNode node) {
		if(node==null) {
			return 1;
		}
		node.val+=addOne(node.next);
		int carry=node.val/10;
		node.val%=10;
		return carry;
	}
	public static void main(String[] args) {
	}
}
