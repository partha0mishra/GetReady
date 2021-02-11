package com.leetcode.linkedList.r01;

import java.util.ArrayList;
import java.util.Collections;

import com.leetcode.linkedList.ListNode;

/**
 * 23. Merge K sorted lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
 */
public class MergeKSortedLists {
	/**
	 * Approach 02: Copied so far - TBD
	 * 
	 */
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//	    ListNode h = new ListNode(0);
//	    ListNode ans=h;
//	    while (l1 != null && l2 != null) {
//	        if (l1.val < l2.val) {
//	            h.next = l1;
//	            h = h.next;
//	            l1 = l1.next;
//	        } else {
//	            h.next = l2;
//	            h = h.next;
//	            l2 = l2.next;
//	        }
//	    }
//	    if(l1==null){
//	        h.next=l2;
//	    }
//	    if(l2==null){
//	        h.next=l1;
//	    } 
//	    return ans.next;
//	}
//	public ListNode mergeKLists(ListNode[] lists) {
//	    if(lists.length==0){
//	        return null;
//	    }
//	    int interval = 1;
//	    while(interval<lists.length){
//	        System.out.println(lists.length);
//	        for (int i = 0; i + interval< lists.length; i=i+interval*2) {
//	            lists[i]=mergeTwoLists(lists[i],lists[i+interval]);            
//	        }
//	        interval*=2;
//	    }
//
//	    return lists[0];
//	}
	/**
	 * Brute and still works.
	 * Bring in all the nodes in an ArrayList
	 * Sort the ArrayList
	 * Create a new LinkedList with nodes from the ArrayList
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		ArrayList<ListNode> allNodes= new ArrayList<>();
		for(ListNode ln: lists) {
			while(ln != null) {
				allNodes.add(ln);
				ln=ln.next;
			}
		}
		Collections.sort(allNodes, (n1, n2) -> Integer.compare(n1.val, n2.val));
		ListNode result= new ListNode(0), temp=result;
		for(ListNode n: allNodes) {
			result.next=n;
			result=result.next;
		}
		return temp.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
