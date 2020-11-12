package com.algods.learn.substring;

public class ATestClass {
	public static void main(String[] args) {
		String text="ABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABAB";
		String pattern="ABABABABABABC";
		StringBuilder sb= new StringBuilder(text);
		for(int i=0; i< 20; i++) {
			sb.append(sb);
		}
		sb.append('C');
		sb.append(sb);
		System.out.println("Positive Scenarios ");
		tests(sb,pattern);
		System.out.println("Negative Scenario");
		pattern=pattern.concat("ABCX");
		tests(sb,pattern);
		
	}
	static void tests(StringBuilder sb, String pattern) {
		long tStart;
		tStart=System.currentTimeMillis();
		System.out.println(BruteForceSubstringSearch.search(sb.toString(),pattern));
		System.out.println("Brute: "+(System.currentTimeMillis()-tStart));
		tStart=System.currentTimeMillis();
		System.out.println(SubstringSearchWithBackup.searchWithBackup(sb.toString(),pattern));
		System.out.println("Backup: "+(System.currentTimeMillis()-tStart));
		tStart=System.currentTimeMillis();
		System.out.println(MyKMP.search(sb.toString(),pattern));
		System.out.println("KMP: "+(System.currentTimeMillis()-tStart));
		tStart=System.currentTimeMillis();
		System.out.println(new RabinKarp(pattern).search(sb.toString()));
		System.out.println("Rabin-Karp: "+(System.currentTimeMillis()-tStart));
		tStart=System.currentTimeMillis();
		System.out.println(new BoyerMoore(pattern).search(sb.toString()));
		System.out.println("Boyer-Moore: "+(System.currentTimeMillis()-tStart));
	}
}
