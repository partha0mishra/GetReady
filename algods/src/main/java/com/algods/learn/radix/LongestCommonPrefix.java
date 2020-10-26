package com.algods.learn.radix;

public class LongestCommonPrefix {
	/* Approach 02: CP Way*/
	public String findPrefix(String a, String b) {
		int i=0;
		while(i < a.length() && i< b.length() && a.charAt(i) == b.charAt(i)) i++;
		return a.substring(0,i);
	}
	/* Approach 01: The Regular way*/
//	public String findPrefix(String a, String b) {
//		int minLength=Math.min(a.length(), b.length());
//		StringBuilder result= new StringBuilder();
//		for(int i=0; i<minLength; i++) {
//			if(a.charAt(i) != b.charAt(i)) break;
//			else result.append(a.charAt(i));
//		}
//		return result.toString();
//	}
	public static void main(String[] args) {
		LongestCommonPrefix instance= new LongestCommonPrefix();
		System.out.println("1> "+instance.findPrefix("something", "anything"));
		System.out.println("2> "+instance.findPrefix("something", "someone"));
		System.out.println("3> "+instance.findPrefix("something", "some"));
		System.out.println("4> "+instance.findPrefix("something", ""));
	}
}
