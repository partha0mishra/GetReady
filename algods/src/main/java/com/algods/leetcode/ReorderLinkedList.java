package com.algods.leetcode;
/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
import java.util.*;
public class ReorderLinkedList {
/**
 * Definition for singly-linked list. */
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
 
    public void reorderList(ListNode head) {
    	if(head == null || head.next==null) return;// single node
    	Stack<ListNode> stack= new Stack<ListNode>();
        ListNode start=head;
        while(start != null) {// pushing into stack
//        	System.out.println(start.val);
        	stack.push(start);
        	start=start.next;
        }
        start=head;// let's start over
        ListNode last=stack.pop();
        while(start !=last && start.next != last) {
        	ListNode origNext=start.next;
        	start.next=last;
        	last.next=origNext;
        	start=origNext;
        	last=stack.pop();
        }
        last.next=null;
    }
    public ListNode createTree(int[] values) {
    	if(values.length <1) return null;
    	ListNode head=null;
    	ListNode prev=null;
    	for(int v: values) {
    		ListNode thisNode= new ListNode(v);
    		if(prev != null) prev.next=thisNode;
    		else head=thisNode;// first node
    		prev=thisNode;
    	}
    	return head;
    }
    public void printTree(ListNode head) {
    	while(head != null) {
    		System.out.printf("%2d ",head.val);
    		head=head.next;
    		if(head != null) System.out.printf("-> ");
    	}
    	System.out.println();
    }
	public static void main(String[] args) {
		ReorderLinkedList instance= new ReorderLinkedList();
		ListNode tree0=instance.createTree(new int[] {1,2});
		instance.printTree(tree0);
		instance.reorderList(tree0);
		instance.printTree(tree0);
		ListNode tree=instance.createTree(new int[]{1,2,3,4});
		instance.printTree(tree);
		instance.reorderList(tree);
		instance.printTree(tree);
		ListNode tree2=instance.createTree(new int[] {1,2,3,4,5});
		instance.printTree(tree2);
		instance.reorderList(tree2);
		instance.printTree(tree2);
	}

}
