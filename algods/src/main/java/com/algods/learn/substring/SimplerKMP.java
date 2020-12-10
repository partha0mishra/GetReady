package com.algods.learn.substring;
/* KMP - trying for a simpler table and failure function
 * 
 */
public class SimplerKMP {
	static int[] dfa;
	public SimplerKMP(String pattern) {
		dfa=initializeDFA(pattern);
		printDfa(pattern);
	}
	public static int search(String text, String pattern) {
		dfa=initializeDFA(pattern);
		return kmp(text, pattern);
	}
	// Refer to https://www.youtube.com/watch?v=GTJr8OvyEVQ for explanation
	private static int[] initializeDFA(String pattern) {
		int j=0, patLen=pattern.length();
		int[] dfa=new int[patLen];// dfa[0]=0 ALWAYS
		for(int i=1; i< patLen;) {// NO i++
			if(pattern.charAt(i) == pattern.charAt(j)) {dfa[i++]=++j;}
			else {
				if(j != 0) j=dfa[j-1];
				else dfa[i++]=0;
			}
		}
		return dfa;
	}
	public static int kmp(String text, String pattern) {
//		if(dfa == null) return text.length();
		int i=0, j=0, txtLen=text.length();
		while(i< txtLen && j< dfa.length) {
			if(text.charAt(i) == pattern.charAt(j)) {i++;j++;}
			else {
				if(j==0) i++;
				else j=dfa[j-1];
			}
		}
		if(j==dfa.length) return i-j;
		return i;
	}
	private void printDfa(String pattern) {
		initializeDFA(pattern);
		String separator=" | ";
		System.out.println("------------------------------------------------------------------");
		
		for(int i=0;i<pattern.length(); i++) {
			System.out.print(separator+i);
		}
		System.out.println();
		for(char c: pattern.toCharArray()) {
			System.out.print(separator+c);
		}
		System.out.println();
		for(int i: dfa) {
			System.out.print(separator+i);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		SimplerKMP s00= new SimplerKMP("a");
		SimplerKMP s01= new SimplerKMP("ab");
		SimplerKMP s02= new SimplerKMP("aba");
		SimplerKMP s03= new SimplerKMP("abab");
		SimplerKMP s04= new SimplerKMP("ababa");
		SimplerKMP s05= new SimplerKMP("ababab");
		SimplerKMP s06= new SimplerKMP("abcaby");
		SimplerKMP s07= new SimplerKMP("aabaaa");
		SimplerKMP s08= new SimplerKMP("abcdabca");
		SimplerKMP s09= new SimplerKMP("aabaabaaa");
		SimplerKMP s10= new SimplerKMP("ABABABABABABC");
		SimplerKMP s11= new SimplerKMP("abcdabcy");
		
		String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        int result=SimplerKMP.search(str, subString);
        System.out.println(result);
        String str2 = "abcxabcdabcdabcdab";
        int result1=SimplerKMP.search(str2, subString);
        System.out.println(result1);
	}
}
