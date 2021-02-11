package com.leetcode.linkedList._easy;

import com.leetcode.linkedList.ListNode;

/** TODO Anki
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {
	/**
	 * More compact: during revision.
	 * still O(N) O(N)
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1), result=dummy;
        int sum=0;
        while(l1 != null || l2 != null){
            if(l1 != null){sum+=l1.val; l1=l1.next;}
            if(l2 != null){sum+=l2.val; l2=l2.next;}
            result.next=new ListNode(sum%10); result=result.next;
            sum/=10;
        }
        if(sum >0) result.next=new ListNode(sum);
        return dummy.next;
    }
	/**
	 * Easy to do as the numbers are already reversed
	 * keep the carry.
	 * O(N) O(N) since we're not reusing any of the LinkedLists
	 */
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int carry=0;
//        ListNode result=null, current=null;
//        while(l1 != null || l2 != null){
//            if(l1 != null){carry+=l1.val; l1=l1.next;}
//            if(l2 != null){carry+=l2.val; l2=l2.next;}
//            System.out.println(carry);
//            ListNode temp=new ListNode(carry%10);
//            if(result == null){
//                result=temp;
//            }else{
//                current.next=temp;
//            }
//            current=temp;
//            carry/=10;
//        }
//        if(carry > 0){
//            current.next=new ListNode(carry);
//        }
//        return result;
//    }
}
