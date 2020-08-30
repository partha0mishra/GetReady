package com.algods.sedgewick.radix;

public class LongestCommonPrefix {
	public String findPrefix(String a, String b) {
		int minLength=Math.min(a.length(), b.length());
		StringBuffer result= new StringBuffer();
		for(int i=0; i<minLength; i++) {
			if(a.charAt(i) != b.charAt(i)) break;
			else result.append(a.charAt(i));
		}
		return result.toString();
	}
	public static void main(String[] args) {
		LongestCommonPrefix instance= new LongestCommonPrefix();
		System.out.println("1> "+instance.findPrefix("something", "anything"));
		System.out.println("2> "+instance.findPrefix("something", "someone"));
		System.out.println("3> "+instance.findPrefix("something", "some"));
		System.out.println("4> "+instance.findPrefix("something", ""));
	}

}
