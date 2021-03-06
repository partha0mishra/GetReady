package com.leetcode.linkedList.r01;
/** TODO Anki 
 * 445: Add Two Numbers II
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */
import java.util.*;

import com.leetcode.linkedList.ListNode;
public class AddTwoNumbers2 {
	/** 
	 * Approach 02: Using Stack since the operations need to be from Right
	 * O(N)/ O(N)
	 * */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> sa= new Stack<>(), sb=new Stack<>();
        while(l1 != null){sa.push(l1.val); l1=l1.next;}
        while(l2 != null){sb.push(l2.val); l2=l2.next;}
        int sum=0;
        ListNode result=null, temp;
        while(!sa.isEmpty() || !sb.isEmpty()|| sum!=0){ // NOTE: sum!=0 so that the carry is also put into a new head node
            if(!sa.isEmpty()) sum+=sa.pop();
            if(!sb.isEmpty()) sum+=sb.pop();
            temp=new ListNode(sum%10); sum/=10;
            temp.next=result; result=temp;
        }
        return result;
    }
	/* Approach 01a: using int1 to keep l1 and int2 to keep l2 and int3=int1+int2 and convert back to LL - too small
	 * Approach 01b: using long instead - still get TLE as the number of digits can be 10000 
	 * Approach 01c: converting LLs to StringBuilders and then operating from the END << idea of Stack perhaps??
	 * */
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        StringBuilder sb1=new StringBuilder(),sb2=new StringBuilder();
//        while(l1 != null) {sb1.append(l1.val);l1=l1.next;}
//        while(l2 != null) {sb2.append(l2.val);l2=l2.next;}
//        
//        int maxLen=Math.max(sb1.length(), sb2.length());
//        // System.out.println(maxLen);
//        while(sb1.length() < maxLen) sb1.insert(0, 0);
//        // System.out.println(sb1);
//        while(sb2.length() < maxLen) sb2.insert(0, 0);
//        // System.out.println(sb2);
//        int n=0;
//        ListNode result=null;
//        for(int i=maxLen-1; i>=0; i--) {
//            // System.out.println(i+" "+sb1.charAt(i)+" "+sb2.charAt(i));
//        	n+=(sb1.charAt(i) - '0') +(sb2.charAt(i) -'0');
//        	// System.out.println(n);
//        	ListNode temp=new ListNode(n%10);
//        	n=n/10;
//        	temp.next=result;
//        	result=temp;
//        }
//        if(n > 0){
//            ListNode temp=new ListNode(n);
//            temp.next=result;
//            result=temp;
//        }
//        return result;
//    }
}
