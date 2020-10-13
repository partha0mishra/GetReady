package com.algods.leetcode.linkedList;
/* 
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 * Example 1:
 * Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:
Input: head = []
Output: []
Constraints:
The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if(head ==null || head.next == null) return head;// null or single-node list
        ListNode slow=head, fast=head,head2,list1, list2;
        while(fast.next !=null && fast.next.next !=null) {
        	slow=slow.next;
        	fast=fast.next.next;
        }// now slow is the mid
        head2=slow.next;// next list
        slow.next=null;// terminate the end
        list1=sortList(head);
        list2=sortList(head2);
        return mergeSortedLists(list1,list2);
    }

	private ListNode mergeSortedLists(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		ListNode head=null, prev=null, current;
		boolean done=false;
		while(list1 !=null || list2 !=null) {
			if(list1 == null) 				{current=list2; done=true;}
			else if(list2 == null) 			{current=list1; done=true;}
			else if(list1.val < list2.val) 	{current=list1; list1=list1.next;}
			else							{current=list2; list2=list2.next;}
			
			if(prev==null) 	{head=current;}
			else			{prev.next=current;}
			
			prev=current;
			if(done) break;
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode head=new ListNode(-1);
		head.next=new ListNode(5);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(0);
		SortList instance= new SortList();
		instance.sortList(head);
		while(head !=null) {
			System.out.println(head.val+" ");
			head=head.next;
		}
	}
}
