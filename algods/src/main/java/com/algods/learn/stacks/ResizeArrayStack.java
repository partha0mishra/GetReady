package com.algods.learn.stacks;

public class ResizeArrayStack {
	String[] items;
	int top;
	public ResizeArrayStack() {
		items= new String[1];
		top=0;
	}
	public boolean isEmpty() { return top==0;}
	public void push(String s) {
		items[top++]=s;
		if(top == items.length) resize(top);
	}
	public String pop() {
		if(isEmpty()) throw new IllegalArgumentException("-- empty --");
		String result=items[--top];
		if(top == items.length/4) resize(top);
		
		return result;
	}
	private void resize(int size) {
		System.out.println(">> Resize called at: "+top);
		String[] newItems=new String[2*size];
		System.arraycopy(items, 0, newItems, 0, size);// size: NUMBER of elements to be copied
//		for(int i=0; i<size; i++) {
//			newItems[i]=items[i];
//		}
		items=newItems;
	}
	public String toString() {
//		if(isEmpty()) throw new IllegalArgumentException("-- empty --");
		StringBuffer sb= new StringBuffer();
		for(int i=0; i<top; i++) {
			sb.append(items[i]).append(" ");
		}
		if(sb.length() < 1) return "-- empty --";
		return sb.substring(0, sb.length()-1);
	}
	public static void main(String[] args) {
		ResizeArrayStack instance = new ResizeArrayStack();
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
		
		// test resizing
		ResizeArrayStack instance2 = new ResizeArrayStack();
		System.out.println("Start push");
		for(int i=0; i< 1000; i++) instance2.push(String.valueOf(i));
		System.out.println("Start pop");
		for(int i=0; i< 1000; i++) {
//			System.out.println(
					instance2.pop()
//					)
			;
		}
	}

}
