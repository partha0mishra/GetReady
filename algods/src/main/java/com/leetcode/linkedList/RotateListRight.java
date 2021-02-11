package com.leetcode.linkedList;
/**
 * 61 Rotate List
 * 
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 * */
public class RotateListRight {
	/**
	 * Approach 02:
	 */
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null) return head;
        int length=1;// let's find the length first
        ListNode current=head;
        while(current.next !=null){
            current=current.next;
            length++;
        }
        k=k%length;// the is the 'real' rotation we need to do
        // System.out.println(k+" "+length);
        for(int i=1; i<= k; i++){
            current=head;
            while(current.next.next != null){// at the end, current.next will be the last node
                current=current.next;
            }
            current.next.next=head;// connecting last node to the Head
            head=current.next;// changing 'head' pointer
            current.next=null;// ending the list at the previous node
        }
        return head;
    }
	/**
	 * Approach 01:
	 * 
	 */
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null) return head;
        int length=1;// let's find the length first
        ListNode current=head;
        while(current.next !=null){
            current=current.next;
            length++;
        }
        k=k%length;// the is the 'real' rotation we need to do
        // System.out.println(k+" "+length);
        for(int i=1; i<= k; i++){
            current=head;
            while(current.next.next != null){// at the end, current.next will be the last node
                current=current.next;
            }
            current.next.next=head;// connecting last node to the Head
            head=current.next;// changing 'head' pointer
            current.next=null;// ending the list at the previous node
        }
        return head;
    }
}
