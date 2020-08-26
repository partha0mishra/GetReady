package com.algods.sedgewick.queues;

public class ResizeArrayQueue {
	String[] items;
	int first, last;
	public ResizeArrayQueue(){
		items=new String[1];
		first=0;
		last=0;
	}
	public void enqueue(String s) {
		items[last++]=s;
		if(last==items.length) resize();
	}
	public String dequeue() {
		if (isEmpty()) throw new IllegalArgumentException("--- empty ---");
		return items[++first];
	}
	private void resize() {
		int newSize=2*(last-first);
		System.out.println(">> Resize called at: first "+first+" last "+last+" newSize "+newSize);
		String[] newItems=new String[newSize];
		int i;
		for(i=first; i<last; i++) {
			newItems[i-first]=items[i];
		}
		first=0;
		last=i;
		items=newItems;
	}
	public boolean isEmpty() {
		return first==last;
	}
	public String toString() {
		if(isEmpty()) return "--- empty ---";
		StringBuffer result= new StringBuffer();
		for(int i=first; i<last; i++) {
			result.append(items[i]).append(" ");
		}
		return result.substring(0, result.length()-1);
	}
	public static void main(String[] args) {
		ResizeArrayQueue instance = new ResizeArrayQueue();
		System.out.println("Queue: " +instance);
		instance.enqueue("1");
		System.out.println("Queue: " +instance);
		instance.enqueue("2");
		System.out.println("Queue: " +instance);
		instance.enqueue("3");
		System.out.println("Queue: " +instance);
		System.out.println("Dequeued: "+instance.dequeue());
		System.out.println("Queue: " +instance);
		System.out.println("Dequeued: "+instance.dequeue());
		System.out.println("Queue: " +instance);
		System.out.println("Dequeued: "+instance.dequeue());
		System.out.println("Queue: " +instance);
		
		// test resizing
		ResizeArrayQueue instance2 = new ResizeArrayQueue();
		System.out.println("Start Enqueue");
		for(int i=0; i< 1000; i++) instance2.enqueue(String.valueOf(i));
		System.out.println("Start Dequeue");
		for(int i=0; i< 1000; i++) {
//			System.out.println(
					instance2.dequeue()
//					)
			;
		}
	}
}
