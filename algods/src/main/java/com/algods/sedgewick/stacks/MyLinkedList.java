package com.algods.sedgewick.stacks;

public class MyLinkedList {
	private class Node{
		String item;
		Node next;
		Node(String s){
			this.item=s;
		}
	}
	private Node head;
	public MyLinkedList() {
		head=null;
	}
	public void push(String s) {
		Node oldHead= head;
		head=new Node(s);
		head.next=oldHead;
	}
	public String pop() {
		if(head == null) throw new IllegalArgumentException("Empty Stack!!");
		String result=head.item;
		head=head.next;
		return result;
	}
	public String toString() {
		StringBuffer sb= new StringBuffer();
		Node start=head;
		while(start !=null) {
			sb.append(start.item).append(" ");
			start=start.next;
		}
		if(sb.length() < 1) return "-- empty --";
		return sb.substring(0, sb.length()-1);
	}
	public static void main(String[] args) {
		MyLinkedList instance = new MyLinkedList();
		System.out.println("Stack: " +instance);
		instance.push("1");
		System.out.println("Stack: " +instance);
		instance.push("2");
		System.out.println("Stack: " +instance);
		instance.push("3");
		System.out.println("Stack: " +instance);
		System.out.println("popped: "+instance.pop());
		System.out.println("Stack: " +instance);
		System.out.println("popped: "+instance.pop());
		System.out.println("Stack: " +instance);
		System.out.println("popped: "+instance.pop());
		System.out.println("Stack: " +instance);
	}
}
