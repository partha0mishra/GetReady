package com.leetcode._explore;

import static org.junit.Assert.assertEquals;
import java.util.*;

/**
 * 5483. Make The String Great
 * 
 * Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.
 * 
 * Example 01:
 * Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
 * 
 * Example 02:
 * Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
 * 
 * Example 03:
 * Input: s = "s"
Output: "s"
 * 
 * Constraints:
 * 1 <= s.length <= 100
 * s contains only lower and upper case English letters.
 */
public class MakeStringGreat {
	public String makeGood(String s) {
    if(s.length() ==1) return s;
    Stack<Character> charStack= new Stack<Character>();
    for(char c: s.toCharArray()) {
    	if(charStack.isEmpty()) charStack.push(c);
    	else {
    		char prev= charStack.peek();
    		if(Math.abs(prev-c)==32) charStack.pop();
    		else charStack.push(c);
    	}
    }
    StringBuffer sb= new StringBuffer();
    for(char c: charStack) {
    	sb.append(c);
    }
    
//    System.out.println("toString"+sb.toString());
    return sb.toString();
    }
	public static void main(String[] args) {
		MakeStringGreat instance= new MakeStringGreat();
		assertEquals("01","leetcode",instance.makeGood("leEeetcode"));
		assertEquals("02","",instance.makeGood("abBAcC"));
		assertEquals("03","s",instance.makeGood("s"));
	}

}
