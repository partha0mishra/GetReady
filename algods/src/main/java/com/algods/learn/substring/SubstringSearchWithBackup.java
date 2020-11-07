package com.algods.learn.substring;

public class SubstringSearchWithBackup {
	public static int searchWithBackup(String text, String pattern) {
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
