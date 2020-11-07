package com.algods.learn.substring;

public class BruteForceSubstringSearch {
	public static int search(String text, String pattern) {
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
}
