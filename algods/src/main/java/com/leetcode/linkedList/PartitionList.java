package com.leetcode.linkedList;
/* 86 Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        ListNode slow=null, fast=head;
        while(fast !=null && fast.val < x) {
            slow=fast;
            fast=fast.next;
        }
        if(fast == null) return head;
        // slow @ insertion point, fast at hunting position
        while(fast.next != null){
            if(fast.next.val < x){
                ListNode temp=fast.next;
                fast.next=fast.next.next;
                if(slow == null) {// insertion before head
                    temp.next=head;
                    head=temp;
                } else {
                    temp.next=slow.next;
                    slow.next=temp;
                }
                slow=temp;
            }else fast=fast.next;
        }
        return head;
    }
}
