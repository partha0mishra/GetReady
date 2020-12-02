package com.algods.learn.substring;

import java.util.Arrays;

public class SimplerBoyerMoore {
    private final int R;     // the radix
    private int[] right;     // the bad-character skip array

    private char[] pattern;  // store the pattern as a character array
    private String pat;      // or as a string

    public SimplerBoyerMoore(String pat) {
        this.R = 256;
        this.pat = pat;

        // position of rightmost occurrence of c in the pattern
        right = new int[R];
        Arrays.fill(right, pat.length());// everything 'else'
        for (int index = 0; index < pat.length(); index++) 
        	right[pat.charAt(index)] = pat.length() -index-1;// length - index -1
    }

    public int search(String txt) {
        int m = pat.length();
        int n = txt.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m-1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i+j)) {
                    skip = right[txt.charAt(i+j)];
                    break;
                }
            }
            if (skip == 0) return i;    // found
        }
        return n;                       // not found
    }

    /**
     * Takes a pattern string and an input string as command-line arguments;
     * searches for the pattern string in the text string; and prints
     * the first occurrence of the pattern string in the text string.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
    	String text="ABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABAB";
		String pattern="ABABABABABABC";
		StringBuilder sb= new StringBuilder(text);
		for(int i=0; i< 20; i++) {
			sb.append(sb);
		}
		sb.append('C');
		sb.append(sb);
        String pat = pattern;
        String txt = sb.toString();

        long tStart=System.currentTimeMillis();
        SimplerBoyerMoore boyermoore1 = new SimplerBoyerMoore(pat);
        int offset1 = boyermoore1.search(txt);
        System.out.println("Matched at: "+offset1+" time: "+(System.currentTimeMillis()-tStart));

        // print results
//        System.out.println("text:    " + txt);
//
//        System.out.print("pattern: ");
//        for (int i = 0; i < offset1; i++)
//            System.out.print(" ");
//        System.out.println(pat);
    }
}