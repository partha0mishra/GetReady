package com.algods.leetcode.stack;
/* 844. Backspace String Compare
 * 
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 * */
import java.util.Stack;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class BackspaceStringCompare {
	/* Approach 02 - String compare from end */
	public boolean backspaceCompare(String S, String T) {
		int si=S.length()-1;
		int ti=T.length()-1;
		Character sc=null, st=null;
		while(si >=0 || ti >=0) {
			int toSkip=0;
			if(si >=0) {
				sc=S.charAt(si);
				toSkip=evaluate(sc);
				while(toSkip >=0) {
					if(si ==0) {
						sc=null;
						break;
					}
					sc=S.charAt(--si);
					toSkip+=evaluate(sc);
				}
			} else sc=null;
			if(ti >=0) {
				st=T.charAt(ti);
				toSkip=evaluate(st);
				while(toSkip >=0) {
					if(ti ==0) {
						st=null;
						break;
					}
					st=T.charAt(--ti);
					toSkip+=evaluate(st);
				}
			} else st=null;
//			System.out.println(si+" "+sc+" : "+ti+" "+st);
			if(sc !=st) return false;
			if(sc == null && st == null) break;
			si--;ti--;
		}
		return sc == st;
	}
	private int evaluate(Character c) {
		return (c == '#')? 1:-1; 
	}
	/* Approach 01 - Stack based implementation*/
//	public boolean backspaceCompare(String S, String T) {
//        Stack<Character> ss= new Stack<>();
//        Stack<Character> st= new Stack<>();
//        for(char c: S.toCharArray()) {
//        	if(c == '#') {
//        		if(!ss.isEmpty()) ss.pop();
//        	}
//        	else ss.push(c);
//        }
//        for(char c: T.toCharArray()) {
//        	if(c == '#') {
//        		if(!st.isEmpty()) st.pop();
//        	}
//        	else st.push(c);
//        }
//        if(ss.size() != st.size()) return false;
//        while(!ss.isEmpty()) if(ss.pop() != st.pop()) return false;
//        return true;
//    }
	public static void main(String[] args) {
		assertTrue(new BackspaceStringCompare().backspaceCompare("ab#c", "ad#c"));
		assertTrue(new BackspaceStringCompare().backspaceCompare("a##c", "#a#c"));
		assertFalse(new BackspaceStringCompare().backspaceCompare("a#c", "b"));
		assertFalse(new BackspaceStringCompare().backspaceCompare("bxj##tw","bxj###tw"));
		assertTrue(new BackspaceStringCompare().backspaceCompare("nzp#o#g","b#nzp#o#g"));
	}

}
