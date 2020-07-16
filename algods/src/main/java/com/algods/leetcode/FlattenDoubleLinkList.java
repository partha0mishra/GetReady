/*
 * Flatten a multi-level, doubly-linked list
 */
package com.algods.leetcode;

//Definition for a Node.
class Node {
 public int val;
 public Node prev;
 public Node next;
 public Node child;
};

public class FlattenDoubleLinkList {
	public Node flatten(Node head) {
		flattenChild(head);// enter with the starting of the list
		navigate(head);
		return head;
    }
	
	private Node flattenChild(Node head) {
		Node current=head;
		Node next=null;
		Node last=null;
		
		while(current != null) {
			last=current;// keeping the last one visited
			if(current.child != null) {
				next=current.next;
				current.next=current.child;
				current.child.prev=current;
				last=flattenChild(current.child);
				last.next=next;
				if(next != null) {
					next.prev=last;
				}
				current.child=null;
			}
			current = current.next;// keep going
		}
		return last;
	}
	
	void navigate(Node head) {
		Node current = head;
		while(current != null) {
			System.out.println("----");
			System.out.println("Current: "+current.val);
			if(current.next != null) {
				System.out.println("Next: "+current.next.val);
			}else {
				System.out.println("Next: "+null);
			}
			if(current.prev != null) {
				System.out.println("Prev: "+current.prev.val);
			}else {
				System.out.println("Prev: "+null);
			}
			if(current.child != null) {
				System.out.println("Child: "+current.child.val);
			}else {
				System.out.println("Child: "+null);
			}
			current=current.next;
		}
	}

	public static void main(String[] args) {
		Node root=new Node();
		root.val=1;
		root.child=new Node();
		root.child.val=2;
		root.child.child=new Node();
		root.child.child.val=3;
		
		new FlattenDoubleLinkList().flatten(root);
	}

}
