package com.leetcode.linkedList.r01;
// TODO Anki
/**
 * 206. Reverse Linked List
 * 
 * Reverse a singly linked list.
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	 /* Iterative O(n) O(1) 
	  * Good one */
	 public ListNode reverseList(ListNode head) {
		 if(head == null || head.next == null) return head;
		 ListNode current=head;
		 while(current !=null && current.next !=null) {
			 ListNode toMove=current.next;
			 current.next=current.next.next;
			 toMove.next=head;
			 head=toMove;
		 }
		 return head;
	 }
	 /* Recursive Approach : quite tricky 
	  * The recursive version is slightly trickier and the key is to work backwards. 
	  * Assume that the rest of the list had already been reversed, now how do I reverse the front part? 
	  * Let's assume the list is: n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
	  * Assume from node nk+1 to nm had been reversed and you are at node nk.
	  * n1 → … → nk-1 → nk → nk+1 �? … �? nm
	  * We want nk+1’s next node to point to nk.
	  * So, nk.next.next = nk;
	  * Be very careful that n1's next must point to Ø. 
	  * If you forget about this, your linked list has a cycle in it. 
	  * This bug could be caught if you test your code with a linked list of size 2.
	  * O(n) O(n) */
//	 public ListNode reverseList(ListNode head) {
//		 if(head == null || head.next == null) return head;
//		 ListNode p=reverseList(head.next); // reversing up to the node to the right
//		 head.next.next=head;// shift: NOTE: WHY NOT p.next=head?? coz p is the last node that has become first now. 
//	 		head.next was the original second node which is the last node now and head needs to go after that 
//		 head.next=null;// Otherwise it's a cycle
//		 return p;
//	 }
	 
	public static void main(String[] args) {
		ReverseLinkedList instance = new ReverseLinkedList();
		ListNode head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		ListNode result=instance.reverseList(head);
		printList(result);
		
		head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(2);
		head.next.next.next=instance.new ListNode(1);
		ListNode result1=instance.reverseList(head);
		printList(result1);
		
		head=instance.new ListNode(1);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(2);
		head.next.next.next.next=instance.new ListNode(1);
		ListNode result2=instance.reverseList(head);
		printList(result2);
		
		head=instance.new ListNode(-1);
		head.next=instance.new ListNode(5);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(4);
		head.next.next.next.next=instance.new ListNode(0);
		ListNode result3=instance.reverseList(head);
		printList(result3);
		
		instance.reverseList(null);
		printList(instance.reverseList(instance.new ListNode(99)));
	}
	private static void printList(ListNode node) {
		while(node !=null) {
			System.out.print(node.val+" > ");
			node=node.next;
		}
		System.out.println();
	}
}
