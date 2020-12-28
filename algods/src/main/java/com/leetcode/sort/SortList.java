package com.leetcode.sort;
/**
 * 148. Sort List
 * 
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 * 
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * 
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * 
 * Input: head = []
 * Output: []
 * 
 * Constraints:
 * The number of nodes in the list is in the range [0, 5 * 10^4].
 * -10^5 <= Node.val <= 10^5
 */
public class SortList {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	/* Well-articulated solution : https://leetcode.com/problems/sort-list/solution/
	 * Bottom Up Merge Sort
	 * */

    ListNode tail = new ListNode();
    ListNode nextSubList = new ListNode();

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int n = getCount(head);
        ListNode start = head;
        ListNode dummyHead = new ListNode();
        for (int size = 1; size < n; size = size * 2) {
            tail = dummyHead;
            while (start != null) {
                if (start.next == null) {
                    tail.next = start;
                    break;
                }
                ListNode mid = split(start, size);
                merge(start, mid);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        return dummyHead.next;
    }

    ListNode split(ListNode start, int size) {
        ListNode midPrev = start;
        ListNode end = start.next;
        //use fast and slow approach to find middle and end of second linked list
        for (int index = 1; index < size && (midPrev.next != null || end.next != null); index++) {
            if (end.next != null) {
                end = (end.next.next != null) ? end.next.next : end.next;
            }
            if (midPrev.next != null) {
                midPrev = midPrev.next;
            }
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        nextSubList = end.next;
        end.next = null;
        // return the start of second linked list
        return mid;
    }

    void merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode newTail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newTail.next = list1;
                list1 = list1.next;
                newTail = newTail.next;
            } else {
                newTail.next = list2;
                list2 = list2.next;
                newTail = newTail.next;
            }
        }
        newTail.next = (list1 != null) ? list1 : list2;
        // traverse till the end of merged list to get the newTail
        while (newTail.next != null) {
            newTail = newTail.next;
        }
        // link the old tail with the head of merged list
        tail.next = dummyHead.next;
        // update the old tail to the new tail of merged list
        tail = newTail;
    }

    int getCount(ListNode head) {
        int cnt = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            cnt++;
        }
        return cnt;
    }

	public static void main(String[] args) {
		SortList instance = new SortList();
		ListNode head=instance.new ListNode(4);
		head.next=instance.new ListNode(2);
		head.next.next=instance.new ListNode(1);
		head.next.next.next=instance.new ListNode(3);
		ListNode result=instance.sortList(head);
		printList(result);
		
		head=instance.new ListNode(-1);
		head.next=instance.new ListNode(5);
		head.next.next=instance.new ListNode(3);
		head.next.next.next=instance.new ListNode(4);
		head.next.next.next.next=instance.new ListNode(0);
		ListNode result1=instance.sortList(head);
		printList(result1);
	}
	private static void printList(ListNode node) {
		while(node !=null) {
			System.out.print(node.val+" > ");
			node=node.next;
		}
		System.out.println();
	}
}
