package com.algods.learn.substring;

public class ATestClass {
	public static void main(String[] args) {
		String text="ABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABAB";
		String pattern="ABABABC";
		StringBuilder sb= new StringBuilder(text);
		for(int i=0; i< 20; i++) {
			sb.append(sb);
		}
		sb.append('C');
		sb.append(sb);
		System.out.println(BruteForceSubstringSearch.search(sb.toString(),pattern));
		System.out.println(searchWithBackup(sb.toString(),pattern));
		System.out.println(search(sb.toString(),"ABCX"));
		System.out.println(searchWithBackup(sb.toString(),"ABCX"));
	}
}
