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
		long tStart;
		System.out.println("Positive Scenario");
		tStart=System.currentTimeMillis();
		System.out.println(BruteForceSubstringSearch.search(sb.toString(),pattern));
		System.out.println("Brute: "+(System.currentTimeMillis()-tStart));
		tStart=System.currentTimeMillis();
		System.out.println(SubstringSearchWithBackup.searchWithBackup(sb.toString(),pattern));
		System.out.println("Backup: "+(System.currentTimeMillis()-tStart));
		tStart=System.currentTimeMillis();
		System.out.println(MyKMP.search(sb.toString(),pattern));
		System.out.println("KMP: "+(System.currentTimeMillis()-tStart));
		////
		System.out.println("Negative Scenario");
		tStart=System.currentTimeMillis();
		System.out.println(BruteForceSubstringSearch.search(sb.toString(),"ABCX"));
		System.out.println("Brute: "+(System.currentTimeMillis()-tStart));
		tStart=System.currentTimeMillis();
		System.out.println(SubstringSearchWithBackup.searchWithBackup(sb.toString(),"ABCX"));
		System.out.println("Backup: "+(System.currentTimeMillis()-tStart));
		tStart=System.currentTimeMillis();
		System.out.println(MyKMP.search(sb.toString(),"ABCX"));
		System.out.println("KMP: "+(System.currentTimeMillis()-tStart));
	}
}
