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
public class BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
        Stack<Character> ss= new Stack<>();
        Stack<Character> st= new Stack<>();
        for(char c: S.toCharArray()) {
        	if(c == '#') {
        		if(!ss.isEmpty()) ss.pop();
        	}
        	else ss.push(c);
        }
        for(char c: T.toCharArray()) {
        	if(c == '#') {
        		if(!st.isEmpty()) st.pop();
        	}
        	else st.push(c);
        }
        if(ss.size() != st.size()) return false;
        while(!ss.isEmpty()) if(ss.pop() != st.pop()) return false;
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
