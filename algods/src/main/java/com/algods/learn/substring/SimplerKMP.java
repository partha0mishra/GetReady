package com.algods.learn.substring;
/* KMP - trying for a simpler table and failure function
 * 
 */
public class SimplerKMP {
	private static void initializeDFA(String pattern) {
		int i=1, j=0, m=pattern.length();
		char[] p=pattern.toCharArray();
		int[]  f=new int[p.length];
		while(i< m) {
			if(p[j] == p[i]) {f[i]=j+1; i+=1; j+=1;}
//			else if(true) {j=f[j-1];}
			else {f[i]=0; i+=1;}
		}
	}
}
