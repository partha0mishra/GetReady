package com.algods.leetcode.linkedList;
/* Add Two Numbers II
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1=0, num2=0, num3;
        while(l1 != null){
            num1=10*num1+l1.val;
            l1=l1.next;
        }
        while(l2 != null){
            num2=10*num2+l2.val;
            l2=l2.next;
        }
        num3=num1+num2;
        // System.out.println(num3);
        char[] ca=String.valueOf(num3).toCharArray();
        // System.out.println(ca);
        ListNode result=null, newList=null;
        for(char c: ca){
            // System.out.println(c-'0');
            ListNode newNode= new ListNode(c-'0');
            if(result == null){
                newList=newNode;
                result=newList;
            }else{
                newList.next=newNode;
                newList=newList.next;
            }
        }
        return result;
    }
}
