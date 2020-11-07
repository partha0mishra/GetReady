package com.algods.learn.substring;

public class BruteForceSubstringSearch {

	public static void main(String[] args) {
		String text="ABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABAB";
		String pattern="ABABABC";
		StringBuilder sb= new StringBuilder(text);
		for(int i=0; i< 20; i++) {
			sb.append(sb);
		}
		sb.append('C');
		sb.append(sb);
		System.out.println(search(sb.toString(),pattern));
		System.out.println(searchWithBackup(sb.toString(),pattern));
		System.out.println(search(sb.toString(),"ABCX"));
		System.out.println(searchWithBackup(sb.toString(),"ABCX"));
	}

	private static int search(String text, String pattern) {
		int lenTxt=text.length();
		int lenPat=pattern.length();
		for(int start=0; start<=lenTxt-lenPat; start++) {
			int iPat;
			for(iPat=0; iPat< lenPat; iPat++) {
				if(text.charAt(start+iPat) != pattern.charAt(iPat)) break;
			}
			if(iPat == lenPat) return start;
		}
		return lenTxt;
	}
	private static int searchWithBackup(String text, String pattern) {
		int lenTxt=text.length();
		int lenPat=pattern.length();
		for(int start=0, iPat=0; start< lenTxt && iPat< lenPat; start++) {
			if(text.charAt(start) == pattern.charAt(iPat)) iPat++;
			else {start-=iPat; iPat=0;}
			if(iPat == lenPat) return start-iPat+1;
		}
		return lenTxt;
	}
}
