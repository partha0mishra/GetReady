package com.algods.leetcode;
/**
 * Remove all elements from a linked list of integers that have value val.
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * 
 * @author Partha.X.Mishra
 *
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveLinkedListVal {
//	 Definition for singly-linked list.	 
	 
//*
	public ListNode removeElements(ListNode head, int val) {
        ListNode current=head;
        ListNode prev=null;
        
        if(head == null) return head;
        
        // traverse, check for value, remove if the value matches
        while(current != null) {
        	ListNode next= current.next;
        	if(current.val == val) {
        		current=null;
        		if(prev == null) {// head node or single-node LL
        			if(next == null) {// single node LL
        				head=null;
        				continue;
        			}else {
        				head=next;
        			}
        		}else {
        			prev.next=next;
        		}
        	}else {
        		prev=current;
        	}
        	current= next;
        }
        
        return head;
    }
//    */

	public void printList(ListNode head, String msg) {
		System.out.print("tree ["+msg+"] ");
		while (head !=null) {
			System.out.print(head.val);
			if(head.next != null) {
				System.out.print(" -> ");
			}
			head = head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		RemoveLinkedListVal instance= new RemoveLinkedListVal();
		
		ListNode head= new ListNode(1);
		head.next= new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		instance.printList(head, "orig");
		
		int val=6;// removing one that has multiple values
		instance= new RemoveLinkedListVal();
		head=instance.removeElements(head,val);
		instance.printList(head,"removed 6");
		
		val=1;// removing head node
		head=instance.removeElements(head,val);
		instance.printList(head, "removed 1");
		
		val=5;// removing last node
		head=instance.removeElements(head,val);
		instance.printList(head, "removed 5");
		
		val=2;// removing a node that makes the list a null LL
		head=instance.removeElements(head,3);
		instance.printList(head, "removed 3");
		head=instance.removeElements(head,4);
		instance.printList(head, "removed 4");
		head=instance.removeElements(head,val);
		instance.printList(head, "removed 2");
		
		head=null;// how does it work on a null LL
		val=1;
		head=instance.removeElements(head,val);
		instance.printList(head,"removed from a NULL tree");
	}

}
