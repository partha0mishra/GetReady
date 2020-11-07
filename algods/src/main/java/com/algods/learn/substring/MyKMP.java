package com.algods.learn.substring;
/* Knuth Morris Pratt
 * 
 */
public class MyKMP {
	static int[][]dfa;
	static final int R=256;// extended ASCII
	public static int search(String txt, String pattern) {
		int i,j,N=txt.length(),M=pattern.length();
		initializeDfa(pattern);
		for(i=0,j=0;i<N && j<M;i++ )
			j=dfa[txt.charAt(i)][j];
		if(j==M) return i-M;
		else return N;
	}
	private static void initializeDfa(String pattern) {
		int M=pattern.length();
		dfa=new int[R][M];
		dfa[pattern.charAt(0)][0]=1;
		for(int X=0,j=1; j< M; j++) {
			for(int c=0; c<R; c++)
				dfa[c][j]=dfa[c][X];
			dfa[pattern.charAt(j)][j]=j+1;
			X=dfa[pattern.charAt(j)][X];
		}
	}
}
