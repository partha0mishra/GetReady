package com.algods.learn.stacks;

public class LinkedListStack {
	private class Node{
		String item;
		Node next;
		Node(String s){
			this.item=s;
		}
	}
	private Node head;
	public LinkedListStack() {
		head=null;
	}
	public void push(String s) {
		Node newNode=new Node(s);
		newNode.next=head;
		head=newNode;
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
		LinkedListStack instance = new LinkedListStack();
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
