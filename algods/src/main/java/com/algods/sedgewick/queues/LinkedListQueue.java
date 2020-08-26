package com.algods.sedgewick.queues;

public class LinkedListQueue {
	private class Node{
		String item;
		Node next;
		Node(String s){
			this.item=s;
		}
	}
	private Node first, last;
	public LinkedListQueue() {
		first=null; last=null;
	}
	public boolean isEmpty() {
		return first==null;
	}
	private void enqueue(String s) {// enqueue at Last
		Node oldLast=last;
		last=new Node(s);
		if(first == null) first=last;
		else oldLast.next=last;// otherwise oldLast.next would throw a Null Pointer error
	}
	private String dequeue() {// dequeue from first
		if(isEmpty()) throw new IllegalArgumentException("--- Empty ---");
		String result= first.item;
		first=first.next;
		if(isEmpty()) last=null;
		return result;
	}
	public String toString() {
		if(isEmpty()) return "--- Empty --";
		StringBuffer result= new StringBuffer();
		Node start=first;
		while(start != null) {
			result.append(start.item).append(" ");
			start=start.next;
		}
		return result.substring(0,result.length()-1);
	}
	public static void main(String[] args) {
		LinkedListQueue instance = new LinkedListQueue();
		System.out.println(instance);
		instance.enqueue("1");
		System.out.println(instance);
		instance.enqueue("2");
		System.out.println(instance);
		instance.enqueue("3");
		System.out.println(instance);
		instance.enqueue("4");
		System.out.println(instance);
		System.out.println("Dequeued: "+instance.dequeue());
		System.out.println(instance);
		System.out.println("Dequeued: "+instance.dequeue());
		System.out.println(instance);
		System.out.println("Dequeued: "+instance.dequeue());
		System.out.println(instance);
		System.out.println("Dequeued: "+instance.dequeue());
		System.out.println(instance);
	}
}
